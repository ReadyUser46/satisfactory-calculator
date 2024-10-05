package dev.mrrobot.models;

import dev.mrrobot.enums.ItemEnum;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Recipe {

    private ItemEnum itemEnum;
    private List<Input> inputs;
    private List<Output> outputs;
    private String producer;

    public Recipe(ItemEnum itemEnum) {
        this.itemEnum = itemEnum;
        inputs = new LinkedList<>();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }
}
