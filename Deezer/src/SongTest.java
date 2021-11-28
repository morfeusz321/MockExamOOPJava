import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    void Song() {
        Song song= new Song("4","bud guy","4:24");
        Assertions.assertNotNull(song);
    }
    @Test
    void getTitle() {
        Song song= new Song("4","bud guy","4:24");
        Assertions.assertEquals("bud guy",song.getTitle());
    }

    @Test
    void setTitle() {
        Song song= new Song("4","bud guy","4:24");
        song.setTitle("dupa");
        Assertions.assertEquals("dupa",song.getTitle());
    }

    @Test
    void getLength() {
        Song song= new Song("4","bud guy","4:24");
        Assertions.assertEquals("4:24",song.getLength());
    }

    @Test
    void setLength() {
        Song song= new Song("4","bud guy","4:24");
        song.setLength("3:43");
        Assertions.assertEquals("3:43",song.getLength());
    }

    @Test
    void testToString() {
        Song song= new Song("4","bud guy","4:24");
        Assertions.assertEquals("Song{" +
                "number=" + "4" +
                ", title='" + "bud guy" + '\'' +
                ", length='" + "4:24"+ '\'' +
                '}',song.toString());
    }

    @Test
    void testEquals() {
        Song song= new Song("4","bud guy","4:24");
        Song dupa= new Song("4","bud guy","4:24");
        Assertions.assertTrue(song.equals(dupa));
        Assertions.assertTrue(song.equals(song));
    }

    @Test
    void read() {
        Song song= Song.read("TRACK 1; The Miracle; 4:15");
        Assertions.assertNotNull(song);
    }
}