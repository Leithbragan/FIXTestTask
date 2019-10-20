package fix.test.task;

import fix.test.task.util.validator.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void test01() {
        boolean target = validator.isNotEmpty("3", "5", "A1", "A2");
        Assert.assertTrue(target);
    }

    @Test
    public void test02() {
        boolean target = validator.isNotEmpty("", "5", "A1", "A2");
        Assert.assertFalse(target);
    }

    @Test
    public void test11() {
        boolean target = validator.isNotNull("8", "8", "A1", "H8");
        Assert.assertTrue(target);
    }

    @Test
    public void test12() {
        boolean target = validator.isNotNull(null, "8", "A1", "H8");
        Assert.assertFalse(target);
    }

    @Test
    public void test21() {
        boolean target = validator.isInField("5", "5", "A1", "A5");
        Assert.assertTrue(target);
    }

    @Test
    public void test22() {
        boolean target = validator.isInField("5", "5", "A1", "G6");
        Assert.assertFalse(target);
    }

    @Test
    public void test23() {
        boolean target = validator.isInField("5", "5", "B11", "A5");
        Assert.assertFalse(target);
    }

    @Test
    public void test31() {
        int[] pose = {0, 0};
        boolean target = validator.isInField(pose,8,8);
        Assert.assertTrue(target);
    }

    @Test
    public void test32() {
        int[] pose = {8, 8};
        boolean target = validator.isInField(pose,8,8);
        Assert.assertFalse(target);
    }

    @Test
    public void test41() {
        boolean target = validator.isNormalFormat("8", "8", "A1", "A3");
        Assert.assertTrue(target);
    }

    @Test
    public void test42() {
        boolean target = validator.isNormalFormat("8d", "8", "A1", "A3");
        Assert.assertFalse(target);
    }

    @Test
    public void test43() {
        boolean target = validator.isNormalFormat("8", "8", "A1$", "A3");
        Assert.assertFalse(target);
    }

    @Test
    public void test44() {
        boolean target = validator.isNormalFormat("8", "8", "Aa1", "A3");
        Assert.assertFalse(target);
    }
}
