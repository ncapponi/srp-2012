
Solution 3 : Séparation des interfaces

Cart : implémentation de tous les aspects du Panier
SimpleCart : interface pour l'objet métier
CartRepository : interface pour le stockage
MailBuilder : interface pour la construction de mail
Payment : interface pour le paiement

-> L'implémentation est regroupée dans une seule classe - plusieurs responsabilités
-> Le service est utilise des interfaces distinctes, il ne manipule jamais l'objet qui implémente le comportement
-> L'objet métier n'expose pas son contenu
-> La construction des objets et le passage d'une interface à une autre nécessite une indirection (utilisation de Factory)
