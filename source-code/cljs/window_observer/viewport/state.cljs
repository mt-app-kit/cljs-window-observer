
(ns window-observer.viewport.state
    (:require [reagent.core :rename {atom ratom}]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @description
; Storing the viewport dimensions in a Reagent atom makes Reagent components
; reacting to viewport resize events.
;
; @atom (map)
(def VIEWPORT-STATE (ratom {}))

; @ignore
;
; After the viewport resize observer inited and a resize event set on the
; JS Window object the listen-to-viewport-resize! function no longer operates.
;
; @atom (boolean)
(def OBSERVER-INITED? (atom false))
