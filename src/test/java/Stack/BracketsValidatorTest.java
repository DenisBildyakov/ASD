package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsValidatorTest {
    private final String bracket1 = "(";
    private final String bracket2 = "()";
    private final String bracket3 = "(()";
    private final String bracket4 = "(())";
    private final String bracket5 = "(()()";
    private final String bracket6 = "(()())";
    private final String bracket7 = "())";
    private final String bracket8 = "((((";
    private final String bracket9 = "(((()";
    private final String bracket10 = "())))";
    private final String bracket11 = "()))(";
    private final String bracket12 = ")(";
    private final String bracket13 = "((";
    private final String bracket14 = "))";
    private final String bracket15 = ")))(((";
    private final String bracket16 = ")";

    @Test
    void isValidBrackets() {
        BracketsValidator bracketsValidator = new BracketsValidator();
        assertTrue(bracketsValidator.isValidBrackets(bracket2));
        assertTrue(bracketsValidator.isValidBrackets(bracket4));
        assertTrue(bracketsValidator.isValidBrackets(bracket6));

        assertFalse(bracketsValidator.isValidBrackets(bracket1));
        assertFalse(bracketsValidator.isValidBrackets(bracket3));
        assertFalse(bracketsValidator.isValidBrackets(bracket5));
        assertFalse(bracketsValidator.isValidBrackets(bracket7));
        assertFalse(bracketsValidator.isValidBrackets(bracket8));
        assertFalse(bracketsValidator.isValidBrackets(bracket9));
        assertFalse(bracketsValidator.isValidBrackets(bracket10));
        assertFalse(bracketsValidator.isValidBrackets(bracket11));
        assertFalse(bracketsValidator.isValidBrackets(bracket12));
        assertFalse(bracketsValidator.isValidBrackets(bracket13));
        assertFalse(bracketsValidator.isValidBrackets(bracket14));
        assertFalse(bracketsValidator.isValidBrackets(bracket15));
        assertFalse(bracketsValidator.isValidBrackets(bracket16));
    }
}