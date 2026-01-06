package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuCategoryTest {

    @ParameterizedTest
    @CsvSource(value = {
            "일식,JAPANESE",
            "한식,KOREAN",
            "중식,CHINESE",
            "아시안,ASIAN",
            "양식,WESTERN"
    })
    @DisplayName("이름으로 MenuCategory를 찾는다.")
    public void nameOf(String menuName, MenuCategory menuCategory) throws Exception {

        // when
        MenuCategory result = MenuCategory.nameOf(menuName);

        // then
        assertThat(result).isEqualTo(menuCategory);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,JAPANESE",
            "2,KOREAN",
            "3,CHINESE",
            "4,ASIAN",
            "5,WESTERN"
    })
    @DisplayName("번호로 MenuCategory를 찾는다.")
    public void numberOf(int number, MenuCategory menuCategory) throws Exception {
        // when
        MenuCategory result = MenuCategory.numberOf(number);

        // then
        assertThat(result).isEqualTo(menuCategory);
    }

}