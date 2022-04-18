
package reloj;

import java.util.*;

public class Reloj extends javax.swing.JFrame implements Runnable{
    String hora, min, seg, ampm;
    Calendar calendario;
    Thread h1;

    public Reloj() {
        initComponents();
        
         h1 = new Thread(this);
        h1.start();

        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blReloj = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 100, 100));

        blReloj.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        blReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blReloj.setText("jLabel1");
        getContentPane().add(blReloj, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Inicio");
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Espacio para la simulacion");
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blReloj;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
         Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            blReloj.setText(hora + ":" + min + ":" + seg + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }

    private void calcula() {
       Calendar calendario = new GregorianCalendar();
        Date fechaHoraactual = new Date();
        calendario.setTime(fechaHoraactual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if(h==00){
                   hora="12";
             }else{
                   hora=h>9?""+h:"0"+h;
             }      
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
}
