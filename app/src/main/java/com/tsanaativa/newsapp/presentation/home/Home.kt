package com.tsanaativa.newsapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tsanaativa.newsapp.presentation.Dimension
import com.tsanaativa.newsapp.presentation.MainViewModel
import com.tsanaativa.newsapp.presentation.STATE

@Composable
fun Home(mainViewModel: MainViewModel) {
    Column (
    ) {
        Spacer(modifier = Modifier.height(Dimension.ExtraSmallPadding3))
        if (mainViewModel.headlinesResponse.isNotEmpty())
            Text(
                text = "Top Headlines",
                style = MaterialTheme.typography.titleLarge.copy(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = Dimension.ExtraSmallPadding3, vertical = Dimension.ExtraSmallPadding)
            )

        HeadlineList(mainViewModel)
        if (mainViewModel.headlinesResponse.isEmpty())
            mainViewModel.getHeadlines()

        Spacer(modifier = Modifier.height(Dimension.ExtraSmallPadding4))

        if (mainViewModel.articlesResponse.isNotEmpty())
            Text(
                text = "Recent News",
                style = MaterialTheme.typography.titleLarge.copy(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = Dimension.ExtraSmallPadding3, vertical = Dimension.ExtraSmallPadding2)
            )

        ArticleList(mainViewModel)
        if (mainViewModel.articlesResponse.isEmpty())
            mainViewModel.getArticles()


        if (mainViewModel.headlineState == STATE.LOADING || mainViewModel.state == STATE.LOADING) {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card (
                    modifier = Modifier
                        .alpha(0.7f)
                        .padding(50.dp)
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(50.dp)
                    )
                }
            }
        }
    }
    
}