/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Rectangulo extends FiguraGeometrica {
    private Punto p1;
    private Punto p2;

    public Rectangulo(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() { return p1; }
    public Punto getP2() { return p2; }

    public double getBase() {
        return Math.abs(p2.getX() - p1.getX());
    }

    public double getAltura() {
        return Math.abs(p2.getY() - p1.getY());
    }

    @Override
    public double calcularArea() {
        return getBase() * getAltura();
    }

    @Override
    public void mover(double dx, double dy) {
        p1.mover(dx, dy);
        p2.mover(dx, dy);
    }

    @Override
    public String toString() {
        return "Rectángulo con vértices " + p1 + " y " + p2
                + " | Base: " + getBase() + " | Altura: " + getAltura();
    }
}