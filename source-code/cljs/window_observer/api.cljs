
(ns window-observer.api
    (:require [window-observer.touch.helpers         :as touch.helpers]
              [window-observer.touch.side-effects    :as touch.side-effects]
              [window-observer.viewport.helpers      :as viewport.helpers]
              [window-observer.viewport.side-effects :as viewport.side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; window-observer.touch.helpers
(def touch-detected? touch.helpers/touch-detected?)

; window-observer.touch.side-effects
(def detect-touch! touch.side-effects/detect-touch!)

; window-observer.viewport.helpers
(def get-viewport-height  viewport.helpers/get-viewport-height)
(def get-viewport-width   viewport.helpers/get-viewport-width)
(def get-viewport-shape   viewport.helpers/get-viewport-shape)
(def square-viewport?     viewport.helpers/square-viewport?)
(def landscape-viewport?  viewport.helpers/landscape-viewport?)
(def portrait-viewport?   viewport.helpers/portrait-viewport?)
(def viewport-height-max? viewport.helpers/viewport-height-max?)
(def viewport-height-min? viewport.helpers/viewport-height-min?)
(def viewport-width-max?  viewport.helpers/viewport-width-max?)
(def viewport-width-min?  viewport.helpers/viewport-width-min?)

; window-observer.viewport.side-effects
(def listen-to-viewport-resize! viewport.side-effects/listen-to-viewport-resize!)
