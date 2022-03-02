package cl.sangut.pichangapp.viewmodel.shared

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.sangut.pichangapp.model.data.Pichanga
import cl.sangut.pichangapp.model.data.PichangaLocation
import cl.sangut.pichangapp.model.data.Team
import java.time.LocalDateTime

class PichangaDetailsViewModel: ViewModel() {

  internal val pichangaLiveData = MutableLiveData<Pichanga>()

  fun getData() {
    val pichangaLocation1 = PichangaLocation(
      "1",
      "0",
      "0",
      "Sausalito"
    )
    val homeTeam = Team(
      "1",
      "Sangut FC",
      "fc@sangut.cl",
      "123123",
      "feminine",
      null
    )
    val pichanga = Pichanga(
      "1",
      pichangaLocation1,
      LocalDateTime.now(),
      homeTeam,
      null,
      "instrucciones",
      null
    )

    pichangaLiveData.value = pichanga
  }
}
