package com.dtag.WFMTAT;

import com.dtag.Trie.StreamTrie;
import com.dtag.Trie.TrieElement;

public class StreamTreiLauncher {
    public static void main(String[] args) {
        TrieElement trieRoot = new TrieElement();
        trieRoot.addWord("cлово");
        trieRoot.addWord("дело");
        trieRoot.addWord("дуло");
        trieRoot.addWord("тело");

        String text = "Эй, ты, где тело. Доставай дуло, выноси тело. Делай дело.";

        StreamTrie streamTrie = new StreamTrie(trieRoot);

        // experiment with stream later

        for(int i = 0; i < text.length(); i++) {
            streamTrie.handleSymbol(text.charAt(i));
        }
    }
}
