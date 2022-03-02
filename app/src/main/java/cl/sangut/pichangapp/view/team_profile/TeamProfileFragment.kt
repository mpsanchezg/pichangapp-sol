package cl.sangut.pichangapp.view.team_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.sangut.pichangapp.databinding.FragmentProfileBinding
import cl.sangut.pichangapp.viewmodel.team_profile.TeamProfileViewModel

class TeamProfileFragment : Fragment() {

    private lateinit var teamProfileViewModel: TeamProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        teamProfileViewModel =
            ViewModelProvider(this)[TeamProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamProfileViewModel.getData()

        binding.editTeamButton.setOnClickListener { showEditProfileView() }
        binding.cancelEditTeamButton.setOnClickListener { showProfileView() }
        binding.saveTeamButton.setOnClickListener { updateTeam() }

        observeTeamProfileViewModel()
    }

    private fun updateTeam() {
        teamProfileViewModel.updateTeam()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeTeamProfileViewModel() {
        teamProfileViewModel.teamLiveData.observe(viewLifecycleOwner) { team ->
            team?.let {
                binding.nameTextView.text = team.name
                binding.emailTextView.text = team.mail
                binding.categoryTextView.text = team.category
            }
        }
    }

    private fun showEditProfileView() {
        binding.nameTextView.visibility = View.GONE
        binding.emailTextView.visibility = View.GONE
        binding.categoryTextView.visibility = View.GONE

        binding.nameEditText.visibility = View.VISIBLE
        binding.emailEditText.visibility = View.VISIBLE
        binding.categoryEditText.visibility = View.VISIBLE

        binding.cancelEditTeamButton.visibility = View.VISIBLE
        binding.saveTeamButton.visibility = View.VISIBLE
        binding.editTeamButton.visibility = View.GONE
    }

    private fun showProfileView() {
        binding.nameTextView.visibility = View.VISIBLE
        binding.emailTextView.visibility = View.VISIBLE
        binding.categoryTextView.visibility = View.VISIBLE

        binding.nameEditText.visibility = View.GONE
        binding.emailEditText.visibility = View.GONE
        binding.categoryEditText.visibility = View.GONE

        binding.cancelEditTeamButton.visibility = View.GONE
        binding.saveTeamButton.visibility = View.GONE
        binding.editTeamButton.visibility = View.VISIBLE
    }
}
