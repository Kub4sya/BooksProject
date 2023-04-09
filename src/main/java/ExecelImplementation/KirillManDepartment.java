/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExecelImplementation;

import DirectlyGuys.EvilKirill;
import DirectlyGuys.GraciousKirill;
import Folders.Kirill;
import Folders.KirillMan;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kubasya
 */
public class KirillManDepartment {
//    private File file;
//    private  XSSFWorkbook wholeFile;
    
    private ArrayList<EvilKirill> EvilKirillContainer = new ArrayList();  // массивы с чуваками
    private ArrayList<GraciousKirill> GraciousKirillContainer = new ArrayList();
    //private ArrayList<Kirill> KirillContainer = new ArrayList();
    KirillMan kirillGenerator = new KirillMan();
    
    
    public KirillManDepartment() {
       //this.file = new File("/Users/kubasya/Documents/MyFolder/ProgramingsStuff/DataTable.xlsx");
       //openExcel();
    }
    
    public void MakeEvilOne(XSSFWorkbook wholeFile)   // создание всех злых чуваков, на выходе получаем сооответствующий заполненный массиив
    {
        ArrayList<String> allEvilMenNames = getKirills(wholeFile.getSheet("GeneralNames"));    // массивы тупа с данными из экселя 
        ArrayList<String> allEvilMenSurnames = getKirills(wholeFile.getSheet("TeacherSurnames"));
        ArrayList<String> allEvilLastnames = getKirills(wholeFile.getSheet("LastNames"));
        ArrayList<String> allEvilWomenNames = getWomenKirills(wholeFile.getSheet("GeneralNames"));
        ArrayList<String> allEvilWomenSurnames = getWomenKirills(wholeFile.getSheet("TeacherSurnames"));
        System.out.println(allEvilMenNames);
        Collections.shuffle(allEvilMenNames);
        Collections.shuffle(allEvilMenSurnames);
        Collections.shuffle(allEvilLastnames);
        Collections.shuffle(allEvilWomenNames);
        Collections.shuffle(allEvilWomenSurnames);
        for(int i = 0; i < allEvilMenSurnames.size(); i++) // преобразоование данных в челиков
        {
            EvilKirillContainer.add(kirillGenerator.createEvilKirill(allEvilMenSurnames.get(i), allEvilMenNames.get(i), allEvilLastnames.get(i),1));
        }
        for(int i = 0; i < allEvilWomenSurnames.size(); i++)
        {
            EvilKirillContainer.add(kirillGenerator.createEvilKirill(allEvilWomenSurnames.get(i), allEvilWomenNames.get(i), allEvilLastnames.get(i),2));
        }
       // EvilKirillContainer.add(kirillGenerator.createEvilKirill("Лох", "Тупой", "Попуск"));
        System.out.println(EvilKirillContainer);
    }
    
    public void MakeGraciousOne(XSSFWorkbook wholeFile)
    {
        ArrayList<String> allGraciousNames = getKirills(wholeFile.getSheet("GeneralNames"));
        ArrayList<String> allGraciousSurnames = getKirills(wholeFile.getSheet("StudentSurnames"));
        
        ArrayList<String> allGraciousWomenNames = getWomenKirills(wholeFile.getSheet("GeneralNames"));
        ArrayList<String> allGraciousWomenSurnames = getWomenKirills(wholeFile.getSheet("StudentSurnames"));
        for(int i = 0; i < allGraciousSurnames.size(); i++) // преобразоование данных в челиков
        {
            GraciousKirillContainer.add(kirillGenerator.createGraciousKirill(allGraciousSurnames.get(i),allGraciousNames.get(i)));
        }
        for(int i = 0; i < allGraciousWomenSurnames.size(); i++) // преобразоование данных в челиков
        {
            GraciousKirillContainer.add(kirillGenerator.createGraciousKirill(allGraciousWomenSurnames.get(i), allGraciousWomenNames.get(i)));
        }
        System.out.println(GraciousKirillContainer);
    }
    
    public ArrayList getKirills(XSSFSheet shit)  // чтение первой колонки требуемого листа экселя в стринговый массив
    {
        XSSFRow row = shit.getRow(0);
        XSSFCell cell;
        int A=0;   // наибольшее количество строк в колонке на листе, при считывании колонок с таким количеством строк цикл не прооставляет А
        ArrayList<String> data = new ArrayList();
        for(int i = 0; i < 999; i++)     // получение максимального количества строк в колонке
        {
            row = shit.getRow(i);
            if(shit.getRow(i+1) != null && row.getCell(0) == null){
            //cell = row.getCell(B);
                A=i;
                break;
            }
            if(shit.getRow(i+1) != null && shit.getRow(i+1).getCell(0) == null)
            {
                A=i+1;
                break;
            }
            if(shit.getRow(i+1) == null && row.getCell(0) != null)
            {
                A=i+1;
                break;
            }
        }
        //System.out.println(A);
        for(int i = 0; i < A; i++)
        {
           row = shit.getRow(i);
           data.add(row.getCell(0).getStringCellValue());         
        }
        //System.out.println(data);
        return data;
    }
    
    
    public ArrayList getWomenKirills(XSSFSheet shit) // чтение второй колонки листа экселя в стринговый массив
    {
        XSSFRow row = shit.getRow(0);
        XSSFCell cell;
        int A=0;   // наибольшее количество строк в колонке на листе, при считывании колонок с таким количеством строк цикл не прооставляет А
        ArrayList<String> data = new ArrayList();
        for(int i = 0; i < 999; i++)     // получение максимального количества строк в колонке
        {
            row = shit.getRow(i);
            if(shit.getRow(i+1) != null && row.getCell(1) == null){
            //cell = row.getCell(B);
                A=i;
                break;
            }
            if(shit.getRow(i+1) != null && shit.getRow(i+1).getCell(1) == null)
            {
                A=i+1;
                break;
            }
            if(shit.getRow(i+1) == null && row.getCell(1) != null)
            {
                A=i+1;
                break;
            }
        }
        //System.out.println(A);
        for(int i = 0; i < A; i++)
        {
           row = shit.getRow(i);
           data.add(row.getCell(1).getStringCellValue());         
        }
        //System.out.println(data);
        return data;
    }
    
    
//    public void openExcel()
//    {
//        try {
//            wholeFile = new XSSFWorkbook(file);
//        } catch (IOException ex) {
//            Logger.getLogger(ExecelProvider.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvalidFormatException ex) {
//            Logger.getLogger(ExecelProvider.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public ArrayList getKirills(XSSFSheet shit)   // алгоритм который полностью считывает все данные с листа в массив
//    {
//        int A = shit.getLastRowNum();
//        XSSFRow row;
//        int B;
//        ArrayList<String> data = new ArrayList();
//        for(int i = 0; i < A; i++)
//        {
//           row = shit.getRow(i);
//           B = row.getLastCellNum();
//           for(int j = 0; j < B; j++)
//           {
//               data.add(row.getCell(j).getStringCellValue());
//           }
//           
//        }
//        return data;
//    }

    public ArrayList<EvilKirill> getEvilKirillContainer() {
        return EvilKirillContainer;
    }

    public ArrayList<GraciousKirill> getGraciousKirillContainer() {
        return GraciousKirillContainer;
    }
    
}
