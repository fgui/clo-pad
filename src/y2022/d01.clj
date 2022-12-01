(ns y2022.d01)

(def sample-data
  [[1000
    2000
    3000]
   [4000]
   [5000
    6000]
   [7000
    8000
    9000]
   [10000]])

(defn get-max-carrier [data]
  (->> data
       (map-indexed #(vec [%1 (reduce +  %2)]))
       (reduce #(if (>= (second %1) (second %2))
                  %1
                  %2))))

(defn solve-first-part [data]
  (second
   (get-max-carrier data)))

(defn solve-second-part [data]
  (->> data
       (map #(reduce +  %))
       (sort >)
       (take 3)
       (reduce +)
       ))

(solve-first-part sample-data)

(defn vector-as-ints[v]
  (map read-string v))

;; process input
(defn get-input []
  (->>
   (clojure.string/split
    (slurp "src/y2022/input-d1.txt")
    #"\n\n")
   (map #(clojure.string/split % #"\n"))
   (map vector-as-ints)))

(solve-first-part (get-input))
(solve-second-part (get-input))






