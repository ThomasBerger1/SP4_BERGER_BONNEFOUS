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
    
    public Jeton recupererJeton(){
        Jeton j = jetonCourant;
        jetonCourant = null;
        return j;
    }
}

