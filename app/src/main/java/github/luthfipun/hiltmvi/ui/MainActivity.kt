package github.luthfipun.hiltmvi.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import github.luthfipun.hiltmvi.databinding.ActivityMainBinding
import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.DataState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetUserEvents)
    }

    private fun subscribeObservers(){
        viewModel.dataState.observe(this, { dataState ->
            when(dataState){
                is DataState.Success<List<User>> -> {
                    displayProgressBar(false)
                    displayData(dataState.data)
                }

                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }

                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?){
        Toast.makeText(this, message ?: "Unknown Errors", Toast.LENGTH_LONG).show()
    }

    private fun displayData(users: List<User>){
        users.map {
            Log.e("ENOG", it.email)
        }
    }
}