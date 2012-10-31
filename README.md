srp-2012
========

Code utilisé pour notre présentation [Well-crafted software: un code maintenable avec le "principe de responsabilité unique"][http://sessions.agile-grenoble.org/program#session_detail_37] à Agile Grenoble 2012

Il y a 5 implémentations. 

* Chaque implémentation est complétement indépendante des autres
* Dans chaque implémentation, on trouve
 * un commentaire dans le fichier README.txt correspondant
 * un package collaborators qui sert à isoler les classes nécessaires à la compilation mais qui n'apportent rien à la compréhension
 * la classe BusinessService qui sert à illustrer l'utilisation de la classe Cart (et des classes liées) 

Les 5 implémentations
---------------------

* com.kelkoo.agile.start : 

  Implémentation initiale, tout le code dans une seule classe Cart
  
  Le principe de responsabilité unique (Single responsability principle - SRP) n'est pas respecté.

* com.kelkoo.agile.solution1 :
 
  Utilisation d'une classe différente par responsabilité 

* com.kelkoo.agile.solution2

  Introduction d'un objet Facade pour simplifier la manipulation des classes

* com.kelkoo.agile.solution3

  Une interface par responsabilité, mais l'implémentation reste dans une seule classe

* com.kelkoo.agile.solution4
 
  Utilisation du Pattern visiteur pour éviter d'exposer la structure interne de la classe Cart
   