
(ns window-observer.viewport.side-effects
    (:require [window-observer.viewport.state :as viewport.state]
              [window.api                     :as window]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn detect-viewport-dimensions!
  ; @description
  ; - Detects the dimensions of the viewport.
  ; - Returns the detected viewport dimensions, and stores the return value.
  ;
  ; @usage
  ; (detect-viewport-dimensions!)
  ; =>
  ; {:viewport-height 960
  ;  :viewport-shape  :landscape
  ;  :viewport-wide   1980}
  ;
  ; @return (map)
  ; {:viewport-height (px)
  ;  :viewport-shape (keyword)
  ;   :landscape, :portrait, :square
  ;  :viewport-width (px)}
  []
  (reset! viewport.state/VIEWPORT-DIMENSIONS {:viewport-height (window/viewport-height)
                                              :viewport-shape  (window/viewport-shape)
                                              :viewport-width  (window/viewport-width)}))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn listen-to-viewport-resize!
  ; @description
  ; - Detects the dimensions of the viewport and sets a viewport resize listener for detecting further changes.
  ; - Returns the detected viewport dimensions, and stores the return value.
  ;
  ; @usage
  ; (listen-to-viewport-resize!)
  ; =>
  ; {:viewport-height 960
  ;  :viewport-shape  :landscape
  ;  :viewport-wide   1980}
  ;
  ; @return (map)
  ; {:viewport-height (px)
  ;  :viewport-shape (keyword)
  ;   :landscape, :portrait, :square
  ;  :viewport-width (px)}
  []
  (when-not @viewport.state/OBSERVER-INITED? (detect-viewport-dimensions!)
                                             (.addEventListener js/window "resize" detect-viewport-dimensions! false)
                                             (reset! viewport.state/OBSERVER-INITED? true))
  (-> @viewport.state/VIEWPORT-DIMENSIONS))
