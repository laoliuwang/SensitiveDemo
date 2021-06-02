package com.cw;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {


    public static void main(String[] args) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();


        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        HSSFSheet sheet = workbook.createSheet("sheet");
        sheet.setDefaultColumnWidth(25);
        sheet.setDefaultRowHeightInPoints(30);

        HSSFRow row0 = sheet.createRow(0);
        row0.setHeightInPoints(40);
        HSSFCell cell_00 = row0.createCell(0);


        cell_00.setCellStyle(style);
        cell_00.setCellValue("产品名称");
        HSSFCell cell_01 = row0.createCell(1);
        cell_01.setCellStyle(style);
        cell_01.setCellValue("子产品名称");
        HSSFCell cell_02 = row0.createCell(2);
        cell_02.setCellStyle(style);
        cell_02.setCellValue("产品细项名称");
        HSSFCell cell_03 = row0.createCell(3);
        cell_03.setCellStyle(style);
        cell_03.setCellValue("容量单位");
        HSSFCell cell_04 = row0.createCell(4);
        cell_04.setCellStyle(style);
        cell_04.setCellValue("可用区");
        HSSFCell cell_05 = row0.createCell(5);
        cell_05.setCellStyle(style);
        cell_05.setCellValue("已投放容量");
        HSSFCell cell_06 = row0.createCell(6);
        cell_06.setCellStyle(style);
        cell_06.setCellValue("可分配容量");
        HSSFCell cell_07 = row0.createCell(7);
        cell_07.setCellStyle(style);
        cell_07.setCellValue("可分配占比");
        HSSFCell cell_08 = row0.createCell(8);
        cell_08.setCellStyle(style);
        cell_08.setCellValue("已交付容量");
        HSSFCell cell_09 = row0.createCell(9);
        cell_09.setCellStyle(style);
        cell_09.setCellValue("已交付占比");

        HSSFRow row1 = sheet.createRow(1);
        row1.setHeightInPoints(30);
        HSSFRow row2 = sheet.createRow(2);
        row2.setHeightInPoints(30);
        HSSFRow row3 = sheet.createRow(3);
        row3.setHeightInPoints(30);
        HSSFCell cell_10 = row1.createCell(0);

        cell_10.setCellStyle(style);
        cell_10.setCellValue("云数据库TDSql版");


        HSSFCell cell_11 = row1.createCell(1);
        cell_11.setCellStyle(style);
        cell_11.setCellValue("云数据库TDSql子版");

        String[][] values = new String[8][3];
        values[0][0] = "CPU";
        values[0][1] = "内存";
        values[0][2] = "本地存储";

        values[1][0] = "核";
        values[1][1] = "GB";
        values[1][2] = "GB";

        values[2][0] = "标准-武汉";
        values[2][1] = "标准-武汉";
        values[2][2] = "标准-武汉";

        values[3][0] = "3024";
        values[3][1] = "14280";
        values[3][2] = "415800";

        values[4][0] = "1479.74";
        values[4][1] = "8095.12";
        values[4][2] = "331005";

        values[5][0] = "49%";
        values[5][1] = "57%";
        values[5][2] = "80%";

        values[6][0] = "1554.26";
        values[6][1] = "6184.88";
        values[6][2] = "84795.00";

        values[7][0] = "51%";
        values[7][1] = "43%";
        values[7][2] = "20%";


        for (int i = 1; i <= 3; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 2; j < 10; j++) {
                System.out.println(i - 1);
                System.out.println(j - 2);
                System.out.println(values[j - 2][i - 1]);
                HSSFCell cell_ij = row.createCell(j);
                cell_ij.setCellStyle(style);
                cell_ij.setCellValue(values[j - 2][i - 1]);
            }
        }


        CellRangeAddress region = new CellRangeAddress(1, 3, 0, 0);
        sheet.addMergedRegion(region);

        CellRangeAddress region2 = new CellRangeAddress(1, 3, 1, 1);
        sheet.addMergedRegion(region2);

        File file = new File("E:\\demo.xls");
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
        fout.close();

    }
}
