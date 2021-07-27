package dev.kibet.e_sports.ui.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kibet.e_sports.data.api.EsportsApi
import dev.kibet.e_sports.data.model.SportsResponse
import dev.kibet.e_sports.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val sportsApi: EsportsApi
): ViewModel() {

    private  val _sportsResponse: MutableLiveData<Resource<SportsResponse>> = MutableLiveData()

    val sportsResponse: LiveData<Resource<SportsResponse>> = _sportsResponse

    fun fetchSports() {
        viewModelScope.launch {
            _sportsResponse.value = Resource.loading(null)
            _sportsResponse.value = sportsApi.getAllSports()
        }
    }
}