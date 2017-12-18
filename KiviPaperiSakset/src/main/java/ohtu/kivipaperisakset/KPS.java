
package ohtu.kivipaperisakset;


public abstract class KPS {
    protected IO io = new IO();
    protected String ekanSiirto;
    protected String tokanSiirto; 
    protected Tekoaly tekoaly;
    
    public static KPSPelaajaVsPelaaja luoPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KPSTekoaly luoPelaajaVsTekoaly() {
        return new KPSTekoaly();
    }

    public static KPSParempiTekoaly luoPelaajaVsParempiTekoaly() {
        return new KPSParempiTekoaly();    
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        ekanSiirto = io.kysyEnsimmaisenPelaajanSiirto();
        toisenPelaajanEnsimmainenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.tulosta(tuomari);
            io.tulosta();

            ekanSiirto = io.kysyEnsimmaisenPelaajanSiirto();
            toisenPelaajanSiirto();
        }

        io.tulosta();
        io.tulosta("Kiitos!");
        io.tulosta(tuomari);
    }
    
    protected abstract void toisenPelaajanEnsimmainenSiirto();
    protected abstract void toisenPelaajanSiirto();
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
