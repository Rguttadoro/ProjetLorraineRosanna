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
    
    public CelluleGraphique ( Cellule uneCellule ) {
        celluleAssociee = uneCellule;
        
        
    }
    
    @Override // permet de dessiner la cellule graphique 
    public void paintComponent(Graphics G ) {
        super.paintComponent(G);
        setIcon(img_vide); // on attribue l'image celluleVide.png
    }
    
}
