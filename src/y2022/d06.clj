(ns y2022.d06)

(def sample-data-raw7
  "mjqjpqmgbljsphdztnvjfqwrcgsmlb")

(def sample-data-raw10
  "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")

(defn sol [line n]
  (->>
   (map vector
        (partition n 1 line)
        (iterate inc 0))
   (some #(when (= n (count (set (first %)))) %))
   second
   (+ n)))

(defn sol1 [line]
  (sol line 4))

(sol1 sample-data-raw10)

(sol1
 (slurp "src/y2022/input-d6.txt"))

(defn sol2 [line]
  (sol line 14))

(sol2 
 (slurp "src/y2022/input-d6.txt"))

