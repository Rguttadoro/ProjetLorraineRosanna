/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance4_guttadoro_prouillet;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Lorraine
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trou = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique ( Cellule uneCellule ) {
        celluleAssociee = uneCellule;
        
        
    }
    
    @Override // permet de dessiner la cellule graphique 
    public void paintComponent(Graphics G ) {
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir()==true) {
            setIcon(img_trou); // SI il y a un trou noir, on lui attribue la bonne image
        }
        else if (celluleAssociee.presenceDesintegrateur()==true) {
            setIcon(img_desint); //De meme pour le désintégrateur
            
        }
        else {
            String couleurAssociee = celluleAssociee.lireCouleurDuJeton() ;
            if (couleurAssociee == "rouge") { 
                setIcon(img_rouge);
            } 
            else if (couleurAssociee == "jaune"){
                setIcon(img_jaune);
            }
            else {
                setIcon(img_vide); 
            }
        }
        
    }
    
}
