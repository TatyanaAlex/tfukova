package ru.job4j.tracker;

//создаем внешний внутренний класс (внешний класс который находится в файле публичного класса)
class EditItem extends BaseAction {

    public EditItem(String name, int key){
        super(name, key);
    }
    public int key() {
        return super.key;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter the Item's Id: ");
        String name = input.ask("Please enter the Item's name: ");
        String desc = input.ask("Please enter the Item's description: ");
        Long create = Long.valueOf(input.ask("Please enter the Item's creation time: "));
        Item item = new Item(name, desc, create);
        item.setId(id);
        tracker.update(item);
    }

}


public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private BaseAction[] actions = new BaseAction[7];

        public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

        // метод, который инициализирует события
    public void fillActions() {
        this.actions[0] = this.new AddItem("Add new Item", 0);//создаём внутренний обьект и передаем в него значение нашего input и tracker.Обращ.через обьект(нестатический класс)
        this.actions[1] = this.new ShowAllItems("Show all Items", 1);//т.к статический внутренний класс, то обращаемся через внешний класс
        this.actions[2] = new EditItem("Edit Item", 2);// т.к внешний класс то вызываем его напрямую
        this.actions[3] = this.new DeleteItem("Delete the Item", 3);
        this.actions[4] = this.new FindById("Find the Item by Id",4);
        this.actions[5] = this.new FindByName("Find the Item by Name",5);
        this.actions[6] = this.new Exit("Exit program", 6);
    }
    // добавляем метод который будет выполнять наши действия
    public void select(int key){
        this.actions[key].execute(this.input, this.tracker);

    }

    //добавляем печать меню
    public void show(){
        for(UserAction action: this.actions){
            if(action != null){
                System.out.println(action.info());
            }
        }
    }

    //создаём нестатический внутренний класс, который находится в теле внешнего класса (MenuTracker)
    private class AddItem extends BaseAction{
        public AddItem(String name, int key) {
            super(name, key);
        }

        public int key(){
            return super.key;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please enter the Item's name ");
            String desc = input.ask("Please enter the Item's description ");
            Long create = Long.valueOf(input.ask("Please enter the Item's creation time "));
            tracker.add(new Item(name, desc, create));

        }

    }

    private class FindByName extends BaseAction{
        public FindByName(String name, int key) {
            super(name, key);
        }

        public int key(){
            return super.key;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the Item's name: ");
            for (Item item : tracker.findByName(name)) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }


    private class ShowAllItems extends BaseAction{
        public ShowAllItems(String name, int key){
        super(name, key);
        }
        public int key(){
            return super.key;
        }

        public void execute(Input input, Tracker tracker){
            for(Item item : tracker.findAll()){
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }

    private class DeleteItem extends BaseAction{

            public DeleteItem(String name, int key) {
            super(name, key);
        }

        public int key(){
            return super.key;
        }

        public void execute(Input input, Tracker tracker){
            String id = input.ask("Please enter the Item's Id: ");
            String desc = input.ask("Please enter the Item's description: ");
            String name = input.ask("Please enter the Item's name: ");
            Long create = Long.valueOf(input.ask("Please enter the Item's creation time: "));
            Item item = new Item(name, desc, create);
            item.setId(id);
            tracker.delete(item);
        }

    }

    private class FindById extends BaseAction{
        public FindById(String name, int key) {
            super(name, key);
        }

        public int key(){
            return super.key;}
        public void execute(Input input, Tracker tracker){
            String id = input.ask("Please enter the Item's Id: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s", item.getId(), item.getName()));

        }
    }

    private class Exit extends BaseAction {
        public Exit(String name, int key) {
            super(name, key);
        }

        public int key() {
            return super.key;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("Goodbye");
        }

    }
}
