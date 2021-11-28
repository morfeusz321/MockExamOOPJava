import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        boolean isOn=true;
        Scanner scanner=new Scanner(System.in);
        Catalog deezer=new Catalog();
        deezer.read(new Scanner( new File("src/deezer.txt")));
        while(isOn){
            printMenu();
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(deezer.getAlbums());
                    break;
                case 2:
                    deezer.addAd(new Scanner(System.in));
                    break;
                case 3:
                    Thread t=new Thread(deezer);
                    t.run();
                    break;
                case 4:
                    deezer.optionFour(new Scanner(System.in));
                    break;
                case 5:
                    System.out.println("How would you like to name the file in which the data is going to be stored?");
                    File file=new File("src/"+scanner.next()+".txt");
                    file.createNewFile();
                    PrintWriter printer=new PrintWriter(file);
                    printer.write(deezer.getAlbums().toString());
                    printer.write(deezer.getAds().toString());
                    printer.flush();
                    printer.close();
                    break;
                case 6:
                    deezer.optionSix();
                    break;
                case 7:
                    isOn=false;
                    break;

            }
        }
    }
    public static void printMenu(){
        System.out.println("Please make your choice:\n" +
                "1 – Print all albums & songs\n" +
                "2 – Add a new advertisement\n" +
                "3 – Enable shuffling of songs\n" +
                "4 – Add song to front of playlist\n" +
                "5 – Write to file\n" +
                "6 – Calculate commercial value\n"+"7 – Stop the program");
    }
}
