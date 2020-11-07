/*
 * Guttadoro Rosanna Lorraine Prouillet
 * Classe Partie
 * Statut : en cours
 */
package superpuissance4_guttadoro_prouillet;

import java.util.Random; // permet de générer le nombre aléatoire 

/**
 *
 * @author lprouill
 */
public class Partie {
    Joueur[] ListeJoueurs = new Joueur[2];
    Jeton[] ListeJetons = new Jeton[21];
    Joueur joueurCourant;
    
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
        
        
    }
    
    public void initialiserPartie() {
        
        
    }
}
