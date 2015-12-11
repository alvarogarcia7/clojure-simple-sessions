; copied, modified from http://www.braveclojure.com/writing-macros/

(defn criticize-code
  [criticism code]
  `(println ~criticism (quote ~code)))

(defmacro code-critic
  [good bad]
  `(do ~@(map #(apply criticize-code %)
              [["Sweet lion of Zion, this is bad code:" bad]
               ["Great cow of Moscow, this is good code:" good]])))

; usage
; simple.core=> (code-critic (+ 1 1) (1 + 1))
; Sweet lion of Zion, this is bad code: (1 + 1)
; Great cow of Moscow, this is good code: (+ 1 1)
; nil
