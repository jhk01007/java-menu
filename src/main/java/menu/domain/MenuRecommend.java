package menu.domain;

import java.util.List;

public class MenuRecommend {

    private DayOfTheWeek dayOfTheWeek;
    private MenuCategory menuCategory;
    private List<RecommendedMenu> recommendedMenuList;

    public MenuRecommend(DayOfTheWeek dayOfTheWeek, MenuCategory menuCategory, List<RecommendedMenu> recommendedMenuList) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.menuCategory = menuCategory;
        this.recommendedMenuList = recommendedMenuList;
    }
}
