package com.abhijith.ecommerceclone.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.abhijith.ecommerceclone.R
import com.abhijith.ecommerceclone.domain.models.Value
import com.abhijith.ecommerceclone.presentation.ui.theme.GoldColor
import com.abhijith.ecommerceclone.util.SpaceLarge
import com.abhijith.ecommerceclone.util.SpaceMedium
import com.abhijith.ecommerceclone.util.SpaceSmall

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductItem(
    product: Value,
    modifier: Modifier = Modifier,
    imageLoader: ImageLoader
) {
    Column(
        modifier = modifier
            .width(180.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = MaterialTheme.shapes.large
            )
            .clip(MaterialTheme.shapes.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(SpaceMedium))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Offer Tag
            TagShape("${product.offer}% OFF")
            // Favorite Button
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
        // Product Image
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = rememberImagePainter(
                data = product.image,
                imageLoader = imageLoader
            ),
            contentDescription = null
        )
        Column(Modifier.padding(SpaceMedium)) {
            // Truck Icon
            if (product.is_express == true) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(25.dp)
                            .clip(shape = MaterialTheme.shapes.small)
                            .background(GoldColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_truck),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }

            // Prices
            Text(
                text = product.actual_price ?: "",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                    textDecoration = TextDecoration.LineThrough
                )
            )
            Text(
                text = product.offer_price ?: "",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            )
            // Product Name
            Text(
                text = product.name ?: "",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            // Add Button
            Spacer(modifier = Modifier.height(SpaceSmall))
            AddButton {

            }
        }
    }
}

@Composable
fun TagShape(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .width(80.dp)
                .height(SpaceLarge),
            shape = CutCornerShape(
                topEndPercent = 50,
                bottomEndPercent = 50
            ),
            colors = CardDefaults.cardColors(containerColor = Color.Red),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}