package com.maxx.github_demo.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.maxx.github_demo.model.Commit
import com.maxx.github_demo.repository.MainRepository
import com.maxx.github_demo.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _dataState: MutableLiveData<DataState<List<Commit>>> = MutableLiveData()

    val dataState: MutableLiveData<DataState<List<Commit>>> get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetBlogEvents ->{
                    mainRepository.getBlogs()
                        .onEach {
                            _dataState.value = it
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None ->{

                }
            }
        }
    }
}

sealed class MainStateEvent {

    object GetBlogEvents : MainStateEvent()

    object None : MainStateEvent()

}