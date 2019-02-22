(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (println "Voce perdeu!"))
(defn ganhou [] (println "Voce ganhou!"))

(defn letras-faltantes [palavra chutes]
  (remove (fn [letra] (contains? chutes (str letra))) palavra)
)


(defn acertou-a-palavra-toda? [palavra chutes]
  (empty? (letras-faltantes palavra chutes))
)

(defn jogo [vidas palavra chutes] 
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra chutes)
      (ganhou)
      (println "Tente novamente!")      
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; --------- Exercicios ---------
(defn fibonacci [n] 
  (if (= n 0) 0
    (if (= n 1) 1
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
)

(defn multiplicaArray [x] (* x 2))

(defn removeOsPares [x] (= 0 (rem x 2)))
