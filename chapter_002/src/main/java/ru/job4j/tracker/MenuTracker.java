package ru.job4j.tracker;

//создаем внешний внутренний класс (внешний класс который находится в файле публичного класса)
class EditItem extends BaseAction{
    public int key(){
        return 2;
    }
    public void execute(Input input, Tracker tracker){
        String id = input.ask("Please enter the Item's Id: ");
        String name = input.ask("Please enter the Item's name: ");
        String desc = input.ask("Please enter the Item's description: ");
        Long create = Long.valueOf(input.ask("Please enter the Item's creation time: "));
        Item item = new Item(name, desc, create);
        item.setId(id);
        tracker.update(item);
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the Item");
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
        this.actions[0] = this.new AddItem();//создаём внутренний обьект и передаем в него значение нашего input и tracker.Обращ.через обьект(нестатический класс)
        this.actions[1] = new MenuTracker.ShowAllItems();//т.к статический внутренний класс, то обращаемся через внешний класс
        this.actions[2] = new EditItem();// т.к внешний класс то вызываем его напрямую
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindById();
        this.actions[5] = this.new FindByName();
        this.actions[6] = new MenuTracker.Exit();
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
        public int key(){
            return 0;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please enter the Item's name ");
            String desc = input.ask("Please enter the Item's description ");
            Long create = Long.valueOf(input.ask("Please enter the Item's creation time "));
            tracker.add(new Item(name, desc, create));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    private class FindByName extends BaseAction{
        public int key(){

            return 5;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please enter the Item's name: ");
            for(Item item : tracker.findByName(name)){
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }

        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find the Item by Name");
        }

    }

    //создаем статический внутренний класс
    private static class ShowAllItems extends BaseAction{
        public int key(){
            return 1;
        }
        public void execute(Input input, Tracker tracker){
            for(Item item : tracker.findAll()){
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all Items");
        }

    }

    private static class DeleteItem extends BaseAction{
        public int key(){
            return 3;
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
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the Item");
        }

    }

    private static class FindById extends BaseAction{
        public int key(){
            return 4;
        }
        public void execute(Input input, Tracker tracker){
            String id = input.ask("Please enter the Item's Id: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s", item.getId(), item.getName()));

        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find the Item by Id");
        }

    }
    private static class Exit extends BaseAction{
        public int key(){
            return 6;
        }
        public void execute(Input input, Tracker tracker){
            System.out.println("Goodbye");
         }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
        }

}
