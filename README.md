# ProjectMARKETPLACE

# project_MARKETPLACE


Membre du groupe

* Elias Ait-Bouali
* Mucas Taloub
* Mathis Rellier
* Killian Guelou
* OKON N'Guessan

Ce document est une aide à la compréhension de nos programmes. Les principales classes que nous avons implémenter sont : MARKETPLACE , CLIENT, VENDEUR, CONTRAT, COMMANDE, PRODUIT

Nous passons à la phase de test des différentes fonctionnalité requises pour chaque classe.

Des parties du programme principale (Main) pouront être mise en commentaire afin de bien suivre.

Commençons par la classe VENDEUR.

Comme toute plateforme de commerce nous considérons que toute personne qui la consulte ne dispose pas nécessairement d’un compte c’est à  dire que n’a pas forcement une instance de classe en son nom. 
C’est pourquoi la méthode « static »      Vendeur.faireUnContrat()             permettra à tout utilisateur de se créer un compte vendeur et en même générer un contrat. 
A l’aide des scanner, nous faisons remplir un formulaire d’inscription au vendeur. A l’issue de cette opération, une instance de classe vendeur est créée en son son nom et est stockée dans l’attribut de classe « allVendeur » : cet ArrayList « Vendeur » stocke toutes les instance de vendeur qui sont cree au fur et mesure.

Ensuite supposons que personne inconnue souhaite s’identifier car elle possède déjà un compte qui figure donc dans notre tableau static 
Encore une fois, celle-ci n’a pas accès à l’instance qui lui est dédiée donc elle va essayer de retrouver cette instance grâce à la méthode static « Vendeur.sidentifier(pseudo, mdp) » . A ce moment, nous parcours tout le tableau des vendeurs en comparant les pseudo et les mdp pour ensuite retourne l’indice p de l’instance recherchée.

Cependant s’il n’y a aucune corresponde un « try catch » nous permet de renvoyer un message d’erreur comme quoi il n’a pas de compte vendeur compatible.

Maintenant essayons de nous identifier sur le compte du deuxième vendeur.

Ensuite tentons de publier un produit avec ce profil.

On nous demande donc de nous connecter avant d’effectuer toute opération.

Une fois que le vendeur se connecte, son état de connexion passe à true et maintenant il à la possibilité d’effectuer des opérations. Des tests sont effectués avant tout.

Maintenant essayons de publier un produit.	

Des exceptions peuvent être générées quand des champs sont vides.
Notons aussi que le vendeur peut suivre ses ventes avec suivreVente(). 

Passons à la classe CLIENT.
Le principe est le même que précédemment. Il se créer un compte, s’identifie et se connecte avant tout opération. Là tout se fait avec la méthode static de la classe CLIENT
Il pourra faire une commande.
D’abord on affiche la liste de tous les produits avec la méthode statique de PRODUIT.

La marketplace peut aussi publier des produits. Pour ceux ci, idVendeur = null;



