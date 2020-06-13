import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
public class SILab2Test {

    private final SILab2 test = new SILab2();


    @Test
    void everyBranchTest()
    {

        Angle a = new Angle(90,70,30);
        Angle b = new Angle(90,30,30);
        Angle c = new Angle(90,30,70);
        Angle d = new Angle(360,0,0);
        Angle e = new Angle(360,10,10);
        Angle f = new Angle(450,0,0);
        ArrayList<Angle> agli = new ArrayList<>();



//        a=322230
//        d=1296000

        RuntimeException ex;
        agli.add(a);
        ex=assertThrows(RuntimeException.class,() -> test.function(agli));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));
        agli.clear();

        agli.add(c);
        ex=assertThrows(RuntimeException.class,() -> test.function(agli));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));
        agli.clear();

        agli.add(e);
        ex=assertThrows(RuntimeException.class,() -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));
        agli.clear();

        agli.add(f);
        ex=assertThrows(RuntimeException.class,() -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));
        agli.clear();

        agli.add(b);
        assertEquals(325830,test.function(agli).get(0));
        agli.clear();

        agli.add(d);
        assertEquals(1296000,test.function(agli).get(0));

    }

    @Test
    void multipleConditionTest()
    {
        Angle a = new Angle(90,-5,10); //ex5
        Angle b = new Angle(450,0,0); //ex13
        Angle c = new Angle(-5,10,35); //ex13
        Angle d = new Angle(90,30,70); //ex7
        Angle e = new Angle(90,30,30);  //325 830
        Angle f = new Angle(90,30,-5); //ex7
        Angle g = new Angle(360,0,0); // 1 296 000
        Angle h = new Angle(360,0,5); //ex12
        Angle i = new Angle(360,5,0); //ex12
        Angle j = new Angle(90,70,30); //ex5
        ArrayList<Angle> agli = new ArrayList<>();
        //ex5 "The minutes of the angle are not valid!"
        //ex7 "The seconds of the angle are not valid"
        //ex12 "The angle is greater then the maximum"
        //ex13 "The angle is smaller or greater then the minimum"
        RuntimeException ex;

        agli.add(a);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));
        agli.clear();

        agli.add(b);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));
        agli.clear();

        agli.add(c);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));
        agli.clear();

        agli.add(d);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));
        agli.clear();

        agli.add(f);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid"));
        agli.clear();

        agli.add(h);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));
        agli.clear();

        agli.add(i);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));
        agli.clear();

        agli.add(j);
        ex=assertThrows(RuntimeException.class, () -> test.function(agli));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));
        agli.clear();

        agli.add(e);
        assertEquals(325830, test.function(agli).get(0));
        agli.clear();

        agli.add(g);
        assertEquals(1296000,test.function(agli).get(0));
    }

}
