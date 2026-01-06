package menu.repo;

import menu.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


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
    
    
    @Test
    @DisplayName("특정 이름의 메뉴를 조회한다.")
    public void findByName() throws Exception {
        // given
        
        // when
        
        // then
    }

}