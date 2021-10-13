(ns project-euler.problem10)

;; Find the sum of all the primes below two million.
;;
;; https://projecteuler.net/problem=10

(defn rm-multi
  "Removes multiples of n from coll"
  [n coll]
  (filter #(not= 0 (mod % n)) coll))

(defn prime-numbers-below
  "Implements Sieve of Eratosthenes to find all prime numbers below n."
  [n]
  (loop [candidates (rest (range 1 n 2))
         tested [2]]
    (if (> (first candidates) (Math/floor (Math/sqrt n)))
        (concat tested candidates)
        (recur (rm-multi (first candidates) (rest candidates))
               (conj tested (first candidates))))))

(def result (reduce + (prime-numbers-below 2000000)))
