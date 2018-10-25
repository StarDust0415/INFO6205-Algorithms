package CouponCollector;

import birthday.BirthDay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CouponCollectorTester {
    @Test
    public void testOccupy(){
        CouponColletor<Integer,Integer> couponColletor=new CouponColletor<>(2);
        couponColletor.put(0,0);
        couponColletor.put(2,1);
        assertEquals(couponColletor.ifOccupy(),false);
        couponColletor.put(1,2);
        assertEquals(couponColletor.ifOccupy(),true);
    }
    @Test
    public void testPut(){
        CouponColletor<Integer,Integer> couponColletor=new CouponColletor<>(100);
        assertEquals(couponColletor.ifEncountered(5),false);
        assertEquals(couponColletor.ifEncountered(10),false);
        couponColletor.put(5,15);
        couponColletor.put(10,15);
        assertEquals(couponColletor.ifEncountered(5),true);
        assertEquals(couponColletor.ifEncountered(10),true);
    }
    @Test
    public void testHash(){
        CouponColletor<Integer,Integer> couponColletor=new CouponColletor<>(100);
        assertEquals(couponColletor.hash(5),5);
        assertEquals(couponColletor.hash(105),5);

    }
}
