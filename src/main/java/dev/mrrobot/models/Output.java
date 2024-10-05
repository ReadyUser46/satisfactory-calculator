package dev.mrrobot.models;

import dev.mrrobot.enums.ItemEnum;
import lombok.Data;

@Data
public class Output {

    private ItemEnum item;
    private double recipeQuantity;
    private double userQuantity;

    public Output(ItemEnum item, double recipeQuantity) {
        this.item = item;
        this.recipeQuantity = recipeQuantity;
    }
}
