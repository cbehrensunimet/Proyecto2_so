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
                    Interfaz.Admin1.setText(Interfaz.Admin1.getText() + "ID Escritorio: " + nodo.getID() + "\n");
                    Interfaz.level1.EnqueueNode(nodo);
                    break;
                case 2:
                    Interfaz.Admin2.setText(Interfaz.Admin2.getText() + "ID Escritorio: " + nodo.getID() + "\n");
                    Interfaz.level2.EnqueueNode(nodo);
                    break;
                case 3:
                    Interfaz.Admin3.setText(Interfaz.Admin3.getText() + "ID Escritorio: " + nodo.getID() + "\n");
                    Interfaz.level3.EnqueueNode(nodo);
                    break;
                default:
                    break;
            }
        }
    }
    
    public Nodo SelectArauca() {
        Nodo nodo;
        if (!Interfaz.level1.isEmpty()) {
            nodo = Interfaz.level1.Dequeue();
        } else if (!Interfaz.level2.isEmpty()) {
            nodo = Interfaz.level2.Dequeue();
        } else if (!Interfaz.level3.isEmpty()) {
            nodo = Interfaz.level3.Dequeue();
        } else {
            nodo = null;
        }
        return nodo;
    }
    
    //El metodo que maneja los nodos que ya reviso el robot, y fueron vendidos, de nuevo a la cola, o a reparar
    public void ManageChecked(Revisado checked) { 
        if (checked != null) {
            switch (checked.getAction()) {
                case 0:
                    //Los araucas vendidos 
                    break;
                case 1:
                    //Los araucas a revision
                    AddArauca(checked.getNode());
                    break;
                case 2:
                    //Los araucas a mejoras
                    Interfaz.AdminFix.setText(Interfaz.AdminFix.getText() + "ID Escritorio: " + checked.getNode().getID() + "\n");
                    Interfaz.fixStation.EnqueueNode(checked.getNode());
                    break;
                default:
                    break;
            }
        }
    }
    
    public void ManageFixes() {
        if (!Interfaz.fixStation.isEmpty()) {
            double rand = Math.random() * 100;
            Nodo nodo = Interfaz.fixStation.Dequeue();
            if (rand <= 45) {
                Interfaz.AdminFix.setText(Interfaz.AdminFix.getText() + "ID Arauca Reparado: " + nodo.getID() + "\n");
                switch (nodo.getPriority()) {
                    case 1:
                        Interfaz.level1.EnqueueNode(nodo);
                        break;
                    case 2:
                        Interfaz.level2.EnqueueNode(nodo);
                        break;
                    case 3:
                        Interfaz.level3.EnqueueNode(nodo);
                        break;
                    default:
                        break;
                }
            } else {
                Interfaz.fixStation.EnqueueNode(nodo);
            }
        }
    }
    
    public void UpdatePriority() {
        String string;
        String[] strings;
        string = Interfaz.level1.EnqueueQueue(Interfaz.level2.UpdateCounter());
        if (!string.equals("")) {
            strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Interfaz.Admin1.setText(Interfaz.Admin1.getText() + "Priority UP: " + strings[i] + "\n");
            }
        }
        string = Interfaz.level2.EnqueueQueue(Interfaz.level3.UpdateCounter());
        if (!string.equals("")) {
            strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Interfaz.Admin2.setText(Interfaz.Admin2.getText() + "Priority UP: " + strings[i] + "\n");
            }
        }
    }
}
