package cl.sangut.pichangapp.view.my_pichangas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cl.sangut.pichangapp.databinding.FragmentNewPichangaBinding
import cl.sangut.pichangapp.viewmodel.my_pichangas.MyPichangasViewModel

class NewPichangaFragment : Fragment() {

  private lateinit var newPichangasViewModel: MyPichangasViewModel
  private var _binding: FragmentNewPichangaBinding? = null
  private var userUuid = 0

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    newPichangasViewModel =
      ViewModelProvider(this)[MyPichangasViewModel::class.java]

    _binding = FragmentNewPichangaBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    arguments?.let {
      userUuid = NewPichangaFragmentArgs.fromBundle(it).userUuid
    }

    // TODO remove this
    // Esto es mala practica, pero sirve para el tema de la navegacion
    binding.createPichangaActionButton.setOnClickListener {
      val action = NewPichangaFragmentDirections.goToMyPichangas()
      Navigation.findNavController(it).navigate(action)
    }

  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}
