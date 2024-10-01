package dev.mrrobot;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

@Data
public class ManageExcel {

    private static ManageExcel instance;
    private Workbook workbook;
    private Sheet sheet;

    public static ManageExcel getInstance() {
        if (instance == null) instance = new ManageExcel();
        return instance;
    }

    @SneakyThrows
    public ManageExcel openExcel(String filepath) {
        FileInputStream file = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(file);
        return this;
    }

    public ManageExcel focusSheet(String name) {
        sheet = workbook.getSheet(name);
        return this;
    }

    public ManageExcel focusSheet(int index) {
        sheet = workbook.getSheetAt(index);
        return this;
    }

    @SneakyThrows
    public void closeFile() {
        workbook.close();
    }


}
