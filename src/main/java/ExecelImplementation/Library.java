/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExecelImplementation;

import DirectlyProducts.DummyFunnyBook;
import Folders.Book;
import Folders.DummyBookFactory;
import Folders.FunnyBook;
import Folders.SadBook;
import Folders.SillyBookFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kubasya
 */
public class Library {
    private DummyBookFactory SkyPrintMachine = new DummyBookFactory();
    private SillyBookFactory RainbowPrintMachine = new SillyBookFactory();
//    private ArrayList<FunnyBook> funnyBookShelf = new ArrayList();
//    private ArrayList<SadBook> sadBookShelf = new ArrayList();
    private ArrayList<Book> bookShelf = new ArrayList();
    
    
    public void MakeBooks(XSSFSheet shit)  // основной метод класса создания книг
    {   
        // заполням массиввы данными с листа экселя
        ArrayList<String> dummyType = getData(shit,0);  
        ArrayList<String> dummySubject = getData(shit,1);
        ArrayList<String> dummyFirstPart = getData(shit,2);
        ArrayList<String> dummySecondPart = getData(shit,3);
        ArrayList<String> sillyTitle = getData(shit,4);
        ArrayList<String> sillyUniversity = getData(shit,5);
        ArrayList<String> sillyAuthor = getData(shit,6);
        ArrayList<String> sillyFirstPart = getData(shit,7);
        ArrayList<String> sillySecondPart = getData(shit,8);
        // создание DummyFunnyBook
        //Collections.shuffle(dummyFirstPart);
        //Collections.shuffle(dummySecondPart);
        for(int i = 0; i < dummyFirstPart.size(); i++) // преобразование данных в книги и заполнение ими массива
        {
            bookShelf.add(SkyPrintMachine.createFunnyBook(dummyFirstPart.get(i)+" "+dummySecondPart.get(i)));
        }
        //создание SillyFunnyBook
        for(int i = 0; i < sillyFirstPart.size(); i++)
        {
            bookShelf.add(RainbowPrintMachine.createFunnyBook(sillyFirstPart.get(i)+" "+sillySecondPart.get(i)));
        }
        // создание DummySadBook
        for(int i = 0; i < dummySubject.size(); i++) 
        {
            Collections.shuffle(dummyType);
            bookShelf.add(SkyPrintMachine.createSadBook(dummyType.get(0)+" по "+dummySubject.get(i)));
        }
        // создание SillySadBook
        // заполняем массив с уровнями английской литературы
        ArrayList<String> levelVariables = new ArrayList();
        levelVariables.add("Begginer");
        levelVariables.add("Intermidiate");
        levelVariables.add("Advance");
        levelVariables.add("Incredible");
        for(int i = 0; i < sillyTitle.size(); i++)
        {
            Collections.shuffle(sillyAuthor);
            Collections.shuffle(sillyUniversity);
            Collections.shuffle(levelVariables);
            bookShelf.add(RainbowPrintMachine.createSadBook(sillyAuthor.get(0)+", "+sillyTitle.get(i)+", "+sillyUniversity.get(0)+", "+levelVariables.get(0)));
        }
        System.out.println(bookShelf);
        //System.out.println(sadBookShelf);
    }
    
    
    public ArrayList getData(XSSFSheet shit, int B)  // чтение одной из колонок колонки требуемого листа экселя в стринговый массив
    {
        XSSFRow row = shit.getRow(0);
        XSSFCell cell;
        int A=0;   // наибольшее количество строк в колонке на листе, при считывании колонок с таким количеством строк цикл не прооставляет А
        ArrayList<String> data = new ArrayList();
        for(int i = 0; i < 999; i++)     // получение максимального количества строк в колонке
        {
            row = shit.getRow(i);
            if(shit.getRow(i+1) != null && row.getCell(B) == null){
            //cell = row.getCell(B);
                A=i;
                break;
            }
            if(shit.getRow(i+1) != null && shit.getRow(i+1).getCell(B) == null)
            {
                A=i+1;
                break;
            }
            if(shit.getRow(i+1) == null && row.getCell(B) != null)
            {
                A=i+1;
                break;
            }
        }
        //System.out.println(A);
        for(int i = 0; i < A; i++)
        {
           row = shit.getRow(i);
           data.add(row.getCell(B).getStringCellValue());         
        }
        //System.out.println(data);
        return data;
    }

    public ArrayList<Book> getBookShelf() {
        return bookShelf;
    }
}
