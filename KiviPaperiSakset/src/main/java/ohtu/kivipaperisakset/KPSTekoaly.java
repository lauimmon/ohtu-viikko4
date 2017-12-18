package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {

    private TekoalyYksinkertainen tekoaly;

    @Override
    protected void toisenPelaajanSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
    }

    @Override
    protected void toisenPelaajanEnsimmainenSiirto() {
        tekoaly = new TekoalyYksinkertainen();
        tokanSiirto = tekoaly.annaSiirto();
        io.tulosta("Tietokone valitsi: " + tokanSiirto);
    }

    
}