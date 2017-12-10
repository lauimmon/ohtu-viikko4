
package ohtu;

import javax.swing.JTextField;


class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int viimeisinTulos;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        viimeisinTulos = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        sovellus.plus(viimeisinTulos);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
