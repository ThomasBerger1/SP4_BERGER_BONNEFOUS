/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

/**
 *
 * @author berge
 */
public class Jeton { //Classe Jeton
    private final String couleur; //Attibut principal couleur 

    public Jeton(String color) {
        couleur = color;
    }

    public String lireCouleur() { //On renvoie la couleur associé au jeton
        return couleur;
    }

    @Override //Methode override pour l'affichage lors d'un print
    public String toString() {
        if (couleur.equals("rouge")){
            return "R";
        }else if (couleur.equals("jaune")){
            return "J";
        }
        return null;
    }
}
