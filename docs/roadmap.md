# Roadmap

## Phase 1 — Android MVP

### Objectives
- robust document capture
- strict scan quality validation
- on-device OCR
- structured extraction
- review/correction
- Excel export

### Milestones
1. Project skeleton and module boundaries
2. CameraX capture + contour detection
3. Quality scoring and retake guidance
4. OCR + document classification
5. Structured field extraction + review UI
6. `.xlsx` export
7. Field testing on real devices and real documents

## Phase 2 — Backend + sync
- auth
- upload APIs
- document/object storage
- async processing jobs
- export history
- correction sync

## Phase 3 — Web dashboard on Railway
- document search/list
- review workflows
- export history
- admin visibility

## Phase 4 — AI enrichment
- optional server-side normalization
- reprocessing with improved extraction versions
- advanced automation and template evolution

## Immediate execution order
1. Generate Android multi-module project
2. Define domain models and repository interfaces
3. Implement scan-quality engine
4. Implement OCR + extraction strategy
5. Implement review flow
6. Implement Excel export
