(ns simple.macro2)

(defmacro my-first-macro []
  (list reverse "hello world"))

(macroexpand '(my-first-macro))
;; => (#object[clojure.core$reverse 0x5afa8f57 "clojure.core$reverse@5afa8f57"] "hello world")

(my-first-macro)
;; => (\d \l \r \o \w \space \o \l \l \e \h)

(defmacro my-first-quoted-macro
  []
  '(reverse "Hello World!"))

(my-first-quoted-macro)

(defmacro inc2
  [n]
  (list + 2 n))

(inc2 2)
;; => 4