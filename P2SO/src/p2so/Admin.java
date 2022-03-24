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
    
    public void updateText() {
        Interfaz.Admin1.setText(Interfaz.level1.PrintQueue());
        Interfaz.Admin1.update(Interfaz.Admin1.getGraphics());
        Interfaz.Admin2.setText(Interfaz.level2.PrintQueue());
        Interfaz.Admin2.update(Interfaz.Admin2.getGraphics());
        Interfaz.Admin3.setText(Interfaz.level3.PrintQueue());
        Interfaz.Admin3.update(Interfaz.Admin3.getGraphics());
        Interfaz.AdminFix.setText(Interfaz.fixStation.PrintQueue());
        Interfaz.AdminFix.update(Interfaz.AdminFix.getGraphics());
    }
    
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
        //Metodo que se encarga de meter en las colas
        if (nodo != null) {
            switch (nodo.getPriority()) {
                case 1:
                    Interfaz.level1.EnqueueNode(nodo);
                    updateText();
                    break;
                case 2:
                    Interfaz.level2.EnqueueNode(nodo);
                    updateText();
                    break;
                case 3:
                    Interfaz.level3.EnqueueNode(nodo);                    
                    updateText();
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
                    Interfaz.fixStation.EnqueueNode(checked.getNode());
                    updateText();
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
                updateText();
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
                Interfaz.priorityUp.setText("Prioridad aumentada de 3 a 2\nEscritorio(s): " + strings[i]);
                Interfaz.priorityUp.update(Interfaz.priorityUp.getGraphics());
            }
        }
        string = Interfaz.level2.EnqueueQueue(Interfaz.level3.UpdateCounter());
        if (!string.equals("")) {
            strings = string.split(",");
            for (int i = 0; i < strings.length; i++) {
                Interfaz.priorityUp.setText("Prioridad aumentada de 3 a 2\nEscritorio(s): " + strings[i]);
                Interfaz.priorityUp.update(Interfaz.priorityUp.getGraphics());
            }
        }
    }
}
