package com.shrek99.docscan.domain.model

import java.time.Instant

enum class DocumentStatus {
    CAPTURED,
    QUALITY_REJECTED,
    OCR_DONE,
    EXTRACTED,
    REVIEW_REQUIRED,
    READY_FOR_EXPORT,
    EXPORTED,
}

enum class SyncStatus {
    LOCAL_ONLY,
    PENDING_SYNC,
    SYNCED,
    SYNC_FAILED,
}

enum class ReviewStatus {
    UNREVIEWED,
    USER_CONFIRMED,
    USER_CORRECTED,
    LOW_CONFIDENCE,
}

enum class ImageType {
    ORIGINAL,
    CROPPED,
    ENHANCED,
    THUMBNAIL,
}

data class DocumentType(
    val id: String,
    val code: String,
    val displayName: String,
    val canonicalHeaders: List<String>,
)

data class Document(
    val id: String,
    val documentType: DocumentType?,
    val status: DocumentStatus,
    val captureTimestamp: Instant,
    val qualityScore: Int,
    val syncStatus: SyncStatus,
    val extractionVersion: Int,
    val localOnly: Boolean,
)

data class DocumentImage(
    val id: String,
    val documentId: String,
    val imageType: ImageType,
    val filePath: String,
    val width: Int,
    val height: Int,
    val checksum: String,
)

data class ScanQualityResult(
    val documentId: String,
    val overallScore: Int,
    val blurScore: Int,
    val lightingScore: Int,
    val shadowScore: Int,
    val glareScore: Int,
    val skewScore: Int,
    val edgeScore: Int,
    val resolutionScore: Int,
    val failReasons: List<String>,
    val guidance: List<String>,
    val accepted: Boolean,
)

data class OCRResult(
    val documentId: String,
    val rawText: String,
    val blocksJson: String,
    val engine: String,
    val engineVersion: String,
    val languageHints: List<String>,
)

data class ExtractedField(
    val id: String,
    val documentId: String,
    val fieldKey: String,
    val fieldLabel: String,
    val rawValue: String?,
    val normalizedValue: String?,
    val finalValue: String?,
    val confidence: Double,
    val correctedByUser: Boolean,
    val reviewStatus: ReviewStatus,
)

data class ExtractedRow(
    val id: String,
    val documentId: String,
    val rowType: String,
    val rowIndex: Int,
    val valuesJson: String,
    val confidence: Double,
)

data class ExportJob(
    val id: String,
    val createdAt: Instant,
    val format: String,
    val status: String,
    val outputPath: String?,
)
