package factoryMethod;

import TemplateMethod_practice.LogReader;

public abstract class BaseLogReaderCreator {


    protected  LogReader createLogReader(Object data) {

        LogReader logReader = createLogReaderInstance();

        logReader.setDataSourse(data);
        logReader.setCurrentPosition(4);

        return  logReader;
    }

    protected abstract LogReader createLogReaderInstance();

}
