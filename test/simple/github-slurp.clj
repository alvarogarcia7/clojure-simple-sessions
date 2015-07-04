(ns github-slurp
    (:require [clojure.java.io :as io]))
(def file "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt")
(def contents '())
(with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (->>
       (def contents (conj contents line))
      (println line))))

; (def contents (conj contents "aa" "bb"))

contents

; index map, if needed
(map-indexed
 (fn [index content] [index content])
   contents)

(defn lines-cleanup [mess tok]
     (if (empty? tok)
       mess
       (let [removed (map #(clojure.string/replace % (first tok) "") mess)]
        (lines-cleanup removed (rest tok)))))

(defn get-contents-by-line-number [contents lines]
  (map #(nth contents %) lines))

(defn code [contents & [{lines :lines}]]
  (map #(lines-cleanup % '("\t"))
       (map #(get-contents-by-line-number contents %) lines)))
(code contents {:lines [(range 1 4)]})

(def extractedLines (code contents {:lines [(range 1 1) (range 1 1)]}))
extractedLines
(assert (= 2 (count extractedLines)))

; test
(assert
 (=
  (lines-cleanup '("a\taa\t\t\n\n" "bbbb\n\t") ["\t" "\n"])
  '("aaa" "bbbb")))

; (def foo (map println [1 2 3]))
; (def foo (doall (map println [1 2 3])))

(map-indexed (fn [idx itm] [idx itm]) '(:f :o))
