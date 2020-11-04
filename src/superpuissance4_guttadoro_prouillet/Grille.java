/*
 * Guttadoro Rosanna Lorraine Prouillet
 * Classe Cellule
 * Statut : en cours et commentée
 */
package superpuissance4_guttadoro_prouillet;

/**
 * @author lprouill
 */
public class Grille {
    Cellule[][] Cellules = new Cellule[6][7]; //La grille de jeu est un tableau de 42 cellules
    
    // ajout constructeur 
    public Grille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cellules[i][j] = new Cellule();
            }
        }
    }
    
    public boolean ajouterJetondansColonne ( Jeton Valjeton , int C ) {
        // C désigne la colonne choisie par le joueur 
        boolean pleine = true; // Initialise la valeur pleine qui correspond 
        // au fait que la case ou arrive le jeton est pleine ou non
        for ( int i =0 ; i<=5 ; i++ ) { 
            // On parcours la colonne d'en haut jusqu'en bas
            if ( Cellules[i][C-1].jetonCourant==null) {
                //Si cette première cellule est vide, on lui affecte le jeton joué
                Cellules[i][C-1].affecterJeton(Valjeton); 
                return true; //L'action a était faite on renvoie vraie et on sort de la boucle
            } else {
                pleine= false; //Si cette cellule n'était pas vide, on reste dans la boucle for et décréménte i
            } //Renverra faux à la fin si la colonne est entièrement pleine
        }
        return pleine; 
        
    }
    
    public boolean etreRemplie () {
        
        boolean remplie = true;
        //Création d'un booleen véirifiant si la grille est totalement remplie ou non
        for ( int i=0 ; i <=5 ; i++ ) {
            //On parcours donc la grille dans son intégralité
            for ( int j=0 ; j<=6 ; j++ ) { 
                if ( Cellules[i][j] == null) {
                    return false; // Si on tombe sur une seule case vide
                    //On sort de la boucle est renvoie faux, elle n'est pas remplie
                } else { 
                    remplie = true ; 
                }   //Tant qu'on croise aucune cellules vide, on continue d'incrémenter
                        //A la fin si remplie doit renvoyer vrai.         
            }       
        }
        return remplie;
    }
    
    public void viderGrille ( ) {
        //Pour une nouvelle partie on souhaite vider la grille
        for ( int i=0 ; i <=5 ; i++ ) {
            //On parcours encore une fois toute la grille
            for ( int j=0 ; j<=6 ; j++ ) {
                //Pour chaque cellule on supprime : un quelquonque jeton, trou, desintegrateur
                Cellules[i][j].jetonCourant = null;
                Cellules[i][j].desintegrateur = false;
                Cellules[i][j].trouNoir = false;
                                       
            }
                       
        }       
    }
    
    
    public void  afficherGrilleSurConsole ( ) {
        //Affichage des colonnes en haut de la matrice
        System.out.println("1 2 3 4 5 6 7");
        // Pour l'affichage on parcours le tableau dans le sens inverse des lignes
        for ( int i=5 ; i>= 0 ; i--) {
            //En commencant par la ligne 5, puis 4 ect...
            for ( int j=0 ; j<=6 ; j++ ) {
               
                if  ( Cellules[i][j].jetonCourant == null ) {
                    System.out.print("V ");
                    //V corresponds à  case vide
                } else if ( Cellules[i][j].trouNoir) {
                    System.out.print("T ");
                    // T corresponds à un trou noir
                }else if ( Cellules[i][j].desintegrateur) {
                    System.out.print("D ");
                    // D corresponds a un désintégrateur
                } else {
                    
                    if (Cellules[i][j].jetonCourant.lireCouleur() == "rouge") {
                        System.out.print("R " );      
                    }
                    if (Cellules[i][j].jetonCourant.lireCouleur() == "jaune") {
                        System.out.print("J " );
                    }
                    
                 
                  // Si c'est aucune des précédentes cases, c'est donc forcément un jeton
                  // jetonCourant est de type jeton et un jeton a pour attribut une couleur
                } //(On lit sa couleur est affiche R ou J en fonction)
                if (j==6) {
                      System.out.print("\n");
                }
            }
        }
}

    public boolean celluleOccupee ( int y , int x  ) { //y pour le numéro de la colonne et x numéro de  la ligne
        if ( Cellules[y][x] == null ) { //on vérifie sur la cellule de coordonnées passés en paramètres est nulle ( sans jetons)
            return false;
        } else {
            return true;
        }

    }  

    public String lireCouleurDuJeton (int y ,int x ) { //même principe que pour la méthode du dessus avec les coordonnées    
        String couleur = Cellules[y][x].jetonCourant.lireCouleur(); 
        return couleur;

    }
    
    public boolean etreGagnantePourJoueur(Joueur unJoueur) {
        boolean gagnante= false ; //Initialise gagnante comme faux
        String couleurJoueur = unJoueur.couleur;
        //Analyse d'une colonne:
        for (int i = 0; i<=6 ; i++) { //On s'intéresse à chaques lignes
            int sommepions=0; //Mais on remets la somme des pions à 0 entre chaque colonnes étudiées
            for (int j= 0; j<=5; i++) { //On regarde chaque case de la colonne
                if (Cellules[j][i].lireCouleurDuJeton() == couleurJoueur) {
                    sommepions++; //Des qu'une case a la bonne couleur on incrémente
                } else {
                    sommepions=0; //Sinon la somme est remise à 0
                }
                if (sommepions==4) { //Une fois que la somme atteint 4 la partie est gagnée
                    gagnante = true;
                    //System.out.println("Gagné"); Test vérifiant le fonctionnement
                    return gagnante;
                }
            }
        } //Analyse des lignes :
        for (int i = 0; i<=5 ; i++) { //On étudie chaque ligne
            int sommepions=0;
            for (int j= 0; j<=6; i++) { // Et donc on décale d'une colonne a chaque fois
                if (Cellules[i][j].lireCouleurDuJeton()== couleurJoueur) {
                    sommepions++;//Meme principe que précédemment
                } else {
                    sommepions=0;
                }
                if (sommepions==4) {
                    gagnante = true;
                    return gagnante;
                }
            }
        }
        //Analyse des diagonales:
    return true;
    }

    
    public boolean colonneRemplie() {
        boolean remplie = false ;
        for (int i =0; i<=5;i++ ) {
            if (Cellules[i] == null) {
               
                return false;
            } else {
                remplie=true;
                return remplie;
            }
        } return true;
    }
}

