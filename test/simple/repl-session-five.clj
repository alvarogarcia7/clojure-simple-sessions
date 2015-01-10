(defn recursive-reverse [coll]
  (defn rever2 [in out]
  (if (empty? in)
    out
    (conj
     (rever2 (rest in) out)
     (first in))))
  (rever2 coll [])
  )

(defn rever [in]
  (if (empty? in)
    []
    (conj
     (rever (rest in))
     (first in))))

(conj [1] 2)
(rever '(1 2 3 4))


(defn rever2 [in out]
  (if (empty? in)
    out
    (conj
     (rever2 (rest in) out)
     (first in))))

(rever2 '(1 2 3 4) '[])


(conj [1] 2)

(vec '(1 2))

(vec (reverse [1 2]))

(recursive-reverse [1])

  (= '(1) (recursive-reverse [1]))

  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))



((fn [[a b]] (str b a))
         [:foo :bar])

(str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")

(clojure.string/join "," '(1 2))

 (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
   full-name)

  (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
       {:original-parts [full-name]
        :named-parts {:first first-name :last last-name}})


(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})


  (def the-world (ref "hello"))
(def bizarro-world (ref {}))
    (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          [@the-world @bizarro-world]))




(def atomic-clock (atom 101))
(do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock)
