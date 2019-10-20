package fix.test.task;

import fix.test.task.util.Converter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new Converter();
    }

    @Test
    public void test01() {
        int[] pose = {0, 0};
        int[] target = converter.convertPosition("A1");
        Assert.assertArrayEquals(target, pose);
    }

    @Test
    public void test11() {
        String target = converter.separationOfOrientation("A","([a-zA-Z]+)");
        Assert.assertEquals(target, "A");
    }

    @Test
    public void test12() {
        String target = converter.separationOfOrientation("A","([0-9]+)");
        Assert.assertNotEquals(target, "A");
    }
}
