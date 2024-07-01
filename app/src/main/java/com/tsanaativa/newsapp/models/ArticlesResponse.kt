package com.example.newsapp.models

data class ArticlesResponse (
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Article>,
)