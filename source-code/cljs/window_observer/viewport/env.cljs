
(ns window-observer.viewport.env
    (:require [window-observer.viewport.state :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-height
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns the actual height of the viewport.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (get-viewport-height)
  ;
  ; @return (px)
  []
  (:viewport-height @viewport.state/VIEWPORT-STATE))

(defn get-viewport-width
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns the actual width of the viewport.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (get-viewport-width)
  ;
  ; @return (px)
  []
  (:viewport-width @viewport.state/VIEWPORT-STATE))

(defn get-viewport-shape
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns the actual shape of the viewport.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
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
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport are the exact same.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (square-viewport?)
  ;
  ; @return (boolean)
  []
  (= :square (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn landscape-viewport?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns TRUE if the actual width of the viewport is greater than its height.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (landscape-viewport?)
  ;
  ; @return (boolean)
  []
  (= :landscape (:viewport-shape @viewport.state/VIEWPORT-STATE)))

(defn portrait-viewport?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns TRUE if the actual height of the viewport is greater than its width.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
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
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @description
  ; - Returns TRUE if the actual height of the viewport is smaller than or equal to the given value.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
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
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @param (px) min-height
  ;
  ; @description
  ; - Returns TRUE if the actual height of the viewport is greater than or equal to the given value.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (viewport-height-min? 1024)
  ;
  ; @return (boolean)
  [min-height]
  (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-max?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @param (px) max-width
  ;
  ; @description
  ; - Returns TRUE if the actual width of the viewport is smaller than or equal to the given value.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (viewport-width-max? 1024)
  ;
  ; @return (boolean)
  [max-width]
  (>= max-width (:viewport-width @viewport.state/VIEWPORT-STATE)))

(defn viewport-width-min?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @param (px) min-width
  ;
  ; @description
  ; - Returns TRUE if the actual width of the viewport is greater than or equal to the given value.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (viewport-width-min? 1024)
  ;
  ; @return (boolean)
  [min-width]
  (<= min-width (:viewport-width @viewport.state/VIEWPORT-STATE)))

(defn viewport-size-min?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @param (px) min-width
  ; @param (px) min-height
  ;
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport is greater than or equal to the given values.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (viewport-size-min? 1024 768)
  ;
  ; @return (boolean)
  [min-width min-height]
  (and (<= min-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE))))

(defn viewport-size-max?
  ; @important
  ; Before the first use of this function, call the 'listen-to-viewport-resize!' function once!
  ;
  ; @param (px) max-width
  ; @param (px) max-height
  ;
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport is smaller than or equal to the given values.
  ; - Viewport dimensions are read from the JS Window object and stored within a Reagent atom,
  ;   to make Reagent components rerender when a dimension changes.
  ;
  ; @usage
  ; (viewport-size-max? 1024 768)
  ;
  ; @return (boolean)
  [max-width max-height]
  (and (>= max-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (>= max-height (:viewport-height @viewport.state/VIEWPORT-STATE))))
