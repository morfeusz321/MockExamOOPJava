import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Album {
    private String band;
    private String albumName;
    private String year;
    private List<String> artists;
    private List<Song> trucks;



    public Album(String band, String albumName, String year, List<String> artists, List<Song> trucks) {
        this.band = band;
        this.albumName = albumName;
        this.year = year;
        this.artists = artists;
        this.trucks = trucks;
    }

    public List<Song> getTrucks() {
        return trucks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return Objects.equals(band, album.band) && Objects.equals(albumName, album.albumName) && Objects.equals(year, album.year) && Objects.equals(trucks, album.trucks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, albumName, year, trucks);
    }

    @Override
    public String toString() {
        return "Album{" +
                "band='" + band + '\'' +
                ", albumName='" + albumName + '\'' +
                ", year='" + year + '\'' +
                ", trucks=" + trucks +
                '}';
    }
    public static Album read(String chunk){
        Scanner scanner= new Scanner(chunk);
        Scanner cos=new Scanner(scanner.nextLine()).useDelimiter("; ");
        String op= cos.next();
        String fu= cos.next();
        String dupa=cos.next();
        List<String>artists=new ArrayList<>();
        Scanner scanner1=new Scanner(scanner.nextLine());
        scanner1.next();
        scanner1.useDelimiter("; ");
        while(scanner1.hasNext()){
            artists.add(scanner1.next());
        }
        List<Song> songs=new ArrayList<>();
        while(scanner.hasNextLine()){
            songs.add(Song.read(scanner.nextLine()));
        }
        return new Album(op, fu, dupa, artists,songs);
    }
}
