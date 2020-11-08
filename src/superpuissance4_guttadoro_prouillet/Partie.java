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
    Jeton jetonCourant;
    
    
      
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
        // grace a cette boucle, le boolean ( qui n'a que 2 possibilités ) aléatoire permet de distribuer les couleurs de façon aléatoire aux joueurs 
        // ( comme il y a que deux joueurs et deux couleurs ) 
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
        
        initialiserPartie();
        
        //Afficher le menu de jeu tant que la partie n'est pas finie
        
        // on détermine qui sera le premier joueur de la meme facon que pour attribuer les couleurs
        Random random = new Random();
        boolean premier_joueur = random.nextBoolean();
        if ( premier_joueur==true ) {
            joueurCourant=ListeJoueurs[0];
        } else {
            joueurCourant = ListeJoueurs[1];
        }
        
        
        // on donne des jetons aux joueurs
        Jeton Jeton1 = new Jeton(Joueur1.couleur);
        Jeton Jeton2 = new Jeton(Joueur2.couleur);
        
        for ( int i=0 ; i<21 ; i++ ){
            Joueur1.ajouterJeton(Jeton1);
            Joueur2.ajouterJeton(Jeton2);
        }
        
        do { // demande au joueur de choisir ce qu'il veut faire
            Scanner scs = new Scanner(System.in);
            System.out.print("Que voulez vous faire ?\\n"+"1) Jouer un jeton\\n"+"2) choix non disponbile \\n"+"3) choix non dispobible");
            int choix = scs.nextInt();
            if  ( choix != 1 ) {
                System.out.println("saisissez un choix valide");
                choix = scs.nextInt();
            } else {
                
                Scanner sca = new Scanner(System.in);
                boolean resultAct;
                System.out.println("Veuillez choisir une colonne ");
                int colonne = sca.nextInt() -1; // on met le -1 car le chiffre de la colone ne correspond pas à l'indice puisque le tableau est initialisé à 0
                while ( colonne > 6 && colonne<1) {
                    System.out.println(" veuillez saisir une colonne valide ");
                    colonne = sca.nextInt()-1;
                }
                resultAct= grillePartie.ajouterJetondansColonne(jetonCourant , colonne );
                while resultAct
            }
            
            
        } while ( grillePartie.etreGagnantePourJoueur(joueurCourant) != true ); // tant que aucun joueur n'a gagné la partie on affiche le menu
        
     
    }
    
    public void initialiserPartie() {
        //initialisation de la grille
        
        // nous avions vu que dans la classe grille, pour chaque nouvelle partie il fallait vider la grille :
        grillePartie.viderGrille();
        
        //composé la grille avec des désintégrateurs et trou noir placé aléatoirement
        int [] positionsTrounoir = new int[4];
        for (int i = 0; i<positionsTrounoir.length; i++) {
            //génére un tableau de 4 entiers aléatoire
            Random a = new Random();
            positionsTrounoir[i] = a.nextInt(6);
            //System.out.print(positionsTrounoir[i]); 
            }
        
        for (int j = 0; j<2; j++) { //crée 3 différents Trous noirs
            grillePartie.placerTrouNoir(positionsTrounoir[j],positionsTrounoir[j+1]);
            
        } 
        int [] positionsDesing = new int[4];
        for (int i = 0; i<positionsDesing.length; i++) {
            //génére un tableau de 4 entiers aléatoire
            Random a = new Random();
            positionsDesing[i] = a.nextInt(6);
            //System.out.print(positionsDesing[i]); 
            }
        
        for (int j = 0; j<2; j++) { //crée 3 différents désintégrateurs sur la grille
            grillePartie.placerDesintegrateur(positionsDesing[j],positionsDesing[j+1]);
            
        } 
        grillePartie.afficherGrilleSurConsole();
        //Affiche la grille de jeu prête pour le début de la partie.
        
        
    }
    
    public Joueur JoueurSuivant ( Joueur leJoueur ) {
        if ( ListeJoueurs[1]==joueurCourant ){
            return ListeJoueurs[0];
            
        }else {
           return ListeJoueurs[1];
        }    
    }
    
}
