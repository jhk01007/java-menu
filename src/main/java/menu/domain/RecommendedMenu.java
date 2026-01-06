package menu.domain;

public class RecommendedMenu {

    private Coach coach;
    private Menu menu;

    public RecommendedMenu(Coach coach, Menu menu) {
        this.coach = coach;
        this.menu = menu;
    }

    public Coach getCoach() {
        return new Coach(coach.getName(), coach.getCantEatMenuList());
    }

    public Menu getMenu() {
        return new Menu(menu.getName(), menu.getMenuCategory());
    }

    @Override
    public String toString() {
        return "RecommendedMenu{" +
                "coach=" + coach +
                ", menu=" + menu +
                '}';
    }

    public boolean isSameRecommend(Menu menu, Coach coach) {
        return this.menu.getName().equals(menu.getName()) &&
                this.coach.getName().equals(coach.getName());
    }
}
