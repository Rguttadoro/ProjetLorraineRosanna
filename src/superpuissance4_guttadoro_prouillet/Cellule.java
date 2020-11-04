/*
 * Guttadoro Rosanna Lorraine Prouillet 04/11/2020
 * Classe Cellule
 * Statut : finie et commentée
 */
package superpuissance4_guttadoro_prouillet;

/**
 *
 * @author lprouill
 */
public class Cellule { //Attributs de la classe cellule
    Jeton jetonCourant; //case qui ontient ou non un jeton
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule () { //Constructeur et initialisation de la cellule
        jetonCourant=null; //Vide, sans trou noir ni désintégrateur
        trouNoir = false;
        desintegrateur = false;
        
    }
    
    public boolean affecterJeton(Jeton ValJeton) { //Valjeton est un Jeton possèdant une couleur
        if ( jetonCourant==null) { //Si aucun jeton n'est présent dans la case courante
            jetonCourant= ValJeton; //On y affecte le jeton jouée
            return true; // Et retourne vraie, la case a été remplie
        } else {
            return false; //Ou faux, elle était pleine
        }
        
    }
    
    public Jeton recupererJeton() {
        return jetonCourant; //Accéder au jeton
        
    }
    
    public boolean supprimerjeton () {
        if ( jetonCourant != null ) { //Si cette case est bien occupée par un jeton
            jetonCourant=null; // On la rends vide et retourne vrai
            return true;
        } else {
            System.out.println(" pas de jeton présent "); 
            // Si elle etait vide, aucune action, renvoie faux
            return false;
        }
    }
    
    public boolean placerTrouNoir () {
        if ( trouNoir == false ) { //Vérifie qu'il n'y a pas deja un trou noir
            trouNoir=true; //Place ce trou noir en rendant le booleen vrai
            return true; // Renvoie vraie, il a était placé
            
        } else {
            return false;  //Si c'est impossible renvoie faux, pas placé
        }
    }
    
    public boolean placerDesintegrateur() { //Meme fonctionnement que le trou noir
        if ( desintegrateur == false ) {
            desintegrateur=true;
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean presenceTrouNoir () { //Sert à verifier la présence d'un trou noir sur la cellule en question
        if ( trouNoir == true ) { // Si trou noir est vrai, il est présent
            return true; // Méthode renvoie vrai
            
        }else {
            return false;
        }           
    }
    
     public boolean presencDesintegrateur () { //Meme fonctionnement
        if ( desintegrateur == true ) {
            return true;
            
        }else {
            return false;
        }           
    }
     
    public String lireCouleurDuJeton () { //Appel de la méthode définie dans jeton
        return jetonCourant.lireCouleur(); 
        //On obtient la couleur du jeton courant utilisé

    }
    
    
    public boolean recupererDesintegrateur () {
        //On tombe sur un désintégrateur et désire le récupérer
        if ( desintegrateur == true ) { //S'il y en a un sur la case, booléen vrai
            desintegrateur=false;  //On l'enlève et le booléen devient faux
            return true; // Renvoie vrai, il a bien était retiré
        } else {
            return false; //Aucun désintégrateur, renvoie faux.
        }
    }
    
    public boolean activerTrouNoir () { //Activer le trou noir d'une case
        if ( trouNoir == true ) { // Si il y a bien un trou noir sur la case
            jetonCourant= null; // Le jeton disparait , la case est vide
            trouNoir=false; // Le trou noir disparait aussi
            return true; // L'activation a fonctionné, renvoie vrai
        } else {
            return false; //Pas d'activation du trou noir, renvoie faux
        }
        
    }
}
