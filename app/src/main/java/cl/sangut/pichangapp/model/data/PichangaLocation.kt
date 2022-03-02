package cl.sangut.pichangapp.model.data

import com.google.gson.annotations.SerializedName

data class PichangaLocation(
  @SerializedName("id")
  var pichangaLocationId: String,
  @SerializedName("latitude")
  var latitude: String,
  @SerializedName("longitude")
  var longitude: String,
  @SerializedName("place_name")
  var placeName: String,
)
