package cl.sangut.pichangapp.view.upcoming_pichangas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.sangut.pichangapp.databinding.FragmentUpcomingPichangasBinding
import cl.sangut.pichangapp.viewmodel.upcoming_pichangas.UpcomingPichangasViewModel

class UpcomingPichangasFragment : Fragment() {

  // RES: late init: inicializar mas tarde
  private lateinit var upcomingPichangasViewModel: UpcomingPichangasViewModel
  private var _binding: FragmentUpcomingPichangasBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, // RES: clase que se encarga de que una vista se "incurste" en un fragment/activity
    container: ViewGroup?, // RES: o "parent" porque una vista esta contenida en otras.
    savedInstanceState: Bundle?
  ): View? {
    upcomingPichangasViewModel =
      ViewModelProvider(this).get(UpcomingPichangasViewModel::class.java)

    _binding = FragmentUpcomingPichangasBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textUpcomingPichangas
    upcomingPichangasViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
