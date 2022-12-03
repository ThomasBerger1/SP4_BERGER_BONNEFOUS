/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_berger;

/**
 *
 * @author berge
 */
public class CelluleDeGrille {
    private Jeton jetonCourant = null;
    private boolean avoirTrouNoir = false;
    private boolean avoirDesintegrateur = false;

    public CelluleDeGrille() {       
    }
    
    public boolean presenceJeton(){
        return jetonCourant != null;
    }

    public void affecterJeton(Jeton j){
        jetonCourant = j;
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant != null){
            return jetonCourant.lireCouleur();
        }else{
            return "vide";
        }
    }
    
    public void placerTrouNoir(){
        avoirTrouNoir = true;
    }
    
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
    }

    public boolean presenceTrouNoir() {
        return avoirTrouNoir;
    }    
    
    public void supprimerJeton(){
        jetonCourant = null;
    }
    
    public Jeton recupererJeton(){
        Jeton j = jetonCourant;
        jetonCourant = null;
        return j;
    }

    public boolean presenceDesintegrateur() {
        return avoirDesintegrateur;
    }
    
    public void placerDesintegrateur(){
        avoirDesintegrateur = true;
    }
    
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false;
    }
    
    public void activerTrouNoir(){
        supprimerJeton();
        supprimerTrouNoir();
    }
    
    @Override
    public String toString() {
        String msg ="";
        if (presenceTrouNoir()){
            msg += "@ ";
        }
        if (jetonCourant.lireCouleur().equals("rouge")){
            msg += "R";
        }else if (jetonCourant.lireCouleur().equals("jaune")){
            msg += "J";
        }
        return msg;
    }
    
    
}

