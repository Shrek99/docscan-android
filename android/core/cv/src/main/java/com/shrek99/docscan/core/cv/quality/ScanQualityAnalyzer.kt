package com.shrek99.docscan.core.cv.quality

import com.shrek99.docscan.domain.model.ScanQualityResult

interface ScanQualityAnalyzer {
    suspend fun analyze(input: ScanQualityInput): ScanQualityResult
}

data class ScanQualityInput(
    val documentId: String,
    val imagePath: String,
    val width: Int,
    val height: Int,
)
