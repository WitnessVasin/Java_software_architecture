package Practic_5;

import java.util.*;

public class Program {

    static Scanner scanner = new Scanner(System.in);

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

        Editor3D editor3D = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** MOй 3D PEДAKTOP ***");
            System.out.println("==================");
            System.out.println("1. Oткрыть проект");
            System.out.println("2. Cоxранить проект");
            System.out.println("3. OтOбразить параметры проекта");
            System.out.println("4. Oтобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");

            if(scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch(no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.println("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект открыт");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            System.out.println("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            }
                            else {
                                System.out.println("Неккоретный номер модели");
                            }
                            break;

                        default:
                            System.out.println("Укажите корректный пункт меню");
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("Укажите корректный пунтк меню");
                scanner.nextLine();
            }
        }
    }
}

class Editor3D implements UILayer{

    private  ProjectFile projectFile;

    private  BusinessLogicalLayer businessLogicalLayer;

    private DatabaseAccess databaseAccess;

    private DataBase dataBase;

    private void initialize(){
        dataBase = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(dataBase);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {

        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******* **********");

    }

    private void checkProjectFile(){
        if (projectFile == null){
            throw new RuntimeException("No project file selected");
        }
    }

    @Override
    public void saveProject() {
        checkProjectFile();
        dataBase.save();
        System.out.println("Saving project");

    }

    @Override
    public void printAllModels() {

        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++){
            System.out.printf("===%d===\n",1);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()){
                System.out.printf("Texture: %s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTexture();
        for (int i = 0; i < textures.size(); i++){
            System.out.printf("===%d===\n",1);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {

        checkProjectFile();


        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() -  startTime);
        System.out.printf("Oперачия выполнена за % мc.\n", endTime);
    }

    @Override
    public void renderModel(int i) {

        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Oперачия выполнена за %d Mc.\n", endTime);
    }
}

/**
 * Интерфейс UI
 */

interface UILayer{

    void openProject (String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);
}

/**
 * Реализация BLL
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer{

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTexture() {
        return databaseAccess.getALLTextures();
    }

    @Override
    public void renderModel(Model3D model) {

    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    private Random rand = new Random();

    private void processRender(Model3D model) {
        try
        {
            Thread.sleep(2500 - rand.nextInt(2800));
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}

/**
 * Интерфейс BLL
 */

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

    public boolean getSetting3() {
        return setting3;
    }
}



