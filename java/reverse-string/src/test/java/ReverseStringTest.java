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

    @Ignore("Remove to run test")
    @Test
    public void aCapitalizedWord() {
        assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }

    @Ignore("Remove to run test")
    @Test
    public void aSentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }

    @Ignore("Remove to run test")
    @Test
    public void aPalindrome() {
        assertEquals("racecar", new ReverseString().reverse("racecar"));
    }

}
