# Domain Models

## Document
- id: String
- documentType: DocumentType
- status: DocumentStatus
- captureTimestamp: Instant
- qualityScore: Int
- syncStatus: SyncStatus
- extractionVersion: Int
- localOnly: Boolean

## DocumentImage
- id: String
- documentId: String
- imageType: ImageType (`ORIGINAL`, `CROPPED`, `ENHANCED`, `THUMBNAIL`)
- filePath: String
- width: Int
- height: Int
- checksum: String

## ScanQualityResult
- documentId: String
- overallScore: Int
- blurScore: Int
- lightingScore: Int
- shadowScore: Int
- glareScore: Int
- skewScore: Int
- edgeScore: Int
- resolutionScore: Int
- failReasons: List<String>
- guidance: List<String>
- accepted: Boolean

## OCRResult
- documentId: String
- rawText: String
- blocksJson: String
- engine: String
- engineVersion: String
- languageHints: List<String>

## ExtractedField
- id: String
- documentId: String
- fieldKey: String
- fieldLabel: String
- rawValue: String?
- normalizedValue: String?
- finalValue: String?
- confidence: Double
- correctedByUser: Boolean
- reviewStatus: ReviewStatus

## ExtractedRow
- id: String
- documentId: String
- rowType: String
- rowIndex: Int
- valuesJson: String
- confidence: Double

## ExportJob
- id: String
- createdAt: Instant
- format: String (`XLSX`)
- status: ExportStatus
- outputPath: String?

## DocumentType
- id: String
- code: String
- displayName: String
- canonicalHeaders: List<String>

## Enums
- DocumentStatus: `CAPTURED`, `QUALITY_REJECTED`, `OCR_DONE`, `EXTRACTED`, `REVIEW_REQUIRED`, `READY_FOR_EXPORT`, `EXPORTED`
- SyncStatus: `LOCAL_ONLY`, `PENDING_SYNC`, `SYNCED`, `SYNC_FAILED`
- ReviewStatus: `UNREVIEWED`, `USER_CONFIRMED`, `USER_CORRECTED`, `LOW_CONFIDENCE`
- ExportStatus: `PENDING`, `RUNNING`, `SUCCEEDED`, `FAILED`
