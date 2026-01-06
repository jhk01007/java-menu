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

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public boolean isAlreadyRecommended(Menu menu, Coach coach) {
        for (RecommendedMenu recommendedMenu : recommendedMenuList) {
            if(recommendedMenu.isSameRecommend(menu, coach)) { // 이미 해당 코치가 해당 메뉴를 추천 받은적이 있으면
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MenuRecommend{" +
                "dayOfTheWeek=" + dayOfTheWeek +
                ", menuCategory=" + menuCategory +
                ", recommendedMenuList=" + recommendedMenuList +
                '}';
    }
}
