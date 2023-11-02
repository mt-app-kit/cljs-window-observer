
(ns window-observer.touch.side-effects
    (:require [window.api                  :as window]
              [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn detect-touch!
  ; @description
  ; Detects whether the browser can use touch pointer devices.
  ;
  ; Returns TRUE if the Touch events API is detected, and stores the return
  ; value within a Reagent atom.
  ;
  ; After this function first called, the 'touch-detected?' function can read
  ; the return value from the atom and you don't have to call this function again.
  ;
  ; @usage
  ; (detect-touch!)
  ;
  ; @return (boolean)
  []
  (let [% (window/touch-events-api-detected?)]
       (reset! touch.state/TOUCH-EVENTS-API-DETECTED? %)))
