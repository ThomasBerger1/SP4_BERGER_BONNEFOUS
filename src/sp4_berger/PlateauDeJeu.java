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
    CelluleDeGrille[][] grille = new CelluleDeGrille[ligne][coln];

    public PlateauDeJeu() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < coln; j++) {
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }

    public int ajouterJetonDansColonne(Jeton j, int c) {
        for (int l = 0; l < ligne; l++) {
            if (grille[l][c].presenceJeton() == false) {
                grille[l][c].affecterJeton(j);
                return l;
            }
        }
        return -1;
    }

    public boolean grilleRemplie() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < coln; j++) {
                if (grille[i][j].presenceJeton()) {
                    return false;
                }
            }
        }
        return false;
    }

    public void viderGrille(Joueur j1, Joueur j2) {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < coln; j++) {
                if (grille[i][j].presenceJeton()) {
                    String color = grille[i][j].lireCouleurDuJeton();
                    if (color.equals("rouge")) {
                        j1.ajouterJeton(grille[i][j].recupererJeton());
                    } else if (color.equals("jaune")) {
                        j2.ajouterJeton(grille[i][j].recupererJeton());
                    }
                }
                if (grille[i][j].presenceTrouNoir()) {
                    grille[i][j].supprimerTrouNoir();
                }
                if (grille[i][j].presenceDesintegrateur()) {
                    grille[i][j].supprimerDesintegrateur();
                }
            }
        }
    }

    public void afficherGrilleSurConsole() {
        for (int i = 5; i > -1; i--) {
            for (int j = 0; j < coln; j++) {

                if (grille[i][j].presenceJeton()) {
                    System.out.print("[" + grille[i][j].lireCouleurDuJeton() + "]");
                } else if (grille[i][j].presenceTrouNoir()) {
                    System.out.print("[TrouNoir]");
                } else if (grille[i][j].presenceDesintegrateur() && !grille[i][j].presenceTrouNoir()) {
                    System.out.print("[Desintegrateur]");
                } else {
                    System.out.print("[" + null + "]");
                }

                if (j == coln - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public boolean presenceJeton(int x, int y) {
        return grille[x][y].presenceJeton();
    }

    boolean presenceTrouNoir(int x, int y) {
        return grille[x][y].presenceTrouNoir();
    }

    public boolean presenceDesintegrateur(int x, int y) {
        return grille[x][y].presenceDesintegrateur();
    }

    public String lireCouleurDuJeton(int x, int y) {
        return grille[x][y].lireCouleurDuJeton();
    }

    public boolean ligneGagnantePourCouleur(String color) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {

                if (presenceJeton(i, j)) {
                    if (grille[i][j].lireCouleurDuJeton().equals(color)) {
                        int cmpt = 1;
                        for (int k = 1; k < 4; k++) {
                            if (grille[i][j + k].lireCouleurDuJeton().equals(color)) {
                                cmpt++;
                            }
                        }
                        if (cmpt == 4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean colonneGagnantePourCouleur(String color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {

                if (presenceJeton(i, j)) {
                    if (grille[i][j].lireCouleurDuJeton().equals(color)) {
                        int cmpt = 1;
                        for (int k = 1; k < 4; k++) {
                            if (grille[i + k][j].lireCouleurDuJeton().equals(color)) {
                                cmpt++;
                            }
                        }
                        if (cmpt == 4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean diagonaleMontanteGagnantePourCouleur(String color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                if (presenceJeton(i, j)) {
                    if (grille[i][j].lireCouleurDuJeton().equals(color)) {
                        int cmpt = 1;
                        for (int k = 1; k < 4; k++) {
                            if (grille[i + k][j + k].lireCouleurDuJeton().equals(color)) {
                                cmpt++;
                            }
                        }
                        if (cmpt == 4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean diagonaleDescendanteGagnantePourCouleur(String color) {
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {

                if (presenceJeton(i, j)) {
                    if (grille[i][j].lireCouleurDuJeton().equals(color)) {
                        int cmpt = 1;
                        for (int k = 1; k < 4; k++) {
                            if (grille[i - k][j + k].lireCouleurDuJeton().equals(color)) {
                                cmpt++;
                            }
                        }
                        if (cmpt == 4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean etreGagnantePourCouleur(String couleur) {

        if (ligneGagnantePourCouleur(couleur)) {
            return true;
        } else if (colonneGagnantePourCouleur(couleur)) {
            return true;
        } else if (diagonaleMontanteGagnantePourCouleur(couleur)) {
            return true;
        } else {
            return diagonaleDescendanteGagnantePourCouleur(couleur);
        }
    }

    public void tasserColonne(int c) {
        for (int k = 0; k < 5; k++) {
            if (!grille[k][c].presenceJeton()) {
                if (grille[k + 1][c].presenceJeton()) {
                    Jeton je = grille[k + 1][c].recupererJeton();
                    grille[k][c].affecterJeton(je);
                }
            }
        }
    }
 
    public void tasserGrille(){
        for (int i = 0; i < 7 ;i++){
            tasserColonne(i);
        }
    }
    
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }
    
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();
    }
    
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerDesintegrateur();
    }
    
    public void supprimerDesintegrateur(int x, int y){
        grille[x][y].supprimerDesintegrateur();
    }
    
    public void supprimerJeton(int x, int y){
        grille[x][y].supprimerJeton();
    }
    
    public Jeton recupererJeton(int x, int y){
        return grille[x][y].recupererJeton();
    }
    
    public boolean colonneremplie(int colonne){
        return grille[5][colonne].presenceJeton();
    }
}
    
