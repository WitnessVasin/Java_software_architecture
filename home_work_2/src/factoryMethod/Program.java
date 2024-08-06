package factoryMethod;

import TemplateMethod_practice.LogEntry;
import TemplateMethod_practice.LogReader;

public class Program {

    public static String data = """
            asdasdasd
            asdasdasdasd
            asd
            asdasdasdasdasdas
            dasdasdasdasdasdas
            asdasdasdasdasdasd
            """;

    public static void main(String[] args) {

        LogReader logReader = new ConcreteReaderCreator()
                .createLogReader(data);
        for (LogEntry log : logReader.readLogEntry()){
            System.out.println(log.getText());
        }
    }
}
