# docscan-android

Android-first document scanning and structured extraction app.

## Phase 1 goal
Build a production-serious Android app that can:
- capture documents with strong scan-quality validation
- extract OCR text
- classify supported document types
- map extracted fields into structured data
- let users review/correct results
- export ordered `.xlsx` files
- stay architecturally ready for a future backend and web app on Railway

## Product principles
- No LLM dependency in extraction
- Reliability over hype
- Quality validation before OCR acceptance
- Offline-first local workflow
- Modular architecture so backend sync and richer extraction can be added later

## Planned stack
- Kotlin
- Jetpack Compose
- CameraX
- OpenCV
- ML Kit Text Recognition
- Room
- Hilt
- WorkManager

## Initial repo contents
- `docs/architecture.md` — implementation architecture and system design
- `docs/roadmap.md` — MVP and phased roadmap
- `android/` — Android app workspace placeholder for implementation

## Immediate next build targets
1. Create Android multi-module project skeleton
2. Implement capture pipeline with CameraX
3. Add on-device scan quality scoring
4. Add OCR pipeline and structured extraction domain model
5. Add review/correction and Excel export
