package com.zyw.meituan.examination2024_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Q1Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testCase1() {
        String input = "2\n10 10.25\n10 3.5\n20 4.5\n";
        String expectedOutput = "error\n";

        provideInput(input);
        Q1.main(new String[]{});
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testCase2() {
        String input = "2\n10 5.5\n10 6.5\n20 10\n";
        String expectedOutput = "10.00\n";

        provideInput(input);
        Q1.main(new String[]{});
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testCase3() {
        String input = "2\n10 5.5\n10 6.5\n15 3\n";
        String expectedOutput = "12.00\n";

        provideInput(input);
        Q1.main(new String[]{});
        assertEquals(expectedOutput, outContent.toString());
    }
}