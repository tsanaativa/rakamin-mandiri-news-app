package com.tsanaativa.newsapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.models.Article
import com.tsanaativa.newsapp.R
import com.tsanaativa.newsapp.presentation.Dimension
import com.tsanaativa.newsapp.utils.Formatter

@Composable
fun ArticleCard(article: Article) {
    val context = LocalContext.current
    Row (
        modifier = Modifier.padding(Dimension.ExtraSmallPadding3),
        horizontalArrangement = Arrangement.spacedBy(Dimension.ExtraSmallPadding2)
    ) {
        AsyncImage(modifier = Modifier
            .size(Dimension.ArticleCardSize)
            .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimension.ExtraSmallPadding2)
                .height(Dimension.ArticleCardSize)
        ) {
            Text(
                text = article.title?:"",
                style = MaterialTheme.typography.bodyMedium.copy(),
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(0.5f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_person_outline_24),
                        contentDescription = null,
                        modifier = Modifier.size(Dimension.SmallIconSize),
                        tint = colorResource(id = R.color.primary)
                    )
                    Spacer(modifier = Modifier.width(Dimension.ExtraSmallPadding))
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        text = article.author?:"Unknown",
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
                Spacer(modifier = Modifier.width(Dimension.ExtraSmallPadding2))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                        contentDescription = null,
                        modifier = Modifier.size(Dimension.SmallIconSize),
                        tint = colorResource(id = R.color.primary)
                    )
                    Spacer(modifier = Modifier.width(Dimension.ExtraSmallPadding))
                    Text(
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        text = Formatter.formatDate(article.publishedAt?:""),
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}