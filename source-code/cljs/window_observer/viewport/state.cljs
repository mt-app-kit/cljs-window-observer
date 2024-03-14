
(ns window-observer.viewport.state
    (:require [reagent.core :as reagent]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @description
; Stored viewport dimensions.
; Updated automatically in case the 'listen-to-viewport-resize!' function is called.
;
; @note
; Before dereferencing this atom for the first time, call the 'detect-viewport-dimensions!' or the 'listen-to-viewport-resize!' function!
;
; @atom (map)
; {:viewport-height (px)
;  :viewport-shape (keyword)
;   :landscape, :portrait, :square
;  :viewport-width (px)}
;
; @usage
; (deref VIEWPORT-DIMENSIONS)
; =>
; {:viewport-height 960
;  :viewport-shape  :landscape
;  :viewport-wide   1980}
(def VIEWPORT-DIMENSIONS (reagent/atom nil))

; @ignore
;
; @note
; If the viewport resize observer is inited and a resize event is set on the
; JS Window object, the 'listen-to-viewport-resize!' function does not operate.
;
; @atom (boolean)
(def OBSERVER-INITED? (atom false))
