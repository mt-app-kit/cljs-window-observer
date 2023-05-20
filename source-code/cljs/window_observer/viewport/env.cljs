
(ns window-observer.viewport.env
    (:require [window-observer.viewport.state :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-height
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns the actual height of the viewport.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (get-viewport-height)
  ;
  ; @return (px)
  []
  (:viewport-height @viewport.state/VIEWPORT-STATE))

(defn get-viewport-width
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns the actual width of the viewport.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (get-viewport-width)
  ;
  ; @return (px)
  []
  (:viewport-width @viewport.state/VIEWPORT-STATE))

(defn get-viewport-shape
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns the actual shape of the viewport.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (get-viewport-shape)
  ;
  ; @return (keyword)
  ; :landscape, :portrait, :square
  []
  (:viewport-shape @viewport.state/VIEWPORT-STATE))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn square-viewport?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns true if the actual width and height of the viewport are the exact same.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (square-viewport?)
  ;
  ; @return (boolean)
  []
  (= :square (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn landscape-viewport?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns true if the actual width of the viewport is greater than its height.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (landscape-viewport?)
  ;
  ; @return (boolean)
  []
  (= :landscape (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn portrait-viewport?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns true if the actual height of the viewport is greater than its width.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (portrait-viewport?)
  ;
  ; @return (boolean)
  []
  (= :portrait (:viewport-shape @viewport.state/VIEWPORT-STATE)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-height-max?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @description
  ; Returns true if the actual height of the viewport is smaller than or equal
  ; to the given value.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @param (px) max-height
  ;
  ; @usage
  ; (viewport-height-max? 1024)
  ;
  ; @return (boolean)
  [max-height]
  (>= max-height (:viewport-height @viewport.state/VIEWPORT-STATE)))

(defn viewport-height-min?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @param (px) min-height
  ;
  ; @description
  ; Returns true if the actual height of the viewport is greater than or equal
  ; to the given value.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (viewport-height-min? 1024)
  ;
  ; @return (boolean)
  [min-height]
  (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-max?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @param (px) max-width
  ;
  ; @description
  ; Returns true if the actual width of the viewport is smaller than or equal
  ; to the given value.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (viewport-width-max? 1024)
  ;
  ; @return (boolean)
  [max-width]
  (>= max-width (:viewport-width @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-min?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @param (px) min-width
  ;
  ; @description
  ; Returns true if the actual width of the viewport is greater than or equal
  ; to the given value.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (viewport-width-min? 1024)
  ;
  ; @return (boolean)
  [min-width]
  (<= min-width (:viewport-width @viewport.state/VIEWPORT-STATE)))

(defn viewport-size-min?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @param (px) min-width
  ; @param (px) min-height
  ;
  ; @description
  ; Returns true if the actual width and height of the viewport is greater than
  ; or equal to the given values.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (viewport-size-min? 1024 768)
  ;
  ; @return (boolean)
  [min-width min-height]
  (and (<= min-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE))))

(defn viewport-size-max?
  ; @warning
  ; Before calling this function first time, call the listen-to-viewport-resize! function once!
  ;
  ; @param (px) max-width
  ; @param (px) max-height
  ;
  ; @description
  ; Returns true if the actual width and height of the viewport is smaller than
  ; or equal to the given values.
  ;
  ; Viewport dimensions are read from the JS Window object and stored within a Reagent
  ; atom in order to make Reagent components rerender when a dimension changed.
  ;
  ; @usage
  ; (viewport-size-max? 1024 768)
  ;
  ; @return (boolean)
  [max-width max-height]
  (and (>= max-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (>= max-height (:viewport-height @viewport.state/VIEWPORT-STATE))))
