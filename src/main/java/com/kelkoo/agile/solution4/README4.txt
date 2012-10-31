
Solution 4 : utilisation du pattern Visiteur

Cart : représente l'objet métier - le panier ; 
       permet aux autres objets de traverser la structure (liste de produits) en conservant l'encapsulation
CartVisitor : interface d'accès au contenu du Panier
CartRepository : pour le stockage
MailBuilder : pour la construction de mail
Payment : pour le paiement

-> L'implémentation est séparée dans des classes distinctes
-> Le service doit connaître toutes les classes
-> le service est responsable de la création des objets
-> L'objet métier expose moins son contenu (parcours de la structure encapsulé)


Note: variante du Visiteur Hiérarchique
 - Visiteur prévient quand on entre dans un noeud de la structure (mais pas quand on en sort)
 - VH autorise en plus :
   1) la navigation hiérarchique (concept de profondeur)
   2) la navigation conditionnelle (exclure un noeud du parcours)
  Implémémentation : 
     visitEnter() + visitLeave() pour les composites, 
         qui peuvent retourner un booléen pour stopper le parcours
     visit() pour les feuilles de la structure