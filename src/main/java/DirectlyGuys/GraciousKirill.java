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
public class GraciousKirill extends KirillMan implements Kirill{
    private String surname;
    private String name;

    public GraciousKirill(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    @Override
    public String toString() {
        return surname + " " + name + " ";
    }
    
    
}
