package factoryMethod;

import TemplateMethod_practice.LogEntry;
import TemplateMethod_practice.LogReader;

/**
 * одна из реализаций показана в PoemReader
 */
public class TextFileReader extends LogReader {
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
