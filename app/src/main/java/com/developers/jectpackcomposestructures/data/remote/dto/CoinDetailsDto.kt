package com.developers.jectpackcomposestructures.data.remote.dto


import com.developers.jectpackcomposestructures.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailsDto(
    @SerializedName("contract")
    val contract: String,
    @SerializedName("contracts")
    val contracts: List<Contract>,
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("parent")
    val parent: Parent,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitePaper: WhitePaper,
)

fun CoinDetailsDto.toCoinDetails() = CoinDetail(coinId = id,
    name = name,
    description = description,
    symbol,
    rank,
    isActive,
    tags.map {tag -> tag.name },
    team
)