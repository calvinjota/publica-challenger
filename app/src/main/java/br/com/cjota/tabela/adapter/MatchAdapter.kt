package br.com.cjota.tabela.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cjota.tabela.holder.MatchViewHolder
import br.com.cjota.tabela.model.Match

class MatchAdapter(var list: List<Match>) : RecyclerView.Adapter<MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}