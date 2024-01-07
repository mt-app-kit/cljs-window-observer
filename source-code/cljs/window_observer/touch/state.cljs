
(ns window-observer.touch.state)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @important
; Before dereferencing this atom for the first time, call the 'detect-touch!' function once!
;
; @atom (boolean)
;
; @usage
; (deref TOUCH-EVENTS-API-DETECTED?)
; =>
; true
(def TOUCH-EVENTS-API-DETECTED? (atom nil))
