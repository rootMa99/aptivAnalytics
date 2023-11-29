package com.aptiv.dataAnalytics.service;

import com.aptiv.dataAnalytics.model.ActDataExcel;
import com.aptiv.dataAnalytics.model.DataFromExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class UploadExcelAndExtractData {

    public static boolean isValidFormat(MultipartFile file){
        return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<DataFromExcel>getDataFromEXcelFile(InputStream inputStream){

        List<DataFromExcel> dataFromExcels=new ArrayList<>();

        try {
            XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
            XSSFSheet sheet= workbook.getSheet("DATA");
            int rowIndex=0;
            for (Row row:sheet){
            if(rowIndex==0){
                rowIndex++;
                continue;
            }
                Iterator<Cell>cellIterator=row.iterator();
                int cellIndex=0;
                DataFromExcel dataFromExcel= new DataFromExcel();
                while (cellIterator.hasNext()){
                    Cell cell= cellIterator.next();
                    switch (cellIndex){
                        case 0-> {
                            if (cell.getCellType()== CellType.STRING){
                                System.out.println("plant ######### "+ cell.getStringCellValue());
                            }else {
                                System.out.println("plant "+cell.getCellType());
                            }
                        }
                        case 1-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("area "+cell.getStringCellValue());
                            }else {
                                System.out.println("area "+cell.getCellType());
                            }
                        }
                        case 2-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("project "+cell.getStringCellValue());
                            }else {
                                System.out.println("project "+cell.getCellType());
                            }
                        }
                        case 3-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("family "+cell.getStringCellValue());
                            }else {
                                System.out.println("family "+cell.getCellType());
                            }
                        }
                        case 4-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("crew "+cell.getStringCellValue());
                            }else {
                                System.out.println("crew "+cell.getCellType());
                            }
                        }
                        case 5-> {
                            if (cell.getCellType()==CellType.STRING&& cell.getCellType()!=CellType.BLANK ){
                                System.out.println("team leader "+cell.getStringCellValue());
                            }else {
                                System.out.println("team leader "+cell.getCellType());
                            }
                        }
                        case 6-> {
                            if (cell.getCellType()==CellType.STRING&& cell.getCellType()!=CellType.BLANK){
                                System.out.println("shift leader "+cell.getStringCellValue());
                            }else {
                                System.out.println("shift leader "+cell.getCellType());
                            }
                        }
                        case 7-> {
                            if (cell.getCellType()==CellType.STRING&& cell.getCellType()!=CellType.BLANK){
                                System.out.println("coordinator "+cell.getStringCellValue());
                            }else {
                                System.out.println("coordinator "+cell.getCellType());
                            }
                        }
                        case 8-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("month "+cell.getStringCellValue());
                            }else {
                                System.out.println("month "+cell.getCellType());
                            }
                        }
                        case 9-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("week "+cell.getStringCellValue());
                            }else {
                                System.out.println("week "+cell.getCellType());
                            }
                        }
                        case 10-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("date "+cell.getNumericCellValue());
                            }else {
                                System.out.println("date "+cell.getCellType());
                            }
                        }
                        case 11-> {
                            if (cell.getCellType()==CellType.STRING){
                                System.out.println("filter "+cell.getStringCellValue());
                            }else {
                                System.out.println("filter "+cell.getCellType());
                            }
                        }
                        case 12-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("output "+cell.getNumericCellValue());
                            }else {
                                System.out.println("output "+cell.getCellType());
                            }
                        }
                        case 13-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("prod-h "+cell.getNumericCellValue());
                            }else {
                                System.out.println("prod-h "+cell.getCellType());
                            }
                        }
                        case 14->{
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("paid-h "+cell.getNumericCellValue());
                            }else {
                                System.out.println("paid-h "+cell.getCellType());
                            }
                        }
                        case 15-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("totalHc "+cell.getNumericCellValue());
                            }else {
                                System.out.println("totalHc "+cell.getCellType());
                            }
                        }
                        case 16-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("hc "+cell.getNumericCellValue());
                            }else {
                                System.out.println("hc "+cell.getCellType());
                            }
                        }
                        case 17-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("ot "+cell.getNumericCellValue());
                            }else {
                                System.out.println("ot "+cell.getCellType());
                            }
                        }
                        case 18-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("ab "+cell.getNumericCellValue());
                            }else {
                                System.out.println("ab "+cell.getCellType());
                            }
                        }
                        case 19-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("tlo "+cell.getNumericCellValue());
                            }else {
                                System.out.println("tlo "+cell.getCellType());
                            }
                        }
                        case 20-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("dt "+cell.getNumericCellValue());
                            }else {
                                System.out.println("dt "+cell.getCellType());
                            }
                        }
                        case 21->{
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("output target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("output target "+cell.getCellType());
                            }
                        }
                        case 22-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("prod target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("prod target "+cell.getCellType());
                            }
                        }
                        case 23-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("payed target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("payed target "+cell.getCellType());
                            }
                        }
                        case 24-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("hc target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("hc target "+cell.getCellType());
                            }
                        }
                        case 25-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("abs target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("abs target "+cell.getCellType());
                            }
                        }
                        case 26-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("dt target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("dt target "+cell.getCellType());
                            }
                        }
                        case 27-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("scrap "+cell.getNumericCellValue());
                            }else {
                                System.out.println("scrap "+cell.getCellType());
                            }
                        }
                        case 28-> {
                            if (cell.getCellType()==CellType.NUMERIC){
                                System.out.println("scrap target "+cell.getNumericCellValue());
                            }else {
                                System.out.println("scrap target "+cell.getCellType());
                            }
                        }
                        default -> {

                        }
                    }
                    cellIndex++;
                }
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

}
