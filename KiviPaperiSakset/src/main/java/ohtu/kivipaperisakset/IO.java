
package ohtu.kivipaperisakset;

import java.util.Scanner;


public class IO {
    private Scanner lukija;

    public IO() {
        lukija = new Scanner(System.in);
    }
    
    public void tulosta(Object o) {
        System.out.println(o);
    }
    
    public void tulosta() {
        System.out.println();
    }
    
    public String lueRivi() {
        return lukija.nextLine();
    }
    
    public String kysyToisenPelaajanSiirto() {
        tulosta("Toisen pelaajan siirto: ");
        return lueRivi();
    }

    public String kysyEnsimmaisenPelaajanSiirto() {
        tulosta("Ensimmäisen pelaajan siirto: ");
        return lueRivi();
    }
}
