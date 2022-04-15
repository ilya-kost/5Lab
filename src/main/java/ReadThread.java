
public class ReadThread extends Thread {
    private SourceBook sourceBook;

    public void setSourceBook(SourceBook sourceBook) {
        this.sourceBook = sourceBook;
    }

    @Override
    public void run() {
        if (sourceBook == null) {
            System.out.println("SourceBook is null");
        } else {
            for (int i = 0; i < sourceBook.getInformation().size(); i++) {
                System.out.println("Read: " + sourceBook.getInformationElement(i) + " to position" + i);
            }
        }
    }
}
