
(ns window-observer.viewport.side-effects
    (:require [window.api                     :as window]
              [window-observer.viewport.state :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn update-viewport-data!
  ; @ignore
  []
  (reset! viewport.state/VIEWPORT-STATE {:viewport-height (window/viewport-height)
                                         :viewport-shape  (window/viewport-shape)
                                         :viewport-width  (window/viewport-width)}))

(defn listen-to-viewport-resize!
  ; @ignore
  []
  (.addEventListener js/window "resize" update-viewport-data! false))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn init-viewport-observer!
  ; @usage
  ; (init-observer!)
  []
  (when-not @viewport.state/OBSERVER-INITED? (update-viewport-data!)
                                             (listen-to-viewport-resize!)
                                             (reset! viewport.state/OBSERVER-INITED? true)))
