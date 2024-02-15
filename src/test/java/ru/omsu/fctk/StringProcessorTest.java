package ru.omsu.fctk;

import org.junit.Assert;
import org.junit.Test;

public class StringProcessorTest {

    @Test
    public void CopyNTimeS() {
        StringProcessor a = new StringProcessor();
        String b = "abc";
        Assert.assertEquals("abcabcabcabcabc", a.CopyNTimeS(5, b));
        Assert.assertNotSame(b, a.CopyNTimeS(10, b));
        Assert.assertEquals(b, a.CopyNTimeS(1, b));
        Assert.assertEquals("", a.CopyNTimeS(0, b));
        try {
            a.CopyNTimeS(-1, b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error is accepte");
        }
    }

    @Test
    public void CountTimesInString() {
        StringProcessor a = new StringProcessor();
        String b = "abc";
        String c = "rtyuk";
        Assert.assertEquals(0, a.CountTimesInString(c, b));
        try {
            a.CountTimesInString("", b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error1 is accepte");
        }
        try {
            a.CountTimesInString(c, "");
        } catch (IllegalArgumentException e) {
            System.out.println("Error2 is accepte");
        }
        try {
            a.CountTimesInString(null, b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error3 is accepte");
        }
        try {
            a.CountTimesInString(c, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error4 is accepte");
        }

    }


    @Test
    public void ReplaceNumbersWithWords() {
        StringProcessor a = new StringProcessor();
        Assert.assertEquals("одиндватри, триодинтриодинтридваодиндваодиндваодинодинодин", a.ReplaceNumbersWithWords("123, 3131321212111"));
        Assert.assertEquals("", a.ReplaceNumbersWithWords(""));
        Assert.assertEquals("qwerty9", a.ReplaceNumbersWithWords("qwerty9"));
    }

    @Test
    public void ChangeEverySecondSymbol() {
        StringProcessor a = new StringProcessor();
        StringBuilder r = new StringBuilder("1,2,3");
        StringBuilder r1 = r;
        a.ChangeEverySecondSymbol(r);
        Assert.assertEquals("123", r.toString());
        Assert.assertSame(r1, r);
        r = new StringBuilder();
        Assert.assertEquals("", r.toString());
    }
}