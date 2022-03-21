/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2so;

/**
 *
 * @author cbcbe
 */
public class Robot {
    public Robot() {

    }

    public Revisado Check(Nodo node) {
        Revisado checked = null;
        if (node != null) {
            Interfaz.ColasBot.setText("ID Escritorio en revisión: " + Integer.toString(node.getID()) + "\n");
            node.setCounter(0);
            double rand = Math.random() * 100;
            if (rand <= 40) {
                //Sale al mercado
                checked = new Revisado(node, 0);
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Escritorio vendido" + "\n");
            } else if (rand > 40 && rand <= 65) {
                //Volver a encolar para revision
                checked = new Revisado(node, 1);
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Escritorio a revisión" + "\n");
            } else {
                //Requiere una mejora
                checked = new Revisado(node, 2);                
                Interfaz.ColasBot.setText(Interfaz.ColasBot.getText() + "Escritorio a mejoras" + "\n");
            }
        }
        return checked;
    }
}
