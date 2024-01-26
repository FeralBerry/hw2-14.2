import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayTest {
    private final StringArray stringArray = new StringArray();
    private final String[] example = new String[]{"раз","два","три","четыре","пять"};
    @Test
    void add() {
        String actual = stringArray.add("раз");
        String expected = "раз";
        Assertions.assertEquals(expected,actual);
    }
    @ParameterizedTest
    @MethodSource("params")
    void testAdd(String first, String second, String third, String four, String five, String[] expected) throws IndexAddExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        int index = 2;
        String actual = stringArray.add(index,"3");
        Assertions.assertEquals(expected[index],actual);
    }
    @ParameterizedTest
    @MethodSource("params")
    void set(String first, String second, String third, String four, String five, String[] expected) throws IndexAddExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        int index = 2;
        String actual = stringArray.set(index,"3");
        Assertions.assertEquals(expected[index], actual);
    }
    @ParameterizedTest
    @MethodSource("params")
    void remove(String first, String second, String third, String four, String five, String[] expected) throws NotHaveItemExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        String actual = stringArray.remove("два");
        Assertions.assertEquals(expected[1], actual);
    }
    @ParameterizedTest
    @MethodSource("params")
    void testRemove(String first, String second, String third, String four, String five, String[] expected) throws NotHaveItemExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        String actual = stringArray.remove(1);
        Assertions.assertEquals(expected[1], actual);
    }
    @ParameterizedTest
    @MethodSource("params")
    void contains(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        Assertions.assertTrue(stringArray.contains("два"));
    }
    @ParameterizedTest
    @MethodSource("params")
    void indexOf(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        assertEquals(1, stringArray.indexOf("два"));
    }
    @ParameterizedTest
    @MethodSource("params")
    void lastIndexOf(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        assertEquals(1, stringArray.lastIndexOf("два"));
    }
    @ParameterizedTest
    @MethodSource("params")
    void get(String first, String second, String third, String four, String five) throws NotHaveItemExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        String expected = "два";
        assertEquals(stringArray.get(1), expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void testEquals(String first, String second, String third, String four, String five) throws NotHaveItemExceptions {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        StringArray expected = new StringArray();
        expected.add("раз");
        expected.add("два");
        expected.add("три");
        expected.add("четыре");
        expected.add("пять");
        assertTrue(stringArray.equals(expected));
    }

    @ParameterizedTest
    @MethodSource("params")
    void size(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        assertEquals(5,stringArray.size());
    }

    @ParameterizedTest
    @MethodSource("params")
    void isEmpty(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        assertFalse(stringArray.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("params")
    void clear(String first, String second, String third, String four, String five) {
        stringArray.add(first);
        stringArray.add(second);
        stringArray.add(third);
        stringArray.add(four);
        stringArray.add(five);
        stringArray.clear();
        assertTrue(stringArray.isEmpty());
    }
    public static Stream<Arguments> params(){
        return Stream.of(Arguments.of("раз","два","три","четыре","пять",new String[]{"раз","два","3","четыре","пять"}));
    }
}