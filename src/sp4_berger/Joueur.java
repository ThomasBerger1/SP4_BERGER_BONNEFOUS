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

    String Nom;
    String Couleur;
    ArrayList<Jeton> reserveJetons = new ArrayList<>();

    public Joueur(String unNom) {
        Nom = unNom;
    }

    public void affecterCouleur(String UneCouleur) {
        Couleur = UneCouleur;
    }

    public int getReserveJetons() {
        return reserveJetons.size();
    }

    public void ajouterJeton(Jeton UnJeton) {
        reserveJetons.add(UnJeton);
    }

    public Jeton jouerJeton() {
        Jeton jetonTampon;
        if (reserveJetons.size() > 0) {
            jetonTampon = reserveJetons.get(0);
            reserveJetons.remove(0);
            return jetonTampon;
        }
        return null;
    }
}