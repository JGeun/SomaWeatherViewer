package org.soma.weatherviewer.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.soma.weatherviewer.common.MainActivityUtil
import org.soma.weatherviewer.home.databinding.FragmentHomeBinding
import org.soma.weatherviewer.home.detail.WeatherDetailFragment
import org.soma.weatherviewer.home.detail.WeatherDetailInfoFragment

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeFragmentListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
            listener = this@HomeFragment
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WeatherDetailFragment())
            .commit()

        return binding.root
    }

    override fun onClick5DaysButton() {
        (activity as MainActivityUtil).navigateToWeatherFragment(this)
    }

    override fun onClickSettingButton() {
        (activity as MainActivityUtil).navigateToSettingFragment(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

interface HomeFragmentListener {
    fun onClick5DaysButton()
    fun onClickSettingButton()
}