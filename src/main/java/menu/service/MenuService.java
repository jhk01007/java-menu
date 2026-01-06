package menu.service;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRecommend;
import menu.repo.MenuRepository;

import java.util.List;

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

        // 각 요일별로 카테고리 선정

        // 한주에 해당 카테고리가 2회이상 나왔는지 검증

        // 각 코치별로 해당 카테고리의 메뉴 선정

        // 해당 코치가 해당 메뉴를 먹은적이 있는지 검증
        return null;
    }
}
