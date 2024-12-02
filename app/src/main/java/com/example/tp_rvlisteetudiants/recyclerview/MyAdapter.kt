package com.example.tp_rvlisteetudiants.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_rvlisteetudiants.databinding.ItemEtudiantsBinding
import com.example.tp_rvlisteetudiants.models.Etudiant

class MyAdapter (private val LesEtudiants : ArrayList<Etudiant>) : RecyclerView.Adapter<MyHolder>() {
    private lateinit var binding : ItemEtudiantsBinding
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyHolder {
        binding = ItemEtudiantsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return LesEtudiants.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(LesEtudiants.get(position))
    }
}