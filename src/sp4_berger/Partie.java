/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

import java.util.Scanner;

/**
 *
 * @author berge
 */
public class Partie {
    private final Joueur[] listeJoueurs = new Joueur[2];
    private Joueur JoueurCourant;
    PlateauDeJeu Plateau = new PlateauDeJeu();

    public Partie(Joueur j1, Joueur j2) {
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        listeJoueurs[0].affecterCouleur("rouge");
        listeJoueurs[1].affecterCouleur("jaune");
    }  
    
    public void creerEtAffecterJeton(Joueur j){
        for (int i = 0; i < 30; i++){
            Jeton jet = new Jeton(j.Couleur);
            j.ajouterJeton(jet);
        }
    }
    
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        Plateau.afficherGrilleSurConsole();
    }
    
    public int choix(){
        int c = 0; 
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println(""" 
                           Que voulez faire ? : 
                           1 -> Jouer un jeton
                           2 -> Récupérer un jeton
                           """);  
        
        while(c<1 | c>2){ 
            
            c = sc.nextInt(); 
        }
        
        return c;
        }
    
    public void lancerPartie(){
        int nbrCoup = 0;
        int choice;
        
        while(true){
            if (nbrCoup % 2 == 0){
                JoueurCourant = listeJoueurs[0];
            }else{
                JoueurCourant = listeJoueurs[1];
            }
            System.out.println("C'est a " + JoueurCourant.Nom + " de jouer");
            
            choice = choix();
            switch(choice){
                case 1 :
                    JoueurCourant.jouerJeton();
                    break;
                /*case 2 :
                    recupJeton();
                    break;
                    */
            }
            
            Plateau.afficherGrilleSurConsole();
            nbrCoup ++;
            
            if (Plateau.etreGagnantePourCouleur(listeJoueurs[0].Couleur)){
                System.out.println("Le joueur "+listeJoueurs[0]+" a gagné !!!");
                break;
            }
            
            if (Plateau.etreGagnantePourCouleur(listeJoueurs[1].Couleur)){
                System.out.println("Le joueur "+listeJoueurs[1]+" a gagné !!!");
                break;
            }
            
            if(Plateau.grilleRemplie()){
                System.out.println("La grille est remplie.");
                break;
            }
        }
        
        System.out.println("--Partie terminée--");
    }
    
    public int asknbr(String qst){
        Scanner sc = new Scanner(System.in);
        System.out.println(qst);
        int rep = sc.nextInt();
        return rep;
    }
    
    /**public void recupererjeton(){
        int x = -1;
        int y = -1;
        
        do{
            x = asknbr("Ligne : ");
            y = asknbr("Colonne : ");}
        while(Plateau.recupererjeton(x, y) == null);
        
        Jeton jet = Plateau.(x, y);
        JoueurCourant.ajouterJeton(jet);
    }
    */
}
