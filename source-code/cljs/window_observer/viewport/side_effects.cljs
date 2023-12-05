
(ns window-observer.viewport.side-effects
    (:require [window-observer.viewport.state :as viewport.state]
              [window.api                     :as window]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn update-viewport-data!
  ; @ignore
  ;
  ; @return (map)
  []
  (reset! viewport.state/VIEWPORT-STATE {:viewport-height (window/viewport-height)
                                         :viewport-shape  (window/viewport-shape)
                                         :viewport-width  (window/viewport-width)}))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn listen-to-viewport-resize!
  ; @usage
  ; (listen-to-viewport-resize!)
  []
  (when-not @viewport.state/OBSERVER-INITED? (update-viewport-data!)
                                             (.addEventListener js/window "resize" update-viewport-data! false)
                                             (reset! viewport.state/OBSERVER-INITED? true)))
