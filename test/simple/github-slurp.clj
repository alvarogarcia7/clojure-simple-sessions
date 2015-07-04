(ns github-slurp
    (:require [clojure.java.io :as io]))
(def file "/Users/alvaro/Documents/sandbox/clojure/simple/test/simple/RegistryShould.txt")
(with-open [rdr (io/reader file)]
    (doseq [line (line-seq rdr)]
      (println line)))
