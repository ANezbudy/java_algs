package com.dtag.WFMTAT;

import com.dtag.Trie.StreamTrie;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class TextProcessor {
    public static String cyrToLat(char ch) {
        switch (ch) {
            case 'А':
                return "A";
            case 'Б':
                return "B";
            case 'В':
                return "V";
            case 'Г':
                return "G";
            case 'Д':
                return "D";
            case 'Е':
                return "E";
            case 'Ё':
                return "JE";
            case 'Ж':
                return "ZH";
            case 'З':
                return "Z";
            case 'И':
                return "I";
            case 'Й':
                return "Y";
            case 'К':
                return "K";
            case 'Л':
                return "L";
            case 'М':
                return "M";
            case 'Н':
                return "N";
            case 'О':
                return "O";
            case 'П':
                return "P";
            case 'Р':
                return "R";
            case 'С':
                return "S";
            case 'Т':
                return "T";
            case 'У':
                return "U";
            case 'Ф':
                return "F";
            case 'Х':
                return "KH";
            case 'Ц':
                return "C";
            case 'Ч':
                return "CH";
            case 'Ш':
                return "SH";
            case 'Щ':
                return "JSH";
            case 'Ъ':
                return "HH";
            case 'Ы':
                return "IH";
            case 'Ь':
                return "JH";
            case 'Э':
                return "EH";
            case 'Ю':
                return "JU";
            case 'Я':
                return "JA";
            case 'а':
                return "a";
            case 'б':
                return "b";
            case 'в':
                return "v";
            case 'г':
                return "g";
            case 'д':
                return "d";
            case 'е':
                return "e";
            case 'ё':
                return "je";
            case 'ж':
                return "zh";
            case 'з':
                return "z";
            case 'и':
                return "i";
            case 'й':
                return "y";
            case 'к':
                return "k";
            case 'л':
                return "l";
            case 'м':
                return "m";
            case 'н':
                return "n";
            case 'о':
                return "o";
            case 'п':
                return "p";
            case 'р':
                return "r";
            case 'с':
                return "s";
            case 'т':
                return "t";
            case 'у':
                return "u";
            case 'ф':
                return "f";
            case 'х':
                return "kh";
            case 'ц':
                return "c";
            case 'ч':
                return "ch";
            case 'ш':
                return "sh";
            case 'щ':
                return "jsh";
            case 'ъ':
                return "hh";
            case 'ы':
                return "ih";
            case 'ь':
                return "jh";
            case 'э':
                return "eh";
            case 'ю':
                return "ju";
            case 'я':
                return "ja";
            default:
                return String.valueOf(ch);
        }
    }

    public static String wordChanger(String word) {
        switch (word) {
            case "Scrum":
                return "Waterfall";
            case "scrum":
                return "waterfall";
            case "Sprint":
                return "Stage";
            case "sprint":
                return "stage";
            case "Self-organized":
                return "Managed";
            case "self-organized":
                return "managed";
            case "Servant-leader":
                return "Good_manager";
            case "servant-leader":
                return "good_manager";
            default:
                return String.valueOf(word);
        }
    }

    private static ArrayList<Character> stringToCharArrayList(String text) {
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            letters.add(text.charAt(i));
        }
        return letters;
    }

    private static ArrayList<String> stringToArrayList(String text) {
        ArrayList<String> words = new ArrayList<>();
        String[] textArray = text.split(" ");
        for (int i = 0; i < textArray.length; i++) {
            words.add(textArray[i]);
        }
        return words;
    }

    public static void transLit(String text, int length) {
        ArrayList<Character> letters = stringToCharArrayList(text);

        if (length > text.length()) {
            System.out.println("The lenght is to big. Please provide the length less or equal " + text.length());
            return;
        }

        letters.stream().limit(length).map(c -> {
            return cyrToLat(c);
        }).forEach(c -> System.out.print(c));

    }

    public static void censor(String text, ArrayList<String> restrictedWords) {
        ArrayList<String> words = stringToArrayList(text);
        String result = words.stream().map(word -> TextProcessor.wordChanger(word)).reduce((s1, s2) -> s1 + " " + s2)
                .orElse("");
        System.out.println(result);

    }

//    public static void reverseTheString(String text) {
//        ArrayList<String> words = stringToArrayList(text);
//        ArrayList<String> result = new ArrayList<>();
//
//        words.stream().forEachOrdered(word -> result.add(0, word));
//
//        String resultString = "";
//
//        for (String word: result) {
//            resultString = resultString + word + " ";
//        }
//
//        System.out.println(resultString);
//    }

    public static void reverseTheString(String text) {
        ArrayList<String> words = stringToArrayList(text);

        String resultString = words.stream().reduce((s1, s2) -> s2 + " " + s1).orElse("");

        System.out.println(resultString);
    }


    public static Boolean checkForbiddenWords(String text) {
        ArrayList<String> words = stringToArrayList(text);
        return words.stream().anyMatch(word -> "Scrum".equals(word) || "Sprint".equals(word) || "Self-organazid".equals(word) ||
                "Servant_leader".equals(word));
    }

    public static void stringDevider(String text) {
        ArrayList<String> words = stringToArrayList(text);
        String evenLength = words.stream().filter(word -> word.length()%2 == 0).reduce((s1, s2) -> s1 + " " + s2).orElse("");
        String unEvenLength = words.stream().filter(word -> word.length()%2 > 0).reduce((s1, s2) -> s1 + " " + s2).orElse("");
        System.out.println("Words with even length: " + evenLength);
        System.out.println("Words with uneven length: " + unEvenLength);
    }

//    public static void fibonachiStream() {
//        Stream<Integer> fibonachiStr = Stream.iterate(0, n -> )
//    }
}
