package com.abhijith.ecommerceclone.presentation.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.abhijith.ecommerceclone.domain.models.Value
import com.abhijith.ecommerceclone.util.SpaceSmall
import kotlin.random.Random

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CategoryItem(
    item: Value,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    imageLoader: ImageLoader
) {
    val randomColor = remember {
        Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 0.15f
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(randomColor)
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(60.dp),
                painter = rememberImagePainter(
                    data = item.image_url,
                    imageLoader = imageLoader
                ),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(SpaceSmall))
        Text(
            text = item.name ?: "",
            style = MaterialTheme.typography.bodySmall.copy(
                textAlign = TextAlign.Center
            )
        )
    }
}