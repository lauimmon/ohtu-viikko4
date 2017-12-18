package ohtu.kivipaperisakset;



// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPS {

    @Override
    protected void toisenPelaajanSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirtoMuistiin(ekanSiirto);
    }

    @Override
    protected void toisenPelaajanEnsimmainenSiirto() {
        tekoaly = new TekoalyParannettu(20);
        tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
    }
}
