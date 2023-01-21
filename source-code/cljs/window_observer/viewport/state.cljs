
(ns window-observer.viewport.state
    (:require [reagent.core :rename {atom ratom}]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @description
; Storing the viewport dimensions in a Reagent atom helps make Reagent components
; reacting to viewport resize events.
;
; @atom (map)
(def VIEWPORT-STATE (ratom {}))

; @ignore
;
; @atom (boolean)
(def OBSERVER-INITED? (atom false))
