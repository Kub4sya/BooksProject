/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DirectlyProducts;

import Folders.SadBook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kubasya
 */
public class SillySadBook implements SadBook{
    private String author;
    private String title;
    private String university;
    private String grade;


    

    public SillySadBook(String entirelyAll) 
    {
        setAtributes(entirelyAll);
        //System.out.println("Create SillySadBook");
        //this.entirelyAll = entirelyAll;
    }

    public void setAtributes(String all)
    {
        Pattern p = Pattern.compile("(?s)(.*),.(.*),.(.*),.(.*)");
        Matcher m = p.matcher(all);
        if (m.find()) 
        {
           this.author = m.group(1);
           this.title = m.group(2);
           this.university = m.group(3);
           this.grade= m.group(4);
        }
        //System.out.println(all);
    }

    @Override
    public String toString() {
        return "SillySadBook{" + "author=" + author + ", title=" + title + ", university=" + university + ", grade=" + grade + '}';
    }
    @Override
    public String getTitle() {
        return title;
    }
    
}

