package dev.mrrobot.runner;

import dev.mrrobot.enums.ItemEnum;
import dev.mrrobot.models.Recipe;
import dev.mrrobot.services.DataRetriever;
import dev.mrrobot.services.MaterialBuilder;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class MainRunner {

    public static void main(String[] args) {

        ItemEnum desiredItem = ItemEnum.VIGA_ACERO;
        double desiredquantity = 200;

        //services
        DataRetriever dataRetriever = DataRetriever.getInstance();
        MaterialBuilder materialBuilder = MaterialBuilder.getInstance();

        List<Recipe> recipes = dataRetriever.readExcel().getRecipes();

        materialBuilder.setRecipes(recipes);
        List<Recipe> requiredRecipes = materialBuilder.getRequiredRecipes(desiredItem);

        Recipe originrecipe = materialBuilder.findRecipeByItem(desiredItem);
        Objects.requireNonNull(originrecipe.getOutputs().stream().filter(output -> output.getItem().equals(desiredItem)).findFirst().orElse(null)).setUserQuantity(desiredquantity);
        requiredRecipes.addFirst(originrecipe);

        materialBuilder.calculateQuantities(requiredRecipes, desiredquantity);

        //console output
        System.out.println("---------------------------------");
        System.out.printf("-%5s OUTPUT: %-17s-%n", "", desiredItem.getName());
        System.out.println("---------------------------------");
        AtomicInteger counter = new AtomicInteger();
        requiredRecipes.forEach(recipe -> {
            counter.getAndIncrement();
            System.out.printf("%nRecipe %s > %-12s > Inputs:%n", counter, recipe.getProducer());
            recipe.getInputs().forEach(input -> System.out.println("    -> " + input.getItem().getName()));
        });

    }
}
