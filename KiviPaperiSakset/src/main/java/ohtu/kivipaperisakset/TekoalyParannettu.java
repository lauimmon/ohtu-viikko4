
package ohtu.kivipaperisakset;

// "Muistava tekoäly"

public class TekoalyParannettu implements Tekoaly {
  private String[] muisti;
  private int vapaaMuistiIndeksi;
  private int k;
  private int p;
  private int s;

  public TekoalyParannettu(int muistinKoko) {
    muisti = new String[muistinKoko];
    vapaaMuistiIndeksi = 0;
  }
  
  public void asetaSiirtoMuistiin(String siirto) {
    // jos muisti täyttyy, unohdetaan viimeinen alkio
    if(muistiOnTaynna()) {
        poistaEnsimmainenMuistista();
    }
    
    asetaSiirtoVapaaseenMuistipaikkaan(siirto);
  }

    private void asetaSiirtoVapaaseenMuistipaikkaan(String siirto) {
        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    private void poistaEnsimmainenMuistista() {
        for(int i = 1; i < muisti.length; i++) {
            muisti[i-1] = muisti[i];
        }
        
        vapaaMuistiIndeksi--;
    }

    private boolean muistiOnTaynna() {
        return vapaaMuistiIndeksi == muisti.length;
    }

  
  @Override
  public String annaSiirto() {
    if(maxYksiSiirtoTehty()) {
      return "k";
    }
    
    String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];
    
    k = 0;
    p = 0;
    s = 0;
    
    
    tutkiVastustajanSiirtojenToistuvuutta(viimeisinSiirto);
    
    
    // Tehdään siirron valinta esimerkiksi seuraavasti;
    // - jos kiviä eniten, annetaan aina paperi
    // - jos papereita eniten, annetaan aina sakset
    // muulloin annetaan aina kivi
    if(k > p && k > s) {
      return "p";
    }
    else if (p > s) {
      return "s";
    }
    else {
      return "k";
    }
    
    // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
    // Johdatus Tekoälyyn kurssilla!
  }

    private void tutkiVastustajanSiirtojenToistuvuutta(String viimeisinSiirto) {
        for(int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if(viimeisinSiirto.equals(muisti[i])) {
                String seuraava = muisti[i+1];
                
                if("k".equals(seuraava)) {
                    k++;
                }
                else if("p".equals(seuraava)) {
                    p++;
                }
                else {
                    s++;
                }
            }
        }
    }

    private boolean maxYksiSiirtoTehty() {
        return vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1;
    }
}