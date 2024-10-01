package dev.mrrobot;

import org.apache.poi.ss.usermodel.Sheet;

public class RetrieveData {

    private void readExcel() {
        Sheet sheet = ManageExcel.getInstance()
                .openExcel("src/main/resources/satisfactory.xlsx")
                .focusSheet("recipes")
                .getSheet();

        sheet.forEach(row -> {
            if (row.getRowNum() > 0) {
                //todo create new instance model
                row.forEach(cell -> {
                    switch (cell.getColumnIndex()) {
                        case 0:
                            //todo instance set atributes from cell.getStringCellValue();
                            break;
                    }
                });
            }
        });

    }
}
