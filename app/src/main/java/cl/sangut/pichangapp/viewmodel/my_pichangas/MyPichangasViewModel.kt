package cl.sangut.pichangapp.viewmodel.my_pichangas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.sangut.pichangapp.model.data.Pichanga
import cl.sangut.pichangapp.model.data.PichangaLocation
import cl.sangut.pichangapp.model.data.Team
import java.time.LocalDateTime

class MyPichangasViewModel : ViewModel() {

    internal val pichangasLiveData = MutableLiveData<List<Pichanga>>()
    internal val pichangaLoadError = MutableLiveData<Boolean>()
    internal val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val pichangaLocation1 = PichangaLocation(
            "1",
            "0",
            "0",
            "place"
        )
        val homeTeam = Team(
            "1",
            "Sangut FC",
            "fc@sangut.cl",
            "123123",
            "feminine",
            null
        )
        val pichanga1 = Pichanga(
            "1",
            pichangaLocation1,
            LocalDateTime.now(),
            homeTeam,
            null,
            "instrucciones",
            null
        )
        val pichanga2 = Pichanga(
            "2",
            pichangaLocation1,
            LocalDateTime.now(),
            homeTeam,
            null,
            "instrucciones",
            null
        )
        val pichanga3 = Pichanga(
            "3",
            pichangaLocation1,
            LocalDateTime.now(),
            homeTeam,
            null,
            "instrucciones",
            null
        )
        val pichangaList = arrayListOf<Pichanga>(
            pichanga1,
            pichanga2,
            pichanga3,
            pichanga1,
            pichanga2,
            pichanga3,
            pichanga1,
            pichanga2,
            pichanga3
        )

        pichangasLiveData.value = pichangaList
        pichangaLoadError.value = false
        loading.value = false
    }
}
