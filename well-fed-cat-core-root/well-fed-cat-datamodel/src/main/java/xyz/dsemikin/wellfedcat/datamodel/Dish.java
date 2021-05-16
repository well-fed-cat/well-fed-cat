package xyz.dsemikin.wellfedcat.datamodel;

import java.io.Serializable;
import java.util.Set;

public record Dish(
        String publicId,
        String name,
        Set<MealTime> suitableForMealTimes
)
    implements Serializable
{

    public static final int MAX_DISH_NAME_LENGTH = 100; // must be coherent with DB schema

    public Dish {
        final boolean publicIdIsOk =
                publicId.codePoints().allMatch(c ->
                        c < 128 &&
                                (Character.isLetter(c)
                                        || Character.isDigit(c)
                                        || c == Character.codePointAt("_", 0)
                                )
                );
        if (!publicIdIsOk) {
            throw new IllegalArgumentException("publicId must be composed of digits, ascii chars or underscore.");
        }

        if (name.length() > MAX_DISH_NAME_LENGTH) {
            throw new IllegalArgumentException("Max allowed length of dish name is " + MAX_DISH_NAME_LENGTH);
        }
    }
}
