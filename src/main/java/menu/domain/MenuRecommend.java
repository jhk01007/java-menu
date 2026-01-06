package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuRecommend {

    private DayOfTheWeek dayOfTheWeek;
    private MenuCategory menuCategory;
    private List<Map<Coach, Menu>> recommendedMenu;

    public MenuRecommend(DayOfTheWeek dayOfTheWeek, MenuCategory menuCategory, List<Map<Coach, Menu>> recommendedMenu) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.menuCategory = menuCategory;
        this.recommendedMenu = recommendedMenu;
    }
}
