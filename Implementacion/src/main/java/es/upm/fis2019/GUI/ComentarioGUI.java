package es.upm.fis2019.GUI;

import es.upm.fis2019.IComentario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComentarioGUI extends JPanel implements ActionListener{

    private String applyButtonTextColor = "color: #ffffff;";
    private String applyButtonTextSize = "font-size: 12px;";
    private JButton answer = new JButton("<html><span style=\""+applyButtonTextColor+applyButtonTextSize+"\">RESPONDER</spam></html>");
    private JLabel label;
    private JLabel respuesta;
    private IComentario comentario;
    private OpcionesPublicacionGUI opciones;
    private GridBagConstraints ctes = new GridBagConstraints();

    public ComentarioGUI(IComentario comentario, OpcionesPublicacionGUI opciones){
        this.opciones = opciones;
        this.comentario = comentario;
        this.label = new JLabel("<html><h2>"+comentario.getTexto()+"</h2></html>");
        String respuesta = comentario.getRespuesta();
        if(respuesta != null)
            this.respuesta = new JLabel("<html><p>"+respuesta+"</p></html>");
        addComponents();
        setBackground(Color.WHITE);
        setVisible(true);
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel();
        addRespuesta();
        addButton(answer);
        addActionEvent();
        setBorder(new EmptyBorder(5,5,5,5));
    }

    private void addLabel(){
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridheight=3;
        ctes.gridwidth=2;
        ctes.weightx = 1.0;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        add(this.label,ctes);
        reset();
    }

    private void addButton(JButton button){
        ctes.gridx = 2;
        ctes.gridy = 1;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        button.setBackground(new Color(12,86,206));
        add (button, ctes);
        reset();
    }

    private void addRespuesta(){
        if(respuesta == null) return;

        ctes.gridx = 1;
        ctes.gridy = 3;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        add(this.respuesta,ctes);
        reset();
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    private void addActionEvent()
    {
        answer.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==answer){
            WriteGUI writeGUI = new WriteGUI(this.comentario, opciones);
            writeGUI.display();
        }
    }
}
