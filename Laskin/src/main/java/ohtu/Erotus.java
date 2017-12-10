
package ohtu;

import javax.swing.JTextField;

class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int viimeksiMiinustettu;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int annettuLuku = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(annettuLuku);
        viimeksiMiinustettu = annettuLuku;
        paivitaKentat();
    }

    @Override
    public void peru() {
        sovellus.plus(viimeksiMiinustettu);
        paivitaKentat();
    }

    private void paivitaKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
