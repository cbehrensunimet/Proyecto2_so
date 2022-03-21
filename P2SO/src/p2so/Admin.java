/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2so;

/**
 *
 * @author Nicolás
 */
public class Admin {
    
    public Nodo Arauca() { 
        //Aquí se crean por prioridad y se avisa a interfaz de su creación
        double rand = Math.random() * 3;
        Nodo nodo;
        if (rand <= 1) {
            nodo = new Nodo(Interfaz.araucas, 1);
            Interfaz.araucas++;
        } else if (rand <= 2) {
            nodo = new Nodo(Interfaz.araucas, 2);
            Interfaz.araucas++;
        } else {
            nodo = new Nodo(Interfaz.araucas, 3);
            Interfaz.araucas++;
        }
        return nodo;
    }
    
    public Nodo CreateArauca() {
        //Proceso normal de creacion, tomando en cuenta la probabilidad (70%)
        double rand = Math.random() * 100;
        Nodo nodo = null;
        if (rand <= 70) {
            nodo = Arauca();
        }
        return nodo;
    }
    
    public void AddArauca(Nodo nodo) {
        //Metodo que se encarga de actualizar la interfaz
        if (nodo != null) {
            switch (nodo.getPriority()) {
                case 1:
                    Interfaz.Admin1.setText(Interfaz.Admin1.getText() + "Añadida consola: " + nodo.getID() + "\n");
                    Interfaz.level1.EnqueueNode(nodo);
                    break;
                case 2:
                    Interfaz.Admin2.setText(Interfaz.Admin2.getText() + "Añadida consola: " + nodo.getID() + "\n");
                    Interfaz.level2.EnqueueNode(nodo);
                    break;
                case 3:
                    Interfaz.Admin3.setText(Interfaz.Admin3.getText() + "Añadida consola: " + nodo.getID() + "\n");
                    Interfaz.level3.EnqueueNode(nodo);
                    break;
                default:
                    break;
            }
        }
    }
    
    
    
}
