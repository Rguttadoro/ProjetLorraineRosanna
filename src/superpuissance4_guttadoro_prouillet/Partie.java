/*
 * Guttadoro Rosanna Lorraine Prouillet
 * Classe Partie
 * Statut : en cours
 */
package superpuissance4_guttadoro_prouillet;

import java.util.Random; // permet de générer le nombre aléatoire 
import java.util.Scanner; // permet a l'utilisateur de saisir qqch

/**
 *
 * @author lprouill
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[2];
    Jeton[] ListeJetons = new Jeton[21];
    Joueur joueurCourant;
    Grille grillePartie = new Grille(); //on initialise la grille de jeu 
    
    
  
    
    public void  attribuerCouleursAuxJoueurs ( ) {
        // l'atribution de la couleur se fait de manière aléatoire 
        Random rand = new Random(); // on créé une variable aléatoire 
        boolean couleur; // on créé la variable couleur 
        couleur = rand.nextBoolean(); // la variable couleur est donc un boolean aléatoire ( on ne sait pas vrai ou faux ) 
        if ( couleur == true ) {
            ListeJoueurs[0].couleur="jaune"; //on utilise ce qu'on a créé dans la classe Jeton
            ListeJoueurs[1].couleur="rouge"; 
            
        } else {
            ListeJoueurs[0].couleur="rouge";
            ListeJoueurs[1].couleur="jaune";
        }
        // grace a cette boucle, le boolean ( qui n'a que 2 possibilités ) aléatoire permet de distribuer les couleurs de façon aléatoire aux joueurs ( comme il y a que deux joueurs et deux couleurs ) 
    }
    
    public void debuterPartie () {
          
        // il faut créer les 2 joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Pseudo Joueur1 : ");
        Joueur Joueur1 = new  Joueur(sc.nextLine()); // on initialise les joeurs en récupérant ce que l'utilisateur a saisi 
        ListeJoueurs[0]= Joueur1;
        System.out.println("Pseudo Joueur2 : ");
        Joueur Joueur2 = new  Joueur(sc.nextLine());
        ListeJoueurs[1]= Joueur2;
        
        attribuerCouleursAuxJoueurs(); //on appelle la méthode créé précédemment, les joueurs ont maintenant une couleur d'attribuée
        
        // on l'affiche pour permettre aux joueurs de connaitre leur couleur 
        
        System.out.println(Joueur1.Nom +" a la couleur "+Joueur1.couleur);
        System.out.println(Joueur2.Nom +" a la couleur "+Joueur2.couleur);
        
        
        
        // nous avions vu que dans la classe grille, pour chaque nouvelle partie il fallait vider la grille :
        grillePartie.viderGrille();
        
        
        
        
        
    }
    
    public void initialiserPartie() {
        
        
    }
}
