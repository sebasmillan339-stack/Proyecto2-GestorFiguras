/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controlador.ControladorRectangulo;
import vista.VistaRectangulo;

public class Main {
    public static void main(String[] args) {
        ControladorRectangulo controlador = new ControladorRectangulo();
        VistaRectangulo vista = new VistaRectangulo(controlador);
        vista.setVisible(true);
    }
}