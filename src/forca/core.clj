(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (println "Voce perdeu!"))

(defn jogo [vidas] 
  (if (= vidas 0)
    (perdeu)
    (do
      (println (str "Quantidade de vidas restantes: " vidas))
      (jogo (dec vidas))
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; Exercicios
(defn fibonacci [n] 
  (if (= n 0) 0
    (if (= n 1) 1
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
)
