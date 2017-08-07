(ns simple.psr)

(defn pow [n x]
    (reduce *' (repeat x n)))
    
(defn- square [n]
  (pow n 2))

(def certainty 5)

(defn- prime? [n]
      (.isProbablePrime (BigInteger/valueOf n) certainty))

(defn- primes [n] (concat [2] (take n 
   (filter prime? 
      (take-nth 2 
         (range 1 Integer/MAX_VALUE))))))

(defn prime-squares-remainder-of [[n pn]]
    (mod 
      (+'
        (pow (inc pn) n) 
        (pow (dec pn) n)) 
      (square pn)))

(defn prime-squares-remainder-geq [n]
  (let [primes (primes n)
         sqrt (Math/sqrt n)]
    (->> 
      (range)
      (map #(-> [% (nth primes %)]))
      (drop-while #(<= (second %) sqrt))
      (drop-while #(>= n (prime-squares-remainder-of %)))
      first
      first)))

(comment (let [t (Integer/parseInt (read-line))
      matrix (for [_ (range t)] (bigint (read-line)))]
  (->> matrix
    (map prime-squares-remainder-geq)
    (map println)
    doall)))