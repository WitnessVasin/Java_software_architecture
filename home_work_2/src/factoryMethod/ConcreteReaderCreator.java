package factoryMethod;

import TemplateMethod_practice.LogReader;
import TemplateMethod_practice.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator{

    @Override
    protected LogReader createLogReaderInstance() {

        return switch (LogType.Poem){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DataBaseReader();
            case System -> new OperationSystemLogEventReader();
        };
    }
}
