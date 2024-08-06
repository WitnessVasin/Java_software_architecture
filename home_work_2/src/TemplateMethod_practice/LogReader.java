package TemplateMethod_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Основа работы алгоритма чтения данныйх
 */
public abstract class LogReader {

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }


    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }


    public Iterable<LogEntry> readLogEntry(){
        List<LogEntry> logList = new ArrayList<LogEntry>();
        for (String str : readEntries(currentPosition)){
            logList.add(parseLogEntry(str));
        }
        return logList;
    }
    public abstract Object getDataSourse();

    public abstract void  setDataSourse(Object data);

    protected abstract Iterable<String> readEntries(Integer position);

    protected abstract LogEntry parseLogEntry(String stringentry);
}
