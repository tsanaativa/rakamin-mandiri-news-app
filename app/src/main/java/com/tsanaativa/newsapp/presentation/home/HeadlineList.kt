package com.tsanaativa.newsapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.tsanaativa.newsapp.R
import com.tsanaativa.newsapp.presentation.Dimension
import com.tsanaativa.newsapp.presentation.MainViewModel
import com.tsanaativa.newsapp.presentation.home.components.ArticleCard
import com.tsanaativa.newsapp.presentation.home.components.HeadlineCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HeadlineList(mainViewModel: MainViewModel) {
    var index by remember { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true, block = {
        coroutineScope.launch {
            while (true) {
                delay(2500)
                if (index == mainViewModel.headlinesResponse.size - 1) index = 0
                else index++
                scrollState.animateScrollToItem(index)
            }
        }
    })

    LazyRow (
        state = scrollState
    ) {
        itemsIndexed(mainViewModel.headlinesResponse) { _, item -> HeadlineCard(article = item) }
    }
}