package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MenuRecommendTest {

    @ParameterizedTest
    @CsvSource(value = {
            "제임스,스시,true",
            "토니,스시,false",
            "제임스,라자냐,false"
    })
    @DisplayName("이미 해당코치가 해당 메뉴를 추천받은적이 있는지 여부를 반환한다.")
    public void isAlreadyRecommended(String coachName, String menuName, boolean result) throws Exception {
        // given
        Coach coach = new Coach("제임스", List.of());
        Menu menu = new Menu("스시", MenuCategory.JAPANESE);
        MenuRecommend menuRecommend =
                new MenuRecommend(DayOfTheWeek.FRI, MenuCategory.JAPANESE, List.of(new RecommendedMenu(coach, menu)));

        Coach targetcoach = new Coach(coachName, List.of());
        Menu targetMenu = new Menu(menuName, MenuCategory.JAPANESE);

        // when
        boolean alreadyRecommended = menuRecommend.isAlreadyRecommended(targetMenu, targetcoach);

        // then
        assertThat(alreadyRecommended).isEqualTo(result);
    }

}