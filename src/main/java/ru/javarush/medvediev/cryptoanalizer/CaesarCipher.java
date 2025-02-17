package ru.javarush.medvediev.cryptoanalizer;
import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\"-!? "; // криптографический алфавит
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        return shift(text, key);
    }

    public String decrypt(String text) {
        return shift(text, -key);
    }

    private String shift(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                int newIndex = (index + shift + ALPHABET.length()) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            } // игнорируем символы, не входящие в алфавит
        }
        return result.toString();
    }
}
