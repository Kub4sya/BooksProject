/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExecelImplementation;

import com.mycompany.booksproject.NewJFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kubasya
 */
public class ExecelProvider {
    private File file;
    private  XSSFWorkbook wb;
    private ObjectDispencer trashBox;
    
    
    
    public ExecelProvider()  //открытие файла, указывайте свой путь
    {
        //this.file = new File("/Users/kubasya/Documents/MyFolder/ProgramingsStuff/DataTable.xlsx");
      //this.file = new File("/Users/kubasya/Documents/MyFolder/Teachers.xlsx");
    }
    
    public void run()
    {
        if (loadFile() == true)
        {
        readShit();
        trashBox.mapElements();
        }
        // просто достл значение конкретной ячейки
        //String s = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        //System.out.println(s);
    }
    public Boolean loadFile() // получение рабочей книги из файла
    {
        try {
            this.file = new File("/Users/kubasya/Documents/MyFolder/ProgramingsStuff/DataTable.xlsx");
            wb = new XSSFWorkbook(file);
        } catch (IOException ex) {
            System.out.println("Fuck");
            Logger.getLogger(ExecelProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            System.out.println("You");
            Logger.getLogger(ExecelProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e)
        {
            System.out.println("Fuck You");
            NewJFrame frame = new NewJFrame();
            JOptionPane.showMessageDialog(frame,"где файл долбаеб");
            return false;
        }
        return true;
    }
    public void readShit()  // вытягиваем имена листов и отправляем на распределение вместе со всей книгой
    {
        int n = wb.getNumberOfSheets();
        trashBox = new ObjectDispencer();
        XSSFWorkbook table = wb;
       for(int i=0; i<n; i++)
        {
        XSSFSheet shit = wb.getSheetAt(i);
        String name = shit.getSheetName();
        trashBox.AddObject(name, table);
//            if(shitName.equals("Teachers"))
//                {
//                    XSSFSheet shit = wb.getSheetAt(i);
//                    trashBox.AddEvilKirills("Teachers");
//                }
//            if(shitName.equals("Students"))
//                {
//                    XSSFSheet shit = wb.getSheetAt(i);
//                   // trashBox.AddGraciousKirillGroup("Teachers");
//                }
            // similary set book sheet titles
        }
    }
    // more methods
    
    public void getHeader(XSSFSheet shit) // получение заголовков страницы
    {
    
    }
    
    public ObjectDispencer getDispencer()
    {
    return trashBox;
    }
    
}
