(ns project-euler.problems.problem3)

;; What is the largest prime factor of the number 600851475143 ?
;;
;; https://projecteuler.net/problem=3

(defn find-first [pred coll] (first (filter pred coll)))

(defn is-next-prime?
  "Given a list of the x first prime numbers, returns true if n is the next prime number"
  [primes n]
  (not (some zero? (map (partial mod n) primes))))

(defn find-next-prime
  "Given a list of the x first prime numbers, returns the next prime number"
  [primes]
  (find-first (partial is-next-prime? primes)
              (iterate inc (inc (last primes)))))

;; An infinite lazy sequence of prime numbers
(def prime-numbers 
  (map last (iterate #(conj % (find-next-prime %)) [2])))

(defn find-lowest-factor
  "Returns the lowest prime factor of number n"
  [n]
  (find-first #(zero? (mod n %)) prime-numbers))

(defn get-prime-factors
  "Returns a list of the prime factors of number n"
  [n]
  (let [factor (find-lowest-factor n)]
    (if (= n factor)
      [factor]
      (cons factor (get-prime-factors (/ n factor))))))

(def result (apply max (get-prime-factors 600851475143)))
