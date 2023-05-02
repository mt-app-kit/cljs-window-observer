
(ns window-observer.touch.env
    (:require [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-detected?
  ; @warning
  ; Before calling this function first time call the detect-touch! function once!
  ;
  ; @description
  ; Returns true in case of the browser can use touch pointer devices.
  ;
  ; @usage
  ; (touch-detected?)
  ;
  ; @return (boolean)
  []
  @touch.state/TOUCH-EVENTS-API-DETECTED?)
