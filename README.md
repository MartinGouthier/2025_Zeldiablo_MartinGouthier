# 2025_Zeldiablo_MartinGouthier

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

Lancer le jeu :
java -cp src main.Main
💡 Le jeu s’exécute dans une interface texte (console) et nécessite des interactions clavier.

🎮 Points forts du gameplay
  🧍 Déplacez votre héros dans le donjon
  🐍 Affrontez ou évitez les monstres
  🧠 Les ennemis vous poursuivent grâce à une IA simple
  🗝️ Trouvez la clé pour atteindre la sortie


