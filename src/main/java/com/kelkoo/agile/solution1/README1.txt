
Solution 1 : 1 classe différente pour chaque raison de changer (est-ce qu'on montre la solution intermédiaire : 1 classe différente pour chaque raison de changer, mais en interne de Cart)

Cart : représente l'objet métier - le panier  (Produit)
CartRepository : responsable du stockage des paniers (Architecte)
MailBuilder : responsable du contenu de mail (Marketing)
Payment : responsable du paiement (Finance)

-> L'implémentation est séparée dans des classes distinctes
-> Le service doit connaître toutes les classes
-> le service est responsable de la création des objets
-> L'objet métier doit exposer son contenu
