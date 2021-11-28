import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdTest {
    @Test
    void Ad() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Assertions.assertNotNull(cycki);
    }

    @Test
    void getCompany() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Assertions.assertEquals("ING Bank", cycki.getCompany());
    }

    @Test
    void getLength() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Assertions.assertEquals("0:20",cycki.getLength());
    }

    @Test
    void setLength() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        cycki.setLength("0:35");
        Assertions.assertEquals("0:35",cycki.getLength());
    }

    @Test
    void getPrice() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Assertions.assertEquals(0.05,cycki.getPrice());
    }

    @Test
    void testEquals() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Ad ruchanie=new Ad("ING Bank","0:20",0.05);
        Ad dupa=new Ad("ING","0:20",0.05);
        Assertions.assertTrue(cycki.equals(ruchanie));
        Assertions.assertFalse(cycki.equals(dupa));
    }

    @Test
    void testToString() {
        Ad cycki=new Ad("ING Bank","0:20",0.05);
        Assertions.assertEquals("Ad{" +
                "company='" + "ING Bank"+ '\'' +
                ", length='" + "0:20" + '\'' +
                ", price=" + 0.05 +
                '}',cycki.toString());
    }

    @Test
    void read() {
        Ad ruchanie=Ad.read("AD ING Bank; 0:20; 0.05 euros");
        Assertions.assertNotNull(ruchanie);
    }
}