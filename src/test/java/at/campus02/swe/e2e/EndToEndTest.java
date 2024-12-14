package at.campus02.swe.e2e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;
import org.junit.Test;

import java.io.File;


public class EndToEndTest {

    @Test
    public void testParserTest06Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(3, parser.parse(new File("src/test/resources/test06.xml")), 0);

    }


    @Test
    public void testParserTest07Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        assertEquals(6, parser.parse(new File("src/test/resources/test07.xml")), 0);

    }
}
