package xyz.dsemikin.wellfedcat.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/** Day menu without date. */
public class DayMenuSimple implements Serializable {

    private LinkedHashSet<Dish> breakfast;
    private LinkedHashSet<Dish> lunch;
    private LinkedHashSet<Dish> supper;

    public DayMenuSimple() {
        breakfast = new LinkedHashSet<>();
        lunch = new LinkedHashSet<>();
        supper = new LinkedHashSet<>();
    }

    public LinkedHashSet<Dish> getBreakfast() {
        return breakfast;
    }

    public LinkedHashSet<Dish> getLunch() {
        return lunch;
    }

    public LinkedHashSet<Dish> getSupper() {
        return supper;
    }

    public void setBreakfast(final List<Dish> breakfast) {
        this.breakfast = new LinkedHashSet<>(breakfast);
    }

    public void setBreakfast(final Dish breakfastDish) {
        breakfast = new LinkedHashSet<>(singletonArrayList(breakfastDish));
    }

    public void setLunch(final List<Dish> lunch) {
        this.lunch = new LinkedHashSet<>(lunch);
    }

    public void setLunch(final Dish lunchDish) {
        lunch = new LinkedHashSet<>(singletonArrayList(lunchDish));
    }

    public void setSupper(List<Dish> supper) {
        this.supper = new LinkedHashSet<>(supper);
    }

    public void setSupper(final Dish supperDish) {
        supper = new LinkedHashSet<>(singletonArrayList(supperDish));
    }

    private ArrayList<Dish> singletonArrayList(final Dish dish) {
        return new ArrayList<>(Collections.singletonList(dish));
    }
}
