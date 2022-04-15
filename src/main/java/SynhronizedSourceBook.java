import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class SynhronizedSourceBook implements SourceBook {

    private final SourceBook sourceBook;

    public SynhronizedSourceBook(SourceBook sourceBook) {
        this.sourceBook = sourceBook;
    }

    @Override
    public synchronized Integer getInformationElement(Integer index) {
        return sourceBook.getInformationElement(index);
    }

    @Override
    public synchronized void removeInformationElement(Integer index) {
        sourceBook.removeInformationElement(index);
    }

    @Override
    public synchronized int getSumOfInformationElements() {
        return sourceBook.getSumOfInformationElements();
    }

    @Override
    public synchronized List<Integer> getInformation() {
        return sourceBook.getInformation();
    }

    @Override
    public synchronized void output(OutputStream outputStream) throws IOException {
        sourceBook.output(outputStream);
    }

    @Override
    public synchronized void write(Writer writer) throws IOException {
        sourceBook.write(writer);
    }

    @Override
    public synchronized void setInformationElement(Integer index, int element) {
        sourceBook.setInformationElement(index, element);
    }

    @Override
    public synchronized int getSizeOfInformation() {
        return sourceBook.getSizeOfInformation();
    }

    @Override
    public String toString() {
        return sourceBook.toString();
    }
}
