
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

    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};
    private Input input;
    private ITracker tracker;

    /**
     * конструктор.
     * @param input **initialization of the input **
     * @param tracker ** initialization of the tracker**
     */
    public StartUi(Input input, ITracker tracker) {

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
        Input input = new ValidateInput();
        ITracker tracker = new Tracker();
        new StartUi(input, tracker).init();
    }

    /**
     * Method to show the menu and react to the user's input.
     */
    public void init() {

        //input.ask("" + "0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" + "5. Find items by name\n" + "6. Exit Program\n" + "Select:");
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();

        do {
            menu.show();
            menu.select(input.ask("Select: ", ranges));
        } while (!"yes".equals(input.ask("Exit (yes/no)? ")));
    }

}
