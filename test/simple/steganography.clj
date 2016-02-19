(ns simple.steganography
  (:use midje.sweet))

(defn reveal-message
  [message]
    (->> message
         (map #(apply + %))
         (map char )
         (apply str)))

(defn conceal-message
  [plaintext]
  (letfn [(split-in-two [n] (-> (let [value (rand-int n)
                                   difference (- n value)]
                               [value difference])))]
    (->> plaintext
         (map int)
         (map split-in-two))))

(facts "decrypting messages"
       (fact "a single-letter message"
             (reveal-message '([115 0])) => "s")
       (fact "a multiple-letter message"
             (reveal-message '([115 0] [101 0] [99 0] [114 0] [101 0] [116 0] [32 0] [109 0] [101 0] [115 0] [115 0] [97 0] [103 0] [101 0])) => "secret message")
       (fact "symbols"
             (reveal-message '([45 2] [45 2] [45 2])) => "///"))

(facts "encrypting messages"
       (let [conceal-then-reveal (comp reveal-message conceal-message)]
         (fact "a single-letter message"
               (conceal-then-reveal "s") => "s")
         (fact "a multiple-letter message"
               (conceal-then-reveal "sss") => "sss")))