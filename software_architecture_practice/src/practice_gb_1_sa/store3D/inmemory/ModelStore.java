package practice_gb_1_sa.store3D.inmemory;

import practice_gb_1_sa.store3D.models.Camera;
import practice_gb_1_sa.store3D.models.Flash;
import practice_gb_1_sa.store3D.models.PoligonalModel;
import practice_gb_1_sa.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{

    private List<ModelChagedObserver> observers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();

    private List<Scene> scenes = new ArrayList<>();

    private List<Flash> flashes = new ArrayList<>();

    private List<Camera> cameras = new ArrayList<>();


    public Scene GetScene(int id) {
        for (int i = 0; i < scenes.size(); i++) {
            if (scenes.get(i).id == id) {
                return scenes.get(i);
            }
        }
        return null;
    }

    public void add(PoligonalModel model){
        models.add(model);
        notifyChange();

    }



    @Override
    public void notifyChange() {

        for (ModelChagedObserver observer: observers){
            observer.ApplyUpdateModel();
        }
    }

    @Override
    public void RegigisterModelChanger(ModelChagedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChagedObserver o) {
        observers.add(o);
    }


}
