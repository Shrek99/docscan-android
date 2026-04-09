package com.shrek99.docscan.domain.usecase

import com.shrek99.docscan.domain.model.DocumentImage
import com.shrek99.docscan.domain.model.DocumentType
import com.shrek99.docscan.domain.model.ExtractedField
import com.shrek99.docscan.domain.model.ExtractedRow
import com.shrek99.docscan.domain.model.OCRResult
import com.shrek99.docscan.domain.model.ScanQualityResult

data class CaptureAnalysis(
    val quality: ScanQualityResult,
    val processedImage: DocumentImage?,
)

data class ExtractionResult(
    val documentType: DocumentType?,
    val ocrResult: OCRResult,
    val fields: List<ExtractedField>,
    val rows: List<ExtractedRow>,
)

interface AnalyzeCapturedDocument {
    suspend operator fun invoke(originalImage: DocumentImage): CaptureAnalysis
}

interface ExtractStructuredData {
    suspend operator fun invoke(documentId: String, processedImage: DocumentImage): ExtractionResult
}
