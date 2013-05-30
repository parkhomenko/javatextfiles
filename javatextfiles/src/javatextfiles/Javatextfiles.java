package javatextfiles;

import java.util.Map;
import java.util.Scanner;

/**
 * Main class for testing java text file functions
 */
public class Javatextfiles {

    /**
     * The entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length > 0) {
            FileData fileData = new FileDataImpl();

            //Gets the name of the file and fills the map with the data from that file
            System.out.println("Reading the file of words: " + args[0]);
            System.out.println();
            Map<String, Integer> map = fileData.getData(args[0]);
            if (map == null) {
                System.exit(0);
            }
            
            //Gets the option user entered in the console
            //and writes the data either on console or into the file
            String choice = getOutputOption();
            switch(choice) {
                case "1":
                    System.out.println();
                    System.out.println("The result:");
                    System.out.println(map);
                    break;
                case "2":
                    fileData.writeData("output.txt", map);
                    break;
                default:
                    System.out.println("You specified the wrong option of output");
            }
        } else {
            System.out.println("You have to provide a file name as a command line parameter");
        }
    }
    
    /**
     * Reads the option from the console
     * where to write the output data
     * @return the user's choice
     */
    private static String getOutputOption() {
        String choice = "";
        
        System.out.println("Choose the output:");
        System.out.println("1 - on console");
        System.out.println("2 - into the file");
        System.out.print("Your choice: ");
        try (Scanner scanner = new Scanner(System.in)) {
            choice = scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        return choice;
    }
}