package cl.sangut.pichangapp.view.shared

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import cl.sangut.pichangapp.databinding.FragmentPichangaDetailsBinding
import cl.sangut.pichangapp.viewmodel.shared.PichangaDetailsViewModel
import java.time.format.DateTimeFormatter

class PichangaDetailsFragment : Fragment() {

  private lateinit var pichangaDetailsViewModel: PichangaDetailsViewModel
  private var _binding: FragmentPichangaDetailsBinding? = null
  private var pichangaId = "0"

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreate(savedInstanceState)
    pichangaDetailsViewModel =
      ViewModelProvider(this)[PichangaDetailsViewModel::class.java]

    _binding = FragmentPichangaDetailsBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    pichangaDetailsViewModel.getData()

    arguments?.let {
      pichangaId = PichangaDetailsFragmentArgs.fromBundle(it).pichangaId
    }

    observePichangaDetailsViewModel()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun observePichangaDetailsViewModel() {
    pichangaDetailsViewModel.pichangaLiveData.observe(viewLifecycleOwner) { pichanga ->
      pichanga?.let {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")

        binding.pichangaOrganizerTextView.text = pichanga.homeTeam.name
        binding.pichangaDateTextView.text = pichanga.dateTime.format(formatter)
        binding.pichangaPlaceTextView.text = pichanga.location.placeName
        binding.pichangaInstructionsTextView.text = pichanga.instructions
      }
    }
  }
}
