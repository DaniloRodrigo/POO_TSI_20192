/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author 3086926
 */
public class Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new JPanel(new BorderLayout()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Minha janela");
        
        JMenuBar menu = new JMenuBar();
        JMenu arquivos = new JMenu("Arquivo");
        JMenuItem salvar = new JMenuItem("Salvar");
        
        menu.add(arquivos);
        arquivos.add(salvar);
        
        JPanel center = new JPanel(new FlowLayout());
        
        JTextField campo1 = new JTextField(10);
        JTextField campo2 = new JTextField(10);
        JButton somar = new JButton("Somar");
        somar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, campo1.getText() + campo2.getText());
            }
        });
        center.add(campo1);
        center.add(campo2);
        center.add(somar);
        
        
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.setSize(400, 200);
        //frame.setResizable(false);
        

        frame.setVisible(true);
    }
    
}
