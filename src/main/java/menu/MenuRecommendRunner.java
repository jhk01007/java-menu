package menu;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRecommend;
import menu.service.MenuService;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendRunner {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuRecommendRunner(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }


    public void run() {

        outputView.printStartMessage();

        // 코치의 이름 입력받기
        List<String> coachNames = readCoachNames();

        // 못먹는 메뉴 입력 및 Coach 객체 생성
        List<Coach> coachList = readCantEatMenuList(coachNames);

        List<MenuRecommend> menuRecommendList = menuService.recommendMenu(coachList); // 메뉴 추천 받기

        // 메뉴 출력하기
        outputView.printRecommendedResult(menuRecommendList);
    }

    private List<Coach> readCantEatMenuList(List<String> coachNames) {
        List<Coach> coachList = new ArrayList<>();
        for (String coachName : coachNames) {
            while (true) {
                try {
                    List<String> cantEatMenuNameList = InputParser.parseCantEatMenu(inputView.readCantEatMenu(coachName));
                    List<Menu> cantEatMenuList = cantEatMenuNameList.stream()
                            .map(menuService::findMenuByName)
                            .collect(Collectors.toList()); // 메뉴 객체로 변환(실제 있는 메뉴인지도 검증)
                    coachList.add(new Coach(coachName, cantEatMenuList));
                    break;
                } catch (IllegalArgumentException e) {
                    outputView.printError(e.getMessage());
                }
            }
        }
        return coachList;
    }

    private List<String> readCoachNames() {
        while (true) {
            try {
                return InputParser.parseCoachName(inputView.readCoachName());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
