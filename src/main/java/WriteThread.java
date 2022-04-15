
public class WriteThread extends Thread {

    private int number;
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
                number = (int) (Math.random() * (100));
                sourceBook.setInformationElement(i, number);
                System.out.println("Write: " + number + " to position" + i);
            }
        }
    }
}
