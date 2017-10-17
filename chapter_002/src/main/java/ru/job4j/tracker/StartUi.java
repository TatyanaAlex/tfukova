
/**
 * Package for StartUi.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
 package ru.job4j.tracker;

/**
 * Class StartUi.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class StartUi {

    /**
     * variable corresponding to the menu's item number 0.
     */
    private static final String ADD = "0";
    /**
     * variable corresponding to the menu's item number 1.
     */
    private static final String SHOWAll = "1";
    /**
     * variable corresponding to the menu's item number 2.
     */
    private static final String EDIT = "2";
    /**
     * variable corresponding to the menu's item number 3.
     */
    private static final String DELETE = "3";
    /**
     * variable corresponding to the menu's item number 4.
     */
    private static final String FINDBYID = "4";
    /**
     * variable corresponding to the menu's item number 5.
     */
    private static final String FINDBYNAME = "5";
    /**
     * variable corresponding to the menu's item number 6.
     */
    private static final String EXIT = "6";

    /**
     * object of the Input class.
     */
    private Input input;
    /**
     * object of the Tracker class.
     */
    private Tracker tracker;

    /**
     * конструктор.
     * @param input **initialization of the input **
     * @param tracker ** initialization of the tracker**
     */
    public StartUi(Input input, Tracker tracker) {

        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Main Method.
     * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
     * @param args **enter to the program**
     * @version $I$
     * @since 15.10
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUi(input, tracker).init();

    }

    /**
     * Method to show the menu and react to the user's input.
     */
    public void init() {

        String chosenItem = input.ask("" + "0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" + "5. Find items by name\n" + "6. Exit Program\n" + "Select:");

        if (ADD.equals(chosenItem)) {
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0], array[1], Long.getLong(array[2]));
            tracker.add(item);
            this.init();
        }
        if (SHOWAll.equals(chosenItem)) {
            tracker.findAll();
            this.init();
        }
        if (EDIT.equals(chosenItem)) {
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0], array[1], Long.getLong(array[2]));
            tracker.update(item);
            this.init();
        }
        if (DELETE.equals(chosenItem)) {
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0], array[1], Long.getLong(array[2]));
            tracker.delete(item);
            this.init();
        }
        if (FINDBYID.equals(chosenItem)) {
            String answer = input.ask("Please enter 'Id'");
            tracker.findById(answer);
            this.init();

        }
        if (FINDBYNAME.equals(chosenItem)) {
            String answer = input.ask("Please enter 'name'");
            tracker.findByName(answer);
            this.init();
        }
        if (EXIT.equals(chosenItem)) {
            System.out.println("Goodbye");
        }
    }

}
