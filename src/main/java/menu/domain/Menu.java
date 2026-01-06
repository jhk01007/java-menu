package menu.domain;

import java.util.Objects;

public class Menu {
    private String name;
    private MenuCategory menuCategory;

    public Menu(String name, MenuCategory menuCategory) {
        this.name = name;
        this.menuCategory = menuCategory;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", menuCategory=" + menuCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) && menuCategory == menu.menuCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menuCategory);
    }
}
