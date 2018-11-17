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
testEclipseHashCodeImpl
HashTable insertion duration  = 1595 ms  
HashTable seek duration  = 33163 ns  
Value is found  
______________________________________
testBeanWithSameHashValue  
Should be slow because hashcode method return always the same value and the repartition is bad  
HashTable insertion duration  = 1223 ms  
HashTable seek duration  = 17542 ns  
Value is found  
______________________________________
searchReferenceForBeanWithoutHash  
HashTable insertion duration  = 811 ms  
HashTable seek duration  = 16457 ns  
Value is found  
______________________________________
beCarefullWhenYouReimplementHashCodeMethod  
Classical Implement with prime number  
HashTable insertion duration  = 627 ms  
HashTable seek duration  = 22892 ns  
Value is found  
Personalize Implement  
HashTable insertion duration  = 1529 ms  
HashTable seek duration  = 22921 ns  
Value is found  
______________________________________
testJava8HashCodeImpl  
HashTable insertion duration  = 853 ms  
HashTable seek duration  = 14593 ns  
Value is found  
______________________________________
changeValueForBeanWithHash  
HashTable insertion duration  = 610 ms  
HashTable seek duration  = 13575 ns  
Value not found  
______________________________________
testIntelliJHashCodeImpl  
HashTable insertion duration  = 819 ms  
HashTable seek duration  = 25314 ns  
Value is found  
______________________________________
testBeanWithHash  
HashTable insertion duration  = 1527 ms  
HashTable seek duration  = 20919 ns  
Value is found  
______________________________________
testBeanWithHashImmutable  
HashTable insertion duration  = 617 ms  
HashTable seek duration  = 23329 ns    
Value is found  
______________________________________
testImmutableCachingHashCode  
HashTable insertion duration  = 705 ms  
HashTable seek duration  = 4408 ns  
Value is found  
______________________________________
searchBeanWithDifferentReferenceForBeanWithoutHash  
HashTable insertion duration  = 662 ms  
HashTable seek duration  = 1718 ns  
Value not found  


