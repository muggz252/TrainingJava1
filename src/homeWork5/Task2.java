package homeWork5;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<ForeignWords> words = new ArrayList<>();
        words.add(new ForeignWords("Hallo", "привет"));
        words.add(new ForeignWords("Dog", "собака"));
        words.add(new ForeignWords("Cat", "кошка"));
        words.add(new ForeignWords("beetle", "жук"));
        words.add(new ForeignWords("terrible", "ужасный"));
        words.add(new ForeignWords("kiss", "поцелуй"));
        words.add(new ForeignWords("shit", "дерьмо"));
        words.add(new ForeignWords("car", "автомобиль"));
        words.add(new ForeignWords("game", "игра"));
        words.add(new ForeignWords("go", "ходить"));

        ArrayList<ForeignWords> unknownWords = new ArrayList<>();

        System.out.println("""
                1.Добавить слово
                2.Повторяем слова
                3.Учим слова
                4.Статистика""");
        int input = 0;
        String string;
        while (input != 5) {
            input = Input.nextInt();
            if (input == 1) {
                words.add(new ForeignWords(Input.next("Добавить слово: "),
                        Input.next("Добавить перевод: ")));
            } else if (input == 2) {
                Random rnd = new Random();
                int enter = Input.nextInt("Сколько слов повторяем?: ");
                for (int i = 0; i < enter; i++) {
                    ForeignWords w = words.get(rnd.nextInt(words.size() - 1));
                    System.out.println(w.getWord());
                    w.wordRepeat(Input.next("Перевод: "));
                    if (w.getIndex() == 0) {
                        unknownWords.add(w);
                        words.remove(w);
                    }
                }
            } else if (input == 3) {
                for (int i = 0; i<unknownWords.size(); i++)
                System.out.println(unknownWords.get(i).getWord());
            }
        }
    }


}

class ForeignWords {
    private String word;
    private String translation;
    private int index;

    public ForeignWords(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public int wordRepeat(String text) {
        if (text.equals(getTranslation())) {
            index++;
            System.out.println("Верно!");
            System.out.println("=======");
        } else {
            index = 0;
            System.out.println("Ошибка");
            System.out.println("=======");
        }
        return index;
    }

    public int getIndex() {
        return index;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }


}