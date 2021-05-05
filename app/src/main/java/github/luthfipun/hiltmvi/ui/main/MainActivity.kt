package github.luthfipun.hiltmvi.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import github.luthfipun.hiltmvi.databinding.ActivityMainBinding
import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.DataState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetUserEvents)
    }

    private fun initView() {
        binding.recyclerView.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mainAdapter
        }
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
        mainAdapter.addData(users)
    }
}