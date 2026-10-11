/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Punto;
import modelo.Rectangulo;

public class ControladorRectangulo {
    private Rectangulo rectangulo;

    public boolean hayRectangulo() {
        return rectangulo != null;
    }

    public boolean crear(double x1, double y1, double x2, double y2) {
        if (x1 == x2 || y1 == y2) {
            return false; 
        }
        rectangulo = new Rectangulo(new Punto(x1, y1), new Punto(x2, y2));
        return true;
    }

    public double calcularArea() {
        return rectangulo.calcularArea();
    }

    public void mover(double dx, double dy) {
        rectangulo.mover(dx, dy);
    }

    public boolean escalar(double factor) {
        if (factor <= 0) {
            return false;
        }
        Punto a = rectangulo.getP1();
        Punto b = rectangulo.getP2();
        b.setX(a.getX() + (b.getX() - a.getX()) * factor);
        b.setY(a.getY() + (b.getY() - a.getY()) * factor);
        return true;
    }

    public String descripcion() {
        return rectangulo.toString();
    }

    public boolean puntoDentro(double px, double py) {
        double x1 = rectangulo.getP1().getX();
        double y1 = rectangulo.getP1().getY();
        double x2 = rectangulo.getP2().getX();
        double y2 = rectangulo.getP2().getY();

        double minX = Math.min(x1, x2);
        double maxX = Math.max(x1, x2);
        double minY = Math.min(y1, y2);
        double maxY = Math.max(y1, y2);

        return px >= minX && px <= maxX && py >= minY && py <= maxY;
    }
}