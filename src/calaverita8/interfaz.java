package calaverita8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Image;
import java.awt.Font;

public class interfaz extends JFrame {
    JButton click;
    JPanel principal, panelImagen, panelTexto, panelBoton;
    JTextArea textoArea;

    public interfaz() {
        setTitle("Calaverita Literaria");
        setSize(800, 800);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 
        this.setResizable(false);  

        principal = new JPanel();
        principal.setLayout(new BorderLayout(10, 10));
        principal.setBackground(new Color(234, 230, 192));
        principal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        JLabel titulo = new JLabel("Calaverita Literaria", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);
        titulo.setForeground(new Color(34, 139, 34));
        
        panelImagen = new JPanel();
        ImageIcon imagenIcon = new ImageIcon(getClass().getResource("/imagen/ilustracion.jpg"));
        Image imagen = imagenIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        panelImagen.add(titulo);
        JLabel imagenLabel = new JLabel(new ImageIcon(imagen), JLabel.CENTER);
        panelImagen.setBackground(new Color(234, 230, 192));
        panelImagen.add(imagenLabel);

        panelTexto = new JPanel();
        panelTexto.setBackground(new Color(234, 230, 192));
        textoArea = new JTextArea(10, 30); 
        textoArea.setText("""
                            Diego en su patineta,
                            veloz iba a rodar,
                            esquivando a la calaca
                            que lo queria llevar.
                          
                            Diego, deja ya de deslizar,
                            que este viaje es sin regreso!
                            Ven conmigo a descansar!.
                          
                            Pero Diego, muy tranquilo,
                            con una sonrisa y gran valor,
                            le dijo: No tengas prisa,
                            yo de aqui no me voy.
                          
                            Asi siguio su dia,
                            entre clases y el patinar,
                            y la Catrina, frustrada,
                            no lo pudo atrapar.""");
        Font fuente = new Font("Arial", Font.BOLD, 16);
        textoArea.setFont(fuente);
        textoArea.setEditable(false); 
        panelTexto.add(textoArea);
        panelTexto.setVisible(false); 

        panelBoton = new JPanel();
        click = new JButton("Click");
        click.setBackground(Color.BLACK); 
        click.setForeground(Color.WHITE);
        panelBoton.setBackground(new Color(234, 230, 192));
        panelBoton.add(click);

        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTexto.setVisible(true);
                revalidate(); 
                repaint(); 
            }
        });

        principal.add(panelImagen, BorderLayout.NORTH);
        principal.add(panelTexto, BorderLayout.CENTER); 
        principal.add(panelBoton, BorderLayout.SOUTH);

        add(principal, BorderLayout.CENTER);
    }
}