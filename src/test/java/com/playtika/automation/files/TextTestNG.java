package com.playtika.automation.files;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TextTestNG {
    Text sentences = new Text("  one way,1 way -oNe*  ticket '");
    Text emptyText = new Text(",  ^\\ @\n %\t ");

    @Test(groups = {"getTopWordsChecks"})
    public void sortedSetOfUniqueWordsIsReturned() {
        assertThat(sentences.getTopWords(4), contains("1", "one", "ticket", "way"));
    }

    @Test(groups = {"getTopWordsChecks"}, priority = 1,
            dependsOnMethods = "sortedSetOfUniqueWordsIsReturned")
    public void wordsWithDifferentCaseAreTheSame() {
        assertThat(new Text("One wAy onE Way").getTopWords(4), contains("one", "way"));
    }

    @Test(groups = {"getTopWordsChecks"})
    public void cutSetIsReturnedIfNLessThanSetSize() {
        assertThat(sentences.getTopWords(2), hasSize(2));
    }

    @Test(groups = {"getTopWordsChecks"})
    public void fullSetIsReturnedIfNMoreThanSetSize() {
        assertThat(sentences.getTopWords(5), hasSize(4));
    }

    @Test(groups = {"getTopWordsChecks"}, priority = 2,
            expectedExceptions = IllegalArgumentException.class)
    public void topCannotBeZero() throws Exception {
        sentences.getTopWords(0);
    }

    @Test(groups = {"getTopWordsChecks"}, priority = 2)
    public void topWordsIsEmptyForTextWithoutWords() {
        assertThat(emptyText.getTopWords(3), empty());
    }

    @Test(groups = {"getFrequenciesChecks"})
    public void wordFrequenciesAreReturnedForTextWithBothCases() {
        HashMap<String, Long> expectedFrequencies = new HashMap<>();
        expectedFrequencies.put("one", 2L);
        expectedFrequencies.put("way", 2L);
        expectedFrequencies.put("ticket", 1L);
        expectedFrequencies.put("1", 1L);
        assertThat(sentences.getFrequencies(), is(equalTo(expectedFrequencies)));
    }

    @Test(groups = {"getFrequenciesChecks"}, priority = 2)
    public void wordFrequenciesIsEmptyForTextWithoutWords() {
        assertThat(emptyText.getFrequencies().keySet(), hasSize(0));
    }

    @Test(groups = {"getLengthInCharsChecks"})
    public void lengthInCharsIsReturnedForText() {
        assertThat(sentences.getLengthInChars(), CoreMatchers.is(19));
    }

    @Test(groups = {"getLengthInCharsChecks"}, priority = 2)
    public void lengthIsZeroForTextWithoutWords() {
        assertThat(emptyText.getLengthInChars(), equalTo(0));
    }

    @Test(groups = {"getTopWordsChecks"}, priority = 2, expectedExceptions = IllegalArgumentException.class)
    public void nullTextShouldNotBeProcessed() {
        new Text(null);
    }
}