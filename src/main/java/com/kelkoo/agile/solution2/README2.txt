
Solution 2 : Facade pour faciliter le travail du client

Cart : représente l'objet métier - le panier
CartRepository : responsable du stockage des paniers
MailBuilder : responsable
Payment : responsable du paiement

CartFacade : encapsule les 4 classes pour simplifier le travail des utilisateurs de Panier

-> L'implémentation est séparée dans des classes distinctes
-> Le service est plus simple
-> La facade reste très simple, elle délègue tout
-> La création des objets est plus compliquée, on doit créer les objets cachés par la façade
-> L'objet métier doit exposer son contenu
