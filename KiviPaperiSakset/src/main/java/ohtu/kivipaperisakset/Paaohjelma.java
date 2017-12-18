package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Paaohjelma {

    private static final IO io = new IO();

    public static void main(String[] args) {

        while (true) {
            HashMap<String, KPS> map = new HashMap<>();
            map.put("a", KPS.luoPelaajaVsPelaaja());
            map.put("b", KPS.luoPelaajaVsTekoaly());
            map.put("c", KPS.luoPelaajaVsParempiTekoaly());
            
            io.tulosta("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.lueRivi();
            
            io.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            if (map.get(vastaus) == null) {
                break;
            }
            KPS peli = map.get(vastaus);
            peli.pelaa();

        }

    }
}
