
(ns window-observer.touch.env
    (:require [window-observer.touch.state :as touch.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn touch-detected?
  ; @important
  ; Before the first use of this function, call the 'detect-touch!' function once!
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
