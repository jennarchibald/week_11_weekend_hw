import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger jenn;

    @Before
    public void before(){
        jenn = new Passenger("Jenn");
    }

    @Test
    public void hasName(){
        assertEquals("Jenn", jenn.getName());
    }
}
