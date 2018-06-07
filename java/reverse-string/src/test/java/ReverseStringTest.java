import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void anEmptyString() {
        assertEquals("", new ReverseString().reverse(""));
    }

    @Test
    public void aWord() {
        assertEquals("tobor", new ReverseString().reverse("robot"));
    }

    @Test
    public void aCapitalizedWord() {
        assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }

    @Test
    public void aSentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }

    @Test
    public void aPalindrome() {
        assertEquals("racecar", new ReverseString().reverse("racecar"));
    }

}
