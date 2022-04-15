
public class WriteRunnable extends Thread {

    private BookSynchronizer bookSynchronizer;

    public WriteRunnable(BookSynchronizer bookSynchronizer) {
        this.bookSynchronizer = bookSynchronizer;
    }

    @Override
    public void run() {
        try {
            int value;
            for (int i = 0; i < bookSynchronizer.getNumberOfElements(); i++) {
                value = (int) (Math.random() * (100));
                bookSynchronizer.write(value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
