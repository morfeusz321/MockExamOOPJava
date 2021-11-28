import java.util.Objects;
import java.util.Scanner;

public class Song {
    private String number;
    private String title;
    private String length;

    public Song(String number, String title, String length) {
        this.number = number;
        this.title = title;
        this.length = length;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return number == song.number && Objects.equals(title, song.title) && Objects.equals(length, song.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title, length);
    }
    public static Song read(String line){
        Scanner scanner=new Scanner(line);
        scanner.next();
        scanner.useDelimiter("; ");
        return new Song(scanner.next(), scanner.next(), scanner.next());
    }
}
