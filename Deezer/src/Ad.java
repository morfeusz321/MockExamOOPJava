import java.util.Objects;
import java.util.Scanner;

public class Ad {
    private String company;
    private String length;
    private double price;

    public Ad(String company, String length, double price) {
        this.company = company;
        this.length = length;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad)) return false;
        Ad ad = (Ad) o;
        return Double.compare(ad.price, price) == 0 && Objects.equals(company, ad.company) && Objects.equals(length, ad.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, length, price);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "company='" + company + '\'' +
                ", length='" + length + '\'' +
                ", price=" + price +
                '}';
    }
    public static Ad read(String line){
        Scanner scanner= new Scanner(line);
        scanner.next();
        scanner.useDelimiter("; ");
        String brand=scanner.next();
        String length= scanner.next();
        scanner.useDelimiter(" ");
        scanner.next();
        return new Ad(brand,length,scanner.nextDouble());

    }
}
