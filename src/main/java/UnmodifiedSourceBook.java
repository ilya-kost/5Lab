import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class UnmodifiedSourceBook implements SourceBook{

    private final SourceBook sourceBook;

    public UnmodifiedSourceBook(SourceBook sourceBook) {
        this.sourceBook = sourceBook;
    }

    @Override
    public Integer getInformationElement(Integer index) {
        return sourceBook.getInformationElement(index);
    }

    @Override
    public void removeInformationElement(Integer index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Для этого класса не поддерживаются операции изменения");
    }

    @Override
    public int getSumOfInformationElements() {
        return sourceBook.getSumOfInformationElements();
    }

    @Override
    public List<Integer> getInformation() {
        return sourceBook.getInformation();
    }

    @Override
    public void output(OutputStream outputStream) throws IOException {
        sourceBook.output(outputStream);
    }

    @Override
    public void write(Writer writer) throws IOException {
        sourceBook.write(writer);
    }

    @Override
    public void setInformationElement(Integer index, int element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Для этого класса не поддерживаются операции изменения");
    }

    @Override
    public int getSizeOfInformation() {
        return sourceBook.getSizeOfInformation();
    }

    @Override
    public String toString() {
        return sourceBook.toString();
    }
}
