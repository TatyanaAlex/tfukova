package ru.job4j.tracker;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        String result = answers[position];
        position++;
        return result;
    }
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }

    }
}
