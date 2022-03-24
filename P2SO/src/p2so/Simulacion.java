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
public class Simulacion {
    
    private Admin admin;
    private Robot robot;

    public Simulacion() {

        this.admin = new Admin();
        this.robot = new Robot();

    }
    
    public void run() {
        admin.AddArauca(admin.Arauca());
        
        while (true) {
            try {
                for (int j = 0; j < 2; j++) {
                    Nodo nodo = admin.SelectArauca();
                    Revisado checked = robot.Check(nodo);
                    Thread.sleep(10000);
                    admin.ManageChecked(checked);
                    Interfaz.ColasBot.update(Interfaz.ColasBot.getGraphics());
                    admin.UpdatePriority();
                    admin.ManageFixes();
                }
                admin.AddArauca(admin.CreateArauca());
            } catch (Exception e) {
            }
        }
    }
}
