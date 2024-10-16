package com.nelalexxx.myfoodapp.ui.fragments

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.nelalexxx.myfoodapp.databinding.LoadingFragmentLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingFragment : BindingFragment<LoadingFragmentLayoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = LoadingFragmentLayoutBinding::inflate
}
