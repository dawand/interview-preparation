package dsa_koffman_ch2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnitTest {

//    static OrderedList list;

    @BeforeAll
    static void setup() {
    }

    @Test
    void addElementTest(){
        OrderedList list = new OrderedList();
        list.add(5);
        assertEquals(list.get(0), 5);
    }

    @Test
    void correctOrderTest(){
        OrderedList<Integer> list = new OrderedList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        int[] order = new int[3];
        int i=0;

       for (Integer n: list){
            order[i] = n;
            i++;
        }
        assertArrayEquals(new int[] {5,6,7}, order);
    }
}
