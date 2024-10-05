package dev.mrrobot.models;

import dev.mrrobot.enums.ItemEnum;
import lombok.Data;

@Data
public class Input {

    private ItemEnum item;
    private double recipeQuantity;
    private double userQuantity;

    public Input(ItemEnum item, double recipeQuantity) {
        this.item = item;
        this.recipeQuantity = recipeQuantity;
    }

    @Override
    public String toString() {
        return String.format("Input -> '%s' - '%s'", item.getName(), recipeQuantity);
    }


}
