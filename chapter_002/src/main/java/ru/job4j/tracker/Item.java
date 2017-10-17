
/**
 * Package for Item.
 * @author Tatyana Fukova (mailto: tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10.17
 */
 package ru.job4j.tracker;

/**
 * Class Item.
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 15.10
 */
public class Item {
    /**
     * unique number(Id) of the Item.
     */
    private String id; //определяет уникальный номер для каждого item
    /**
     * name of the Item.
     */
    private String name;
    /**
     * description of the Item.
     */
    private String description;
    /**
     * time of creating the Item.
     */
    private long create;

    /**
     * конструктор.
     * @param create **the time of creating the item**
     * @param description ** description of the item**
     * @param name **name of the item**
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;

    }
    /**
     * Method for getting item's name.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method for getting item's description.
     * @return description
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Method for getting time of item's creation.
     * @return create
     */
    public long getCreate() {
        return this.create;
    }
    /**
     * Method for getting Id of the Item.
     * @return Id
     */
    public String getId() {
        return this.id;
    }
    /**
     * Method for setting Id of the Item.
     * @param id **identification number of the item**
     */

    public void setId(String id) {
        this.id = id;
    }
}
