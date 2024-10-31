/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodo;

/**
 *
 * @author brian
 */
public class Nodo {
    String palabra;
    Nodo siguiente;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}
