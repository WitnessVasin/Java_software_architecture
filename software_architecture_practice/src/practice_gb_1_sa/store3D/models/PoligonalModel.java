package practice_gb_1_sa.store3D.models;

import java.util.List;

public class PoligonalModel {

    private List<Poligon> poligons;

    private List<Texture> textures;

    public List<Poligon> getPoligons() {
        return poligons;
    }

    public void setPoligons(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public List<Texture> getTextures() {
        return textures;
    }

    public void setTextures(List<Texture> textures) {
        this.textures = textures;
    }

    public PoligonalModel(List<Poligon> poligons) {
        this.poligons = poligons;
    }

    public PoligonalModel(List<Poligon> poligons, List<Texture> textures) {
        this.poligons = poligons;
        this.textures = textures;
    }
}
