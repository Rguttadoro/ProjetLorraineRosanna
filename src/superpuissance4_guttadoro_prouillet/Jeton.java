/*
 * Guttadoro Rosanna Lorraine Prouillet
 * Classe Jeton 
 * Statut : finie et commentée
 */
package superpuissance4_guttadoro_prouillet;

/**
 *
 * @author lprouill
 */
public class Jeton { //Attributs du jeton
    String couleur;
    
    public Jeton( String uneCouleur ) { //Constructeur
        couleur = uneCouleur;
    }
    
    public String  lireCouleur ( ) { //Obtenir la couleur du jeton en jeu
        //System.out.println ( " Le jeton est de couleur "+couleur );
        return couleur;
    }
}
