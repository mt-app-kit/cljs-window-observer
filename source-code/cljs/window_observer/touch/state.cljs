
(ns window-observer.touch.state
    (:require [reagent.api :refer [ratom]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @atom (boolean)
(def TOUCH-EVENTS-API-DETECTED? (ratom false))
