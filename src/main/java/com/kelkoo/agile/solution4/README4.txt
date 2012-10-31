
Solution 4 : utilisation du pattern Visiteur

Cart : représente l'objet métier - le panier
       permet aux autres objets de traverser la structure (liste de produits) en conservant l'encapsulation
CartVisitor : interface d'accès au contenu du Panier
MailBuilder : pour la construction de mail - c'est un visiteur
CartRepository : pour le stockage - ce n'est pas un visiteur car pas d'accès à la structure
Payment : pour le paiement - ce n'est pas un visiteur car pas d'accès à la structure

-> L'implémentation est séparée dans des classes distinctes
-> Le service doit connaître toutes les classes
-> le service est responsable de la création des objets
-> L'objet métier expose moins son contenu (parcours de la structure encapsulé)


*** Variante du Visiteur Hiérarchique
 - Le visiteur prévient quand on entre dans un noeud de la structure (mais pas quand on en sort)
 - Le visiteur hiérarchique autorise en plus :
   1) la navigation hiérarchique (concept de profondeur)
   2) la navigation conditionnelle (exclure un noeud du parcours)
  
   Implémentation : 
     visitEnter() + visitLeave() pour les composites, 
         qui peuvent retourner un booléen pour stopper le parcours
     visit() pour les feuilles de la structure
     
*** Autre variante : on peut aussi, dans le même genre d'idée, avoir un beforeVisit et afterVisit() pour permettre au visiteur de s'initialiser et de finaliser le traitement. 

Application à CartVisitor :
  - le visiteur hiérarchique n'apporte pas grand chose, la structure étant simple (une liste de Produits).
  - la possibilité d'initialiser le visiteur est exploitée
