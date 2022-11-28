/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_berger;

/**
 *
 * @author berge
 */
public class SP4_BERGER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Joueur j1 = new Joueur("Thomas");
        Joueur j2 = new Joueur("Alizée");
        Partie partie = new Partie(j1,j2);
        partie.initialiserPartie();
        partie.lancerPartie();
        
    }
    
}
