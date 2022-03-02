package cl.sangut.pichangapp.model.data

import android.media.Image
import com.google.gson.annotations.SerializedName

data class Team(
  @SerializedName("id")
  var teamId: String,
  @SerializedName("name")
  var name: String,
  @SerializedName("mail")
  var mail: String,
  @SerializedName("password")
  var password: String,
  @SerializedName("category")
  var category: String,
  @SerializedName("image")
  var image: Image?,
)
