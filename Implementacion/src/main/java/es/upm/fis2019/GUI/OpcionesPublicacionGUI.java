package es.upm.fis2019.GUI;

import es.upm.fis2019.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class OpcionesPublicacionGUI extends JFrame implements ActionListener{

    private JButton borrar = new JButton("BORRAR");
    private JButton comentar = new JButton("COMMENT");
    private String text;
    private GridBagConstraints ctes = new GridBagConstraints();
    private PublicationGUI publicationGUI;
    private IPublicacion publicacion;
    private PublicacionesUsuarioGUI gui;

    public OpcionesPublicacionGUI(PublicationGUI publicationGUI, IPublicacion publicacion, PublicacionesUsuarioGUI gui){
        this.gui = gui;
        this.publicacion = publicacion;
        this.text= publicationGUI.getText();
        this.publicationGUI = publicationGUI;
        this.getContentPane().setLayout(new GridBagLayout());
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

    public void display(){
        addActionEvent();
        addButtons();
        addPublication();
        addComments();
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
        List<IComentario> comentarios = this.publicacion.getComentarios();
        for(int i=0; i<comentarios.size(); i++){
            ctes.gridx=0;
            ctes.gridy=i+2;
            ctes.gridwidth=6;
            ctes.gridheight=1;
            ctes.weighty = 1.0;
            ctes.fill = GridBagConstraints.BOTH;
            this.getContentPane().add(new ComentarioGUI(comentarios.get(i), this),ctes);
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


    public void resetView(){
        this.getContentPane().removeAll();
        this.display();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comentar){
            WriteGUI writeGUI = new WriteGUI(this.publicationGUI.getPublicacion(), "Comentario", this);
            writeGUI.display();
        }
        else {
            IBorraPublicacion borrador = App.getControladorPublicaciones();
            borrador.borrarPublicacion(this.publicacion);
            gui.updateGUI();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
