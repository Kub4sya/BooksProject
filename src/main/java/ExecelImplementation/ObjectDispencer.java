/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExecelImplementation;


import DirectlyGuys.EvilKirill;
import DirectlyGuys.GraciousKirill;
import DirectlyProducts.DummySadBook;
import Folders.Book;
import Folders.Kirill;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kubasya
 */
public class ObjectDispencer {
   private KirillManDepartment dep;
   private Library library;
   private HashMap<Kirill,HashSet<Book>> evilData = new HashMap();
   private HashMap<Kirill,HashSet<Book>> graciousData = new HashMap();
//   private ArrayList<EvilKirill> EvilKirill = new ArrayList();  // массивы с чуваками
//   private ArrayList<GraciousKirill> GraciousKirill = new ArrayList();
       
    
    public ObjectDispencer()
    {
        dep = new KirillManDepartment();
        library = new Library();
        // graciousGroup = new ArrayList();
    }
    
    public void AddObject(String name, XSSFWorkbook wholeFile) // расспределяем создание объектов, то есть говорим что кому создавать
    {
      if(name.equals("TeacherSurnames"))
        {
            dep.MakeEvilOne(wholeFile);
        }
      if(name.equals("StudentSurnames"))
        {
            dep.MakeGraciousOne(wholeFile);
        }
      if(name.equals("Books"))
      {
          library.MakeBooks(wholeFile.getSheet("Books"));
      }
    }
    
    public void mapElements()  // stage2 распределение элементов
    {
        ArrayList<EvilKirill> generalEvil = dep.getEvilKirillContainer();
        ArrayList<GraciousKirill> generalGracious = dep.getGraciousKirillContainer();
        ArrayList<Book> optional = library.getBookShelf();
        
        //System.out.println(optional);
        for(EvilKirill kirill : generalEvil)
        {
            evilData.put(kirill,getRandom(optional));
        }
        for(GraciousKirill kirill : generalGracious)
        {
            graciousData.put(kirill,getRandom(optional));
        }
       // System.out.println(generalEvil.get(0));
        //System.out.println(infoData.get(generalEvil.get(0)));
        System.out.println(evilData);
        System.out.println(graciousData);
    }
    
    public HashSet<Book> getRandom(ArrayList<Book> basa)
    {
        
        int qu = new Random().nextInt(3, 10);
        HashSet<Book> books = new HashSet();
        //System.out.println(rnd);
        for(int i = 0; i < qu; i++)
        {
            int rnd = new Random().nextInt(basa.size());
            books.add(basa.get(rnd));
            
        }
        return books;
    }
//    public void AddGraciousKirillGroup(String name)
//    {
//        GraciousKirillGroup group = new GraciousKirillGroup(name);
//        groups.add(group);
//        activeGroup = group;
//    }
        public DefaultMutableTreeNode fillEvil()
        {
        DefaultMutableTreeNode evils = new DefaultMutableTreeNode("Препопадаватели");
        for(Map.Entry<Kirill,HashSet<Book>> info : evilData.entrySet())
        {
          DefaultMutableTreeNode items = new DefaultMutableTreeNode(info.getKey());
          //items.add(info.getValue());
          for(Book book : info.getValue())
          {
              items.add(new DefaultMutableTreeNode(book.getTitle()));
          }
          evils.add(items);
        }
            return evils;
        }
        
        public DefaultMutableTreeNode fillGracious()
        {
            DefaultMutableTreeNode graciouses = new DefaultMutableTreeNode("Обычные Чуваки");
            for(Map.Entry<Kirill,HashSet<Book>> info : graciousData.entrySet())
                {
                DefaultMutableTreeNode items = new DefaultMutableTreeNode(info.getKey());               
                for(Book book : info.getValue())
                    {
                        items.add(new DefaultMutableTreeNode(book.getTitle()));
                    }
                graciouses.add(items);
                }
            return graciouses;
        }
    
        public DefaultMutableTreeNode addInfo2GUI() {
        //String s = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Кирилл Стор");
//        DefaultMutableTreeNode evils = new DefaultMutableTreeNode("Препопадаватели");
//        DefaultMutableTreeNode graciouses = new DefaultMutableTreeNode("Обычные Чуваки");
        main.add(fillEvil());
        main.add(fillGracious());
       return main;
    }
    
}
