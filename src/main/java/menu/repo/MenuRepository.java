package menu.repo;

import menu.domain.Menu;
import menu.domain.MenuCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    private static final String MENU_FILE_PATH = "./src/main/resources/menu.txt";

    public List<Menu> findAll() {
        return loadAll();
    }


    /** 전체 조회 */
    private List<Menu> loadAll() {
        Path path = Path.of(MENU_FILE_PATH);

        // 파일이 아직 없으면 "빈 목록" 반환
        if (!Files.exists(path)) {
            return List.of();
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            List<Menu> menus = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                String categoryName = line.split(":")[0];
                String menuList = line.substring(categoryName.length() + 2);
                String[] split = menuList.split(",", -1);

                for (String menuName : split) {
                    MenuCategory menuCategory = MenuCategory.nameOf(categoryName);
                    menus.add(new Menu(menuName, menuCategory));
                }
            }
            return menus;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
