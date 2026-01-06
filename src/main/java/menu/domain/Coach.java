package menu.domain;

import java.util.List;

public class Coach {

    private String name;
    private List<Menu> cantEatMenuList;

    public Coach(String name, List<Menu> cantEatMenuList) {
        this.name = name;
        this.cantEatMenuList = cantEatMenuList;
    }

    public String getName() {
        return name;
    }

    /**
     * 해당 메뉴를 먹을 수 있는지 여부
     */
    public boolean canEat(Menu menu) {
        for (Menu cantEatMenu : cantEatMenuList) {
            if(cantEatMenu.equals(menu)) {
                return false;
            }
        }
        return true;
    }
}
