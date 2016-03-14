(ns simple.psr)

(defn pow [n x]
    (reduce *' (repeat x n)))
    
(defn- square [n]
  (pow n 2))

(def certainty 5)

(defn- prime? [n]
      (.isProbablePrime (BigInteger/valueOf n) certainty))

(def primes (concat [2] (take 10001 
   (filter prime? 
      (take-nth 2 
         (range 1 Integer/MAX_VALUE))))))

(defn prime-squares-remainder-of [n]
  (let [n (bigint n)
         pn (nth primes (dec n))]
    (mod 
      (+'
        (pow (inc pn) n) 
        (pow (dec pn) n)) 
      (square pn))))

(defn prime-squares-remainder-geq [n]
  (->> 
    (range) 
    (map inc) 
    (drop-while #(>= n (prime-squares-remainder-of %)))
    (take 1)
    first))

(let [t (Integer/parseInt (read-line))
      matrix (for [_ (range t)] (bigint (read-line)))]
  (->> matrix
    (map prime-squares-remainder-geq)
    (map println)
    doall))