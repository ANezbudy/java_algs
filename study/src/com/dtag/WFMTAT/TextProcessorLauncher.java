package com.dtag.WFMTAT;

public class TextProcessorLauncher {
    public static void main(String[] args) {
        String text = "Йож был безумен аки барабаба";

//        TextProcessor.transLit(text, 15);
        TextProcessor.reverseTheString(text);
        System.out.println(TextProcessor.checkForbiddenWords(text));
        TextProcessor.stringDevider(text);

    }
}
