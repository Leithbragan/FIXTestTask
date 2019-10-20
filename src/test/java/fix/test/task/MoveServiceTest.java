package fix.test.task;

import fix.test.task.model.Board;
import fix.test.task.model.HorsePosition;
import fix.test.task.service.MoveHorseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveServiceTest {

    private Board board;
    private MoveHorseService moveService;

    @Before
    public void setUp() {
        moveService = new MoveHorseService();
    }

    @Test
    public void test01() {
        int[] shift = {-2, -1};
        HorsePosition lPosition = new HorsePosition(2, 2);
        HorsePosition cPosition = new HorsePosition(0, 1);
        boolean target = moveService.moveExist(lPosition, shift, cPosition);
        Assert.assertTrue(target);
    }

    @Test
    public void test02() {
        int[] shift = {2, 1};
        HorsePosition lPosition = new HorsePosition(0, 0);
        HorsePosition cPosition = new HorsePosition(0,1);
        boolean target = moveService.moveExist(lPosition, shift, cPosition);
        Assert.assertFalse(target);
    }

    @Test
    public void test11() {
        board = new Board(8, 8);
        HorsePosition sPosition = new HorsePosition(4, 3);
        HorsePosition ePosition = new HorsePosition(6, 5);
        int target = moveService.calculateCountSteps(board, sPosition, ePosition);
        Assert.assertEquals(target, 4);
    }

    @Test
    public void test12() {
        board = new Board(8, 8);
        HorsePosition sPosition = new HorsePosition(0, 0);
        HorsePosition ePosition = new HorsePosition(7, 7);
        int target = moveService.calculateCountSteps(board, sPosition, ePosition);
        Assert.assertEquals(target, 6);
    }
}
