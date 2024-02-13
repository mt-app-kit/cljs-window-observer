
(ns window-observer.touch.state)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @note
; Before dereferencing this atom for the first time, call the 'detect-touch-events-api!' or the 'touch-events-api-detected?' function!
;
; @atom (boolean)
;
; @usage
; (deref TOUCH-EVENTS-API-DETECTED?)
; =>
; true
(def TOUCH-EVENTS-API-DETECTED? (atom nil))
