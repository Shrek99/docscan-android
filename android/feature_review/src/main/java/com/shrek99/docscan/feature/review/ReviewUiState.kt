package com.shrek99.docscan.feature.review

import com.shrek99.docscan.domain.model.ExtractedField
import com.shrek99.docscan.domain.model.ExtractedRow

data class ReviewUiState(
    val documentId: String = "",
    val documentTypeLabel: String = "",
    val fields: List<ExtractedField> = emptyList(),
    val rows: List<ExtractedRow> = emptyList(),
    val lowConfidenceCount: Int = 0,
    val canExport: Boolean = false,
)
