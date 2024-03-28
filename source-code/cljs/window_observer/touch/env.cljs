
(ns window-observer.touch.env
    (:require [window-observer.touch.side-effects :as touch.side-effects]
              [window-observer.touch.state        :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-events-api-detected?
  ; @description
  ; - Returns the dereferenced output of the 'TOUCH-EVENTS-API-DETECTED?' atom.
  ; - In case the 'TOUCH-EVENTS-API-DETECTED?' atom is empty, automatically calls the 'detect-touch-events-api!' function.
  ; 
  ; @usage
  ; (touch-events-api-detected?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (if-some [touch-events-api-detected? @touch.state/TOUCH-EVENTS-API-DETECTED?]
           (-> touch-events-api-detected?)
           (touch.side-effects/detect-touch-events-api!)))
