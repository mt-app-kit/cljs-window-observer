
(ns window-observer.touch.side-effects
    (:require [window-observer.touch.helpers :as touch.helpers]
              [window-observer.touch.state   :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn detect-touch!
  ; @description
  ; Detects whether the browser can use touch pointer devices.
  ;
  ; @usage
  ; (detect-touch!)
  []
  (let [% (touch.helpers/touch-events-api-detected?)]
       (reset! touch.state/TOUCH-EVENTS-API-DETECTED? %)))
