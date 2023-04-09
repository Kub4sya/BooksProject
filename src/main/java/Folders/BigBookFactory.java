/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Folders;

/**
 *
 * @author kubasya
 */
public interface BigBookFactory {
    String title = "";
    SadBook createSadBook(String title);
    FunnyBook createFunnyBook(String title);
}
