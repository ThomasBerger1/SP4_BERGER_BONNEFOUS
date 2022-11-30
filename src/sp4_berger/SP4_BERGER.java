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
        
        Joueur j1 = new Joueur("Thomas"); //On crée deux joueurs qui jouent au puissance 4
        Joueur j2 = new Joueur("Alizee");
        Partie partie = new Partie(j1,j2); //On crée la partie
        partie.initialiserPartie();//ON l'intialise
        partie.lancerPartie();//On la lance !
        
    }
    
}
