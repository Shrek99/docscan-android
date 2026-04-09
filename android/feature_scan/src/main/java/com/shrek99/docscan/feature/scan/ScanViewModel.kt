package com.shrek99.docscan.feature.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shrek99.docscan.core.cv.quality.ScanQualityAnalyzer
import com.shrek99.docscan.core.cv.quality.ScanQualityInput
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScanViewModel(
    private val scanQualityAnalyzer: ScanQualityAnalyzer,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ScanUiState())
    val uiState: StateFlow<ScanUiState> = _uiState.asStateFlow()

    fun onCameraReady() {
        _uiState.value = _uiState.value.copy(isCameraReady = true)
    }

    fun analyzeCapture(documentId: String, imagePath: String, width: Int, height: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isAnalyzing = true)
            val result = scanQualityAnalyzer.analyze(
                ScanQualityInput(
                    documentId = documentId,
                    imagePath = imagePath,
                    width = width,
                    height = height,
                )
            )
            _uiState.value = _uiState.value.copy(
                isAnalyzing = false,
                lastQualityScore = result.overallScore,
                hardFailReasons = result.failReasons,
                liveGuidance = result.guidance,
                canAcceptCapture = result.accepted,
            )
        }
    }
}
