package com.developers.jectpackcomposestructures.data.remote.dto

import com.developers.jectpackcomposestructures.domain.model.Coin
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CoinDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String,
) : Serializable

fun CoinDto.toCoin() = Coin(id, isActive, isNew, name, rank, symbol)