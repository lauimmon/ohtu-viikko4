package ohtu.kivipaperisakset;

import java.util.HashMap;

public class TekoalyYksinkertainen implements Tekoaly{

    int siirto;
    HashMap<Integer, String> map;

    public TekoalyYksinkertainen() {
        siirto = 0;
        map = new HashMap<>();
        map.put(0, "k");
        map.put(1, "p");
        map.put(2, "s");
    }

    @Override
    public String annaSiirto() {
        siirto++;
        if (map.get(siirto) == null) {
            siirto = 0;
        }

        return map.get(siirto);
    }

    @Override
    public void asetaSiirtoMuistiin(String siirto) {
    }
}
