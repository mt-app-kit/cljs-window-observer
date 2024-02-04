
(ns window-observer.touch.side-effects
    (:require [window-observer.touch.state :as touch.state]
              [window.api                  :as window]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn detect-touch-events-api!
  ; @description
  ; - Detects whether the Touch events API is available.
  ; - Stores the detected value in the 'TOUCH-EVENTS-API-DETECTED?' atom.
  ; - Returns the detected value.
  ;
  ; @usage
  ; (detect-touch-events-api!)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (let [% (window/touch-events-api-available?)]
       (reset! touch.state/TOUCH-EVENTS-API-DETECTED? %)))
