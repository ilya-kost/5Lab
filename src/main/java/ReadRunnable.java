
public class ReadRunnable extends Thread {

    private BookSynchronizer bookSynchronizer;

    public ReadRunnable(BookSynchronizer bookSynchronizer) {
        this.bookSynchronizer = bookSynchronizer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < bookSynchronizer.getNumberOfElements(); i++) {
                bookSynchronizer.read();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
