package assignment5;

/**
 * Created by THamilton on 7/2/2014.
 */
public abstract class AbstractAddressBook {

    /**
     * @method  loadEntries()
     * @method  printEntries()
     * @param args
     */
    public static void main(String[] args){}

    /**
     * @method printEntries()
     * This method uses the Scanner Class to scan the file using a while loop.
     * It then keeps adding to an ArrayList<String> until it encounters the 5th element.
     * Once it has encountered the 5th element, an ArrayList<AddressBookEntry> adds the prior
     * 5 elements. The counter is implemented to keep track of the index of the String ArrayList.
     * Once all of the elements have been added, Collections.sort takes the AddressBookEntry ArrayList
     * and uses the compareTo method to compare last names. If both last names are the same,
     * their first names are used. Then, a foreach loop prints out the variables accordingly.
     */
    private static void printEntries(){}

    /**
     * @method  loadEntries()
     * This method uses the PrintStream class to print to the file that was created.
     * Scanner Class then uses System.in to capture user input at the console. A while
     * loop controls the flow of information asking the user 5 questions. Each response
     * is saved into a variable and used at the end of the loop to be printed.
     */
    private static void loadEntries(){}

    /**
     * This method was used to make it easier to read the questions that were being asked.
     * Also, it saves time from having to write out System.out.println() everytime.
     * @param question
     */
    private static void question(String question) {
        System.out.println(question);
    }

    /**
     * This method was used primarily as the above method but for more generic qualities.
     * Also to make the print out more easily readable.
     * @param str
     */
    private static void print(String str){
        System.out.println(str);
    }

}
