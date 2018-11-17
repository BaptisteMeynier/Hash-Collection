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
HashTable insertion duration  = 381 ms  
HashTable seek duration  = 22193 ns  
Value is found  
______________________________________
testWithEclipseHashCodeImpl  
HashTable insertion duration  = 640 ms  
HashTable seek duration  = 31993 ns  
Value is found  
______________________________________
searchReferenceForBeanWithoutHash  
HashTable insertion duration  = 301 ms  
HashTable seek duration  = 17913 ns  
Value is found  
______________________________________
beCarefullWhenYouReimplementHashCodeMethod  
Classical Implement with prime number  
HashTable insertion duration  = 342 ms  
HashTable seek duration  = 25658 ns  
Value is found  
Personalize Implement  
HashTable insertion duration  = 988 ms  
HashTable seek duration  = 22555 ns  
Value is found  
______________________________________
testWithBeanWithSameHashValue  
Should be slow because hashcode method return always the same value and the repartition is bad  
HashTable insertion duration  = 239 ms  
HashTable seek duration  = 5575 ns  
Value is found  
______________________________________
changeValueForBeanWithHash  
HashTable insertion duration  = 267 ms  
HashTable seek duration  = 14551 ns  
Value not found  
______________________________________
testWithIntelliJHashCodeImpl  
HashTable insertion duration  = 316 ms  
HashTable seek duration  = 26289 ns  
Value is found  
______________________________________
testBeanWithHashImmutable  
HashTable insertion duration  = 236 ms  
HashTable seek duration  = 24506 ns  
Value is found  
______________________________________
testWithJava8HashCodeImpl  
HashTable insertion duration  = 297 ms  
HashTable seek duration  = 15159 ns  
Value is found  
______________________________________
testCachingHashCode  
HashTable insertion duration  = 246 ms  
HashTable seek duration  = 4101 ns  
Value is found  
______________________________________
searchBeanWithDifferentReferenceForBeanWithoutHash  
HashTable insertion duration  = 271 ms  
HashTable seek duration  = 1575 ns  
Value not found  

