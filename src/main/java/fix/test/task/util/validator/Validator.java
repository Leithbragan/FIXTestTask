package fix.test.task.util.validator;

import fix.test.task.util.Converter;

public class Validator {

    public boolean validate(String width, String height, String start, String end) {
        if (isNotNull(width, height, start, end) && isNotEmpty(width, height, start, end)) {
            if (isNormalFormat(width, height, start, end)) {
                return isInField(width, height, start, end);
            }
        }
        return false;
    }

    public boolean isNotNull(String width, String height, String start, String end) {
        return width != null && height != null && start != null && end != null;
    }

    public boolean isNotEmpty(String width, String height, String start, String end) {
        return !width.isEmpty() && !height.isEmpty() && !start.isEmpty() && !end.isEmpty();
    }

    public boolean isNormalFormat(String width, String height, String start, String end) {
        return width.matches("^([0-9]+)$") && height.matches("^([0-9]+)$") &&
                end.matches("^([A-Z]+[0-9]+)$") && start.matches("^([A-Z]+[0-9]+)$");
    }

    public boolean isInField(String width, String height, String start, String end) {
        Converter convector = new Converter();
        int wBoard = Integer.parseInt(width);
        int hBoard = Integer.parseInt(height);
        int[] sPosition = convector.convertPosition(start);
        int[] ePosition = convector.convertPosition(end);
        return isInField(sPosition, wBoard, hBoard) && isInField(ePosition, wBoard, hBoard);
    }

    public boolean isInField(int[] position, int width, int height){
        return position[0] < width && position[0] >= 0 &&
                position[1] < height && position[1] >= 0;
    }
}
