package br.com.cjota.tabela.model

data class Match(
    val numberMatch: Int,
    val score: Int,
    val minSeason: Int,
    val maxSeason: Int,
    val minRecord: Int,
    val maxRecord: Int
)