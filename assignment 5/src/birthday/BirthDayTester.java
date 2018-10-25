package birthday;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BirthDayTester {
    @Test
    public void testPut(){
        BirthDay<Integer,Integer> birthDay=new BirthDay<>(100);
        assertEquals(birthDay.ifEncountered(5),false);
        assertEquals(birthDay.ifEncountered(10),false);

        birthDay.put(5,15);
        birthDay.put(10,15);
        assertEquals(birthDay.ifEncountered(5),true);
        assertEquals(birthDay.ifEncountered(10),true);
    }
    @Test
    public void testHash(){
        BirthDay<Integer,Integer> birthDay=new BirthDay<>(100);
        assertEquals(birthDay.hash(5),5);
        assertEquals(birthDay.hash(105),5);

    }
}
