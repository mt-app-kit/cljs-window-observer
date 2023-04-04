
(ns window-observer.touch.state
    (:require [reagent.core :rename {atom ratom}]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @atom (boolean)
(def TOUCH-EVENTS-API-DETECTED? (ratom false))
