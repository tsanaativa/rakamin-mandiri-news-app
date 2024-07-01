package com.tsanaativa.newsapp.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.tsanaativa.newsapp.presentation.MainViewModel
import com.tsanaativa.newsapp.presentation.home.components.ArticleCard

@Composable
fun ArticleList(mainViewModel: MainViewModel) {

    val scrollState = rememberLazyListState()
    val isItemReachEndScroll by remember {
        derivedStateOf {
            scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ==
                    scrollState.layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(key1 = isItemReachEndScroll, block = {
        if (mainViewModel.articlesResponse.isNotEmpty())
            mainViewModel.loadMoreArticles()
    })

    LazyColumn(
        state = scrollState
    ) {
        itemsIndexed(mainViewModel.articlesResponse) { _, item -> ArticleCard(article = item) }
    }
}