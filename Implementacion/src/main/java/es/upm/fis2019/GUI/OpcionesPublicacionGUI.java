package es.upm.fis2019.GUI;

import es.upm.fis2019.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class OpcionesPublicacionGUI extends JFrame implements ActionListener{
    private String applyButtonTextColor = "color: #ffffff;";
    private String applyButtonTextSize = "font-size: 12px;";
    private JButton borrar = new JButton("<html><span style=\""+applyButtonTextColor+applyButtonTextSize+"\">BORRAR</spam></html>");
    private JButton comentar = new JButton("<html><span style=\""+applyButtonTextColor+applyButtonTextSize+"\">COMENTAR</spam></html>");
    private String text;
    private GridBagConstraints ctes = new GridBagConstraints();
    private PublicationGUI publicationGUI;
    private IPublicacion publicacion;
    private PublicacionesUsuarioGUI gui;
    private JPanel panel;

    public OpcionesPublicacionGUI(PublicationGUI publicationGUI, IPublicacion publicacion, PublicacionesUsuarioGUI gui){
        this.gui = gui;
        this.publicacion = publicacion;
        this.text= publicationGUI.getText();
        this.publicationGUI = publicationGUI;
        setLayout();
    }
    private void setLayout(){
        this.panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        this.getContentPane().setPreferredSize(new Dimension(700, 500));
        this.getContentPane().add(scrollPane);
        this.panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        this.panel.setBackground(Color.WHITE);
        setBounds(550,100,700,900);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
    }

    private void addButtons(){

        ctes.gridx=10;
        ctes.gridy=0;
        ctes.gridwidth=3;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.weightx = 3.0;
        borrar.setBackground(new Color(206,66,37));
        this.panel.add(borrar,ctes);
        reset();

        ctes.gridx=7;
        ctes.gridy=0;
        ctes.gridwidth=3;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.weightx = 3.0;
        comentar.setBackground(new Color(12,86,206));
        this.panel.setBackground(Color.WHITE);
        this.panel.add(comentar,ctes);
        reset();
    }

    public void display(){
        addActionEvent();
        addButtons();
        addPublication();
        addComments();
        setTitle(getTitle());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    private void addPublication(){
        String applyTextColor = "color: #0C56CE;";
        JLabel label = new JLabel("<html><h1 style=\""+applyTextColor+"\">"+this.text+"</h1></html>");
        label.setBackground(Color.WHITE);
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridwidth=6;
        ctes.gridheight=1;
        ctes.weighty = 1.0;
        ctes.fill = GridBagConstraints.BOTH;
        this.panel.add(label,ctes);
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
            this.panel.add(new ComentarioGUI(comentarios.get(i), this),ctes);
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
        this.panel.removeAll();
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
