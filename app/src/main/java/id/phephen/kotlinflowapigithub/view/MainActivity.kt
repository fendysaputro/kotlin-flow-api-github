package id.phephen.kotlinflowapigithub.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import id.phephen.kotlinflowapigithub.R
import id.phephen.kotlinflowapigithub.databinding.ActivityMainBinding
import id.phephen.kotlinflowapigithub.network.Status
import id.phephen.kotlinflowapigithub.viewmodel.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.button.setOnClickListener {
            if (binding.searchEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Query can't be empty", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.getUser(binding.searchEditText.text.toString())
            }
        }

        lifecycleScope.launch {
            viewModel.userState.collect {
                when(it.status) {
                    Status.LOADING -> {
                        binding.progressBar.isVisible = true
                    }
                    Status.SUCCESS -> {
                        binding.progressBar.isVisible = false
                        it.data?.let { user ->
                            binding.tvName.text = user.login
                            binding.tvEmail.text = user.login
                            binding.tvRepos.text = user.url
                        }
                    }
                    else -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}