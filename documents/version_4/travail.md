# Troisième itération :

<aside>

**Conception :** Logan, Alexis, Martin

**Implémentation :** Yanis, Jassem

**Séquence :** Alexis

**Classe :** Martin

**Tests :** Logan 

</aside>

diagramme de classe :

![DiagrammeIntelliJ](attachment:DiagrammeIntelliJ.png)

DiagrammeIntelliJ

![DiagrammeClasse](attachment:DiagrammeClasse.png)

DiagrammeClasse

[Code](https://www.notion.so/Code-20767c381a9b80639018ed8d918568e1?pvs=21)

Dans un premier temps, nous avons rassembler les entités ainsi que les cases à effets à l’aide de la classe Element car ces deux éléments sont similaires ils ont toutes les deux les attributs x et y et la méthode getColor. Puis, l’ajout d’un élément sera maintenant bien plus rapide et bien plus efficace et la gestion des éléments sera plus simple. 

Ensuite, nous avons modifié la façon dont les coordonnées sont renvoyées dans quelques classes. Maintenant, c’est un tableau d’entier, auparavant, il y avait un getter pour la coordonnée x ainsi que pour la coordonnée y. Nous avons fait cela pour faciliter et uniformiser notre travail car certaine classes utilisaient une méthode et puis certaines utilisaient l’autre. 

Enfin, pour implémenter les déplacement, nous avons créée une interface “TypeDeplacement” qui sera implémenter par tous les types de déplacements afin d’en ajouter autant que l’on veut. Il suffira de redéfinir la méthode “seDeplacer” de chaque classe qui implémente l’interface.

***diagramme de séquence de seDeplacer :***

![DiagrammeSequence](attachment:DiagrammeSequence.png)

DiagrammeSequence

[Code](https://www.notion.so/Code-20767c381a9b80ef92d1c73d3fa493e8?pvs=21)

Pour comprendre comment marche le déplacement d’un monstre, il faut ce rendre dans la boucle du jeu qui ce trouve dans LabyJeu dans la méthode update( ) qui vérifie et modifie les variables comme le joueur et les monstres pour chaque frames.

Pour cela, le main créer labyjeu pour ensuite le launch( ) qui lance la boucle de jeu dans MoteurJeu. Ainsi dans la boucle, il va récupérer chaque Entité de la liste, ici seul le monstre s’y trouve. Pour ensuite exécuter chaque Type de déplacement pour chaque Entités dans la liste sans savoir quelle vas être ce type car c’est l’appel à l’Entité qui vas ensuite déterminé vers quelle méthode de déplacement se dirigé. Ici le type de déplacement du Monstre est deplacerAleatoire donc il vas éxecuter la méthode seDeplacer( ) de la classe deplacerAleatoire.

Screen :

![screen/screen1](attachment:screen/screen1.png)

screen/screen1

Il y a trois Monstre avec des intelligence différente, c’est a dire qu’il utilise des méthode de déplacement différente. le monstre en haut à gauche à une intelligence nulle donc il reste immobile, celui en bas à gauche à une intelligence faible donc il bouge aléatoirement entre les 4 directions et enfin le monstre au centre à une intelligence moyens donc il se dirige vers le Perso sans prendre en compte les murs.

![screen/screen2](attachment:screen/screen2.png)

screen/screen2

Après quelque frames les monstres ont bougé et respect leurs intelligence, le monstre nulle reste immobile, le monstre faible à bouger sans prendre rien en compte complétement aléatoirement et le monstre moyens est allé vers le joueur.

![screen/screen3](attachment:screen/screen3.png)

screen/screen3

Si le joueur ce place derrière un mur, le monstre moyens reste bloquer sans bouger, ou plutôt en essayer de bouger dans un mur.

## Optimisation :  Création de la classe `Element`

Elle va être extend par les classes `Entitées` et `Case` 

## Fonctionnalité 2.5 Monstres avec intelligence variable :

### **Classes à créer :**

Interface `TypeDeplacement`possédant `seDeplacer(Entite, Laby)`

Une classe par type de déplacement (ex :`DeplacementManhattan`) 

### Classe Monstre—————————

**Attributs à créer** : 

- Attribut `TypeDeplacement typeDeplacement`

### *<Interface>*  TypeDeplacement—————————

**Méthodes à créer :**

- seDeplacer(Monstre m, )

**Méthodes à modifier :**

Renommer `deplacerEntite` ⇒ `deplacerManuel` dans `Labyrinthe`

<aside>

`DeplacerImmobile` 

`DeplacerAleatoire` 

`DeplacerManhattan` 

</aside>

### Classe Labyrinthe—————————

Méthodes `boolean estTraversable(x,y)` 

<aside>

**Critères de validation :**
• Un monstre d'intelligence nulle reste immobile.
• Un monstre d'intelligence faible se déplace au hasard.
• Un monstre d'intelligence moyenne cherche à se rapprocher du héros sans prendre
en compte les obstacles.
• Plusieurs monstres avec des intelligences différentes peuvent être présents dans le
même labyrinthe.
• Chaque type de monstre (Orc, Fantome, Troll) peut avoir n'importe quel type
d'intelligence. On peut avoir dans le même labyrinthe des Orc d'intelligence nulle,
faible, moyenne et forte. Idem pour les trolls et les fantômes.

</aside>

**Tests à réaliser :**

`Des monstres avec une intelligence différente sont présents en même temps`    

`Les monstres d'intelligence moyenne construisent un chemin contenant les pièges`

`Les monstres d'intelligence élevée construisent un chemin sans pièges`
