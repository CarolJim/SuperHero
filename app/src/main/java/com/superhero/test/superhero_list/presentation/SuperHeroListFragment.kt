package com.superhero.test.superhero_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.superhero.test.common.BaseFragment
import com.superhero.test.superhero_list.domain.model.SuperHero
import com.superhero.test.superhero_list.domain.model.SuperHeroState
import dagger.hilt.android.AndroidEntryPoint
import test.R
import test.databinding.FragmentHeroListBinding
import java.util.ArrayList

@AndroidEntryPoint
class SuperHeroListFragment : BaseFragment(), OnClickItem {

    private lateinit var binding : FragmentHeroListBinding
    private val superHeroViewModel : SuperHeroViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentHeroListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {

        superHeroViewModel.getSuperHeroState.observe(viewLifecycleOwner){ state ->
            validateState(state)
        }
    }

    private fun validateState(state: SuperHeroState) {
       state.response?.let { arrayList ->  
           setRecyclerSuperHero(arrayList)
       }.run {
           onError()
       }
        when{
            state.error.isNotBlank() -> onError()
            state.isLoading -> onLoadingDialog(getString(R.string.wait_a_little),
                getString(R.string.almost_ready))
        }

    }

    private fun onError() {
        hideLoadingDialog()
        findNavController().navigate(R.id.to_onErrorFragment)
    }

    private fun setRecyclerSuperHero(arrayList: ArrayList<SuperHero>) {
        if (arrayList.isNotEmpty()){
            binding.superHeroRecycler.apply {
                adapter = SuperHeroListAdapter(arrayList,this@SuperHeroListFragment)
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,
                false)
                setHasFixedSize(true)
            }
        }

    }

    override fun onClickListener(hero: SuperHero, position: Int) {
        val extra = SuperHeroListFragmentDirections.toSuperHeroDetailFragment(hero,position)
        findNavController().navigate(extra)
    }

}