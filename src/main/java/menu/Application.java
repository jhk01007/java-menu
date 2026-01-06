package menu;

import menu.repo.MenuRepository;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new MenuRecommendRunner(
                new InputView(),
                new OutputView(),
                new MenuService(new MenuRepository())
        ).run();
    }
}
