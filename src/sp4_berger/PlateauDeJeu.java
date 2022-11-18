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
            for (int j = 0; j < coln; j++){  
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }
    
    public int ajouterJetonDansColonne(Jeton j, int c){
        for (int l = 0; l < ligne; l++){
            if (grille[l][c].presenceJeton()==false){
                return l;
            }
        }
        return -1;
    }
    
    public boolean grilleRemplie(){
        for (int i = 0; i < ligne; i++){
            for (int j = 0; j < coln; j++){ 
                if (grille[i][j].presenceJeton()){
                    return false;
                }
            }
        }
        return false;
    }
    
    public void viderGrille(Joueur j1, Joueur j2){
        for (int i = 0; i < ligne; i++){
            for (int j = 0; j < coln; j++){ 
                if (grille[i][j].presenceJeton()){
                    String color = grille[i][j].lireCouleurDuJeton();
                    if(color.equals("rouge")){
                        j1.ajouterJeton(grille[i][j].recupererJeton());
                    }else if(color.equals("jaune")){
                        j2.ajouterJeton(grille[i][j].recupererJeton());
                    }
                }
            }
        }
    }
    
    public void afficherGrilleSurConsole(){
        for (int i = 0; i < ligne; i++){
            for (int j = 0; j < coln; j++){ 
                
                if (grille[i][j].presenceJeton()){
                    System.out.print("["+grille[i][j].lireCouleurDuJeton()+"]");
                }else{
                    System.out.print("["+null+"]");
                }
                
                if(j==coln-1){
                    System.out.print("\n");
                }
            }
        }
    } 
    
    public boolean presenceJeton (int x, int y){
        return grille[x][y].presenceJeton();
    }
    
    public String lireCouleurDuJeton (int x, int y){
        return grille[x][y].lireCouleurDuJeton();
    }
    
    public boolean etreGagnantePourCouleur(String aa){
        
        public boolean ligneGagnantePourCouleur(String aaa){
            for 
        } 
        
        public boolean colonneGagnantePourCouleur(String aaa){
            
        } 
        
        public boolean diagonaleMontanteGagnantePourCouleur(String aaa){
            
        } 
        
        public boolean diagonaleDescendanteGagnantePourCouleur(String aaa){
            
        } 
        
        if (ligneGagnantePourCouleur(aa)){
            return true;
        }else if (colonneGagnantePourCouleur(aa)){
            return true;
        }else if (diagonaleMontanteGagnantePourCouleur(aa)){
            return true;
        }else if (diagonaleDescendanteGagnantePourCouleur(aa)){
            return true;
        }else{
        return false;
        }
    }
    
}   