package br.com.cjota.tabela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.cjota.tabela.adapter.MatchAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindSeasonScore()
        bindRecord()
        buttonAddNewMatch.setOnClickListener(::onButtonAddNewMatchClicked)
        bindList()
    }

    private fun bindList() {
        if (recyclerView.adapter == null)
            recyclerView.adapter = MatchAdapter(viewModel.matchList)

        (recyclerView.adapter as? MatchAdapter)?.apply {
            list = viewModel.getSortedList()
            notifyDataSetChanged()
        }
    }

    private fun bindSeasonScore() {
        val (minScore, maxScore) = viewModel.getMinMaxScore()
        textMinSeason.text = "Min: $minScore"
        textMaxSeason.text = "Max: $maxScore"
    }

    private fun bindRecord() {
        val (minRecord, maxRecord) = viewModel.getMinMaxRecord()
        textMinRecord.text = "Min: $minRecord"
        textMaxRecord.text = "Max: $maxRecord"
    }

    private fun onButtonAddNewMatchClicked(view: View) {
        val newScore = editText.text.toString()
        val wasAdded = viewModel.addScore(newScore, baseContext)
        if (wasAdded) {
            bindList()
            bindSeasonScore()
            bindRecord()
            editText.text.clear()
        }
    }
}