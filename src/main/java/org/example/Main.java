package org.example;

import com.aspose.cells.*;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Create a new workbook
        Workbook workbook = new Workbook();

// Obtain the reference of the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);
        ArrayList<String> dataCells = new ArrayList<>();
        dataCells.add("Category1");
        dataCells.add("Category2");
        dataCells.add("Category3");
// Add sample values to cells
        Iterator<String> it = dataCells.iterator();
        for (int i = 1; i < 4; i++) {
            worksheet.getCells().get("A"+Integer.toString(i+1)).putValue("Category"+Integer.toString(i));
        }

        //worksheet.getCells().get("A2").putValue("Category1");
        //worksheet.getCells().get("A3").putValue("Category2");
        //worksheet.getCells().get("A4").putValue("Category3");

        worksheet.getCells().get("B1").putValue("Column1");
        worksheet.getCells().get("B2").putValue(4);
        worksheet.getCells().get("B3").putValue(20);
        worksheet.getCells().get("B4").putValue(50);

        worksheet.getCells().get("C1").putValue("Column2");
        worksheet.getCells().get("C2").putValue(50);
        worksheet.getCells().get("C3").putValue(100);
        worksheet.getCells().get("C4").putValue(150);

// Add a chart to the worksheet
        int chartIndex = worksheet.getCharts().add(ChartType.COLUMN, 5, 0, 15, 5);

// Access the instance of the newly added chart
        Chart chart = worksheet.getCharts().get(chartIndex);

// Set chart data source as the range "A1:C4"
        chart.setChartDataRange("A1:C4", true);
        try {
            workbook.save("Column-Chart.xlsx", SaveFormat.XLSX);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}