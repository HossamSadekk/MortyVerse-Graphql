package com.example.domain.model

data class Info(
    /**
     * The amount of pages.
     */
    val pages: Int,
    /**
     * The length of the response.
     */
    public val count: Int,
    /**
     * Number of the next page (if it exists)
     */
    public val next: Int,
)