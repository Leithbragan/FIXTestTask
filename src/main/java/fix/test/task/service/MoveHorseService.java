package fix.test.task.service;

import fix.test.task.model.Board;
import fix.test.task.model.HorsePosition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoveHorseService {

    public boolean moveExist(HorsePosition lastPosition, int[] shift, HorsePosition checkPosition) {
        return lastPosition.getNumber() + shift[0] == checkPosition.getNumber() &&
                lastPosition.getLetter() + shift[1] == checkPosition.getLetter();
    }

    public int calculateCountSteps(Board board, HorsePosition start, HorsePosition end) {
        int[][] shifts = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        List<HorsePosition> lastSteps = new ArrayList<>();
        List<HorsePosition> currentSteps = new ArrayList<>();
        int countSteps = 2;
        int[][] field = new int[board.getHeight()][board.getWight()];
        boolean isFinish = true;
        field[start.getNumber()][start.getLetter()] = 1;
        lastSteps.add(start);
        do {

            for (int h = 0; h < field.length; h++) {
                for (int v = 0; v < field[1].length; v++) {
                    HorsePosition currentPosition = new HorsePosition(h, v);
                    for (HorsePosition pose : lastSteps) {
                        for (int[] shift : shifts) {
                            if (moveExist(pose, shift, currentPosition)) {
                                if (field[h][v] == 0) {
                                    field[h][v] = countSteps;
                                    currentSteps.add(currentPosition);
                                    if (currentPosition.equals(end)) {
                                        return countSteps - 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            lastSteps = currentSteps;
            currentSteps = new ArrayList<>();
            countSteps++;
        }
        while (isFinish);
        return -1;
    }
}
