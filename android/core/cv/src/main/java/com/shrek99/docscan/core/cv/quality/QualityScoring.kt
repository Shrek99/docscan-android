package com.shrek99.docscan.core.cv.quality

import com.shrek99.docscan.domain.model.ScanQualityResult

object QualityScoring {
    fun buildResult(
        documentId: String,
        blurScore: Int,
        lightingScore: Int,
        shadowScore: Int,
        glareScore: Int,
        skewScore: Int,
        edgeScore: Int,
        resolutionScore: Int,
        failReasons: List<String>,
        guidance: List<String>,
    ): ScanQualityResult {
        val weighted = (
            blurScore * 0.25 +
                lightingScore * 0.20 +
                shadowScore * 0.10 +
                glareScore * 0.15 +
                skewScore * 0.10 +
                edgeScore * 0.10 +
                resolutionScore * 0.10
            ).toInt().coerceIn(0, 100)

        val hardFail = failReasons.isNotEmpty()

        return ScanQualityResult(
            documentId = documentId,
            overallScore = weighted,
            blurScore = blurScore,
            lightingScore = lightingScore,
            shadowScore = shadowScore,
            glareScore = glareScore,
            skewScore = skewScore,
            edgeScore = edgeScore,
            resolutionScore = resolutionScore,
            failReasons = failReasons.distinct(),
            guidance = guidance.distinct(),
            accepted = !hardFail && weighted >= 70,
        )
    }
}
