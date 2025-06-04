# 🕹️ Zeldiablo 2025 - Martin Gouthier / Alexis Serda / Chebbah Yanis / Logan Singet / Tamourgh Jassem

Bienvenue dans **Zeldiablo 2025**, un mini-jeu d'action-aventure inspiré de *The Legend of Zelda* ! 🧙‍♂️⚔️  
Ce jeu en Java a été développé dans le cadre d’un projet universitaire et met en avant les principes de la programmation orientée objet, la logique de conception de jeu, et une architecture événementielle.

---

## 🎯 Présentation du projet

**Zeldiablo** est un jeu de type donjon où le joueur se déplace sur une carte en grille, évite ou combat des monstres, collecte des objets, et atteint un objectif final. Le projet met l’accent sur :

- Génération de cartes et de niveaux
- Comportement des personnages et des ennemis
- Déplacements au tour par tour
- Mécaniques de combat
- Intelligence artificielle basique pour les ennemis

---

## 🛠️ Fonctionnalités

✅ Architecture de code modulaire et extensible  
✅ Carte de donjon basée sur une grille  
✅ Logique de jeu au tour par tour  
✅ IA simple pour les ennemis (poursuite du joueur)  
✅ Gestion des objets et des objectifs  
✅ Interface textuelle via Java Swing / console

---

## 📂 Structure du projet
025_Zeldiablo_MartinGouthier/
├── src/
│ ├── gameLaby/ # Logique principale du jeu (héros, ennemis, grille)
│ ├── moteurJeu/ # Composants du moteur de jeu
│ ├── affichage/ # Affichage et rendu
│ └── main/ # Point d'entrée du jeu
└── README.md # Ce fichier !


---

## 🧪 Comment exécuter le jeu

### Prérequis :
- Java 11 ou plus récent
- Un IDE Java (ex : IntelliJ, Eclipse) ou un terminal avec `javac`

### Instructions :
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/MartinGouthier/2025_Zeldiablo_MartinGouthier.git
   cd 2025_Zeldiablo_MartinGouthier
Compiler les fichiers Java :
javac src/**/*.java

💡 Le jeu s’exécute dans une interface texte (console) et nécessite des interactions clavier.

###🎮 Points forts du gameplay
  🧍 Déplacez votre héros dans le donjon
  🐍 Affrontez ou évitez les monstres
  🧠 Les ennemis vous poursuivent grâce à une IA simple
  🗝️ Trouvez la clé pour atteindre la sortie

---

## 🧩 Première Itération – Base du jeu + gestion de la mort

### ⚔️ Fonctionnalité 6.1 : Mort du héros

- **Conception** : Jassem, Martin
- **Implémentation** : Yanis, Alexis, Logan
- **Séquence** : Logan, Alexis, Jassem
- **Tests** : Alexis, Martin

#### 👨‍💻 Classe `Perso`
- Attribut : `vie` (par défaut 5)
- Méthodes : `getVie()`, `modifierVie()`, `estVivant()`
- Modification de `etreFini()` pour vérifier si le héros est vivant

#### 🎨 Classe `LabyDessin`
- Méthode `dessinerJeu()` affiche un écran de fin si `etreFini()`

#### 🔁 Classe `LabyJeu`
- `etreFini()` vérifie `!getPerso().estVivant()`

### 👾 Fonctionnalité 2 : Ajout des monstres

- Création d’une classe abstraite `Entite`
- Création de `Monstre extends Entite`
- `Perso` devient `extends Entite`
- Monstres intégrés dans le labyrinthe (`'M'`)
- Blocage de déplacement si monstre sur la case

### ✅ Tests réalisés
- Vie du personnage modifiée correctement
- Monstre présent dans le labyrinthe et bloquant

---

## 🔮 Deuxième Itération – Cases à effet et pièges

### 🧠 Fonctionnalité 1.4 : Cases à effet

- **Choix d'implémentation** : Classe mère `CaseEffet` et classes filles (`CasePiege`, etc.)

#### 👨‍💻 Classe `Labyrinthe`
- Génère des `CaseEffet`
- Méthode `deplacerEntite()` détecte les effets

#### 🔍 Classe `CaseEffet`
- Attributs : `x`, `y`, `decouvert`
- Méthodes : `activation()`, `getPosition()`, `getDecouvert()`

### ☠️ Fonctionnalité 1.5 : Case piège

- Classe `CasePiege extends CaseEffet`
- Inflige 1 PV de dégâts
- Réarmement du piège après départ du joueur

### ✅ Tests réalisés
- Le joueur prend un seul dégât
- Le piège se réactive correctement
- Affichage console de l’effet

---

## 👣 Troisième Itération – Déplacement intelligent des monstres

### 🧩 Optimisation : création de la classe `Element`

- `Element` regroupe `Entite` et `CaseEffet`
- Uniformisation des coordonnées (`int[] position`)

### 🧠 Fonctionnalité 2.5 : IA variable pour les monstres

- Interface `TypeDeplacement` → `seDeplacer(Entite, Labyrinthe)`
- Implémentations :
  - `DeplacementImmobile`
  - `DeplacementAleatoire`
  - `DeplacementManhattan` (va vers le joueur)

### ✅ Critères et Tests
- Plusieurs types de monstres présents
- Déplacement cohérent selon l’intelligence
- IA moyenne détecte le joueur mais ignore les murs

---

## 👻 Quatrième Itération – Fantômes & Amulette

### 👻 Fonctionnalité 3.2 : Fantôme

- Classe `Fantome extends Monstre`
- Peut traverser les murs, pas les entités
- Redéfinition de `peutTraverser(dir, laby)`

### 💎 Fonctionnalités 6.2 & 6.3 : Amulette

- Classe `Amulette extends Element`
- Attributs : `x`, `y`
- Ajout de `possedeAmulette` dans `Perso`
- `deplacer()` modifié pour prise de l’amulette

### ✅ Critères de validation
- L’amulette disparaît une fois prise
- Seul le héros peut la récupérer
- Affichage sous forme de cercle jaune

---

## 🏆 Cinquième Itération – Victoire du héros

### 🏁 Fonctionnalité 6.4 : Fin de partie

- Si `perso.aAmulette()` && retour à l’entrée ⇒ victoire
- Nouvelle méthode `victoire()` dans `LabyJeu`
- `LabyDessin` affiche un écran de victoire ou défaite selon état

### ✅ Tests réalisés
- Le jeu se termine avec l’amulette à l’entrée
- Le jeu continue si le héros revient sans l’amulette

---

## 🧪 Bilan des tests

- ✅ Tests unitaires pour les déplacements, collisions, effets, IA
- ✅ Scénarios de victoire et défaite
- ✅ Tests d’interaction entre entités et cases

---

## 📌 Conclusion

Ce projet a permis de découvrir :

- Le **développement itératif** avec une approche agile
- L’importance de **l’architecture orientée objet**
- La **gestion des entités, effets, IA, et logique de victoire**
- La **collaboration en équipe** et le versionnage Git

🔜 Possibilités futures : ajout d’un inventaire, de nouvelles IA, ou d’un rendu graphique plus avancé !

---
