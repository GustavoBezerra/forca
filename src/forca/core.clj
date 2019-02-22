(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(declare jogo)

(defn perdeu [] (println "Voce perdeu!"))
(defn ganhou [] (println "Voce ganhou!"))

(defn letras-faltantes [palavra chutes]
  (remove (fn [letra] (contains? chutes (str letra))) palavra)
)

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn acertou-a-palavra-toda? [palavra chutes]
  (empty? (letras-faltantes palavra chutes))
)

(defn avalia-chute [chute vidas palavra acertos]
  (if (acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)
  )
)

(defn jogo [vidas palavra acertos] 
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (avalia-chute (le-letra!) vidas palavra acertos)
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
