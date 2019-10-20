package fix.test.task;

import fix.test.task.model.Board;
import fix.test.task.model.HorsePosition;
import fix.test.task.service.BoardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {

    private Board board;
    private BoardService boardService;

    @Before
    public void setUp() {
        boardService = new BoardService();
    }

    @Test
    public void test01() {
        board = new Board(8, 8);
        HorsePosition sPosition = new HorsePosition(0, 1);
        HorsePosition ePosition = new HorsePosition(0, 1);
        int target = boardService.checkMove(board, sPosition, ePosition);
        Assert.assertEquals(target, 0);
    }

    @Test
    public void test02() {
        board = new Board(8, 8);
        HorsePosition sPosition = new HorsePosition(0, 1);
        HorsePosition ePosition = new HorsePosition(0, 2);
        int target = boardService.checkMove(board, sPosition, ePosition);
        Assert.assertEquals(target, 1);
    }

    @Test
    public void test03() {
        board = new Board(3, 3);
        HorsePosition sPosition = new HorsePosition(0, 1);
        HorsePosition ePosition = new HorsePosition(1, 1);
        int target = boardService.checkMove(board, sPosition, ePosition);
        Assert.assertEquals(target, -1);
    }

    @Test
    public void test04() {
        board = new Board(3, 2);
        HorsePosition sPosition = new HorsePosition(0, 1);
        HorsePosition ePosition = new HorsePosition(2, 1);
        int target = boardService.checkMove(board, sPosition, ePosition);
        Assert.assertEquals(target, -1);
    }

    @Test
    public void test05() {
        board = new Board(1, 1);
        HorsePosition sPosition = new HorsePosition(0, 0);
        HorsePosition ePosition = new HorsePosition(2, 1);
        int target = boardService.checkMove(board, sPosition, ePosition);
        Assert.assertEquals(target, -1);
    }
}
