package ru.job4j.tracker;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random random = new Random();

    public Item add(Item item){
        item.setId(String.valueOf(random.nextInt()));
        this.items[position++] = item;
        return item;
    }

    public void update(Item itemToUpdate){

        for (int i = 0; i < items.length; i++) {
            if(items[i]!=null && items[i].getId().equals(itemToUpdate.getId())){
                items[i] = itemToUpdate;
                break;
            }
        }
    }
    public void delete(Item itemToDelete){
        for (int i = 0; i < items.length ; i++) {
            if(items[i]!=null && items[i].getId().equals(itemToDelete.getId())){
                items[i] = null;
                break;
            }

        }

    }
    public Item[] findAll(){
        Item[] itemsToCopy = new Item[this.position];
        int count = 0;
        for (int i = 0; i <items.length ; i++) {
            if(items[i]!= null){
                itemsToCopy[count]=items[i];
                count++;
            }

        }
        Item[] finalArray = new Item[count];
        System.arraycopy(itemsToCopy,0, finalArray,0, count);
        return finalArray;
    }

    public Item[] findByName(String key){
        Item[] temp = new Item[this.position];
        int count =0;
        for (int i = 0; i< items.length ; i++) {
            if(items[i]!=null && items[i].getName().equals(key)){
                temp[count] = items[i];
                count++;
            }

        }

        Item[] resultArray = new Item[count];
        System.arraycopy(temp,0, resultArray,0, count);
        return resultArray;

    }

    public Item findById(String id){
        Item result = null;
        for(Item item : items){
            if (item != null && item.getId().equals(id) ){
                result = item;
                break;
            }

        }return result;

    }

}





