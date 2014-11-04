package assignment5;
/**
 * Course: CS 3401
 * Section:
 * Name: Thomas Hamilton
 * Processor: Alan Shaw
 * Assignment #: 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class AddressBook {

    public static void main(String[] args) {
        loadEntries();
        printEntries();
    }

    /**
     * This method uses the Scanner Class to scan the file using a while loop.
     * It then keeps adding to an ArrayList<String> until it encounters the 5th element.
     * Once it has encountered the 5th element, an ArrayList<AddressBookEntry> adds the prior
     * 5 elements. The counter is implemented to keep track of the index of the String ArrayList.
     * Once all of the elements have been added, Collections.sort takes the AddressBookEntry ArrayList
     * and uses the compareTo method to compare last names. If both last names are the same,
     * their first names are used. Then, a foreach loop prints out the variables accordingly.
     *
     * @method printEntries()
     */
    private static void printEntries() {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<AddressBookEntry> addressBookEntryArrayList = new ArrayList<AddressBookEntry>();
            File file = new File("C:\\Users\\THamilton\\Desktop\\AddressBook.txt");
            Scanner scanner = new Scanner(file);
            int counter1 = 0;
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
                if ((counter1 % 5) == 4) addressBookEntryArrayList.add(new AddressBookEntry(
                        arrayList.get(counter1 - 4),
                        arrayList.get(counter1 - 3),
                        arrayList.get(counter1 - 2),
                        arrayList.get(counter1 - 1),
                        arrayList.get(counter1)
                ));
                counter1++;
            }
            Collections.sort(addressBookEntryArrayList);
            int counter2 = 1;
            for (AddressBookEntry in : addressBookEntryArrayList) {
                print(counter2 + ".\t" + in.getFirstName() + " " + in.getLastName());
                print("\t" + in.getStreetAddress());
                print("\t" + in.getCityStateZip());
                print("\t" + in.getPhoneNumber());
                print("");
                counter2++;
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        }
    }

    /**
     * This method uses the PrintStream class to print to the file that was created.
     * Scanner Class then uses System.in to capture user input at the console. A while
     * loop controls the flow of information asking the user 5 questions. Each response
     * is saved into a variable and used at the end of the loop to be printed.
     *
     * @method loadEntries()
     */
    private static void loadEntries() {
        try {
            File file = new File("C:\\Users\\THamilton\\Desktop\\AddressBook.txt");
            PrintStream printStream = new PrintStream(file);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                question("Enter a person's first name: ");
                String fName = scanner.nextLine();
                if (fName.equals("done") || fName.equals("none")) {
                    break;
                } else {
                    question("Enter a person's last name: ");
                    String lName = scanner.nextLine();

                    question("Enter the person's street address: ");
                    String sAddress = scanner.nextLine();

                    question("Enter the person's city, state and zip: ");
                    String cStateZip = scanner.nextLine();

                    question("Enter the person's phone number: ");
                    String pNumber = scanner.nextLine();

                    printStream.println(fName);
                    printStream.println(lName);
                    printStream.println(sAddress);
                    printStream.println(cStateZip);
                    printStream.println(pNumber);
                }
            }
            printStream.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    /**
     * This method was used to make it easier to read the questions that were being asked.
     * Also, it saves time from having to write out System.out.println() everytime.
     *
     * @param question
     */
    private static void question(String question) {
        System.out.println(question);
    }

    /**
     * This method was used primarily as the above method but for more generic qualities.
     * Also to make the print out more easily readable.
     *
     * @param str
     */
    private static void print(String str) {
        System.out.println(str);
    }
}
