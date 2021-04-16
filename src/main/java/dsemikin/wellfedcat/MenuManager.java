package dsemikin.wellfedcat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MenuManager {

    private final DishPicker dishPicker;

    public MenuManager() {

        dishPicker = new DishPicker();

    }

    public void fillMenu(final Menu menu) {
        for (DayMenu dayMenu : menu) {
            dayMenu.setBreakfast(pickNextDish());
            dayMenu.setLunch(pickNextDish());
            dayMenu.setSupper(pickNextDish());
        }
    }

    public Menu generateMenu(final int daysCount) {
        Menu menu = new Menu();
        for (int kk = 0; kk < daysCount; kk++) {
            menu.add(new DayMenu());
        }
        fillMenu(menu);
        return menu;
    }

    public Menu generateMenu(final DayOfWeek startDay, final int daysCount) {
        Menu menu = new Menu();
        DayOfWeek currentDay = startDay;
        for (int kk = 0; kk < daysCount; kk++) {
            menu.add(new DayMenu(currentDay));
            currentDay = currentDay.plus(1);
        }
        fillMenu(menu);
        return menu;
    }

    public Menu generateMenu(final LocalDate startDay, final int daysCount) {
        Menu menu = new Menu();
        LocalDate currentDay = startDay;
        for (int kk = 0; kk < daysCount; kk++) {
            menu.add(new DayMenu(currentDay));
            currentDay = currentDay.plusDays(1);
        }
        fillMenu(menu);
        return menu;
    }

    public Menu generateWeekMenu(final LocalDate startDay) {
        return generateMenu(startDay, 7);
    }

    private Dish pickNextDish() {
        return dishPicker.pickNextDishAndUpdateHistory();
    }
}
