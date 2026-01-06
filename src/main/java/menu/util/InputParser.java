package menu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.ErrorMessage.*;

public class InputParser {

    public static List<String> parseCoachName(String strCoachNameList) {
        String[] split = strCoachNameList.split(",", -1);

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

    public static List<String> parseCantEatMenu(String strMenuList) {
        if(strMenuList.isBlank()) {
            return List.of();
        }

        String[] split = strMenuList.split(",", -1);

        if(split.length > 2) {
            throw new IllegalArgumentException(CANT_EAT_MENU_LENGTH_ERROR.getMessage());
        }

        return Arrays.stream(split)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
