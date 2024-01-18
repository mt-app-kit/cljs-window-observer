
(ns window-observer.touch.env
    (:require [window-observer.touch.side-effects :as touch.side-effects]
              [window-observer.touch.state        :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-detected?
  ; @description
  ; Returns TRUE if the browser can use touch pointer devices.
  ;
  ; @usage
  ; (touch-detected?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  ; Use 'if-let' instead of using 'or' because the 'touch-events-api-detected?' can be FALSE!
  (if-let [touch-events-api-detected? @touch.state/TOUCH-EVENTS-API-DETECTED?]
          (-> touch-events-api-detected?)
          (touch.side-effects/detect-touch!)))
