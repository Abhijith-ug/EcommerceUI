package com.abhijith.ecommerceclone.domain.models

data class Value(
    val actual_price: String?,
    val banner_url: String?,
    val id: Int?,
    val image: String?,
    val image_url: String,
    val is_express: Boolean?,
    val name: String?,
    val offer: Int?,
    val offer_price: String?
)