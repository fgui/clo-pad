(ns y2022.d03)

(def sample-data
  ["vJrwpWtwJgWrhcsFMMfFFhFp"
   "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
   "PmmdzqPrVvPwwTWBwg"
   "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
   "ttgJtRGJQctTZtZT"
   "CrZsJsPPZsGzwwsLwLmpwMDw"])

(defn get-priority [c]
  (let [p (- (int c) 96)]
    (if (pos? p)
      p
      (- (int c) 38))))

(get-priority \a)
(get-priority \z)
(get-priority \A)
(get-priority \Z)
(+ 1 1)

(defn get-rucksacks [s]
  (let [half-l (/ (count s) 2)]
    [(take half-l s) (drop half-l s)]))

(get-rucksacks "vJrwpWtwJgWrhcsFMMfFFhFp")

(defn get-repeats [[a b]]
  (clojure.set/intersection (set a) (set b)))



(get-repeats
 (get-rucksacks "vJrwpWtwJgWrhcsFMMfFFhFp"))

(defn get-score [a]
  (->> a
       (map get-priority)
       (reduce +)))

(defn sol1 [input]
  (->> input
       (map get-rucksacks)
       (map get-repeats)
       (map get-score)
       (reduce +)))

(sol1 sample-data)

(defn get-input03 []
  (->>
   (clojure.string/split
    (slurp "src/y2022/input-d3.txt")
    #"\n")
   ))

(sol1 (get-input03))

(defn get-rucksacks-three [l]
  (partition 3 l)
  )

(defn get-repeats-3[[a b c]]
  (clojure.set/intersection (set a) (set b) (set c)))

(get-repeats-3 (first (get-rucksacks-three sample-data)))

(defn sol2 [input]
  (->> (get-rucksacks-three input)
       (map get-repeats-3)
       (map get-score)
       (reduce +)
       ))

(sol2 sample-data)
(sol2 (get-input03))
