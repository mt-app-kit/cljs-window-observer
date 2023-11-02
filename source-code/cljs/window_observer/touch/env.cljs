
(ns window-observer.touch.env
    (:require [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-detected?
  ; @warning
  ; Before first using this function, call the 'detect-touch!' function at least once!
  ;
  ; @description
  ; Returns TRUE if the browser can use touch pointer devices.
  ;
  ; @usage
  ; (touch-detected?)
  ;
  ; @return (boolean)
  []
  @touch.state/TOUCH-EVENTS-API-DETECTED?)
