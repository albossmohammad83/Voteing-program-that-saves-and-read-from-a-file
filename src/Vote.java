/*
 * Extra credit assignment
 * Description: get to vote to one of two people REE or YEE and save the results in a file
 * Name: Mohammad Abdelrahman
 * ID: 920158652
 * Class: CSC 211-02
 * Semester: fall 2020
 */
import java.io.*;
import java.util.Scanner;
public class Vote {
    // a public variable that stores the file location
    public static String fileLocation = "C:/Users/albos/IdeaProjects/Vote/src/Results.txt";

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in); //creat an objet input to store the user input
        int[] votes = readFromFile(); // read the saved votes from file and store it in an array
        int countREE = votes[0]; // stores the first int in array which represents vote count for REE
        int countYEE = votes[1];// stores the second int in array which represents vote count for YEE
        // after we take the saved votes from the file we erase the file and make it ready for the next votes
        PrintWriter writer = new PrintWriter(fileLocation);
        writer.print("");
        writer.close();

        int menu = 0; // variable to hold the user input for the menu options
        int exit = 0; // variable exit to exit the loop
        int vote = 0; // the user input for voting either for REE(1) or YEE(2)
        do {
            System.out.println("Welcome to main menu!");
            System.out.println("Enter the number corresponding to these options\n1) Vote\n2) View Results\n3) Exit");
            menu = input.nextInt(); // assigning the user input to menu
            switch (menu) {
                case 1: // in case the user wants to vote they prompted to vote for REE or YEE
                    System.out.println("Enter 1 to vote for REE or 2 to vote for YEE");
                    vote = input.nextInt(); // store the user's vote to variable vote
                    if (vote == 1) { // if user votes for REE add one to the vote count for REE (countREE)
                        countREE++;
                        System.out.println("You voted for REE");
                    } else if (vote == 2) {// if user votes for YEE add one to the vote count for YEE (countYEE)
                        countYEE++;
                        System.out.println("You voted for YEE");
                    } else {
                        System.out.println("You entered wrong number!");
                    }
                    break;
                case 2: // in case the user wants to show the current votes for REE and YEE
                    System.out.println("REE has " + countREE + " Votes.");
                    System.out.println("YEE has " + countYEE + " Votes.");
                    break;
                case 3: // exit the loop
                    exit = menu;
                    break;
                default:
                    System.out.println("Wrong number!! Enter 1, 2 or 3!");
                    break;
            }

        } while (exit != 3);
        System.out.println("You exited the program!");
        writeToFile("" + countREE); // write the vote count for REE in a file
        writeToFile("" + countYEE); // write the vote count for YEE in a file
    }


    public static void writeToFile(String data) throws IOException { // method to write data to a file
        File file = new File(fileLocation);
        FileWriter writer;
        writer = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(data.toString() + "\n"); // store each data in a new line
        bufferWriter.close();
    }
    // method to read data from a file and store it in an array
    public static int[] readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileLocation));
        int[] votes = new int[100];
        int i = 0;
        while (scanner.hasNextInt()) { // loop as long as there is an int in the file
            votes[i++] = scanner.nextInt(); // add the ints in array of votes
        }
        return votes; // return the array of votes
    }
}
