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
HashTable insertion duration  = 1737 ms  
HashTable seek duration  = 35760 ns  
Value is found  
______________________________________
testWithEclipseHashCodeImpl  
HashTable insertion duration  = 1188 ms  
HashTable seek duration  = 40447 ns  
Value is found  
______________________________________
searchReferenceForBeanWithoutHash  
HashTable insertion duration  = 578 ms  
HashTable seek duration  = 17117 ns  
Value is found  
______________________________________
beCarefullWhenYouReimplementHashCodeMethod  
Classical Implement with prime number  
HashTable insertion duration  = 524 ms  
HashTable seek duration  = 22118 ns  
Value is found  
Personalize Implement  
HashTable insertion duration  = 610 ms  
HashTable seek duration  = 28541 ns  
Value is found  
______________________________________
testWithBeanWithSameHashValue  
Should be slow because hashcode method return always the same value and the repartition is bad  
HashTable insertion duration  = 484 ms  
HashTable seek duration  = 4488 ns  
Value is found  
______________________________________
changeValueForBeanWithHash  
HashTable insertion duration  = 999 ms  
HashTable seek duration  = 13735 ns  
Value not found  
______________________________________
testWithIntelliJHashCodeImpl  
HashTable insertion duration  = 398 ms  
HashTable seek duration  = 24595 ns  
Value is found  
______________________________________
testBeanWithHashImmutable  
HashTable insertion duration  = 410 ms  
HashTable seek duration  = 27089 ns  
Value is found  
______________________________________
testWithJava8HashCodeImpl  
HashTable insertion duration  = 756 ms  
HashTable seek duration  = 17158 ns  
Value is found  
______________________________________
testCachingHashCode  
HashTable insertion duration  = 325 ms  
HashTable seek duration  = 4507 ns  
Value is found  
______________________________________
searchBeanWithDifferentReferenceForBeanWithoutHash  
HashTable insertion duration  = 705 ms  
HashTable seek duration  = 1354 ns  
Value not found  


