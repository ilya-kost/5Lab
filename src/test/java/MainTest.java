import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        Article article = new Article(new ArrayList<>(), "Global smth research", 33);

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(23);
        integers.add(87);
        integers.add(23);
        integers.add(33);
        integers.add(87);
        integers.add(44);
        integers.add(33);
        integers.add(54);
        integers.add(54);
        integers.add(87);
        integers.add(23);
        integers.add(54);


        article.setInformation(integers);

        WriteThread writeThread = new WriteThread();
        writeThread.setSourceBook(article);
        writeThread.start();
        ReadThread readThread = new ReadThread();
        readThread.setSourceBook(article);
        readThread.start();


    }
}
