package menu.service;

import menu.domain.*;
import menu.repo.MenuRepository;
import menu.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MenuServiceTest {

    private final MenuService menuService = new MenuService(
            new MenuRepository()
    );

    @Test
    @DisplayName("특정 이름의 메뉴를 찾는다.")
    public void findMenuByName_success() throws Exception {
        // given
        String name = "그라탱";

        // when
        Menu menu = menuService.findMenuByName(name);

        // then
        assertThat(menu.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("해당 이름의 메뉴가 존재하지 않으면 에러가 발생한다.")
    public void findMenuByName_fail() throws Exception {
        // given
        String name = "없는메뉴";

        // when // then
        assertThatThrownBy(() -> menuService.findMenuByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MENU_NOT_FOUNT_ERROR.getMessage());
    }

    @Test
    @DisplayName("메뉴를 추천한다.")
    public void recommendMenu() throws Exception {
        // given
        Menu menu1 = createMenu("우동", MenuCategory.JAPANESE);
        Menu menu2 = createMenu("스시", MenuCategory.JAPANESE);
        Coach coach1 = createCoach("토미", Arrays.asList(menu1, menu2));

        Menu menu3 = createMenu("뇨끼", MenuCategory.WESTERN);
        Menu menu4 = createMenu("월남쌈", MenuCategory.ASIAN);
        Coach coach2 = createCoach("제임스", Arrays.asList(menu3, menu4));

        Menu menu5 = createMenu("마파두부", MenuCategory.CHINESE);
        Menu menu6 = createMenu("고추잡채", MenuCategory.CHINESE);
        Coach coach3 = createCoach("포코", Arrays.asList(menu5, menu6));

        // when
        List<MenuRecommend> menuRecommendList = menuService.recommendMenu(Arrays.asList(coach1, coach2, coach3));

        // then
        assertThat(menuRecommendList).hasSize(DayOfTheWeek.values().length);
        assertThat(menuRecommendList)
                .extracting(MenuRecommend::getDayOfTheWeek)
                        .containsExactly(DayOfTheWeek.values());
        System.out.println(menuRecommendList);
    }

    private static Menu createMenu(String name, MenuCategory menuCategory) {
        return new Menu(name, menuCategory);
    }

    private static Coach createCoach(String coachName, List<Menu> cantEatMenuList) {
        Coach 토미 = new Coach(coachName, cantEatMenuList);
        return 토미;
    }

}