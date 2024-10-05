package dev.mrrobot.services;

import dev.mrrobot.enums.ItemEnum;
import dev.mrrobot.models.Input;
import dev.mrrobot.models.Output;
import dev.mrrobot.models.Recipe;
import dev.mrrobot.persistance.ManageExcel;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.LinkedList;
import java.util.List;

@Getter
public class DataRetriever {

    private static DataRetriever instance;
    private List<Recipe> recipes;

    public static DataRetriever getInstance() {
        if (instance == null) instance = new DataRetriever();
        return instance;
    }

    public DataRetriever readExcel() {
        recipes = new LinkedList<>();
        Sheet sheet = ManageExcel.getInstance()
                .openExcel("src/main/resources/excel/satisfactory.xlsx")
                .focusSheet("recipes")
                .getSheet();

        sheet.forEach(row -> {
            if (row.getRowNum() > 11) {

                ItemEnum itemEnum = ItemEnum.getItem((int) row.getCell(1).getNumericCellValue());

                Recipe recipe = new Recipe(itemEnum);
                row.forEach(cell -> {
                    if (cell.getColumnIndex() == 0 || cell.getColumnIndex() == 1) return;

                    if (cell.getColumnIndex() == 2) {
                        recipe.setProducer(cell.getStringCellValue());
                        return;
                    }
                    if (cell.getColumnIndex() == 3) {
                        recipe.setOutputs(List.of(new Output(itemEnum, cell.getNumericCellValue())));
                        return;
                    }

                    if (cell.getNumericCellValue() != 0) {
                        ItemEnum itemEnumCol = ItemEnum.getItem((int) sheet.getRow(1).getCell(cell.getColumnIndex()).getNumericCellValue());
                        recipe.addInput(new Input(itemEnumCol, cell.getNumericCellValue()));
                    }
                });
                recipes.add(recipe);
            }
        });
//todo add logs

        return this;
    }
}
