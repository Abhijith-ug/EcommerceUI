package com.abhijith.ecommerceclone.domain.models

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
   val route:String,
   val icon: Painter,
   val contentDescription:String,
)