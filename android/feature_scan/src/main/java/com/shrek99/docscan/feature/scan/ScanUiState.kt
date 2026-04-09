package com.shrek99.docscan.feature.scan

data class ScanUiState(
    val isCameraReady: Boolean = false,
    val isAnalyzing: Boolean = false,
    val liveGuidance: List<String> = emptyList(),
    val lastQualityScore: Int? = null,
    val hardFailReasons: List<String> = emptyList(),
    val canAcceptCapture: Boolean = false,
)
