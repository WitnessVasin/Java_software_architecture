package factoryMethod;

import TemplateMethod_practice.LogEntry;
import TemplateMethod_practice.LogReader;

public class OperationSystemLogEventReader extends LogReader {
    @Override
    public Object getDataSourse() {
        return null;
    }

    @Override
    public void setDataSourse(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringentry) {
        return null;
    }
}
