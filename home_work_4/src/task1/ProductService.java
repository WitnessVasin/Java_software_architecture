package task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class ProductService implements Readable{

    private ArrayList<String> res;


    public void process1(){

    }

    public void process2(){
        res = null;
    }

    public Collection<String> readTextFile(File file){

        // Предусловие

        if (file.exists()){
            if (file.length() > 5000){
                throw new RuntimeException("File is too big");
            }
        else {
            throw new RuntimeException("File in not found");
            }
        }


        //region Работа с данными
        res = new ArrayList<>();
        res.add("АААААААА");
        res.add("Bbbbbbbb");

        process1();
        // Инвариант
        validateResult(res);

        process2();
        // Инвариант
        validateResult(res);

        //endregion

        // ПОСТУСЛОВИЕ
        if (res == null){
            throw new RuntimeException("Error reading file");
        }

        //TODO: Возвращаем результат выполнения задачи ...
        return res;
    }

    private void validateResult(Collection<String> res){
        if (res == null || res.size() == 0){
            throw new RuntimeException("Неккоретное состояние объекта");
        }
    }
}

/**
 * Позволяет считывать данные
 */

interface Readable{
    /**
     * Считывание и обработка данных
     * @param file файл
     * @return коллекция данных
     * @throws RuntimeException исключение при обработке файла
     */
    Collection<String> readTextFile(File file) throws RuntimeException;
}