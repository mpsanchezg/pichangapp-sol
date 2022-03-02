package cl.sangut.pichangapp.viewmodel.team_profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.sangut.pichangapp.model.data.Team

class TeamProfileViewModel : ViewModel() {

  internal val teamLiveData = MutableLiveData<Team>()

  fun getData() {
    val team = Team(
        "1",
      "Sangut FC",
      "fc@sangut.cl",
      "123123",
      "Feminina",
      null
    )

    teamLiveData.value = team
  }

  fun updateTeam() {

  }
}
