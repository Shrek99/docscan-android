# Scan Quality Contract

## Purpose
Define the contract between capture, CV quality scoring, OCR acceptance, and review flows.

## Input
- original camera image
- detected document contour (optional if available from preview)
- device metadata (resolution/orientation)

## Output: ScanQualityResult
- overallScore: 0..100
- accepted: Boolean
- failReasons: List<String>
- guidance: List<String>
- component scores:
  - blurScore
  - lightingScore
  - shadowScore
  - glareScore
  - skewScore
  - edgeScore
  - resolutionScore

## Hard fail conditions
- severe blur
- failed contour detection
- document edges cut off
- severe glare over text region
- resolution below threshold

## Guidance mapping
- blur -> "Hold steady"
- lighting low -> "Increase lighting"
- heavy shadow -> "Remove shadows from the page"
- glare -> "Tilt phone to reduce glare"
- cut edges -> "Fit the entire document in frame"
- skew -> "Center the document and flatten angle"
- low resolution -> "Move closer"

## Acceptance rules
- hard fail overrides score
- otherwise accept only if overallScore >= configured threshold
- store full score breakdown for audit and later tuning
