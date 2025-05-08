package com.example.appmergencybta.ui.modules

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.data.model.Module
import com.example.appmergencybta.databinding.ItemModuleBinding

/**
 * Adaptador para mostrar la lista de módulos en un RecyclerView
 */
class ModulesAdapter(private val onModuleClick: (String) -> Unit) : 
    ListAdapter<Module, ModulesAdapter.ModuleViewHolder>(ModuleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding = ItemModuleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = getItem(position)
        holder.bind(module)
    }

    inner class ModuleViewHolder(private val binding: ItemModuleBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(module: Module) {
            binding.tvModuleTitle.text = module.title
            binding.tvModuleDescription.text = module.description
            binding.imgModule.setImageResource(module.imageResource)
            
            binding.root.setOnClickListener {
                onModuleClick(module.id)
            }
        }
    }
}

/**
 * Callback para comparar elementos en la lista y optimizar actualizaciones
 */
class ModuleDiffCallback : DiffUtil.ItemCallback<Module>() {
    override fun areItemsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem == newItem
    }
}
