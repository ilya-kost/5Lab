public class BookSynchronizer {

    private final SourceBook sourceBook;
    private volatile int index;
    private volatile boolean flag;

    public BookSynchronizer(SourceBook sourceBook) {
        this.sourceBook = sourceBook;
        this.index = 0;
        this.flag = false;
    }

    public void write(int value) throws InterruptedException {
        synchronized (sourceBook) {
            if (!canWrite()) {
                throw new InterruptedException();
            }
            while (flag) {
                sourceBook.wait();
            }
            sourceBook.setInformationElement(index, value);
            flag = true;
            System.out.println("Write " + value + " to position " + index);
            sourceBook.notifyAll();
        }
    }

    private boolean canWrite() {
        return (!flag && index < sourceBook.getSizeOfInformation()
                || (!flag && index < sourceBook.getSizeOfInformation() - 1));
    }

    public void read() throws InterruptedException {

        int value;
        synchronized (sourceBook) {
            if (!canRead()) {
                throw new InterruptedException();
            }
            while (!flag) {
                sourceBook.wait();
            }
        }
        value = sourceBook.getInformationElement(index);
        flag = false;
        System.out.println("Read " + value + " to position " + index);
        index++;

        sourceBook.notifyAll();
    }

    private boolean canRead() {
        return index < sourceBook.getSizeOfInformation();
    }

    public int getNumberOfElements() {
        return sourceBook.getSizeOfInformation();
    }
}
