package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        loadEntries();
        printEntries();
    }

    private static void printEntries() {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<AddressBookEntry> addressBookEntryArrayList = new ArrayList<AddressBookEntry>();
            File file = new File("C:\\Users\\THamilton\\Desktop\\AddressBook.txt");
            Scanner scanner = new Scanner(file);
            int counter1 = 0;
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
                if ( (counter1 % 5) == 4 ) addressBookEntryArrayList.add(new AddressBookEntry(
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
            for(AddressBookEntry in : addressBookEntryArrayList){
                print(counter2 + ".\t" +in.getFirstName() + " " + in.getLastName());
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

    private static void loadEntries() {
        try {
            File file = new File("C:\\Users\\THamilton\\Desktop\\AddressBook.txt");
            PrintStream printStream = new PrintStream(file);
            Scanner scanner = new Scanner(System.in);
            while(true){
                question("Enter a person's first name: ");
                String fName = scanner.nextLine();
                if ( fName.equals("done") || fName.equals("none")){
                    break;
                }
                else {
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

    private static void question(String question) {
        System.out.println(question);
    }

    private static void print(String str){
        System.out.println(str);
    }
}
