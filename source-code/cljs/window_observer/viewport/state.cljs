
(ns window-observer.viewport.state
    (:require [reagent.core :refer [atom] :rename {atom ratom}]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @note
; Before dereferencing this atom for the first time, call the 'detect-viewport-dimensions!'
; or the 'listen-to-viewport-resize!' function!
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
(def VIEWPORT-DIMENSIONS (ratom nil))

; @ignore
;
; @note
; If the viewport resize observer is inited and a resize event is set on the
; JS Window object, the 'listen-to-viewport-resize!' function doesn't operate.
;
; @atom (boolean)
(def OBSERVER-INITED? (atom false))
