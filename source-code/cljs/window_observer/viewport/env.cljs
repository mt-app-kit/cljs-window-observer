
(ns window-observer.viewport.env
    (:require [window-observer.viewport.side-effects :as viewport.side-effects]
              [window-observer.viewport.state        :as viewport.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-dimensions
  ; @description
  ; - Returns the actual dimensions of the viewport.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (get-viewport-dimensions)
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
  ; In case the 'VIEWPORT-DIMENSIONS' atom is still empty, it calls the 'listen-to-viewport-resize!' function that ...
  ; ... initializes the viewport resize listener,
  ; ... updates the 'VIEWPORT-DIMENSIONS' atom with the actual dimensions,
  ; ... returns the actual dimensions.
  (or (deref viewport.state/VIEWPORT-DIMENSIONS)
      (viewport.side-effects/listen-to-viewport-resize!)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-viewport-height
  ; @description
  ; - Returns the actual height of the viewport.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (get-viewport-height)
  ; =>
  ; 960
  ;
  ; @return (px)
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (:viewport-height viewport-dimensions)))

(defn get-viewport-width
  ; @description
  ; - Returns the actual width of the viewport.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (get-viewport-width)
  ; =>
  ; 1980
  ;
  ; @return (px)
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (:viewport-width viewport-dimensions)))

(defn get-viewport-shape
  ; @description
  ; - Returns the actual shape of the viewport.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (get-viewport-shape)
  ; =>
  ; :landscape
  ;
  ; @return (keyword)
  ; :landscape, :portrait, :square
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (:viewport-shape viewport-dimensions)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn square-viewport?
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport are the same.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (square-viewport?)
  ; =>
  ; false
  ;
  ; @return (boolean)
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (= :square (:viewport-shape viewport-dimensions))))

(defn landscape-viewport?
  ; @description
  ; - Returns TRUE if the actual width of the viewport is greater than the actual viewport height.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (landscape-viewport?)
  ; =>
  ; true
  ;
  ; @return (boolean)
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (= :landscape (:viewport-shape viewport-dimensions))))

(defn portrait-viewport?
  ; @description
  ; - Returns TRUE if the actual height of the viewport is greater than the actual viewport width.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @usage
  ; (portrait-viewport?)
  ; =>
  ; false
  ;
  ; @return (boolean)
  []
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (= :portrait (:viewport-shape viewport-dimensions))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn viewport-height-max?
  ; @description
  ; - Returns TRUE if the actual height of the viewport is smaller than or equal to the given value.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) max-height
  ;
  ; @usage
  ; (viewport-height-max? 1024)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [max-height]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (>= max-height (:viewport-height viewport-dimensions))))

(defn viewport-height-min?
  ; @description
  ; - Returns TRUE if the actual height of the viewport is greater than or equal to the given value.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) min-height
  ;
  ; @usage
  ; (viewport-height-min? 1024)
  ; =>
  ; false
  ;
  ; @return (boolean)
  [min-height]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (<= min-height (:viewport-height viewport-dimensions))))

(defn viewport-width-max?
  ; @description
  ; - Returns TRUE if the actual width of the viewport is smaller than or equal to the given value.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) max-width
  ;
  ; @usage
  ; (viewport-width-max? 1024)
  ; =>
  ; false
  ;
  ; @return (boolean)
  [max-width]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (>= max-width (:viewport-width viewport-dimensions))))

(defn viewport-width-min?
  ; @description
  ; - Returns TRUE if the actual width of the viewport is greater than or equal to the given value.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) min-width
  ;
  ; @usage
  ; (viewport-width-min? 1024)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [min-width]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (<= min-width (:viewport-width viewport-dimensions))))

(defn viewport-size-min?
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport is greater than or equal to the given values.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) min-width
  ; @param (px) min-height
  ;
  ; @usage
  ; (viewport-size-min? 1024 768)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [min-width min-height]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (and (<= min-width  (:viewport-width  viewport-dimensions))
               (<= min-height (:viewport-height viewport-dimensions)))))

(defn viewport-size-max?
  ; @description
  ; - Returns TRUE if the actual width and height of the viewport is smaller than or equal to the given values.
  ;   The output is dereferenced from the 'VIEWPORT-DIMENSIONS' atom.
  ; - In case the 'VIEWPORT-DIMENSIONS' atom is empty, automatically calls the 'listen-to-viewport-resize!' function.
  ;
  ; @param (px) max-width
  ; @param (px) max-height
  ;
  ; @usage
  ; (viewport-size-max? 1024 768)
  ; =>
  ; false
  ;
  ; @return (boolean)
  [max-width max-height]
  (if-let [viewport-dimensions (get-viewport-dimensions)]
          (and (>= max-width  (:viewport-width  viewport-dimensions))
               (>= max-height (:viewport-height viewport-dimensions)))))
