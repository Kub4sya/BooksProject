/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DirectlyGuys;
import Folders.Kirill;
import Folders.KirillMan;

/**
 *
 * @author kubasya
 */
public class EvilKirill extends KirillMan implements Kirill{
    private String surname;
    private String name;
    private String lastname;
    
    public EvilKirill(String surname, String name, String lastname, int gender)
    {
        this.surname = surname;
        this.name = name;
        if(gender == 1)
            this.lastname = lastname + "ич";
        if(gender == 2)
            this.lastname = lastname + "на";
    }

    @Override
    public String toString() {
        return  surname + " " + name + " " + lastname + " ";
    }
    
}
