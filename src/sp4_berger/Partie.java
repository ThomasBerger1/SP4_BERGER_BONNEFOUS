 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author berge
 */
public class Partie {
    private final Joueur[] listeJoueurs = new Joueur[2];
    private Joueur JoueurCourant;
    private Joueur jAd; //Joueur adverse // Utilisée pour savoir qui gagne, test sur jAd avant le joueurCourant
    PlateauDeJeu Plateau = new PlateauDeJeu();

    public Partie(Joueur j1, Joueur j2) {
        listeJoueurs[0] = j1;
        listeJoueurs[1] = j2;
    }
    
    public void attribuerCouleurAuxJoueurs(){
        Random r =new Random();
        boolean couleur;
        couleur = r.nextBoolean();
        if(couleur){
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        }else{
        listeJoueurs[1].affecterCouleur("rouge");
        listeJoueurs[0].affecterCouleur("jaune");
        }
    }  
    
    public void creerEtAffecterJeton(Joueur j){
        for (int i = 0; i < 30; i++){
            Jeton jet = new Jeton(j.lireCouleur());
            j.ajouterJeton(jet);
        }
    }
    
    public void placerTrousNoirsEtDesintegrateur(){
        int cTr = 0;
        int cD = 0;
        int lgn;
        int col;
        Random rand = new Random();
        
        while(cTr < 3){
            lgn = rand.nextInt(5);
            col = rand.nextInt(6);
            if (!Plateau.presenceTrouNoir(lgn, col)){
                Plateau.placerTrouNoir(lgn, col);
                Plateau.placerDesintegrateur(lgn, col);
                cTr ++;
                cD ++;
            }
        }
        
        while(cTr < 5){
            lgn = rand.nextInt(5);
            col = rand.nextInt(6);
            if (!Plateau.presenceTrouNoir(lgn, col)){
                Plateau.placerTrouNoir(lgn, col);
                cTr ++;
            }
        }
        
        while(cD < 5){
            lgn = rand.nextInt(5);
            col = rand.nextInt(6);
            if (!Plateau.presenceTrouNoir(lgn, col) && !Plateau.presenceDesintegrateur(lgn, col)){
                Plateau.placerDesintegrateur(lgn, col);
                cD ++;
            }
        }
        
    }
    
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateur();
        Plateau.afficherGrilleSurConsole();
    }
    
    public int choixD(){
        int c = 0; 
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println(""" 
                           Que voulez faire ? : 
                           1 -> Jouer un jeton
                           2 -> Recuperer un jeton
                           3 -> Jouer un desintegrateur
                           """);  
        
        while(c<1 | c>3){ 
            
            c = sc.nextInt(); 
        }
        
        return c;
        }
    
    public int choixSD(){
        int c = 0; 
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println(""" 
                           Que voulez faire ? : 
                           1 -> Jouer un jeton
                           2 -> Recuperer un jeton
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
            
            System.out.println("C'est a " + JoueurCourant.getNom() + " de jouer");
            
            if (JoueurCourant.getNombreDesintegrateur() > 0){
                choice = choixD();
            }else{
                choice = choixSD();
            }
            
            switch(choice){
                case 1 :
                    jouerJeton();
                    break;
                case 2 :
                    recupererJeton();
                    break;
                case 3 :
                    jouerDesintegrateur();
                    break;
            }
            
            Plateau.afficherGrilleSurConsole();
            nbrCoup ++;
            
            if (Plateau.etreGagnantePourCouleur(jAd.lireCouleur())){
                System.out.println("Le joueur "+jAd.getNom()+" a gagne !!!");
                break;
            }
            
            if (Plateau.etreGagnantePourCouleur(JoueurCourant.lireCouleur())){
                System.out.println("Le joueur "+JoueurCourant.getNom()+" a gagne !!!");
                break;
            }
            
            if(Plateau.grilleRemplie()){
                System.out.println("La grille est remplie.");
                break;
            }
        }
        
        System.out.println("--Partie terminee--");
    }
    
    public int asknbr(String qst){
        Scanner sc = new Scanner(System.in);
        System.out.println(qst);
        int rep = sc.nextInt();
        return rep;
    }
    
    public void jouerJeton(){
        
        int colonne = -1;
        int lignejeton;
        if(JoueurCourant.nombreDeJetons() > 0){ 

            while(colonne < 0 | colonne > 6){
                colonne = asknbr("Colonne du jeton : (De 1 a 7)") - 1;
            }

            if (!Plateau.colonneremplie(colonne)){

                lignejeton = Plateau.ajouterJetonDansColonne(JoueurCourant.jouerJeton(), colonne);
                
                if (Plateau.presenceTrouNoir(lignejeton, colonne)){
                    Plateau.supprimerJeton(lignejeton, colonne);
                    Plateau.supprimerTrouNoir(lignejeton, colonne);
                    System.out.println("Le jeton joue a ete absorbe par un trou noir !");
                }
                
                if (Plateau.presenceDesintegrateur(lignejeton, colonne)){
                    JoueurCourant.obtenirDesintegrateur();
                    Plateau.supprimerDesintegrateur(lignejeton, colonne);
                    System.out.println(JoueurCourant.getNom()+" a recupere un desintegrateur");
                }
            }
            
        }
    }
    
    public void recupererJeton(){
        int x;
        int y;
        
        x = asknbr("Ligne du jeton a recuperer: (De 1 a 6)") - 1;
        y = asknbr("Colonne du jeton a recuperer: (De 1 a 7)") - 1;
        
        if (!Plateau.lireCouleurDuJeton(x, y).equals(JoueurCourant.lireCouleur()) || !Plateau.presenceJeton(x, y)){
            System.out.println("Erreur, faute de jeu, il n'y a pas un de vos jetons ici! TOUR ANNULE.");
        }else{
            Jeton je = Plateau.recupererJeton(x, y);
            JoueurCourant.ajouterJeton(je);
            System.out.println(JoueurCourant.getNom()+" a recupere son jeton!");
            Plateau.tasserColonne(y);           
        }
        
    }
    
    public void jouerDesintegrateur(){
        int x;
        int y;
        
        x = asknbr("Ligne du jeton a desintegrer : (De 1 a 6)") - 1;
        y = asknbr("Colonne du jeton a desintegrer: (De 1 a 7)") - 1;
        
        if (Plateau.lireCouleurDuJeton(x, y).equals(JoueurCourant.lireCouleur()) || !Plateau.presenceJeton(x, y)){
            System.out.println("Erreur, faute de jeu, on ne peut desintegrer que des jetons adverses! TOUR ANNULE.");
        }else{
            Plateau.supprimerJeton(x, y);
            JoueurCourant.utiliserDesintegrateur();
            Plateau.tasserColonne(y);
        }
    }
}
