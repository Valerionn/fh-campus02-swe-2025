package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);



        verifyNoMoreInteractions(cal);
    }


    @Test
    public void testParserTest02Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.modulo);


        verifyNoMoreInteractions(cal);

    }



    // Division by Zero Test (vgl Calc Klasse)


    // Test auf unerlaubte Zeichen statt erforderlichem Modulo Operator

    @Test()
    public void testParserInvalidOperator() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        try {
            parser.parse(new File("src/test/resources/test05.xml"));

            fail("We want an exception");
        } catch (CalculatorException e) {
            assertEquals("Unsupported Operation!", e.getMessage());
        }

    }


}