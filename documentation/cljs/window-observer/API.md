
# window-observer.api ClojureScript namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > window-observer.api

### Index

- [detect-touch!](#detect-touch)

- [get-viewport-height](#get-viewport-height)

- [get-viewport-shape](#get-viewport-shape)

- [get-viewport-width](#get-viewport-width)

- [landscape-viewport?](#landscape-viewport)

- [listen-to-viewport-resize!](#listen-to-viewport-resize)

- [portrait-viewport?](#portrait-viewport)

- [square-viewport?](#square-viewport)

- [touch-detected?](#touch-detected)

- [viewport-height-max?](#viewport-height-max)

- [viewport-height-min?](#viewport-height-min)

- [viewport-size-max?](#viewport-size-max)

- [viewport-size-min?](#viewport-size-min)

- [viewport-width-max?](#viewport-width-max)

- [viewport-width-min?](#viewport-width-min)

### detect-touch!

```
@description
Detects whether the browser can use touch pointer devices.
Returns TRUE if the Touch events API is detected, and stores the return
value within a Reagent atom.
After this function first called, the 'touch-detected?' function can read
the return value from the atom and you don't have to call this function again.
```

```
@usage
(detect-touch!)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn detect-touch!
  []
  (let [% (window/touch-events-api-detected?)]
       (reset! touch.state/TOUCH-EVENTS-API-DETECTED? %)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [detect-touch!]]))

(window-observer.api/detect-touch!)
(detect-touch!)
```

</details>

---

### get-viewport-height

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns the actual height of the viewport.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(get-viewport-height)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-height
  []
  (:viewport-height @viewport.state/VIEWPORT-STATE))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [get-viewport-height]]))

(window-observer.api/get-viewport-height)
(get-viewport-height)
```

</details>

---

### get-viewport-shape

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns the actual shape of the viewport.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(get-viewport-shape)
```

```
@return (keyword)
:landscape, :portrait, :square
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-shape
  []
  (:viewport-shape @viewport.state/VIEWPORT-STATE))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [get-viewport-shape]]))

(window-observer.api/get-viewport-shape)
(get-viewport-shape)
```

</details>

---

### get-viewport-width

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns the actual width of the viewport.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(get-viewport-width)
```

```
@return (px)
```

<details>
<summary>Source code</summary>

```
(defn get-viewport-width
  []
  (:viewport-width @viewport.state/VIEWPORT-STATE))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [get-viewport-width]]))

(window-observer.api/get-viewport-width)
(get-viewport-width)
```

</details>

---

### landscape-viewport?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width of the viewport is greater than its height.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(landscape-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn landscape-viewport?
  []
  (= :landscape (:viewport-shape @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [landscape-viewport?]]))

(window-observer.api/landscape-viewport?)
(landscape-viewport?)
```

</details>

---

### listen-to-viewport-resize!

```
@usage
(listen-to-viewport-resize!)
```

<details>
<summary>Source code</summary>

```
(defn listen-to-viewport-resize!
  []
  (when-not @viewport.state/OBSERVER-INITED? (update-viewport-data!)
                                             (.addEventListener js/window "resize" update-viewport-data! false)
                                             (reset! viewport.state/OBSERVER-INITED? true)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [listen-to-viewport-resize!]]))

(window-observer.api/listen-to-viewport-resize!)
(listen-to-viewport-resize!)
```

</details>

---

### portrait-viewport?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual height of the viewport is greater than its width.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(portrait-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn portrait-viewport?
  []
  (= :portrait (:viewport-shape @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [portrait-viewport?]]))

(window-observer.api/portrait-viewport?)
(portrait-viewport?)
```

</details>

---

### square-viewport?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width and height of the viewport are the exact same.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@usage
(square-viewport?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn square-viewport?
  []
  (= :square (:viewport-shape @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [square-viewport?]]))

(window-observer.api/square-viewport?)
(square-viewport?)
```

</details>

---

### touch-detected?

```
@warning
Before first using this function, call the 'detect-touch!' function at least once!
```

```
@description
Returns TRUE if the browser can use touch pointer devices.
```

```
@usage
(touch-detected?)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn touch-detected?
  []
  @touch.state/TOUCH-EVENTS-API-DETECTED?)
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [touch-detected?]]))

(window-observer.api/touch-detected?)
(touch-detected?)
```

</details>

---

### viewport-height-max?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual height of the viewport is smaller than or equal
to the given value.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) max-height
```

```
@usage
(viewport-height-max? 1024)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-height-max?
  [max-height]
  (>= max-height (:viewport-height @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-height-max?]]))

(window-observer.api/viewport-height-max? ...)
(viewport-height-max?                     ...)
```

</details>

---

### viewport-height-min?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual height of the viewport is greater than or equal
to the given value.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) min-height
```

```
@usage
(viewport-height-min? 1024)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-height-min?
  [min-height]
  (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-height-min?]]))

(window-observer.api/viewport-height-min? ...)
(viewport-height-min?                     ...)
```

</details>

---

### viewport-size-max?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width and height of the viewport is smaller than
or equal to the given values.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) max-width
@param (px) max-height
```

```
@usage
(viewport-size-max? 1024 768)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-size-max?
  [max-width max-height]
  (and (>= max-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (>= max-height (:viewport-height @viewport.state/VIEWPORT-STATE))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-size-max?]]))

(window-observer.api/viewport-size-max? ...)
(viewport-size-max?                     ...)
```

</details>

---

### viewport-size-min?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width and height of the viewport is greater than
or equal to the given values.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) min-width
@param (px) min-height
```

```
@usage
(viewport-size-min? 1024 768)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-size-min?
  [min-width min-height]
  (and (<= min-width  (:viewport-width  @viewport.state/VIEWPORT-STATE))
       (<= min-height (:viewport-height @viewport.state/VIEWPORT-STATE))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-size-min?]]))

(window-observer.api/viewport-size-min? ...)
(viewport-size-min?                     ...)
```

</details>

---

### viewport-width-max?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width of the viewport is smaller than or equal
to the given value.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) max-width
```

```
@usage
(viewport-width-max? 1024)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-width-max?
  [max-width]
  (>= max-width (:viewport-width @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-width-max?]]))

(window-observer.api/viewport-width-max? ...)
(viewport-width-max?                     ...)
```

</details>

---

### viewport-width-min?

```
@warning
Before first using this function, call the 'listen-to-viewport-resize!' function at least once!
```

```
@description
Returns true if the actual width of the viewport is greater than or equal
to the given value.
Viewport dimensions are read from the JS Window object and stored within a Reagent
atom in order to make Reagent components rerender when a dimension changes.
```

```
@param (px) min-width
```

```
@usage
(viewport-width-min? 1024)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn viewport-width-min?
  [min-width]
  (<= min-width (:viewport-width @viewport.state/VIEWPORT-STATE)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [window-observer.api :refer [viewport-width-min?]]))

(window-observer.api/viewport-width-min? ...)
(viewport-width-min?                     ...)
```

</details>

---

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.

