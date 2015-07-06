(ns github-slurp
  (:require [clojure.java.io :as io]))

(def file "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt")
(def file-write "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt.out")

(defn read-file [file]
  (def contents '(""))
  (with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (def contents (conj contents line))))
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

(defn write-file [contents filename]
  (with-open [w (clojure.java.io/writer filename :append false)]
    (.write w (clojure.string/join "\n" (flatten contents)))))

(defn read-slurp-write [file-in config file-out]
  (write-file
   ((:output config)
    (code (read-file file-in) config)) file-out))
(defn markdown-format [style contents]
  (map #(concat (cons (str "```" style) %) '("```")) contents))

(defn markdown-java [contents]
  (markdown-format "java" contents))

(def config {:lines [(range 1 8) (range 2 4)]
             :output markdown-java})
