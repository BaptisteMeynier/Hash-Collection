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

______________________________________
testWithBeanWithHash  
HashTable insertion duration  = 409 ms  
HashTable seek duration  = 44541 ns  
Value is found  
______________________________________
searchReferenceForBeanWithoutHash  
HashTable insertion duration  = 677 ms  
HashTable seek duration  = 16334 ns  
Value is found  
______________________________________
beCarefullWhenYouReimplementHashCodeMethod  
HashTable insertion duration  = 320 ms  
HashTable seek duration  = 31187 ns  
Value is found  
HashTable insertion duration  = 974 ms  
HashTable seek duration  = 23970 ns  
Value is found  
______________________________________
testWithBeanWithSameHashValue  
Should be slow because hashcode method return always the same value and the repartition is bad  
HashTable insertion duration  = 415 ms  
HashTable seek duration  = 4021 ns  
Value is found  
______________________________________
testBeanWithHashImmutable  
HashTable insertion duration  = 246 ms  
HashTable seek duration  = 19176 ns  
Value is found  
______________________________________
testCachingHashCode  
HashTable insertion duration  = 308 ms  
HashTable seek duration  = 4429 ns  
Value is found  
______________________________________
searchBeanWithDifferentReferenceForBeanWithoutHash  
HashTable insertion duration  = 238 ms  
HashTable seek duration  = 1385 ns  
Value not found  

