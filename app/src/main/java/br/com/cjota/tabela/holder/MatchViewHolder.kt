package br.com.cjota.tabela.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cjota.tabela.R
import br.com.cjota.tabela.model.Match
import kotlinx.android.synthetic.main.item_view_match.view.*

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    constructor(parent: ViewGroup) : this(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_view_match,
            parent,
            false
        )
    )

    fun bind(match: Match) {
        itemView.matchNumber.text = match.numberMatch.toString()
        itemView.scoreNumber.text = match.score.toString()
    }
}
