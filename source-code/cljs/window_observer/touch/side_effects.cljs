
(ns window-observer.touch.side-effects
    (:require [window.api                  :as window]
              [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn detect-touch!
  ; @description
  ; Detects whether the browser can use touch pointer devices.
  ;
  ; Returns true if the Touch events API detected, and stores the return
  ; value into an atom.
  ;
  ; After this function first called, the touch-detected? function can read
  ; the return value from the atom and this function no longer needed.
  ;
  ; @usage
  ; (detect-touch!)
  ;
  ; @return (boolean)
  []
  (let [% (window/touch-events-api-detected?)]
       (reset! touch.state/TOUCH-EVENTS-API-DETECTED? %)))
