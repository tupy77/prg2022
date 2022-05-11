import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
   
    public static void main (String[]args){
        try {
            FileInputStream f = new FileInputStream("productos.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(f);
            XSSFSheet hoja = libro.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;
            
            Row fila;
            Cell celda;
            while (filas.hasNext()){
                fila = filas.next();
                celdas = fila.cellIterator();
                
                while (celdas.hasNext()){
                    celda = celdas.next();
                    switch(celda.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(celda.getNumericCellValue());
                            break;
                        
                        case Cell.CELL_TYPE_STRING:
                        System.out.println(celda.getStringCellValue());
                        break;
                    }
                }

            }
libro.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
