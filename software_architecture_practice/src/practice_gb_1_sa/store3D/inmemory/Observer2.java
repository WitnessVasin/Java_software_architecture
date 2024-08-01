package practice_gb_1_sa.store3D.inmemory;

public class Observer2 implements ModelChagedObserver {
    @Override
    public void ApplyUpdateModel() {
        System.out.print("add new poligon model - observer&1");
    }
}
