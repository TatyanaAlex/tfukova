package ru.job4j.inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Tatyana (tatyanafukova@gmail.com)
 * @version 1
 * @since 06.02.19
 */
public class Chat {

    public void initial() {
        List<String> list = getPhrases();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/main/java/ru/job4j/inputoutput/textlog.txt"), "utf-8"))) {
            userInput(writer, list);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to get and read phrases.
     *
     * @return list phrases.
     */
    private List<String> getPhrases() {
        File file = new File("src/main/java/ru/job4j/inputoutput/chat.txt");
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * method to analyze user´s input.
     */
    private void userInput(Writer writer, List<String> list) throws IOException {
        System.out.println("Hello, please enter your text ");
        writer.write("Hello, please enter your text ");
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while (sc.hasNext()) {
            String temp = sc.next();
            ((BufferedWriter) writer).newLine();
            writer.write(temp);
            if (temp.equals("continue")) {
                stop = false;
            } else if (temp.equals("stop") || stop) {
                stop = true;
                continue;
            } else if (temp.equals("finish")) {
                System.out.println("Goodbye");
                ((BufferedWriter) writer).newLine();
                writer.write("Goodbye");
                break;
            }
            Random rand = new Random();
            int n = rand.nextInt(list.size());
            System.out.println(list.get(n));
            ((BufferedWriter) writer).newLine();
            writer.write(list.get(n));
        }
        writer.close();
    }
}
