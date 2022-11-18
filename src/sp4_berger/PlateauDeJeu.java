/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

/**
 *
 * @author berge
 */
public class PlateauDeJeu {
    private final int ligne = 6;
    private final int coln = 7; 
    private CelluleDeGrille[][] grille = new CelluleDeGrille[ligne][coln];    
    
    public PlateauDeJeu() {
        for (int i = 0; i < ligne; i++){
            for (int j = 0; i < coln; j++){  
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }
    
    public int ajouterJetonDansColonne(Jeton j, int c){
        for (int l = ligne; l > 0; l--){
            if (grille[l][c].presenceJeton()==false){
                return l;
            }
        }
        return -1;
    }
    
    public boolean grilleRemplie(){
        for (int i = 0; i < ligne; i++){
            for (int j = 0; i < coln; j++){ 
                if (grille[i][j].presenceJeton()){
                    return false;
                }
            }
        }
        return false;
    }
    
    public void viderGrille(Joueur j1, Joueur j2){
        for (int i = 0; i < ligne; i++){
            for (int j = 0; i < coln; j++){ 
                if (grille[i][j].presenceJeton()){
                    String color = grille[i][j].lireCouleurDuJeton();
                    if(color.equals("rouge")){
                        j1.ajouterJeton(grille[i][j]);
                    }else if(color.equals("jaune")){
                        j2.ajouterJeton(grille[i][j]);
                    }
                }
            }
        }
    }
}   
