package com.shrek99.docscan.core.cv.quality

import com.shrek99.docscan.domain.model.ScanQualityResult
import com.shrek99.docscan.feature.scan.capture.ScanGuidance

class StubScanQualityAnalyzer : ScanQualityAnalyzer {
    override suspend fun analyze(input: ScanQualityInput): ScanQualityResult {
        val failReasons = mutableListOf<String>()
        val guidance = mutableListOf<String>()

        val blurScore = 80
        val lightingScore = 75
        val shadowScore = 85
        val glareScore = 80
        val skewScore = 90
        val edgeScore = 88
        val resolutionScore = if (input.width < 1200 || input.height < 1200) 45 else 85

        if (resolutionScore < 60) {
            failReasons += "low_resolution"
            guidance += ScanGuidance.MOVE_CLOSER
        }

        return QualityScoring.buildResult(
            documentId = input.documentId,
            blurScore = blurScore,
            lightingScore = lightingScore,
            shadowScore = shadowScore,
            glareScore = glareScore,
            skewScore = skewScore,
            edgeScore = edgeScore,
            resolutionScore = resolutionScore,
            failReasons = failReasons,
            guidance = guidance,
        )
    }
}
