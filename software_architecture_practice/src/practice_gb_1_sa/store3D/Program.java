package practice_gb_1_sa.store3D;

import practice_gb_1_sa.store3D.inmemory.ModelStore;
import practice_gb_1_sa.store3D.inmemory.Observer1;
import practice_gb_1_sa.store3D.models.Poligon;
import practice_gb_1_sa.store3D.models.PoligonalModel;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();

        ModelStore store = new ModelStore();

        store.RegigisterModelChanger(observer1);

        Poligon poligon1 = new Poligon();
        List<Poligon> poligons = new ArrayList<>();
        poligons.add(poligon1);
        PoligonalModel poligonalModel = new PoligonalModel(poligons);
        store.add(poligonalModel);
    }
}
