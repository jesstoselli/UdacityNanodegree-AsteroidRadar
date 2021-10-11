package com.udacity.asteroidradar.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(
            this,
            MainViewModelFactory(activity.application)
        ).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.asteroidRecycler.adapter = AsteroidsAdapter(AsteroidsAdapter.AsteroidClick {
            viewModel.asteroidClicked(it)
        })

        viewModel.navigateToDetails.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { asteroidItem ->
                findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroidItem))
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.show_week_menu -> viewModel.onFilter(AsteroidRepository.FilterType.WEEK)
            R.id.show_today_menu -> viewModel.onFilter(AsteroidRepository.FilterType.TODAY)
            R.id.show_saved_menu -> viewModel.onFilter(AsteroidRepository.FilterType.FROM_DATABASE)
        }
        return true
    }
}
