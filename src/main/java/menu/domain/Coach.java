package menu.domain;

import java.util.List;

public class Coach {

    private String name;
    private List<String> cantEatMenu;

    public Coach(String name, List<String> cantEatMenu) {
        this.name = name;
        this.cantEatMenu = cantEatMenu;
    }
}
