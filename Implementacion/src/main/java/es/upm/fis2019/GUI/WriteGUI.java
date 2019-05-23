package es.upm.fis2019.GUI;

import es.upm.fis2019.GUI.DocumentSizeFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.event.*;
import javax.swing.text.*;

public class WriteGUI extends JFrame implements ActionListener{
    private JButton send = new JButton("SEND");
    private JTextArea textArea = new JTextArea();
    private DefaultStyledDocument doc;
    private JLabel remaningLabel = new JLabel();
    private int maxChar = 140;
    private GridBagConstraints ctes= new GridBagConstraints();

    public WriteGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        setWrite();
        addComponents();
        setView();
    }

    private void addTextArea(){
        ctes.gridx=0;
        ctes.gridy=0;
        ctes.gridwidth=4;
        ctes.gridheight=2;
        ctes.weightx=2.0;
        ctes.weighty=1.0;
        ctes.fill=GridBagConstraints.BOTH;
        this.getContentPane().add(this.textArea,ctes);
        reset();
    }

    private void addLabel(){
        ctes.gridx=2;
        ctes.gridy=2;
        ctes.gridwidth=1;
        ctes.gridheight=1;
        ctes.weightx=2.0;
        this.getContentPane().add(this.remaningLabel,ctes);
        reset();
    }

    private void addButton(){
        ctes.gridx=3;
        ctes.gridy=2;
        ctes.gridwidth=1;
        ctes.gridheight=1;
        ctes.weightx=2.0;
        this.getContentPane().add(this.send,ctes);
        reset();
    }

    private void addComponents(){
        addTextArea();
        addLabel();
        addButton();
        addActionEvent();
    }

    private void reset(){
        ctes.fill = GridBagConstraints.NONE;
        ctes.weightx = 0.0;
        ctes.weighty = 0.0;
    }

    private void setView(){
        setBounds(10,10,300,300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }

    private void setWrite(){
        doc = new DefaultStyledDocument();
        doc.setDocumentFilter(new DocumentFilter());
        doc.setDocumentFilter(new DocumentSizeFilter(maxChar));
        doc.addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) { updateCount();}
            @Override
            public void insertUpdate(DocumentEvent e) { updateCount();}
            @Override
            public void removeUpdate(DocumentEvent e) { updateCount();}
        });
        textArea.setDocument(doc);updateCount();
        textArea.setLineWrap(true);
    }
    private void updateCount()
    {
        remaningLabel.setText((maxChar -doc.getLength())+"");
    }

    private void addActionEvent()
    {
        send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==send){
            //TODO Que escriba de verdad
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}

