package fix.test.task.service;

import fix.test.task.model.Board;
import fix.test.task.model.HorsePosition;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public int checkMove(Board board, HorsePosition start, HorsePosition end) {
        int width = board.getWight();
        int height = board.getHeight();

        if (start.equals(end)) {
            //точки старта и финиша совпадают
            return 0;
        } else if (width < 3 && height < 3) {
            //слишком маленькая доска и точки не совпадают
            return -1;
        } else if (width == 3 && height == 2 || width == 2 && height == 3) {
            if ((start.getLetter() == 2 || end.getLetter() == 2) && (width == 3)) {
                //слишком маленькая доска и невозможно достичь из А в Б (горизонталь)
                return -1;
            } else if ((start.getNumber() == 2 || end.getNumber() == 2) && (height == 3)) {
                //слишком маленькая доска и невозможно достичь из А в Б (вертикаль)
                return -1;
            } else if (start.getLetter() == end.getLetter() || start.getNumber() == end.getNumber()) {
                //слишком маленькая доска и финиш находится над или под стартом
                return -1;
            }
        } else if ((width == 3 && height == 3) && ((start.getNumber() + 1 == 2 && start.getLetter() + 1 == 2)
                || (end.getNumber() + 1 == 2 && end.getLetter() + 1 == 2))) {
            //старт или финиш находится в середине поля 3х3
            return -1;
        }
        //доска с размером больше 4 w && h удовлетворяет
        return 1;
    }
}
