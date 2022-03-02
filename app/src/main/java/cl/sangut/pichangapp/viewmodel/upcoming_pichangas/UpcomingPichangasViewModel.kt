package cl.sangut.pichangapp.viewmodel.upcoming_pichangas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UpcomingPichangasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pichangas_searcher Fragment"
    }
    val text: LiveData<String> = _text
}
