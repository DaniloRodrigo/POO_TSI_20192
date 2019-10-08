/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 3086926
 */
public class Tutorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // Criando o frame
        frame.setTitle("Minha aplicação"); // Nomeando a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar ao clicar em sair
        frame.setContentPane(new JPanel(new FlowLayout()));
        
        JTextField meuCampo = new JTextField(10);
        JButton meuBotao = new JButton("Clique aqui");
        
        meuBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, meuCampo.getText(), "Minha mensagem", JOptionPane.ERROR_MESSAGE);
                meuCampo.setText("Meu novo valor;");
            }
        });
        
        
        
        
        
        frame.add(meuCampo);
        frame.add(meuBotao);
        
        frame.setSize(400, 300); // Tamanho da janela
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}
