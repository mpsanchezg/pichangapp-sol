package cl.sangut.pichangapp.view.shared

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.sangut.pichangapp.R
import cl.sangut.pichangapp.model.data.Pichanga
import java.time.format.DateTimeFormatter

class PichangaListAdapter(private val pichangaList: ArrayList<Pichanga>)
  :  RecyclerView.Adapter<PichangaListAdapter.PichangaViewHolder>() {


  fun updatePichangaList(newPichangaList: List<Pichanga>) {
    pichangaList.clear()
    pichangaList.addAll(newPichangaList)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PichangaViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view = inflater.inflate(R.layout.item_pichanga, parent, false)

    return PichangaViewHolder(view)
  }

  override fun onBindViewHolder(holder: PichangaViewHolder, position: Int) {
    val pichanga = pichangaList[position]
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")

    holder.organizerTeam.text = addModelText(holder.organizerTeam.text, pichanga.homeTeam.name)
    holder.dateTime.text = addModelText(holder.dateTime.text, pichanga.dateTime.format(formatter))
    holder.place.text = addModelText(holder.place.text, pichanga.location.placeName)
    holder.detailsButton.setOnClickListener() {
      val bundle = bundleOf("pichangaId" to pichanga.pichangaId)
      Navigation.findNavController(it).navigate(R.id.goToPichangaDetails, bundle)
    }
  }

  override fun getItemCount(): Int = pichangaList.size

  inner class PichangaViewHolder(view: View)
    : RecyclerView.ViewHolder(view) {
    val organizerTeam: TextView = view.findViewById(R.id.pichangaOrganizerTextView)
    val dateTime: TextView = view.findViewById(R.id.pichangaDateTextView)
    val place: TextView = view.findViewById(R.id.pichangaPlaceTextView)
    val joinButton: Button = view.findViewById(R.id.joinButton)
    val detailsButton: Button = view.findViewById(R.id.detailsButton)
  }
}

private fun addModelText(charSeq: CharSequence, text: String): String {
  return "$charSeq: $text"
}
