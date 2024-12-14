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
    public void testParserTest01Xml() throws Exception {
        CalculatorImpl cal = new CalculatorImpl();

        Parser parser = new Parser(cal);

        parser.parse(new File("src/test/resources/test06.xml"));

        cal.push(1.0);
        cal.push(2.0);
        assertEquals(3, cal.perform(Operation.add), 0);


    }
}
