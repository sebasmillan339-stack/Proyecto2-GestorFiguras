/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controlador.ControladorRectangulo;

public class PruebasRectangulo {
    static int fallos = 0;

    static void verificar(String nombre, boolean condicion) {
        System.out.println((condicion ? "OK     " : "FALLÓ  ") + nombre);
        if (!condicion) fallos++;
    }

    public static void main(String[] args) {
        ControladorRectangulo c = new ControladorRectangulo();

        verificar("no crea rectángulo degenerado", !c.crear(0, 0, 0, 5));
        verificar("crea rectángulo válido", c.crear(0, 0, 4, 3));
        verificar("área 4x3 = 12", c.calcularArea() == 12.0);

        verificar("punto (2,1) dentro", c.puntoDentro(2, 1));
        verificar("punto (4,3) en el borde cuenta dentro", c.puntoDentro(4, 3));
        verificar("punto (5,1) fuera", !c.puntoDentro(5, 1));
        verificar("punto (-1,1) fuera", !c.puntoDentro(-1, 1));

        c.mover(10, 10);
        verificar("tras mover, (2,1) ya no está dentro", !c.puntoDentro(2, 1));
        verificar("tras mover, (12,11) está dentro", c.puntoDentro(12, 11));
        verificar("el área no cambia al mover", c.calcularArea() == 12.0);

        verificar("escalar x2 es válido", c.escalar(2));
        verificar("área tras escalar x2 = 48", c.calcularArea() == 48.0);
        verificar("factor negativo se rechaza", !c.escalar(-1));

        c.crear(4, 3, 0, 0); // vértices en otro orden
        verificar("funciona con vértices invertidos", c.puntoDentro(2, 1));

        System.out.println(fallos == 0 ? "\nTodas las pruebas pasaron." : "\nFallos: " + fallos);
    }
}