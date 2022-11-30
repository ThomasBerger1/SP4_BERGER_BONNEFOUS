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
public class Joueur { //Classe Joueur, possède un nom, une couleur, une réserve de jetons (30 de base) et un nombre de désintégrateurs, nul de base

    private final String Nom;
    private String Couleur;
    private final ArrayList<Jeton> reserveJetons = new ArrayList<>();
    private int nombreDesintegrateur = 0;
    
    public Joueur(String unNom) { //Constructeur
        Nom = unNom;
    }

    public String lireCouleur() { //On renvoie la couleur
        return Couleur;
    }

    public String getNom() { //On renvoie le nom du joueur
        return Nom;
    }

    public void affecterCouleur(String UneCouleur) { //Permet de changer la couleur associé au joueur
        Couleur = UneCouleur;
    }

    public int nombreDeJetons() { //Renvoie le nombre de jetons restants du joueur 
        return reserveJetons.size();
    }

    public void ajouterJeton(Jeton UnJeton) { //Permet d'ajouter un jeton entré en paramètre dans la réserve du joueur
        reserveJetons.add(UnJeton);
    }
    
    public void obtenirDesintegrateur(){ //Incrémente le nombre de désintégrateur du joueur
        nombreDesintegrateur ++;
    }

    public int getNombreDesintegrateur() { //Retourne le nombre de D du joueur
        return nombreDesintegrateur;
    }
    
    public void utiliserDesintegrateur(){ //Utilisation d'un D, donc on en enlève 1 de sa possession
        if (nombreDesintegrateur > 0){           
            nombreDesintegrateur --;
        }
    }

    public Jeton jouerJeton() { //Méthode qui permet de renvoyer un jeton de la reserve, si il y a des jetons restants.
        Jeton jetonTampon;
        if (!reserveJetons.isEmpty()) {
            jetonTampon = reserveJetons.get(0);
            reserveJetons.remove(0);
            return jetonTampon;
        }
        return null;
    }
}