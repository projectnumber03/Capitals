import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private int records = 0;

    public void printRecordsAmount() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("capitals.txt"));
        while (scan.hasNextLine()){
            scan.nextLine();
            records++;
        }
        System.out.println("База содержит " + records + " записей");
        scan.close();
    }

    public void play() throws FileNotFoundException {
        while (true){
            Scanner scan = new Scanner(new File("capitals.txt"));
            int pick = (int)(Math.random() * records + 1);
            for (int i = 0; i < pick - 1; i++){
                scan.nextLine();
            }
            String[] record = scan.nextLine().split(";");
            System.out.println("Столица государства \"" + record[0] + "\"?");
            Scanner scn = new Scanner(System.in);
            String guess = scn.nextLine();
            if(guess.equals("exit")){
                break;
            }else{
                if(guess.toLowerCase().equals(record[1].toLowerCase())){
                    System.out.println("Верно");
                }else {
                    System.out.println("Неверно, правильный ответ - " + record[1]);
                }
            }
        }
    }
}
