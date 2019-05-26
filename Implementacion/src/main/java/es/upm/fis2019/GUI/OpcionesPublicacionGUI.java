package es.upm.fis2019.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class OpcionesPublicacionGUI extends JFrame implements ActionListener{

    private JButton borrar = new JButton("BORRAR");
    private JButton comentar = new JButton("COMMENT");
    private String text;
    private GridBagConstraints ctes = new GridBagConstraints();
    private PublicacionesUsuarioGUI publicacionesUsuarioGUI;
    private PublicationGUI publicationGUI;

    public OpcionesPublicacionGUI(PublicationGUI publicationGUI, PublicacionesUsuarioGUI publicacionesUsuarioGUI){
        this.publicacionesUsuarioGUI=publicacionesUsuarioGUI;
        this.text= publicationGUI.getText();
        this.publicationGUI = publicationGUI;
        this.getContentPane().setLayout(new GridBagLayout());
        addActionEvent();
        addButtons();
        addPublication();
        addComments();
        setView();
    }

    private void addButtons(){

        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridwidth=3;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.weightx = 3.0;
        this.getContentPane().add(borrar,ctes);
        reset();

        ctes.gridx=3;
        ctes.gridy=0;
        ctes.gridwidth=3;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.weightx = 3.0;
        this.getContentPane().add(comentar,ctes);
        reset();
    }

    private void setView(){
        setTitle(getTitle());
        setVisible(true);
        setBounds(10,10,500,900);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
    }

    private void addPublication(){
        JLabel label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        ctes.gridx=0;
        ctes.gridy=1;
        ctes.gridwidth=6;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(label,ctes);
        reset();
    }

    private void addComments(){
        String text = "Lorem ipsum dolor sit amet consectetur adipiscing elit, volutpat fames quam aliquet ac cras, curae varius vestibulum proin eleifend tempor. ";
        for(int i=0; i<5; i++){
            ctes.gridx=0;
            ctes.gridy=i+2;
            ctes.gridwidth=6;
            ctes.gridheight=1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            this.getContentPane().add(new ComentarioGUI(text), ctes);
            reset();
        }
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    private void addActionEvent()
    {
        comentar.addActionListener(this);
        borrar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comentar){
            WriteGUI writeGUI = new WriteGUI(this.publicationGUI.getPublicacion(), "Comentario");
        }
        else {
            //TODO Que borre de verdad
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
