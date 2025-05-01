package dev.mrrobot.runner;

import dev.mrrobot.enums.ItemEnum;
import dev.mrrobot.models.Output;
import dev.mrrobot.models.Recipe;
import dev.mrrobot.services.DataRetriever;
import dev.mrrobot.services.MaterialBuilder;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class MainRunner {

    public static void main(String[] args) {

        ItemEnum targetItem = ItemEnum.ARMAZON_MODULAR_PESADO;
        double targetQuantity = 200;

        //services
        DataRetriever dataRetriever = DataRetriever.getInstance();
        MaterialBuilder materialBuilder = MaterialBuilder.getInstance();

        //set 'available recipes' from excel to MaterialBulder
        materialBuilder.setRecipes(dataRetriever.readExcel().getRecipes());

        //requiered recipes for building desired Item
        List<Recipe> requiredRecipes = materialBuilder.getRequiredBuildingRecipes(targetItem);

        //set deseired quantity to the item output desired
        Optional<Output> outputChosen = requiredRecipes.getFirst().getOutputs().stream().filter(output -> output.getItem().equals(targetItem)).findFirst();
        outputChosen.ifPresent(output -> output.setUserQuantity(targetQuantity));

        //calculate all quantities
        materialBuilder.calculateQuantities(targetQuantity, targetItem);

        //console output
        System.out.println("---------------------------------");
        System.out.printf("-%5s OUTPUT: %-17s-%n", "", targetItem.getName());
        System.out.println("---------------------------------");

        AtomicInteger counter = new AtomicInteger();
        requiredRecipes.forEach(recipe -> {
            counter.getAndIncrement();
            System.out.printf("%nRecipe %s => '%s' > building: %s > Inputs:%n", counter, recipe.getItemEnum().getName().toUpperCase(), recipe.getProducer());
            double quantity = materialBuilder.selectOutput(recipe, recipe.getItemEnum()).getUserQuantity();
            recipe.getInputs().forEach(input -> System.out.printf("    -> '%s' => '%s'%n", input.getItem().getName(), quantity));
        });

    }
}
