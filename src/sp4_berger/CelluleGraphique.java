/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author berge
 */
public class CelluleGraphique extends JButton {

    CelluleDeGrille celluleAssociee;

    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_d = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jJ = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jR = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_tN = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public CelluleGraphique(CelluleDeGrille uneCell) {
        celluleAssociee = uneCell;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir()) {
            setIcon(img_tN);
        } else if (celluleAssociee.presenceDesintegrateur() && !celluleAssociee.presenceTrouNoir()) {
            setIcon(img_d);
        } else if (celluleAssociee.presenceJeton()) {
            String colorJ = celluleAssociee.lireCouleurDuJeton();
            if ("rouge".equals(colorJ)) {
                setIcon(img_jR);
            } else {
                setIcon(img_jJ);
            }
        } else {
            setIcon(img_vide); //On attribut l'image celluleVide.png
        }
    }

}
