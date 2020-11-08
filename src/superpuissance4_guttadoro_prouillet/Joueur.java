/* Guttadoro Rosanna Lorraine Prouillet
 * Classe Joueur 
 * Statut : finie et commentée
 */
package superpuissance4_guttadoro_prouillet;

/**
 *
 * @author lprouill
 */
public class Joueur { //Définition des attributs de joueur
    String Nom;
    String couleur;
    Jeton[] ListeJetons; //Ce joueur possèdera un certains nombre de jeton
    Jeton jetonJoueur;
    int nombreDesintegrateurs;
    int nombreJetons_restants;
    
    public Joueur ( String unNom ) { //Constructeur de joueur
        Nom = unNom;
        Jeton ListeJetons[]= new Jeton[21]; //Permets de stocker 21 Jetons
        nombreJetons_restants= 21; //Initialisé donc à 21 en début de partie
        nombreDesintegrateurs=0;
        
        //for (int i = 0; i<ListeJetons.length; i++) {
            //ListeJetons[i]= jetonJoueur ;
        //}
         
}
    public void affecterCouleur(String ValCouleur) {
        couleur=ValCouleur; //Valcouleur est saisie par l'utilisateur
        if (ValCouleur != "rouge"  && ValCouleur != "jaune") {
            System.out.println("Erreur couleur"); 
            //Vérification d'une couleur existante sinon erreur
        }
    }
    public boolean ajouterJeton(Jeton ValJeton) {
        if (nombreJetons_restants<21) {
           ListeJetons[nombreJetons_restants]= ValJeton; 
            //Le jeton choisi peut etre ajouté a la liste des jetons du joueur
            //On renvoie donc vrai et l'ajoute dans la liste à la place 
            //correspondant au nombre restant.
           System.out.println("Nombre de jetons égal à "+nombreJetons_restants);
           return true;
        }
        else {
           System.out.println("Erreur impossible d'ajouter un nouveau jeton");
           return false;
           //Si cela est impossible, on prévient le joueur
        }
        
    }
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs++; //Incrémente le nb de désintégrateurs du joueur
        
    }
    public boolean utiliserDesintegrateurs () {
        if (nombreDesintegrateurs>0) { //Si le joueur en possède il peut en utiliser un
            nombreDesintegrateurs--; //Son nombre est donc décrementé
            System.out.println("Désintégrateur bien utilisé, plus que "+ nombreDesintegrateurs+ " restants");
            return true; 
        }
        else {
            return false;
        }
        
        
    }
    
}
