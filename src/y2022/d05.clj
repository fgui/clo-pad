(ns y2022.d05)


(def stack
  ['(:N :Z)
   '(:D :C :M)
   '(:P)
   ])

(defn move [stack n from to]
  (let [pile-from (nth stack from)
        pile-to (nth stack to)
        crates (reverse (take n pile-from))]
    (-> stack
        (assoc from (drop n pile-from))
        (assoc to (concat crates pile-to)))))

(-> stack
    (move 1 1 0)
    (move 3 0 2)
    (move 2 1 0)
    (move 1 0 1)
    )

(defn get-inputs []
  (->>
   (clojure.string/split
    (slurp "src/y2022/input-d5.txt")
    #"\n\n")))

(defn get-stack []
  (vec
   (->>
    (filter #(not= \space (last %))
            (apply (partial map vector)
                   (map vec
                        (-> (get-inputs)
                            first
                            (clojure.string/split #"\n")))))
    (map #(filter (fn [x] (not= \space x)) %)))))

(defn get-command [str]
  (map read-string
       (filter #(not (#{"move" "from" "to"} %))
               (clojure.string/split str #" "))))


(defn get-commands []
  (map get-command
       (-> (get-inputs)
           second
           (clojure.string/split #"\n"))))


(defn move-h [stack [n from to]]
   (move stack n (dec from) (dec to))
  )

(def s (vec (get-stack)))
(move s 1 1 1)

(defn sol1 []
  (map first
       (reduce move-h (get-stack) (get-commands))))

(defn move2 [stack n from to]
  (let [pile-from (nth stack from)
        pile-to (nth stack to)
        crates (take n pile-from)]
    (-> stack
        (assoc from (drop n pile-from))
        (assoc to (concat crates pile-to)))))

(defn move-h2 [stack [n from to]]
   (move2 stack n (dec from) (dec to))
  )

(defn sol2 []
  (map first
       (reduce move-h2 (get-stack) (get-commands))))



