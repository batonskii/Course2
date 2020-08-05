package ru.geekbrains.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChat extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JButton btn;

    public WindowChat(){
        setTitle("Test Chat Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 250, 400, 400);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        jp.add(scrollPane, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        addTextField();
        bottom.add(textField, BorderLayout.CENTER);

        addButton();
        bottom.add(btn, BorderLayout.SOUTH);
        jp.add(bottom, BorderLayout.SOUTH);
        add(jp);

        setVisible(true);
        textField.grabFocus();
    }

    private void Message(){
        if(!textField.getText().isEmpty()){
            textArea.append(textField.getText()+"\n");
            textField.setText("");
            textField.grabFocus();
        }
    }

    private void addTextField(){
        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message();
            }
        });
    }

    private void addButton(){
        btn = new JButton("Отправить сообщение");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message();
            }
        });
    }
}

class MainClass{
    public static void main(String[] args) {
       new WindowChat();
    }
}
