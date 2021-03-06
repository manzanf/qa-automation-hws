package com.playtika.automation.files;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsCounterTest {

    WordsCounter wordsCounter = new WordsCounter();

    @Test
    public void textIsSplitByWhitespace() {
        int wordsCount = wordsCounter.countWords("'I% haVe,4 * 5! dollars Have ");
        assertEquals(6, wordsCount);
    }

    @Test
    public void manySpacesAreTrimmedToOne() {
        assertEquals(2, wordsCounter.countWords("   a3   b"));
    }

    @Test
    public void zeroIsReturnedForTextWithoutWords() {
        assertEquals(0, wordsCounter.countWords(", # ^\\ \n@ \t"));
    }

    @Test
    public void zeroIsReturnedForNullText() {
        assertEquals(0, wordsCounter.countWords(null));
    }

}