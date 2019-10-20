package fix.test.task.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    public int[] convertPosition(String position) {
        int letterVal = 0;
        int power = 0;
        char[] letterCharVal = separationOfOrientation(position, "([a-zA-Z]+)").toCharArray();
        int numberVal = Integer.parseInt(separationOfOrientation(position, "([0-9]+)"));
        for (int i = letterCharVal.length - 1; i >= 0; i--) {

            int buff = Character.getNumericValue(letterCharVal[i]) - 9;

            letterVal += buff * Math.pow(26, power);
            power++;
        }
        return new int[]{letterVal - 1, numberVal - 1};
    }

    public String separationOfOrientation(String pose, String searchTarget) {
        Pattern pattern = Pattern.compile(searchTarget);
        Matcher matcher = pattern.matcher(pose);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "-1";
    }
}
