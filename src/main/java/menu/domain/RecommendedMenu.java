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

    public boolean isSameRecommend(String menuName, String coachName) {
        return this.menu.getName().equals(menuName) &&
                this.coach.getName().equals(coachName);
    }
}
