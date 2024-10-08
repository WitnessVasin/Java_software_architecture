package task2;

import java.util.ArrayList;

/**
 * Информация о детали
 */
public class ComponentInfo {

    private int id;

    private String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ComponentInfo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Component ID: %d, Description: %s", id, description);
    }
}

/**
 * Завод по производству деталей
 */
class FactoryProvider{

    private final ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for(int i = 0; i<10; i++){
            components.add(new ComponentInfo(900000 + i, String.format("Component %d", 900000 + i)));
        }

        for(int i = 0; i<5; i++){
            components.add(new ComponentInfo(1000 + i, String.format("Component %d", 1000 + i)));
        }
    }

    /**
     * Получить информацию о детали по идентификатору
     * @param id Идентификатор детали
     * @throws RuntimeException исключение при обработке операции поиска
     * @return Информация о делаи
     */

    public ComponentInfo getComponent(int id) throws RuntimeException{

        // Предусловие
        if (id <0)
            throw new RuntimeException("Некорректный номер детали");

        if (String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но уже не производится");

        // Выполнение основного кода подпрограммы
        ComponentInfo searchComponent = null;
        for (ComponentInfo componentInfo : components) {
            if (componentInfo.getId() == id) {
                searchComponent = componentInfo;
                break;
            }
        }
        if (searchComponent == null)
            throw new RuntimeException("Деталь не найдена");

        return searchComponent;
    }
}


class DealerProvider{

    private final FactoryProvider factoryProvider;

    public DealerProvider(FactoryProvider factoryProvider) {
        this.factoryProvider = factoryProvider;
    }

    /**
     *
     * @param id
     * @return
     */
    public ComponentInfo getComponent(int id) {

        // Предусловия ...

        if (id < 0 || String.valueOf(id).length() < 6){
            throw new RuntimeException("Invalid component ID");
        }
        return factoryProvider.getComponent(id);

        // Постусловие ...
    }
}