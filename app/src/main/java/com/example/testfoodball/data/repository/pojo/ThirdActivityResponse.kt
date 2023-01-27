package com.example.testfoodball

data class Response3(
    val competition: Competition3,
    val count: Int,
    val filters: Filters3,
    val season: Season3,
    val teams: List<Team>
)
data class Competition3(
    val area: Area3,
    val code: String,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val plan: String
)
class Filters3
data class Season3(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String,
    val winner: Any
)
data class Area3(
    val id: Int,
    val name: String
)
data class AreaX(
    val id: Int,
    val name: String
)

data class Team(
    val address: String,
    val area: AreaX,
    val clubColors: String,
    val crestUrl: String,
    val email: String,
    val founded: Int,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val phone: String,
    val shortName: String,
    val tla: String,
    val venue: String,
    val website: String
)