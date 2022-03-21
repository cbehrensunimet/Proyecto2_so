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
        Interfaz.Admin1.update(Interfaz.Admin1.getGraphics());
        Interfaz.Admin2.update(Interfaz.Admin2.getGraphics());
        Interfaz.Admin3.update(Interfaz.Admin3.getGraphics());
        while (true) {
            try {
                for (int j = 0; j < 2; j++) {
                    Nodo nodo = admin.SelectArauca();
                    Thread.sleep(1000);
                    Revisado checked = robot.Check(nodo);
                    Thread.sleep(5000);
                    admin.ManageChecked(checked);
                    Interfaz.ColasBot.update(Interfaz.ColasBot.getGraphics());
                    admin.UpdatePriority();
                    Interfaz.Admin1.update(Interfaz.Admin1.getGraphics());
                    Interfaz.Admin2.update(Interfaz.Admin2.getGraphics());
                    admin.ManageFixes();
                    Interfaz.AdminFix.update(Interfaz.AdminFix.getGraphics());
                    Thread.sleep(1000);
                }
                admin.AddArauca(admin.CreateArauca());
                Interfaz.Admin1.update(Interfaz.Admin1.getGraphics());
                Interfaz.Admin2.update(Interfaz.Admin2.getGraphics());
                Interfaz.Admin3.update(Interfaz.Admin3.getGraphics());


            } catch (Exception e) {
            }
        }
    }
}
