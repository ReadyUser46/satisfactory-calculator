package dev.mrrobot.services;

import dev.mrrobot.enums.ItemEnum;
import dev.mrrobot.models.Output;
import dev.mrrobot.models.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class MaterialBuilder {

    private static MaterialBuilder instace;
    private List<Recipe> recipes;

    public static MaterialBuilder getInstance() {
        if (instace == null) instace = new MaterialBuilder();
        return instace;
    }

    // obtener los inputs necesarios para el item objetivo
    public List<Recipe> getRequiredRecipes(ItemEnum targetItem) {
        List<Recipe> requiredInputs = new LinkedList<>();
        gatherRecipes(targetItem, requiredInputs);
        return requiredInputs;
    }

    // method recursivo que acumula los inputs necesarios
    private void gatherRecipes(ItemEnum item, List<Recipe> accumulatedRecipes) {
        Recipe recipe = findRecipeByItem(item);
        if (recipe != null) {
            accumulatedRecipes.add(recipe);
            recipe.getInputs().forEach(input -> gatherRecipes(input.getItem(), accumulatedRecipes));
        }
    }

    public Recipe findRecipeByItem(ItemEnum item) {
        return recipes.stream().filter(recipe -> recipe.getItemEnum().equals(item)).findFirst().orElse(null);
    }

    public Output selectOutput(Recipe recipe, ItemEnum itemEnum) {
        return recipe.getOutputs().stream().filter(output -> output.getItem().equals(itemEnum)).findFirst().orElse(null);
    }

    public void calculateQuantities(List<Recipe> recipes, double quantityneed) {
/*
        recipes.stream().findFirst().orElse(null).


        (quantityneed / output.getRecipeQuantity()) * input.getRecipeQuantity()*/

    }


}
