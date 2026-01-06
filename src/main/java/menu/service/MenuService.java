package menu.service;

import menu.domain.Menu;
import menu.repo.MenuRepository;

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
}
