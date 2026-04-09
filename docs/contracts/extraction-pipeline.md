# Extraction Pipeline Contract

## MVP flow
1. Capture original image
2. Perspective correction
3. Contrast normalization
4. OCR with ML Kit
5. Document type classification
6. Field extraction
7. Canonical header mapping
8. Confidence scoring
9. Manual review when confidence is low
10. Persist structured result
11. Export to XLSX

## Supported MVP document types
- invoice
- receipt
- generic_form
- generic_structured

## Classification inputs
- OCR text keywords
- regex matches
- layout features
- totals/date signatures

## Extraction outputs
### ExtractedField
- fieldKey
- rawValue
- normalizedValue
- confidence
- reviewStatus

### ExtractedRow
- rowType
- rowIndex
- valuesJson
- confidence

## Confidence rules
Combine:
- OCR signal quality
- regex certainty
- label proximity certainty
- document type certainty
- normalization success

## Review trigger
Require review if:
- confidence below threshold
- required field missing
- conflicting candidate values
- document type uncertain
