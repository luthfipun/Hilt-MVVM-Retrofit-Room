package github.luthfipun.hiltmvi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.DataState
import github.luthfipun.hiltmvi.repository.MainRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _dataState = MutableLiveData<DataState<List<User>>>()
    val dataState: LiveData<DataState<List<User>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetUserEvents -> {
                    mainRepository.getUser()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    // another state events if exists
                }
            }
        }
    }
}

sealed class MainStateEvent {
    object GetUserEvents: MainStateEvent()
    object None: MainStateEvent()
}