import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.stream.Stream;

public class Catalog implements Runnable{
    private List<Album> albums;
    private List<Song> songs;
    private List<Ad> ads;
    private List<Object> playlist;

    public Catalog() {
        songs = new ArrayList<>();
        albums = new ArrayList<>();
        ads = new ArrayList<>();
        playlist=new ArrayList<>();
    }

    public List<Album> getAlbums(){
        return albums;
    }


    public List<Ad> getAds() {
        return ads;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(songs, catalog.songs) && Objects.equals(ads, catalog.ads) && Objects.equals(playlist, catalog.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songs, ads, playlist);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "songs=" + songs +
                ", ads=" + ads +
                ", playlist=" + playlist +
                '}';
    }
    public void read(Scanner scanner){
        scanner.nextLine();
        scanner.useDelimiter("(ALBUM |ADS)");
        while(scanner.hasNextLine()){
            String next=scanner.next();
            if(next.contains("\nAD")){
                Scanner scanner1=new Scanner(next);
                scanner1.nextLine();
                while(scanner1.hasNextLine()) {
                    this.ads.add(Ad.read(scanner1.nextLine()));
                }
            }
            else{
                this.albums.add(Album.read(next));
            }
        }

    }
    public void addAd(Scanner scanner){
        System.out.println("enetr brand");
        String brand=scanner.nextLine();
        System.out.println("Please enter length:");
        String length= scanner.nextLine();
        System.out.println("Please enter price");
        double price=scanner.nextDouble();
        ads.add(new Ad(brand,length,price));
    }
    public synchronized void optionThree(){
        Random random=new Random();
        for(int o=0;o<albums.size();o++){
            songs= Stream.concat(songs.stream(),albums.get(o).getTrucks().stream()).toList();
        }
        for(int i=0;i<10;i++){
            playlist.add(songs.get(random.nextInt(songs.size())));
            playlist.add(ads.get(random.nextInt(ads.size())));
        }
        System.out.println(playlist);
    }
    public void optionFour(Scanner scanner){
        for(int o=0;o<albums.size();o++){
            songs= Stream.concat(songs.stream(),albums.get(o).getTrucks().stream()).toList();
        }
        Random random= new Random();
        System.out.println("Please enter name of the song");
        String title=scanner.nextLine();
        Optional<Song> song=songs.stream().filter(song1 -> song1.getTitle().equals(title)).findFirst();
        List<Object> temp=new ArrayList<>();
        temp.add(song.get());
        temp.add(ads.get(random.nextInt(ads.size())));
        playlist=Stream.concat(temp.stream(),playlist.stream()).toList();
        System.out.println(playlist);
    }
    public void optionSix(){;
        System.out.println(ads.stream().mapToDouble(ad-> ad.getPrice()).sum());
    }

    @Override
    public void run() {
        optionThree();
    }
}
