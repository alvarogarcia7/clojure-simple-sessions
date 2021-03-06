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
;; => (\! \d \l \r \o \W \space \o \l \l \e \H)

(defmacro inc2
  [n]
  (list + 2 n))

(inc2 2)
;; => 4

(inc2 (+ 2 4))
;; => 8

(defmacro inc2-quoted
  [n]
  `(do (let [result# ~n]
         (println (quote ~n))                               ;; this version, for printing, cannot work with ``result#``
         (+ 2 result#))))

(inc2-quoted 2)
;; => 4

(inc2-quoted (do (Thread/sleep 10000) (* 2 1 3)))
;; this function takes 10s to execute, as there is no double execution
;; => 8

(macroexpand '(inc2-quoted (* 2 1 3)))
;; => (do (clojure.core/println (quote (* 2 1 3))) (clojure.core/+ 2 (* 2 1 3)))

;; currently at https://learnxinyminutes.com/docs/clojure-macros/
;; You can use the usual destructuring args. Expand list variables using ~@
