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
        outputView.printStartMessage(); // 시작 메시지 출력
        List<String> coachNames = readCoachNames(); // 코치의 이름 입력받기
        List<Coach> coachList = createCoachList(coachNames); // 못먹는 메뉴 입력 및 Coach 객체 생성
        List<MenuRecommend> menuRecommendList = menuService.recommendMenu(coachList); // 메뉴 추천 받기
        outputView.printRecommendedResult(menuRecommendList); // 메뉴 출력하기
    }

    private List<Coach> createCoachList(List<String> coachNames) {
        List<Coach> coachList = new ArrayList<>();
        for (String coachName : coachNames) {
            List<String> cantEatMenuNameList = new ArrayList<>();
            while (true) {
                cantEatMenuNameList = readCantEatMenuList(coachName, cantEatMenuNameList);
                if (cantEatMenuNameList == null) break;

                List<Menu> cantEatMenuList = cantEatMenuNameList.stream()
                        .map(menuService::findMenuByName)
                        .collect(Collectors.toList()); // 메뉴 객체로 변환(실제 있는 메뉴인지도 검증)
                coachList.add(new Coach(coachName, cantEatMenuList));
            }
        }
        return coachList;
    }

    private List<String> readCantEatMenuList(String coachName, List<String> cantEatMenuNameList) {
        try {
            cantEatMenuNameList = InputParser.parseCantEatMenu(inputView.readCantEatMenu(coachName));
            return null;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return cantEatMenuNameList;
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
