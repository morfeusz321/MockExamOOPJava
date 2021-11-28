import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    @Test
    void Album() {
        Song song= new Song("4","bud guy","4:24");
        List<Song> songs=new ArrayList<>();
        songs.add(song);
        List<String> artists=new ArrayList<>();
        artists.add("Amelka");
        Album pizda=new Album("Dupa","Wylize","69",artists,songs);
        Assertions.assertNotNull(pizda);

    }

    @Test
    void getTrucks() {
            Song song= new Song("4","bud guy","4:24");
            List<Song> songs=new ArrayList<>();
            songs.add(song);
            List<String> artists=new ArrayList<>();
            artists.add("Amelka");
            Album pizda=new Album("Dupa","Wylize","69",artists,songs);
            Assertions.assertEquals(songs,pizda.getTrucks());
    }

    @Test
    void testEquals() {
            Song song= new Song("4","bud guy","4:24");
            List<Song> songs=new ArrayList<>();
            songs.add(song);
            List<String> artists=new ArrayList<>();
            artists.add("Amelka");
            Album pizda=new Album("Dupa","Wylize","69",artists,songs);
            Album dupa=new Album("Dupa","Wylize","69",artists,songs);
            Assertions.assertTrue(dupa.equals(pizda));
    }

    @Test
    void testToString() {
        Song song= new Song("4","bud guy","4:24");
        List<Song> songs=new ArrayList<>();
        songs.add(song);
        List<String> artists=new ArrayList<>();
        artists.add("Amelka");
        Album pizda=new Album("Dupa","Wylize","69",artists,songs);
        Assertions.assertEquals("Album{" +
                "band='" + "Dupa"+ '\'' +
                ", albumName='" + "Wylize" + '\'' +
                ", year='" + "69" + '\'' +
                ", trucks=" + songs +
                '}',pizda.toString());
    }

    @Test
    void read() {
        Album dupa=Album.read("ALBUM U2; Songs of Innocence; 2014\n" +
                "ARTISTS Larry Mullen Jr.; The Edge; Bono; Adam Clayton\n" +
                "TRACK 1; The Miracle; 4:15\n" +
                "TRACK 2; Every Breaking Wave; 4:12\n" +
                "TRACK 3; California; 4:00\n" +
                "TRACK 4; Song for Someone; 3:47");
        Assertions.assertNotNull(dupa);
    }
}