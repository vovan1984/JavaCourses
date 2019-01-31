package clinic;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest
{

    /**
     * Check getName() method.
     */
    @Test
    public void testGetName()
    {
        Animal a = new Animal("UnitTest");
        assertEquals(a.getName(), "UnitTest");
    }

    /**
     * Check changeName() method.
     */
    @Test
    public void testChangeNameMethod()
    {
        Animal a = new Animal("UnitTest");
        a.changeName("Korova");
        assertEquals(a.getName(), "Korova");
    }
}
