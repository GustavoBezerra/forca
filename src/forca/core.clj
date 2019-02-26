(ns forca.core
  (:gen-class))

(def total-de-vidas 6)
(def palavra-secreta "NUBANK")

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

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas restantes: " vidas)
  (doseq [letra (seq palavra)]
    (if (contains? acertos (str letra))
      (print letra " ")
      (print "_" " ")))
  (println))

(defn jogo [vidas palavra acertos] 
  (imprime-forca vidas palavra acertos)
  (cond 
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
        (if (acertou? chute palavra)
          (do
            (println "Acertou a letra!")
            (recur vidas palavra (conj acertos chute)))
          (do
            (println "Errou a letra! Perdeu vida!")
            (recur (dec vidas) palavra acertos))))))

(defn comeca-o-jogo [] (jogo total-de-vidas palavra-secreta #{}))

(defn -main [& args]
  (println "Dica: Nome de um banco!")
  (comeca-o-jogo))

; --------- Exercicios ---------
(defn fibonacci [n] 
  (if (= n 0) 0
    (if (= n 1) 1
    (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))
)

(defn multiplicaArray [x] (* x 2))

(defn removeOsPares [x] (= 0 (rem x 2)))
