package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static Scanner lukija;

    private static String lueSyote() {
        return lukija.nextLine();
    }

    private static IntJoukko mikaJoukko() {
        String luettu = lueSyote();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = lueSyote();
            }
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        lisLuku = lukija.nextInt();
        joukko.lisaaJoukkoon(lisLuku);
    }

    private static IntJoukko kysyJoukko(int i) {
        IntJoukko bJoukko;
        System.out.print("" + i +  ". joukko? ");
        bJoukko = mikaJoukko();
        return bJoukko;
    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, tulos;
        aJoukko = kysyJoukko(1);
        bJoukko = kysyJoukko(2);
        tulos = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + tulos.toString());
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        aJoukko = kysyJoukko(1);
        bJoukko = kysyJoukko(2);
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        aJoukko = kysyJoukko(1);
        bJoukko = kysyJoukko(2);
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }

    private static void poista() {
        IntJoukko joukko;
        int lisLuku;
        System.out.print("Mistä joukosta? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        lisLuku = lukija.nextInt();
        joukko.poistaJoukosta(lisLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluuJoukkoon(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        lukija = new Scanner(System.in);
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                tulosta(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                tulosta(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                tulosta(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }

    private static void tulosta(IntJoukko joukko) {
        System.out.println(joukko);
    }
}
