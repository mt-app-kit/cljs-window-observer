
(ns window-observer.viewport.state
    (:require [reagent.core :refer [atom] :rename {atom ratom}]))

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
; @description
; After the viewport resize observer is inited and a resize event is set on the
; JS Window object, the 'listen-to-viewport-resize!' function no longer operates.
;
; @atom (boolean)
(def OBSERVER-INITED? (atom false))
