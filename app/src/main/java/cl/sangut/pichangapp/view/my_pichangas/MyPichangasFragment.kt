package cl.sangut.pichangapp.view.my_pichangas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sangut.pichangapp.R
import cl.sangut.pichangapp.databinding.FragmentMyPichangasBinding
import cl.sangut.pichangapp.view.shared.PichangaListAdapter
import cl.sangut.pichangapp.viewmodel.my_pichangas.MyPichangasViewModel

class MyPichangasFragment : Fragment() {

    private lateinit var myPichangasViewModel: MyPichangasViewModel
    private var _binding: FragmentMyPichangasBinding? = null
    private val pichangaListAdapter = PichangaListAdapter(arrayListOf())

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myPichangasViewModel =
            ViewModelProvider(this)[MyPichangasViewModel::class.java]

        _binding = FragmentMyPichangasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPichangasViewModel.refresh()

        binding.myPichangasRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pichangaListAdapter
        }

        // TODO remove this
        // Esto es mala practica, pero sirve para el tema de la navegacion
        binding.newPichangaActionButton.setOnClickListener {
            val action = MyPichangasFragmentDirections.goToNewPichangaFragment()
            action.userUuid = 1
            findNavController().navigate(R.id.goToNewPichangaFragment)
        }

        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModel() {
        myPichangasViewModel.pichangasLiveData.observe(viewLifecycleOwner) { pichangas ->
            pichangas?.let {
                binding.myPichangasRefreshError.visibility = View.VISIBLE
                binding.myPichangasRecyclerView.visibility = View.VISIBLE
                pichangaListAdapter.updatePichangaList(pichangas)
            }
        }

        myPichangasViewModel.pichangaLoadError.observe(viewLifecycleOwner) { isError ->
            isError?.let {
                binding.myPichangasRefreshError.visibility = if(it) View.VISIBLE else View.GONE
            }
        }

        myPichangasViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            isLoading?.let {
                if (it) {
                    binding.myPichangasRecyclerView.visibility = View.GONE
                    binding.myPichangasRefreshError.visibility = View.GONE
                }
            }
        }
    }
}
