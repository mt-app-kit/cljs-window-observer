
(ns window-observer.touch.state
    (:require [reagent.core :refer [atom] :rename {atom ratom}]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @atom (boolean)
(def TOUCH-EVENTS-API-DETECTED? (ratom false))
