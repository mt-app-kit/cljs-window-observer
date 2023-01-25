
(ns window-observer.viewport.env
    (:require [window-observer.viewport.state :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-height
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns the actual height of the viewport.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (get-viewport-height)
  ;
  ; @return (px)
  []
  (:viewport-height @viewport.state/VIEWPORT-STATE))

(defn get-viewport-width
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns the actual width of the viewport.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (get-viewport-width)
  ;
  ; @return (px)
  []
  (:viewport-width @viewport.state/VIEWPORT-STATE))

(defn get-viewport-shape
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns the actual shape of the viewport.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
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
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns true if the actual width and height of the viewport are the exact same.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (square-viewport?)
  ;
  ; @return (boolean)
  []
  (= :square (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn landscape-viewport?
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns true if the actual width of the viewport is greater than the height.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (landscape-viewport?)
  ;
  ; @return (boolean)
  []
  (= :landscape (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn portrait-viewport?
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns true if the actual height of the viewport is greater than the width.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
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
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @description
  ; Returns true if the actual height of the viewport is smaller than or equal
  ; to the given value.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
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
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @param (px) min-height
  ;
  ; @description
  ; Returns true if the actual height of the viewport is greater than or equal
  ; to the given value.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (viewport-height-min? 1024)
  ;
  ; @return (boolean)
  [min-height]
  (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-max?
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @param (px) max-width
  ;
  ; @description
  ; Returns true if the actual width of the viewport is smaller than or equal
  ; to the given value.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (viewport-width-max? 1024)
  ;
  ; @return (boolean)
  [max-width]
  (>= max-width (:viewport-width @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-min?
  ; @warning
  ; Before using, call the init-viewport-observer! function!
  ;
  ; @param (px) min-width
  ;
  ; @description
  ; Returns true if the actual width of the viewport is greater than or equal
  ; to the given value.
  ;
  ; Viewport dimensions read from the JS Window object and stored in a Reagent
  ; atom to make Reagent components rerender when dimensions are changing.
  ;
  ; @usage
  ; (viewport-width-min? 1024)
  ;
  ; @return (boolean)
  [min-width]
  (<= min-width (:viewport-width @viewport.state/VIEWPORT-STATE)))
