package menu.util;

public enum ErrorMessage {
    COACH_NUM_ERROR("코치는 최소 2명, 최대 5명까지 가능합니다."),
    COACH_NAME_LENGTH_ERROR("코치 이름은 최소 2글자 최대 4글자 까지 가능합니다."),
    CANT_EAT_MENU_LENGTH_ERROR("못 먹는 메뉴는 최소 0개 최대 2개까지 입력 가능합니다."),
    MENU_CATEGORY_NAME_NOT_FOUND_ERROR("해당 이름의 MenuCategory는 존재하지 않습니다."),
    MENU_NOT_FOUNT_ERROR("존재하지 않는 메뉴입니다."),

    ;

    private static final String ERROR_PREFIX = "[ERROR]";


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + " " + message;
    }
}

