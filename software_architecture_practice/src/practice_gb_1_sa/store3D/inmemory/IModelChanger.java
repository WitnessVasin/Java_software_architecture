package practice_gb_1_sa.store3D.inmemory;

public interface IModelChanger {
    /**
     * get change
     */
    void notifyChange();

    void RegigisterModelChanger(ModelChagedObserver o);
    void RemoveModelChanger(ModelChagedObserver o);


}
