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
HashTable insertion duration  = 6709 ms
HashTable seek duration  = 48426 ns
Value is found
______________________________________
testBeanWithSameHashValue
Should be slow because hashcode method return always the same value and the repartition is bad
HashTable insertion duration  = 6300 ms
HashTable seek duration  = 23083 ns
Value is found
______________________________________
searchCloneBeanForBeanWithoutHash
HashTable insertion duration  = 6439 ms
HashTable seek duration  = 14443 ns
Value not found
______________________________________
beCarefullWhenYouReimplementHashCodeMethod
Classical Implement with prime number
HashTable insertion duration  = 4610 ms
HashTable seek duration  = 42230 ns
Value is found
Personalize Implement
HashTable insertion duration  = 6758 ms
HashTable seek duration  = 23880 ns
Value is found
______________________________________
testJava8HashCodeImpl
HashTable insertion duration  = 5873 ms
HashTable seek duration  = 15754 ns
Value is found
______________________________________
searchBeanReferenceWithHash
HashTable insertion duration  = 5397 ms
HashTable seek duration  = 22290 ns
Value is found
______________________________________
searchCloneBeanWithHash
HashTable insertion duration  = 4988 ms
HashTable seek duration  = 41633 ns
Value is found
______________________________________
changeValueForBeanWithHash
HashTable insertion duration  = 5799 ms
HashTable seek duration  = 13657 ns
Value not found
______________________________________
testIntelliJHashCodeImpl
HashTable insertion duration  = 5409 ms
HashTable seek duration  = 23096 ns
Value is found
______________________________________
searchByReferenceForBeanWithoutHash
HashTable insertion duration  = 3302 ms
HashTable seek duration  = 3214 ns
Value is found
______________________________________
testBeanWithHashImmutable
HashTable insertion duration  = 3750 ms
HashTable seek duration  = 22791 ns
Value is found
______________________________________
testCloneBeanWithSameHashValue
Should be slow and not find the key
HashTable insertion duration  = 3986 ms
HashTable seek duration  = 24722 ns
Value is found
______________________________________
testImmutableCachingHashCode
HashTable insertion duration  = 5170 ms
HashTable seek duration  = 4773 ns
Value is found



