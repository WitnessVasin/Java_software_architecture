package Car_driver;

import java.awt.*;

public class Program {
    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объем двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     *
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     *
     * 3. Расширить абстрактный класс «Car», добавив метод: поднять
     * кузов. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     *
     * 4. Расширить абстрактный класс «Car», добавив метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     *
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     *
     * 6. Создать конкретный автомобиль путём наследования класса * «Саг», определить метод «движение» «полёт». Провести
     *  проверку принципа LЅР.
     *
     *  7. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.
     *
     *  8. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс «Саг».
     *
     *
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового стекла, протирка фар, протирка зеркал.
     *
     * 10. Имплементировать все методы интерфейса «Заправочная станция» в конкретный класс «Сar». Провести проверку принципа ІЅР. Создать дополнительный/е интерфейсы и имплементировать их в конкретный класс «Саг». Провести проверку принципа ISP.
     *
     * 11. Создать путём наследования класса «Саг» два автомобиля: с бензиновым и дизельным двигателями, имплементировать метод «Заправка топливом» интерфейса «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     */
    public static void main(String[] args) {

        Harvester harvester = new Harvester("a", "b", Color.pink);

        RefuelingStation refuelingStation = new RefuelingStation();

        harvester.setRefuelingStation(refuelingStation);

        harvester.fuel();


    }

    public static double calculateMaintenance(Car car){

        if (car.getWheelsCount() ==6){
            return  1500*6;
        }
        else {
            return 1000*4;
        }
    }
}
