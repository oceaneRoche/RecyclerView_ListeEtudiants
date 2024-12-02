package com.example.tp_rvlisteetudiants.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.tp_rvlisteetudiants.databinding.ItemEtudiantsBinding
import com.example.tp_rvlisteetudiants.models.Etudiant

class MyHolder (private val binding : ItemEtudiantsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun  bind(etudiant: Etudiant){
        binding.etudiant = etudiant
    }
}