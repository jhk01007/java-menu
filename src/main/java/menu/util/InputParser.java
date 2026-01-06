package menu.util;

import java.util.ArrayList;
import java.util.List;

import static menu.util.ErrorMessage.COACH_NAME_LENGTH_ERROR;
import static menu.util.ErrorMessage.COACH_NUM_ERROR;

public class InputParser {

    public static List<String> parseCoachName(String strCoachName) {
        String[] split = strCoachName.split(",", -1);

        List<String> coachNames =  new ArrayList<>();
        validateCoachNum(split);
        for (String coachName : split) {
            validateCoachName(coachName);
            coachNames.add(coachName);
        }

        return coachNames;
    }

    private static void validateCoachNum(String[] split) {
        if (split.length < 2 || split.length > 5) {
            throw new IllegalArgumentException(COACH_NUM_ERROR.getMessage());
        }
    }

    private static void validateCoachName(String coachName) {
        if (coachName.length() < 2 || coachName.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR.getMessage());
        }
    }
}
