package menu.domain;

import java.util.List;

public class Coach {

    private String name;
    private List<Menu> cantEatMenu;

    public Coach(String name, List<Menu> cantEatMenu) {
        this.name = name;
        this.cantEatMenu = cantEatMenu;
    }
}
