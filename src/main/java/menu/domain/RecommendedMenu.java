package menu.domain;

public class RecommendedMenu {

    private Coach coach;
    private Menu menu;

    public RecommendedMenu(Coach coach, Menu menu) {
        this.coach = coach;
        this.menu = menu;
    }

    public Coach getCoach() {
        return coach;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isSameRecommend(Menu menu, Coach coach) {
        return this.menu.getName().equals(menu.getName()) &&
                this.coach.getName().equals(coach.getName());
    }
}
