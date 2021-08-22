package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Form extends JFrame {
    private final JLabel label = new JLabel("");
    private final JButton backSpace = new JButton("⬅");
    private final JButton numberBtn1 = new JButton("1");
    private final JButton numberBtn2 = new JButton("2");
    private final JButton numberBtn3 = new JButton("3");
    private final JButton numberBtn4 = new JButton("4");
    private final JButton numberBtn5 = new JButton("5");
    private final JButton numberBtn6 = new JButton("6");
    private final JButton numberBtn7 = new JButton("7");
    private final JButton numberBtn8 = new JButton("8");
    private final JButton numberBtn9 = new JButton("9");
    private final JButton numberBtn0 = new JButton("0");
    private final JButton numberBtn00 = new JButton("00");
    private final JButton sum = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton multiply = new JButton("*");
    private final JButton division = new JButton("/");
    private final JButton equals = new JButton("=");
    private final JButton cleanUp = new JButton("AC");
    private final JButton dot = new JButton(".");
    private final JButton percent = new JButton("%");

    private boolean numWasInput = false;
    private boolean dotWasInput = false;
    private String operation;


    public Form() {
        super("Calcualator");
        setBounds(10, 10, 280, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        Font font = new Font("Arial", 1, 20);
        label.setFont(font);
        label.setBounds(0, 0, 280, 100);


        JPanel jPanel = new JPanel();
        JPanel jPanel1 = new JPanel();
        Container container = getContentPane();

        jPanel1.add(label);

        jPanel.setLayout(new GridLayout(5, 4));


        container.setLayout(new GridLayout(2, 1));

        for (JButton jButton : Arrays.asList(backSpace, percent, cleanUp, equals, numberBtn7, numberBtn8, numberBtn9, sum, numberBtn4, numberBtn5, numberBtn6, minus, numberBtn1, numberBtn2, numberBtn3, multiply, dot, numberBtn0, numberBtn00, division)) {
            jButton.setFocusPainted(false);
        }
        for (JButton jButton : Arrays.asList(backSpace, percent, cleanUp, equals, numberBtn7, numberBtn8, numberBtn9, sum, numberBtn4, numberBtn5, numberBtn6, minus, numberBtn1, numberBtn2, numberBtn3, multiply, dot, numberBtn0, numberBtn00, division)) {
            jButton.setContentAreaFilled(false);
        }

        for (JButton jButton : Arrays.asList(backSpace, percent, cleanUp, equals, numberBtn7, numberBtn8, numberBtn9, sum, numberBtn4, numberBtn5, numberBtn6, minus, numberBtn1, numberBtn2, numberBtn3, multiply, dot, numberBtn0, numberBtn00, division)) {
            jPanel.add(jButton);
        }

        add(jPanel1);
        add(jPanel);


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_0) {
//                    label.setText(label.getText()+ "0");
                    System.out.println("junkjntd");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        backSpace.addActionListener(e -> {
            StringBuilder str = new StringBuilder(label.getText());
            str.delete(str.length() - 1, str.length());
            char c = str.charAt(str.length()-1);
            if(c=='+' || c=='*' || c=='-' || c=='/')
                numWasInput = false;
            else if(c=='.')
                dotWasInput = false;
            label.setText(String.valueOf(str));
        });

        cleanUp.addActionListener(e -> {
            numWasInput = false;
            label.setText("");
            numWasInput = false;
            dotWasInput = false;
        });

        numberBtn0.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "0");
        });
//TODO: найти как назначить клавишу на событие


        numberBtn00.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "00");
        });
        numberBtn1.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "1");
        });
        numberBtn2.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "2");
        });
        numberBtn3.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "3");
        });
        numberBtn4.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "4");
        });
        numberBtn5.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "5");
        });
        numberBtn6.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "6");
        });
        numberBtn7.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "7");
        });
        numberBtn8.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "8");
        });
        numberBtn9.addActionListener(e -> {
            numWasInput = true;
            label.setText(label.getText() + "9");
        });

        sum.addActionListener(e -> {
            if (numWasInput) {
                label.setText(label.getText() + "+");
                operation = "\\+";
                numWasInput = false;
                dotWasInput = false;
            } else {
                operation = "\\+";
                StringBuilder str = new StringBuilder(label.getText());
                str.replace(str.length() - 1, str.length(), "+");
                label.setText(String.valueOf(str));
                dotWasInput = false;
            }
        });

        minus.addActionListener(e -> {
            if (numWasInput) {
                label.setText(label.getText() + "-");
                operation = "-";
                numWasInput = false;
                dotWasInput = false;
            } else {
                operation = "-";
                StringBuilder str = new StringBuilder(label.getText());
                str.replace(str.length() - 1, str.length(), "-");
                label.setText(String.valueOf(str));
                dotWasInput = false;
            }
        });

        division.addActionListener(e -> {
            if (numWasInput) {
                label.setText(label.getText() + "/");
                operation = "/";
                numWasInput = false;
                dotWasInput = false;
            } else {
                operation = "/";
                StringBuilder str = new StringBuilder(label.getText());
                str.replace(str.length() - 1, str.length(), "/");
                label.setText(String.valueOf(str));
                dotWasInput = false;
            }
        });

        multiply.addActionListener(e -> {
            if (numWasInput) {
                label.setText(label.getText() + "*");
                operation = "\\*";
                numWasInput = false;
                dotWasInput = false;
            } else {
                operation = "\\*";
                StringBuilder str = new StringBuilder(label.getText());
                str.replace(str.length() - 1, str.length(), "*");
                label.setText(String.valueOf(str));
                dotWasInput = false;
            }
        });

        dot.addActionListener(e -> {
            if (numWasInput) {
                label.setText(label.getText() + ".");
                numWasInput = false;
                dotWasInput = true;
            } else {
                StringBuilder str = new StringBuilder(label.getText());
                str.replace(str.length() - 1, str.length(), ".");
                label.setText(String.valueOf(str));
                dotWasInput = true;
            }
        });

        equals.addActionListener(e -> {
            if(!label.getText().isEmpty()) {
                String str1 = label.getText();
                if(str1.lastIndexOf("+")!=-1 || str1.lastIndexOf("-")!=-1 || str1.lastIndexOf("*")!=-1 || str1.lastIndexOf("/")!=-1) {
                    String[] str = str1.split(operation);


                    if (!"".equals(str[0]) && !"".equals(str[1])) {


                        for (String i : str) {
                            System.out.println(i);
                        }
                        double a = Double.parseDouble(str[0]);
                        double b = Double.parseDouble(str[1]);

                        switch (operation) {
                            case "\\+" -> label.setText(String.valueOf(a + b));
                            case "-" -> label.setText(String.valueOf(a - b));
                            case "\\*" -> label.setText(String.valueOf(a * b));
                            case "/" -> {
                                if (b > 0) label.setText(String.valueOf(a / b));
                                else label.setText("");
                            }
                        }
                        numWasInput = false;
                        dotWasInput = false;
                    }

                }

            }


        });

    }


}
