package factoryMethod;

import TemplateMethod_practice.LogReader;

public abstract class BaseLogReaderCreator {


    protected  LogReader createLogReader(LogType logType, Object data) {

        LogReader logReader = createLogReaderInstance(logType);

        logReader.setDataSourse(data);
        logReader.setCurrentPosition(4);

        return  logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);

}
