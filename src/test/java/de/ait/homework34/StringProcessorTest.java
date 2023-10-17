package de.ait.homework34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {

    private StringProcessor stringProcessor;

    @BeforeEach
    public void setUp() {
        stringProcessor = new StringProcessor();
    }

    @DisplayName("Тест двух правильных параметров")
    @Test
    void testConcatenateHappyPath() {
        String result = stringProcessor.concatenate("Hallo ", "Java");
        Assertions.assertEquals("Hallo Java", result);

    }

    @Test
    void testConcatenateSecondParamNull() {
        String result = stringProcessor.concatenate("Hallo ", null);
        Assertions.assertEquals("Hallo null", result);
    }

    @Test
    void testConcatenateFirstParamNull() {
        String result = stringProcessor.concatenate(null, "Hallo ");
        Assertions.assertEquals("nullHallo ", result);
    }

    @Test
    
    void testGetLengthPath(){
        Assertions.assertEquals(4, stringProcessor.getLength("Java"));
    }

    @Test
    void  testGetLengthHappyParamNull(){
        Assertions.assertThrows(NullPointerException.class,() -> {stringProcessor.getLength(null);});
    }

    @Test
    void testIsPalindromeTrue(){
        Assertions.assertTrue(stringProcessor.isPalindrome("HallaH"));
    }

    @Test
    void testIsPalindromeFalse(){
        Assertions.assertFalse(stringProcessor.isPalindrome("Hallo"));
    }

    @Test
    void testReverseHappyPath(){
        Assertions.assertFalse(stringProcessor.isPalindrome("ollaH"), stringProcessor.reverse("Hallo"));
    }

    @Test
    void testReverseParamEmpty(){
        Assertions.assertEquals("", stringProcessor.reverse(""));
    }

}
