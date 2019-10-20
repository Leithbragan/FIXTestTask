package fix.test.task.service;

import fix.test.task.model.Board;
import fix.test.task.model.HorsePosition;
import fix.test.task.util.Converter;
import org.springframework.stereotype.Service;

@Service
public class BuildService {

    private Board board;
    private HorsePosition sPosition;
    private HorsePosition ePosition;
    private String width;
    private String height;
    private String start;
    private String end;



    public int initService(String width, String height, String start, String end) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
        initBoard();
        initPositions();
        return buildLogic();
    }

    private void initBoard(){
        board = new Board(Integer.parseInt(height), Integer.parseInt(width));
    }

    private void initPositions() {
        Converter converter = new Converter();
        int[] convertStart = converter.convertPosition(start);
        int[] convertEnd = converter.convertPosition(end);
        sPosition = new HorsePosition(convertStart[1], convertStart[0]);
        ePosition = new HorsePosition(convertEnd[1], convertEnd[0]);
    }

    private int buildLogic() {
        BoardService boardService = new BoardService();
        MoveHorseService moveHorseService = new MoveHorseService();
        int count = boardService.checkMove(board, sPosition, ePosition);
        if (count != -1) {
            if (count == 0) {
                return 0;
            }
        } else {
            return -1;
        }
        return moveHorseService.calculateCountSteps(board, sPosition, ePosition);
    }
}
