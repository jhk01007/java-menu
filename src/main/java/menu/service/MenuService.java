package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.repo.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.ErrorMessage.MENU_NOT_FOUNT_ERROR;

public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu findMenuByName(String name) {
        return menuRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException(MENU_NOT_FOUNT_ERROR.getMessage()));
    }

    public List<MenuRecommend> recommendMenu(List<Coach> coachList) {
        List<MenuRecommend> menuRecommendList = new ArrayList<>();
        for (DayOfTheWeek day : DayOfTheWeek.values()) {
            List<RecommendedMenu> recommendedMenuList = new ArrayList<>(); // 코치 별 추천 메뉴 리스트
            MenuCategory menuCategory = selectMenuCategory(menuRecommendList); // 메뉴 카테고리 선정하기
            // 각 코치별로 해당 카테고리의 메뉴 선정
            for (Coach coach : coachList) {
                List<Menu> menuList = menuRepository.findByMenuCategory(menuCategory); // 해당 카테고리의 메뉴 리스트 가져오기
                Menu recommendedMenu = selectMenu(coach, menuList, menuRecommendList); // 랜덤으로 메뉴 선정하기
                recommendedMenuList.add(new RecommendedMenu(coach, recommendedMenu));
            }
            menuRecommendList.add(new MenuRecommend(day, menuCategory, recommendedMenuList));
        }
        return menuRecommendList;
    }

    private static Menu selectMenu(Coach coach, List<Menu> menuList, List<MenuRecommend> menuRecommendList) {
        while (true) {
            Menu recommendedMenu = getRandomMenu(menuList); // 랜덤으로 메뉴하나 선정하기
            boolean isAlreadyRecommended = false;
            for (MenuRecommend menuRecommend : menuRecommendList) {
                // 해당 코치가 해당 메뉴를 먹은적이 없는지
                isAlreadyRecommended = menuRecommend.isAlreadyRecommended(recommendedMenu, coach);
            }
            // 해당 코치가 해당 메뉴를 먹을수 있고 해당 메뉴를 추천받은 적이 없다면 반환
            if (coach.canEat(recommendedMenu) && !isAlreadyRecommended) {
                return recommendedMenu;
            }
        }
    }

    private static Menu getRandomMenu(List<Menu> menuList) {
        List<String> menuNameList = menuList.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        // 테스트가 문자열을 반환하도록 모킹되어 있기 때문에 문자열 형태로 뽑기
        String recommendMenuName = Randoms.shuffle(menuNameList).get(0);

        return menuList.stream()
                .filter(menu -> menu.getName().equals(recommendMenuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MENU_NOT_FOUNT_ERROR.getMessage()));
    }

    private static MenuCategory selectMenuCategory(List<MenuRecommend> menuRecommendList) {
        MenuCategory menuCategory;
        do {
            // 각 요일별로 카테고리 선정
            menuCategory = MenuCategory.numberOf(Randoms.pickNumberInRange(1, 5));

            // 한주에 해당 카테고리가 2회이상 나왔는지 검증
        } while (!isMenuCategoryMoreThanTwoTimes(menuRecommendList, menuCategory));
        return menuCategory;
    }

    private static boolean isMenuCategoryMoreThanTwoTimes(List<MenuRecommend> menuRecommendList, MenuCategory menuCategory) {
        int count = 0;
        for (MenuRecommend menuRecommend : menuRecommendList) {
            if(menuRecommend.getMenuCategory().equals(menuCategory)) {
                count++;
            }
        }
        return count < 2; // 해당 카테고리가 한 주에 2회 미만 나온 경우
    }
}
