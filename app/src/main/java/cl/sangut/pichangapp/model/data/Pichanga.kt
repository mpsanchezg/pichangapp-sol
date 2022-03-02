package cl.sangut.pichangapp.model.data

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Pichanga(
  @SerializedName("id")
  var pichangaId: String,
  @SerializedName("pichanga_location")
  var location: PichangaLocation,
  @SerializedName("date_time")
  var dateTime: LocalDateTime,
  @SerializedName("home_team")
  var homeTeam: Team,
  @SerializedName("visitor_team")
  var visitorTeam: Team?,
  @SerializedName("instructions")
  var instructions: String,
  @SerializedName("results")
  var results: String?,
)
