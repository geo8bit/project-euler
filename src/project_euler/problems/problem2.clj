(ns project-euler.problem2)

;; By considering the terms in the Fibonacci sequence whose values do
;; not exceed four million, find the sum of the even-valued terms.
;;
;; https://projecteuler.net/problem=3

(def fibonacci (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2])))

(def result (->> fibonacci
                 (take-while (partial > 4000000))
                 (filter even?)
                 (reduce +)))
