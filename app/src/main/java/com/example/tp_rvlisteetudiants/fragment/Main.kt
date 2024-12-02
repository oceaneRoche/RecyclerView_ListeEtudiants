package com.example.tp_rvlisteetudiants.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_rvlisteetudiants.R
import com.example.tp_rvlisteetudiants.databinding.FragmentMainBinding
import com.example.tp_rvlisteetudiants.models.DataViewModel
import com.example.tp_rvlisteetudiants.recyclerview.MyAdapter
import com.example.tp_rvlisteetudiants.retrofit.ApiAdapteur
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Main : Fragment(R.layout.fragment_main) {
    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModelPartage : DataViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelPartage = ViewModelProvider(this).get(DataViewModel::class.java)
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        miseAJour()
        return binding.root
    }

    private fun miseAJour() {
        GlobalScope.launch(Dispatchers.Main) {
            val response = ApiAdapteur.apiClient.getTousLesEtudiantsEtudiants()
            if(response.isSuccessful){
                response.body()?.let {
                    viewModelPartage.updateData(it)
                    binding.rvEtudiants.adapter= MyAdapter(viewModelPartage.data.value!!)
                    binding.rvEtudiants.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                }
            }
        }
    }

}