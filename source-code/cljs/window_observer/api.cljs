
(ns window-observer.api
    (:require [window-observer.touch.env             :as touch.env]
              [window-observer.touch.side-effects    :as touch.side-effects]
              [window-observer.viewport.env          :as viewport.env]
              [window-observer.viewport.side-effects :as viewport.side-effects]
              [window-observer.touch.state :as touch.state]
              [window-observer.viewport.state :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (window-observer.touch.env/*)
(def touch-detected? touch.env/touch-detected?)

; @redirect (window-observer.touch.side-effects/*)
(def detect-touch! touch.side-effects/detect-touch!)

; @redirect (window-observer.touch.state/*)
(def TOUCH-EVENTS-API-DETECTED? touch.state/TOUCH-EVENTS-API-DETECTED?)

; @redirect (window-observer.viewport.env/*)
(def get-viewport-dimensions viewport.env/get-viewport-dimensions)
(def get-viewport-height     viewport.env/get-viewport-height)
(def get-viewport-width      viewport.env/get-viewport-width)
(def get-viewport-shape      viewport.env/get-viewport-shape)
(def square-viewport?        viewport.env/square-viewport?)
(def landscape-viewport?     viewport.env/landscape-viewport?)
(def portrait-viewport?      viewport.env/portrait-viewport?)
(def viewport-height-max?    viewport.env/viewport-height-max?)
(def viewport-height-min?    viewport.env/viewport-height-min?)
(def viewport-width-max?     viewport.env/viewport-width-max?)
(def viewport-width-min?     viewport.env/viewport-width-min?)
(def viewport-size-min?      viewport.env/viewport-size-min?)
(def viewport-size-max?      viewport.env/viewport-size-max?)

; @redirect (window-observer.viewport.side-effects/*)
(def detect-viewport-dimensions! viewport.side-effects/detect-viewport-dimensions!)
(def listen-to-viewport-resize!  viewport.side-effects/listen-to-viewport-resize!)

; @redirect (window-observer.viewport.state/*)
(def VIEWPORT-DIMENSIONS viewport.state/VIEWPORT-DIMENSIONS)
