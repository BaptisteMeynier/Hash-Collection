# Hash Collection
---
## Quelques conseils

- initialiser la valeur de retour avec un entier premier
- utiliser une formule mathématique dédiée pour chaque type primitif pour déterminer une valeur entière : deux nombres premiers pour les booléens, décalage de bits pour les types plus grands qu'un entier, ...
- faire des combinaisons en ajoutant la valeur de chaque attribut multipliée par un nombre premier

Ainsi si le calcul de la valeur du hashcode est complexe ou pour améliorer les performances, il est possible de mettre en cache la valeur de hachage calculée. Deux cas de figure sont à prendre en compte :

- l'objet est immuable : dans ce cas, c'est très facile car le hashcode peut être calculé une seule et unique fois lorsque l'objet est initialisé
- l'objet n'est pas immuable : il est alors nécessaire de recalculer la valeur du hashcode stocké à chaque modification de la valeur d'un attribut. Il faut cependant dans ce cas avoir la maitrise de tous les cas où la valeur d'un attribut peut être modifiée afin d'être en mesure de recalculer la nouvelle valeur de hachage


____
Résultat de l'execution sur mon poste

testWithBeanWithoutHash  
HashTable temps d'insertion  = 57 ms  
HashTable temps de recherche = 16410 nano secondes  
I find the result  

testWithBeanWithHash  
HashTable temps d'insertion  = 90 ms  
HashTable temps de recherche = 24205 nanoSecondes  
I find the result  

testWithBeanWithSameHashValue  
Should be slow because hashcode method return always the same value and the repartition is bad  
HashTable temps d'insertion  = 56910 ms  
HashTable temps de recherche = 8752003 nano secondes  
  
changeValueForBeanWithHash  
HashTable temps d'insertion  = 28 ms  
HashTable temps de recherche = 7795 nano secondes  
HashTable temps de recherche une fois mutée = 77128 nano secondes  
Does not find the result  

testBeanWithHashImmutable  
HashTable temps d'insertion  = 51 ms  
HashTable temps de recherche = 2462 nano secondes  
I do not find the result  

shouldBeQuickerWithPersonalizeHashThanClassicImpl  
HashTable temps de recherche pour BeanWithHash  = 41436 ms  
HashTable temps de recherche pour BeanWithPersonalizedHashImmutable  = 112411 ms  

testCachingHashCode  
HashTable temps d'insertion  = 37 ms  
HashTable temps de recherche = 54974 nano secondes  
I find the result  

