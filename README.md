# AndroidPwned

Projet mobile de François Dupuis (34)

Ce projet contient les choses suivantes:

  - Une architecture MVC (Media Vue Controller)
  - L'utilisation d'une API Rest 
  - L'implémentation d'une liste scrollable et cliquable grâce à une RecyclerView
  - Plusieurs écrans et activités
  - Utilisation du GitFlow (malgré la mort tardive de la branche Master...)
  
  
  # Présentation de l'application 
  
  Cette application permet de vérifier de façon sure si  son adresse email et son mot de passe à fuité.
  Pour ce faire elle utilise l'API Rest du site [Have I Been Pwned](https://haveibeenpwned.com/).
  
  Au lancement l'application affiche le menu menant vers les différentes fonctionnalités:
  <p align="center">
  <img src="https://zupimages.net/up/19/14/6zvw.png" width="171" height="343">
  </p>
  
  On a  alors accès à l'activité permettant de vérifier son adresse email:
  <p align="center">
  <img src="https://zupimages.net/up/19/14/u73c.png" width="171" height="343">
  </p>
  Cette activité possède une saisie sécurisée à l'aie d'une REGEX, seule des adresses mail seront prises.
  
  De même pour l'activité permettant de vérifier son mot de passe:
  <p align="center">
  <img src="https://zupimages.net/up/19/14/i1lv.png" width="171" height="343">
  </p>
  Cette activité permet de vérifier son mot de passe en toute sécurité grâce à une utilisation intelligente de la fonction de hashage SHA1.
  Elle offre également les fonctionalités suivantes:
  
 - Affiche le nombre de fois que le mot de passe est présent dans la base de donnée si compromis.
 - Encourage l'utilisateur à modifier son mot de passe pour un mot de passe plus sure si non compromis (IE: utilisation de majuscules, chiffres et caractères  spéciaux).
 
 Vient ensuite l'activité contenant la liste:
  <p align="center">
  <img src="https://zupimages.net/up/19/14/8og3.png" width="171" height="343">
  </p>
  La liste est cliquable et affiche des informations relatives au plus grosses failles de sécurités par ordre alphabétique.
  Un click offre alors des informations complémentaires sur chaque faille.
  <p align="center">
  <img src="https://zupimages.net/up/19/14/szyn.png" width="171" height="343">
  </p>
  
  Enfin la dernière activité est simplement constituée d'une page de texte ayant pour objectif d'expliquer comment l'application utilise les mots de passes rentrés.

# Améliorations Possibles (et Future!)

- Implémentation d'un "Background Check" et de notifications push
- Implémentation d'une seconde RecyclerView permettant de voir sur quel site son adresse email à fuitée.
- Amélioration esthétique.
  
  

 
 
 
 
 
 
 
 
 
 
 
