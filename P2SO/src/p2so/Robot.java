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
//            Menu.RobotConsole.setText(Integer.toString(node.getID()));
            node.setCounter(0);
            double rand = Math.random() * 100;
            if (rand <= 40) {
                checked = new Revisado(node, 0);
                //Sale al mercado
            } else if (rand > 40 && rand <= 65) {
                //Volver a encolar para revision
                checked = new Revisado(node, 1);
            } else {
                checked = new Revisado(node, 2);
                //Requiere una mejora
            }
        }
        return checked;
    }
}
