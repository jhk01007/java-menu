package menu.repo;

import menu.domain.Menu;
import menu.domain.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class MenuRepositoryTest {

    private final MenuRepository menuRepository = new MenuRepository();

    @Test
    @DisplayName("Menu 목록을 반환한다.")
    public void findAll() throws Exception {
        // when
        List<Menu> menuList = menuRepository.findAll();

        // then
        System.out.println(menuList);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "스시,true",
            "없는메뉴,false"
    })
    @DisplayName("특정 이름의 메뉴를 조회한다.")
    public void findByName(String menuName, boolean result) throws Exception {
        // when
        Optional<Menu> optionalMenu = menuRepository.findByName(menuName);

        // then
        assertThat(optionalMenu.isPresent()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "JAPANESE,9",
            "KOREAN,9",
            "CHINESE,9",
            "ASIAN,9",
            "WESTERN,9"
    })
    @DisplayName("특정 카테고리의 메뉴를 조회한다.")
    public void findByMenuCategory(MenuCategory menuCategory, int size) throws Exception {
        // when
        List<Menu> menuList = menuRepository.findByMenuCategory(menuCategory);

        // then
        assertThat(menuList).hasSize(size);
    }

}