
(ns window-observer.touch.env
    (:require [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-detected?
  ; @warning
  ; Before using, call the detect-touch! function!
  ;
  ; @description
  ; Returns true in case of the browser can use touch pointer devices.
  ; Determined by using the JS Window object.
  ;
  ; @usage
  ; (touch-detected?)
  ;
  ; @return (boolean)
  []
  @touch.state/TOUCH-EVENTS-API-DETECTED?)
