package Car_driver;


import java.awt.*;

public abstract class Car {

    //region Constructors

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }


    //endregion

    //region Private Fields
    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLight = false;


    //endregion


    //region Public Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    public boolean switchFogLight() {
        fogLight = !fogLight;
        return fogLight;
    }
    //public abstract void sweeping();

    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }
    //endregion

    public int getWheelsCount() {
        return wheelsCount;
    }
}
