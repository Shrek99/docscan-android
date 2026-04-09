# Architecture

## Executive recommendation

### Android stack
- Kotlin
- Jetpack Compose
- CameraX
- OpenCV
- ML Kit Text Recognition v2
- Room
- Hilt
- WorkManager
- Timber
- Firebase Crashlytics or Sentry

### Backend direction for later phases
- NestJS API
- PostgreSQL
- Redis + BullMQ
- S3-compatible object storage
- Railway deployment for API/web later, not for the Android app itself

### Core architectural choice
Use **Clean Architecture + MVVM + modular monolith**.

This keeps the app replaceable at the seams where change is likely:
- OCR engine
- quality scoring engine
- extraction engine
- export engine
- sync transport

## Android module structure

```text
android/
  app/
  core/common/
  core/ui/
  core/designsystem/
  core/camera/
  core/cv/
  core/ocr/
  core/storage/
  core/database/
  core/network/
  domain/
  data/
  feature_scan/
  feature_review/
  feature_documents/
  feature_export/
  feature_sync/
  feature_settings/
```

## Main flows

### 1. Capture flow
1. Open camera preview
2. Detect document contour
3. Show real-time quality guidance
4. Capture image
5. Run post-capture quality validation
6. If pass, persist original + cropped image
7. Start OCR and extraction

### 2. Review flow
1. Show original image and processed image
2. Show detected document type
3. Show extracted fields with confidence
4. Highlight low-confidence fields
5. Let user correct values
6. Save corrected structured record

### 3. Export flow
1. User selects documents/results
2. App generates `.xlsx`
3. Save export locally
4. Share/export file externally on demand

## Quality validation strategy
All acceptance checks should happen on-device before the scan is accepted.

### Metrics
- blur via variance of Laplacian
- lighting via histogram and local brightness variance
- shadows via region brightness difference
- glare via clipped highlight detection in probable text area
- skew/perspective via contour geometry
- cut-off edges via contour/frame intersection
- background noise via contour confidence and non-document clutter
- resolution via cropped document size threshold

### Decision model
- weighted quality score 0-100
- hard-fail for severe blur, cut edges, severe glare, failed contour, very low resolution
- show user-facing guidance, not raw CV jargon

## OCR and extraction pipeline

### MVP pipeline
1. perspective correction
2. contrast normalization / optional thresholding
3. ML Kit OCR
4. block/line/token grouping
5. rule-based document classification
6. field extraction per document type
7. header mapping into canonical schema
8. confidence scoring
9. manual review if confidence is low

### Supported MVP document types
- invoices
- receipts
- generic structured forms
- generic semi-structured documents

## Data model direction

### Core entities
- Document
- DocumentImage
- ScanQualityResult
- OCRResult
- ExtractedField
- ExtractedRow
- ExportJob
- SyncJob
- Template
- DocumentType
- ReviewAction

## Future backend compatibility
The Android app should already persist fields needed for sync later:
- localId
- remoteId nullable
- syncStatus
- extractionVersion
- updatedAt
- correctedByUser

## Non-goals for phase 1
- no LLM extraction
- no server dependency for core scan flow
- no web dashboard yet
- no heavy multi-tenant backend concerns inside Android MVP
