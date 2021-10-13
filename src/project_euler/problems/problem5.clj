(ns project-euler.problems.problem5
  (:require [project-euler.problems.problem3 :as problem3 :refer [get-prime-factors]]))

;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
;;
;; https://projecteuler.net/problem=5

(defn not-nill
  "Helper, returns 0 when nill."
  [n] 
  (if (nil? n) 0 n))

(defn highest-order
  "Given a list of maps of prime factors, where key=base and val=order, 
   returns the highest order for each base."
  [factors]
  (reduce (fn [acc el]
            (->> (keys el)
                 (map #(max (not-nill (get el %)) 
                            (not-nill (get acc %))))
                 (zipmap (keys el))
                 (merge acc)))
          {}
          factors))

(defn do-the-math
  "Given a map of prime factors, where key=base and val=order, returns the
   actual number"
  [factors]
  (reduce (fn [acc [key val]] (* acc (Math/pow key val))) 1 factors))

(def result (->> (range 19)
                 (map (partial + 2))
                 (map get-prime-factors)
                 (map frequencies)
                 (highest-order)
                 (do-the-math)
                 (biginteger)))
