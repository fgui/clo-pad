(ns y2022.d02)

;;A - Rock
;;B - Paper
;;C - Scissors

;;X - Rock
;;Y - Papea
;;Z - Scissors

;;1 - Rock
;;2 - Paper
;;3 - Scissors

;;0 - Lose
;;3 - Draw
;;6 - Win

(def obj
  {:A :rock
   :B :paper
   :C :scissors
   :X :rock
   :Y :paper
   :Z :scissors})

(def obj2
  {:X :lose
   :Y :draw
   :Z :win})

(def values-obj
  {:rock 1
   :paper 2
   :scissors 3})

(def sample-data
  [[:A :Y]
   [:B :X]
   [:C :Z]])

(defn win-lost-score [h1 h2]
  (if (= h1 h2)
    3
    (case h1
      :rock (if (= h2 :paper) 6 0)
      :paper (if (= h2 :scissors) 6 0)
      :scissors (if (= h2 :rock) 6 0))))

(defn match-result [[a b]]
  (let [h1 (get obj a)
        h2 (get obj b)]
    (+ (get values-obj h2)
       (win-lost-score h1 h2))))

(->> sample-data
     (map match-result)
     (reduce +))

(defn get-input []
  (->>
   (clojure.string/split
    (slurp "src/y2022/input-d2.txt")
    #"\n")
   (map #(clojure.string/split % #" "))
   (map (fn [[a b]] [(keyword a) (keyword b)]))
   ))

(defn sol1 [input]
  (->> input
       (map match-result)
       (reduce +)))

(sol1 (get-input))

(defn get-obj [hand result]
  (if (= :draw result)
    hand
    (case hand
      :rock (if (= result :win) :paper :scissors)
      :paper (if (= result :win) :scissors :rock)
      :scissors (if (= result :win) :rock :paper))))

(defn match-result-2 [[a b]]
  (let [h1 (get obj a)
        h2 (get-obj (get obj a) (get obj2 b))]
    (+ (get values-obj h2)
       (win-lost-score h1 h2))))

(match-result-2 [:A :Y])
(match-result-2 [:B :X])
(match-result-2 [:C :Z])

(defn sol2 [input]
  (->> input
       (map match-result-2)
       (reduce +)))

(sol2 sample-data)

(sol2 (get-input))
