/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

import java.util.ArrayList;

/**
 *
 * @author alizeebonnefous
 */
public class Joueur {

    private final String Nom;
    private String Couleur;
    private final ArrayList<Jeton> reserveJetons = new ArrayList<>();
    private int nombreDesintegrateur = 0;
    
    public Joueur(String unNom) {
        Nom = unNom;
    }

    public String getCouleur() {
        return Couleur;
    }

    public String getNom() {
        return Nom;
    }

    public void affecterCouleur(String UneCouleur) {
        Couleur = UneCouleur;
    }

    public int nombreDeJetons() {
        return reserveJetons.size();
    }

    public void ajouterJeton(Jeton UnJeton) {
        reserveJetons.add(UnJeton);
    }
    
    public void obtenirDesintegrateur(){
        nombreDesintegrateur ++;
    }
    
    public void utiliserDesintegrateur(){
        if (nombreDesintegrateur > 0){           
            nombreDesintegrateur --;
        }
    }

    public Jeton jouerJeton() {
        Jeton jetonTampon;
        if (!reserveJetons.isEmpty()) {
            jetonTampon = reserveJetons.get(0);
            reserveJetons.remove(0);
            return jetonTampon;
        }
        return null;
    }
}