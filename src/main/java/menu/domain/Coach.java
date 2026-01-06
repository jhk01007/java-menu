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

    public List<Menu> getCantEatMenuList() {
        return List.copyOf(cantEatMenuList);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", cantEatMenuList=" + cantEatMenuList +
                '}';
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
