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
            if (rand <= 30) {
                checked = new Revisado(node, 0);
            } else if (rand > 30 && rand <= 80) {
                checked = new Revisado(node, 1);
            } else {
                checked = new Revisado(node, 2);
            }
        }
        return checked;
    }
}
