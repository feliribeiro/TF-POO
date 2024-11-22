package Dados;

import java.util.Comparator;

public class Comparador implements Comparator<Drone> {
    @Override
    public int compare(Drone p1, Drone p2) {
        return Integer.compare(p1.getCodigo(), p2.getCodigo());
    }
}
