package br.com.cjota.tabela

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import br.com.cjota.tabela.model.Match
import java.lang.Exception

class MainViewModel : ViewModel() {
    val matchList = mutableListOf(
        Match(1, 12, 12, 12, 0, 0),
        Match(2, 24, 12, 24, 0, 1),
        Match(3, 10, 10, 24, 1, 1),
        Match(4, 24, 10, 24, 1, 1)
    )

    fun getSortedList(): List<Match> {
        return matchList.sortedBy { it.numberMatch }
    }

    fun getMinMaxScore(): Pair<Int, Int> {
        val minScore = matchList.minOf { it.minSeason }
        val maxScore = matchList.maxOf { it.maxSeason }
        return minScore to maxScore
    }

    fun getMinMaxRecord(): Pair<Int, Int> {
        val minRecord = matchList.maxOf { it.minRecord }
        val maxRecord = matchList.maxOf { it.maxRecord }
        return minRecord to maxRecord
    }

    fun addScore(_newScore: String, context: Context): Boolean {
        if (!isValidScore(_newScore)) {
            Toast.makeText(context, "Placar invalido!", Toast.LENGTH_LONG).show()
            return false
        }
        val newScore = _newScore.toInt()
        val (minScore, maxScore) = getMinMaxScore()
        var (minRecord, maxRecord) = getMinMaxRecord()
        val newMatch = Match(
            numberMatch = matchList.size + 1,
            score = newScore,
            minSeason = if (newScore < minScore) newScore else minScore,
            maxSeason = if (newScore > maxScore) newScore else maxScore,
            minRecord = if (newScore < minScore) ++minRecord else minRecord,
            maxRecord = if (newScore > maxScore) ++maxRecord else maxRecord
        )
        matchList.add(newMatch)
        return true
    }

    private fun isValidScore(newScore: String): Boolean {
        return try {
            newScore.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }
}