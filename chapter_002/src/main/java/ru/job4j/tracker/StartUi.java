package ru.job4j.tracker;

public class StartUi {

    private static final String ADD = "0";
    private static final String ShowAll = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String EXIT = "6";

    private Input input;
    private Tracker tracker;

    public StartUi(Input input, Tracker tracker){

        this.input=input;
        this.tracker = tracker;
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUi(input, tracker).init();

    }

    public void init(){

        String chosenItem = input.ask("" +
                "0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" +
                "Select:");


        if(ADD.equals(chosenItem)){
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0],array[1],Long.getLong(array[2]));
            tracker.add(item);
            this.init();
        }
        if(ShowAll.equals(chosenItem)){
            tracker.findAll();
            this.init();
        }
        if(EDIT.equals(chosenItem)){
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0],array[1],Long.getLong(array[2]));
            tracker.update(item);
            this.init();
        }
        if(DELETE.equals(chosenItem)){
            String answer = input.ask("Please enter 'name', 'description', 'create' separated by comma");
            String[] array = answer.split(",");
            Item item = new Item(array[0],array[1],Long.getLong(array[2]));
            tracker.delete(item);
            this.init();
        }
        if(FindById.equals(chosenItem)){
            String answer = input.ask("Please enter 'Id'");
            tracker.findById(answer);
            this.init();

        }
        if(FindByName.equals(chosenItem)){
            String answer = input.ask("Please enter 'name'");
            tracker.findByName(answer);
            this.init();
        }
        if(EXIT.equals(chosenItem)){
            System.out.println("Goodbye");
        }
    }

}
