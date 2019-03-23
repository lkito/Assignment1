// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TabooTest {

    @Test
    public void tabooTest1(){
        List<Integer> rule = Arrays.asList(1, 2, 3, 1, 2, 3, 5);

        Taboo<Integer> tab = new Taboo<>(rule);
        Set<Integer> set = new HashSet<>(Arrays.asList(2));
        assertEquals(set, tab.noFollow(1));
        set = new HashSet<>(Arrays.asList(1, 5));
        assertEquals(set, tab.noFollow(3));
        assertEquals(Collections.emptySet(), tab.noFollow(5));
    }


    @Test
    public void tabooTest2(){
        List<Integer> rule = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 100, null, 100);
        Taboo<Integer> tab = new Taboo<>(rule);
        assertEquals(Collections.emptySet(), tab.noFollow(100));

        Set<Integer> set = new HashSet<>(Arrays.asList(2, 100));
        assertEquals(set, tab.noFollow(2));
    }

    @Test
    public void tabooTest3(){
        List<Integer> rule = new ArrayList<>(Arrays.asList(2, 2, 2, 2, null, 2, 2, 2));
        Taboo<Integer> tab = new Taboo<>(rule);

        List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 5)); //Arrays.asList(1, 2, 5, 10, 5);
        tab.reduce(test);
        assertEquals(Arrays.asList(1, 2, 5, 10, 5), test);
        test = new ArrayList<>(Arrays.asList());
        tab.reduce(test);
        assertEquals(Arrays.asList(), test);
    }

    @Test
    public void tabooTest4(){
        List<Integer> rule = Arrays.asList(10, 534, null, 534, 1000, 534, 22, 22, 534, 2000);
        Taboo<Integer> tab = new Taboo<>(rule);

        List<Integer> test = new ArrayList<>(Arrays.asList(534, 1000, 1000, 1000, 22, 534, 2000, 10, 10, 2000));
        tab.reduce(test);
        assertEquals(Arrays.asList(534, 534, 10, 10, 2000), test);
    }

    @Test
    public void tabooTest5(){
        List<Integer> rule = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Taboo<Integer> tab = new Taboo<>(rule);

        List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 2, 9, 8, 7, 8, 3, 3, 3, 2));
        tab.reduce(test);
        assertEquals(Arrays.asList(1, 4, 6, 2, 9, 7, 3, 3, 3), test);
    }

    @Test
    public void tabooTest6(){
        List<String> rule = Arrays.asList("bla", "blu", "bli", "Bla", "blo", "blo");
        Taboo<String> tab = new Taboo<>(rule);

        List<String> test = new ArrayList<>(Arrays.asList("bla", "bla", "blu", "bli", "bla", "blo",
                "blo", "Bla", "blo", "blo", "blue"));
        tab.reduce(test);
        assertEquals(Arrays.asList("bla", "bla", "bli", "bla", "blo", "Bla", "blue"), test);
    }

    @Test
    public void tabooTest7(){
        List<Character> rule = Arrays.asList('A', 'a', null, 'B', 'b', null, 'C', 'c', null, 'D', 'd', null);
        Taboo<Character> tab = new Taboo<>(rule);

        List<Character> test = new ArrayList<>(Arrays.asList('A', 'a', 'a', 'a', 'a', 'B', 'b', 'b', 'b',
                'A', 'a', 'a', 'R', 'A', 'a', '!'));
        tab.reduce(test);
        assertEquals(Arrays.asList('A', 'B', 'A', 'R', 'A', '!'), test);
    }
}
