(def filename "c:/tmp/full.csv")


(with-open [in-file (io/reader filename)]
  (defn parse-int [s]
    (Integer/parseInt (re-find #"\A-?\d+" s)))
  (defn printnums [& nums] (println nums))

    (let [contents (doall (csv/read-csv in-file))
           ca (filter #(re-matches #"CA.*" (first %)) contents)
           es (filter #(re-matches #"ES*" (first %)) contents)
         
           val1 (reduce + (map #(parse-int (second %)) ca))
           val2 (reduce + (map #(parse-int (nth % 3)) ca))
           val3 (reduce + (map #(parse-int (second %)) es))]

           	(printnums val1 val2 val3)
           	(= val1 val2 val3)))