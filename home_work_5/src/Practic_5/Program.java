package Practic_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Program {

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра). * Какие задачи можно делать
     * -
     * функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация в файловой системе компьютера).
     * *
     * * Предложить варианты связывания всех уровней
     * -сценарии использования. 3-4 сценария.
     * * Сквозная функция создать новую 3D модель, сделать рендер для печати на принтере....
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}

interface BusinessLogicalLayer{

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTexture();

    void renderModel(Model3D model);

    void renderAllModels();
}

/**
 * Реализация DAC
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final DataBase editorDatabase;

    public EditorDatabaseAccess(DataBase editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public void addEntity(Entity entity) {

        editorDatabase.getAll().add(entity);

    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public Collection<Texture> getALLTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()){
            if (entity instanceof Texture){
                models.add((Texture) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity: editorDatabase.getAll()){
            if (entity instanceof Model3D){
                models.add((Model3D)entity);
            }
        }
        return models;
    }
}

/**
 * Интерфейс DAC
 */
interface DatabaseAccess{

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getALLTextures();

    Collection<Model3D> getAllModels();
}

/**
 * Database
 */

class EditorDatabase implements DataBase{

    private Random random = new Random();

    private final ProjectFile projectFile;

    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        // TODO Загрузка всех сущностей проекта
    }

    @Override
    public void save() {
        // TODO Сохранение текущее состояние всех сущностей
    }

    @Override
    public Collection<Entity> getAll() {
        return null;
    }

    public Collection<Entity> getALL(){
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);

            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures(){
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }
}

/**
 * Интерфейс бд
 */

interface DataBase{

    void load();

    void save();

    Collection<Entity> getAll();

}


/**
 * 3D Модель
 */

class Model3D implements Entity{


    private int id;

    private static int counter = 10000;


    private Collection<Texture> textures = new ArrayList<>();


    @Override
    public int getId() {
        return id;
    }

    {
        id = counter++;
    }
    public Model3D(){

    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("3DModel %d", id);
    }
}

class Texture implements Entity{

    private static int counter = 50000;

    private int id;

    {
        id = counter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture %d", id);
    }
}

/**
 * Сущность
 */

interface Entity{

    int getId();

}

/**
 * Файл проекта
 */

class ProjectFile{

    private String fileName;

    private int setting;

    private String setting2;

    private boolean setting3;

    public ProjectFile(String fileName) {
        this.fileName = fileName;

        setting = 1;
        setting2 = "...";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting() {
        return setting;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean isSetting3() {
        return setting3;
    }
}



