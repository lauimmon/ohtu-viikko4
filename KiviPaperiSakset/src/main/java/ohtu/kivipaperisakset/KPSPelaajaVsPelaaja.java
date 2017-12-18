package ohtu.kivipaperisakset;


public class KPSPelaajaVsPelaaja extends KPS {

    @Override
    protected void toisenPelaajanSiirto() {
        tokanSiirto = io.kysyToisenPelaajanSiirto();
    }

    @Override
    protected void toisenPelaajanEnsimmainenSiirto() {
       toisenPelaajanSiirto();
    }
}