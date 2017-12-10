
package ohtu;

import javax.swing.JTextField;

class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int viimeksiPlussattu;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int annettuLuku = Integer.parseInt(syotekentta.getText());
        sovellus.plus(annettuLuku);
        viimeksiPlussattu = annettuLuku;
        paivitaKentat();
    }

    @Override
    public void peru() {
        sovellus.miinus(viimeksiPlussattu);
        viimeksiPlussattu = 0;
        paivitaKentat();
    }

    private void paivitaKentat() {
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
