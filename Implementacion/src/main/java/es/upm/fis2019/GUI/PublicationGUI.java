package es.upm.fis2019.GUI;

import es.upm.fis2019.ControladorPublicaciones;
import es.upm.fis2019.ILikea;
import es.upm.fis2019.IPublicacion;
import es.upm.fis2019.Publicacion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicationGUI extends JPanel implements ActionListener{

    //TODO añadir label likes y dislikes, commit nocturno probablemente

    private int likes;
    private int dislikes;
    private boolean hasBeenLikeado;
    private boolean hasBeenDislikeado;
    private JLabel label;
    private String text;
    private JButton like;
    private JButton dislike;
    private JButton option = new JButton("OPTIONS");
    private PublicacionesUsuarioGUI publicacionesUsuarioGUI;
    private IPublicacion publicacion;
    private GridBagConstraints ctes = new GridBagConstraints();


    public PublicationGUI(IPublicacion publicacion, PublicacionesUsuarioGUI publicacionesUsuarioGUI){
        this.publicacionesUsuarioGUI=publicacionesUsuarioGUI;
        this.text=publicacion.getContenido();
        this.publicacion = publicacion;
        this.likes = publicacion.getLikes();
        this.dislikes = publicacion.getDislikes();

        like = new JButton("LIKE: "+ this.likes);
        dislike = new JButton("DISLIKE: "+ publicacion.getDislikes());
        label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        addComponents();
        setVisible(true);
    }

    private void addActionEvent()
    {
        option.addActionListener(this);
        like.addActionListener(this);
        dislike.addActionListener(this);
    }

    public void setText(String text){
        this.text = text;
        label = new JLabel("<html><h2>"+this.text+"<h2><html>");
        addLabel(label);
    }

    private void updateGUI(){
        this.revalidate();
    }

    public String getText() {
        return text;
    }

    private void addComponents(){

        setLayout(new GridBagLayout());
        addLabel(label);
        addButton(like,0);
        addButton(dislike,1);
        addButton(option,2);
        addActionEvent();
        setBorder(new EmptyBorder(5,5,5,5));
    }

    private void addLabel(JLabel label){
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridheight=3;
        ctes.gridwidth=2;
        ctes.weightx = 4.0;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        add(label,ctes);
        reset();
    }

    private void addButton(JButton button, int i){
        ctes.gridx = 4;
        ctes.gridy = i;
        ctes.gridwidth = 1;
        ctes.gridheight = 1;
        ctes.weighty = 1.0;
        add (button, ctes);
        reset();
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == option) {
            OpcionesPublicacionGUI opcionesPublicacionGUI= new OpcionesPublicacionGUI(this, this.publicacion, this.publicacionesUsuarioGUI);
            opcionesPublicacionGUI.display();
        }
        else if(e.getSource()==like){
            if(!this.hasBeenLikeado){
                this.likes ++;
                this.hasBeenLikeado = true;
            }else{
               this.likes --;
               this.hasBeenLikeado = false;
            }
            if(this.hasBeenDislikeado){
                this.dislikes --;
                this.hasBeenDislikeado = false;
            }

            ILikea like = new ControladorPublicaciones();
            like.likear((Publicacion) this.publicacion, this.likes, this.dislikes);
            this.like.setText("LIKES: " + this.likes);
            this.dislike.setText("DISLIKES: " + this.dislikes);
        }
        else{
            if(!this.hasBeenDislikeado){
                this.dislikes ++;
                this.hasBeenDislikeado = true;
            }else{
               this.dislikes --;
               this.hasBeenDislikeado = false;
            }
            if(this.hasBeenLikeado){
                this.likes --;
                this.hasBeenLikeado = false;
            }
            ILikea dislike = new ControladorPublicaciones();
            dislike.dislikear((Publicacion) this.publicacion, this.likes, this.dislikes);
            this.like.setText("LIKES: " + this.likes);
            this.dislike.setText("DISLIKES: " + this.dislikes);
        }
    }
    public IPublicacion getPublicacion(){
        return this.publicacion;
    }
}
