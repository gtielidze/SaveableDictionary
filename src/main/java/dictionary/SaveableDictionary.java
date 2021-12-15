/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gio
 */
public class SaveableDictionary {

    private ArrayList<Word> words;
    private String file;

    public SaveableDictionary() {
        this.words = new ArrayList<>();
    }

    public SaveableDictionary(String file) {
        this.words = new ArrayList<>();
        this.file = file;
    }

    public void add(String words, String translations) {
        for (int i = 0; i < this.words.size(); i++) {
            if (words.equals(this.words.get(i).getFirst())
                    || words.equals(this.words.get(i).getSecond())
                    || translations.equals(this.words.get(i).getFirst())
                    || translations.equals(this.words.get(i).getSecond())) {
                return;
            }
        }
        this.words.add(new Word(words, translations));
    }


    public boolean load() {
        try {
            Scanner fileReader = new Scanner(Paths.get(this.file));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            fileReader.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void delete(String word) {
        words.removeIf(words1 -> words1.getFirst().equals(word) || words1.getSecond().equals(word));
    }

    public String translate(String word) {
        String translate = null;
        for (int i = 0; i < words.size(); i++) {
            if (word.equals(words.get(i).getFirst())) {
                translate = words.get(i).getSecond();
            } else if (word.equals(words.get(i).getSecond())) {
                translate = words.get(i).getFirst();
            }
        }

        return translate;
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (int i = 0; i < words.size(); i++) {
                writer.println(words.get(i).getFirst() + ":" + words.get(i).getSecond());
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
