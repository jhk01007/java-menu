package menu.domain;

import static menu.util.ErrorMessage.MENU_CATEGORY_NAME_NOT_FOUND_ERROR;

public enum MenuCategory {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private String name;
    private int number;

    MenuCategory(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static MenuCategory nameOf(String name) {
        if(JAPANESE.getName().equals(name))
            return JAPANESE;
        if(KOREAN.getName().equals(name))
            return KOREAN;
        if(CHINESE.getName().equals(name))
            return CHINESE;
        if(ASIAN.getName().equals(name))
            return ASIAN;
        if(WESTERN.getName().equals(name))
            return WESTERN;

        throw new IllegalArgumentException(MENU_CATEGORY_NAME_NOT_FOUND_ERROR.getMessage());
    }
}
