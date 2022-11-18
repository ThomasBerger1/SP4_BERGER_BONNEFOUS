/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

/**
 *
 * @author berge
 */
public class Jeton {
    private final String couleur;

    public Jeton(String color) {
        couleur = color;
    }

    public String lireCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        if (couleur.equals("rouge")){
            return "R";
        }else if (couleur.equals("jaune")){
            return "J";
        }
        return null;
    }
}
