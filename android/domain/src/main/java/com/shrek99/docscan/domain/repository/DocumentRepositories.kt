package com.shrek99.docscan.domain.repository

import com.shrek99.docscan.domain.model.Document
import com.shrek99.docscan.domain.model.DocumentImage
import com.shrek99.docscan.domain.model.ExtractedField
import com.shrek99.docscan.domain.model.ExtractedRow
import com.shrek99.docscan.domain.model.OCRResult
import com.shrek99.docscan.domain.model.ScanQualityResult

interface DocumentRepository {
    suspend fun create(document: Document): String
    suspend fun update(document: Document)
    suspend fun getById(documentId: String): Document?
    suspend fun listActive(): List<Document>
}

interface DocumentImageRepository {
    suspend fun save(image: DocumentImage)
    suspend fun listByDocument(documentId: String): List<DocumentImage>
}

interface QualityRepository {
    suspend fun save(result: ScanQualityResult)
    suspend fun getByDocument(documentId: String): ScanQualityResult?
}

interface OcrRepository {
    suspend fun save(result: OCRResult)
    suspend fun getByDocument(documentId: String): OCRResult?
}

interface ExtractionRepository {
    suspend fun saveFields(fields: List<ExtractedField>)
    suspend fun saveRows(rows: List<ExtractedRow>)
    suspend fun getFields(documentId: String): List<ExtractedField>
    suspend fun getRows(documentId: String): List<ExtractedRow>
}
