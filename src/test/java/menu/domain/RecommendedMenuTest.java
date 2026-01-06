package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RecommendedMenuTest {

    @ParameterizedTest
    @CsvSource(value = {
            "스시,토마스,true",
            "스시,토미,false",
            "나시고렝,토마스,false",
    })
    @DisplayName("코치의 이름이 같고 메뉴의 이름이 같은지")
    public void isSameRecommend(String menuName, String coachName, boolean result) throws Exception {
        // given
        Menu menu = new Menu("스시", MenuCategory.JAPANESE);
        Coach coach = new Coach("토마스", List.of());
        RecommendedMenu recommendedMenu = new RecommendedMenu(coach, menu);

        // when
        boolean sameRecommend = recommendedMenu.isSameRecommend(menuName, coachName);

        // then
        assertThat(sameRecommend).isEqualTo(result);
    }

}