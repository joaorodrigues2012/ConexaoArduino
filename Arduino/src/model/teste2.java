package model;

import javax.swing.JFrame;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class teste2 extends JFrame implements SerialPortEventListener {

private CommPortIdentifier portId = null;
private SerialPort port = null;
private InputStream input;
//private SerialPort serialPort;
private int valor1, valor2;

public teste2() {
initComponents();
jButton2.setEnabled(false);
jButton3.setEnabled(false);
}

public void abrirPorta() throws NoSuchPortException, PortInUseException,
UnsupportedCommOperationException {
portId = CommPortIdentifier.getPortIdentifier("COM3");
port = (SerialPort) portId.open(this.getClass().getName(), 2000);
port.setSerialPortParams(9600, SerialPort.DATABITS_8,
SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
}

public void fecharPorta() throws IOException {
//input.close();
port.removeEventListener();
port.close();
port = null;
}

public void lerDados() throws IOException {
input = port.getInputStream();
//while (true) {

//while (input.available() > 0) {
valor1 = input.read();
valor2 = input.read();
//System.out.println(valor1);
//}
//}

jLabel1.setText(String.valueOf(valor1));
jLabel2.setText(String.valueOf(valor2));
System.out.println("v1: "+valor1);
System.out.println("v2: "+valor2);
}

@SuppressWarnings("unchecked")
// 
private void initComponents() {

jLabel1 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jButton3 = new javax.swing.JButton();
jLabel2 = new javax.swing.JLabel();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

jLabel1.setText("jLabel1");

jButton1.setText("Abrir");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setText("Ler");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

jButton3.setText("Fechar");
jButton3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton3ActionPerformed(evt);
}
});

jLabel2.setText("jLabel2");

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(128, 128, 128)
.addComponent(jButton1)
.addGap(18, 18, 18)
.addComponent(jButton2)
.addGap(27, 27, 27)
.addComponent(jButton3))
.addGroup(layout.createSequentialGroup()
.addGap(45, 45, 45)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jLabel2)
.addComponent(jLabel1))))
.addContainerGap(60, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(42, 42, 42)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton1)
.addComponent(jButton2)
.addComponent(jButton3))
.addGap(38, 38, 38)
.addComponent(jLabel1)
.addGap(33, 33, 33)
.addComponent(jLabel2)
.addContainerGap(136, Short.MAX_VALUE))
);

pack();
}//

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
try {
abrirPorta();
} catch (NoSuchPortException ex) {
Logger.getLogger(teste2.class.getName()).log(Level.SEVERE, null, ex);
} catch (PortInUseException ex) {
Logger.getLogger(teste2.class.getName()).log(Level.SEVERE, null, ex);
} catch (UnsupportedCommOperationException ex) {
Logger.getLogger(teste2.class.getName()).log(Level.SEVERE, null, ex);
}
jButton1.setEnabled(false);
jButton2.setEnabled(true);
jButton3.setEnabled(true);
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
if (port != null) {
try {
lerDados();
} catch (IOException ex) {
Logger.getLogger(teste2.class.getName()).log(Level.SEVERE, null, ex);
}
}
}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
if (port != null) {
try {
fecharPorta();
} catch (IOException ex) {
Logger.getLogger(teste2.class.getName()).log(Level.SEVERE, null, ex);
}
}
jButton1.setEnabled(true);
jButton2.setEnabled(false);
jButton3.setEnabled(false);
} 
// Variables declaration - do not modify 
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
// End of variables declaration

public synchronized void close() {
if (port != null) {
port.removeEventListener();
port.close();
}
}

public synchronized void serialEvent(SerialPortEvent oEvent) {
if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
try {
abrirPorta();
lerDados();
fecharPorta();
} catch (Exception e) {
System.out.println(e.toString());
}
}
// Ignore all the other eventTypes, but you should consider the other ones.
}

public static void main(String[] args) throws NoSuchPortException, PortInUseException, IOException,
UnsupportedCommOperationException {
new teste2().setVisible(true);
}

}