package menu.view;

import menu.domain.Coach;
import menu.domain.MenuRecommend;
import menu.domain.RecommendedMenu;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    private static final String START_BRACKET = "[ ";
    private static final String END_BRACKET = " ]";
    private static final String SPLITTER = " | ";

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendedResult(List<MenuRecommend> menuRecommendList) {
        System.out.println("메뉴 추천 결과입니다.");

        StringBuilder sb = new StringBuilder();
        buildDayOfWeek(menuRecommendList, sb); // 요일
        buildMenuCategory(menuRecommendList, sb); // 메뉴 카테고리
        buildCoachMenu(menuRecommendList, sb); // 코치별 추천 메뉴

        System.out.println(sb);
    }

    private static void buildDayOfWeek(List<MenuRecommend> menuRecommendList, StringBuilder sb) {
        sb.append(START_BRACKET).append("구분");
        for (MenuRecommend menuRecommend : menuRecommendList) {
            sb.append(SPLITTER);
            sb.append(menuRecommend.getDayOfTheWeek().getName());
        }
        sb.append(END_BRACKET).append("\n");
    }

    private static void buildMenuCategory(List<MenuRecommend> menuRecommendList, StringBuilder sb) {
        sb.append(START_BRACKET).append("카테고리");
        for (MenuRecommend menuRecommend : menuRecommendList) {
            sb.append(SPLITTER);
            sb.append(menuRecommend.getMenuCategory());
        }
        sb.append(END_BRACKET).append("\n");
    }

    private static void buildCoachMenu(List<MenuRecommend> menuRecommendList, StringBuilder sb) {
        HashMap<String, StringBuilder> coachMenuMap = buildCoachMenuMap(menuRecommendList);
        for (String coachName : coachMenuMap.keySet()) {
            coachMenuMap.get(coachName).append(END_BRACKET);
            sb.append(coachMenuMap.get(coachName));
            sb.append("\n");
        }
    }

    private static HashMap<String, StringBuilder> buildCoachMenuMap(List<MenuRecommend> menuRecommendList) {
        HashMap<String, StringBuilder> coachMenuMap = new HashMap<>();
        for (MenuRecommend menuRecommend : menuRecommendList) {
            for (RecommendedMenu recommendedMenu : menuRecommend.getRecommendedMenuList()) {
                Coach coach = recommendedMenu.getCoach();

                StringBuilder coachMenuBuilder = new StringBuilder();
                coachMenuMap.putIfAbsent(coach.getName(),
                        coachMenuBuilder.append(START_BRACKET).append(coach.getName()));

                coachMenuMap.get(coach.getName()).append(SPLITTER).append(recommendedMenu.getMenu().getName());
            }
        }
        return coachMenuMap;
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
