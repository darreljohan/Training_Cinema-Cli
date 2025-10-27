import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String info){
        System.out.print(info);
        return scanner.nextLine();
    }

    public static int inputInteger(String info){
        while (true) {
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Input tidak valid - masukkan kembali");
            }
        }
    }

    public static int inputInteger(String info, int minNumber, int maxNumber){
            try{
                int userInput = Integer.parseInt(scanner.nextLine());
                if(userInput < minNumber || userInput > maxNumber){
                    throw new NumberFormatException("Input melebih kapasitas");
                }
                return userInput;
            }catch (NumberFormatException e){
                throw new NumberFormatException("Harus masukan angka 1 - 4, silahkan coba lagi!");
            }
    }

    public static LocalDateTime inputDateTime(String info){
        System.out.print(info);
        try{
            String userInput = scanner.nextLine();
            return formatUtility.parseFormattedDate(userInput);
        }catch (DateTimeParseException e){
            throw new RuntimeException("Format tanggal salah, coba lagi.");
        }
    }

}
