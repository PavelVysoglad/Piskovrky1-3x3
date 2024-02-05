import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Piskvorky implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titul_panel = new JPanel();
    JPanel tlacitka_panel = new JPanel();
    JLabel textovepole = new JLabel();
    JButton[] tlacitka = new JButton[9];
    JPanel rozhrani = new JPanel();
    JButton[] tlacitka_rozhrani = new JButton[3];
    boolean hrac1_tah;
    int xvyhranehry = 0;
    int Ovyhranehry = 0;
    Piskvorky (){
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(800,800);
    frame.setBackground(new Color(58, 51, 51));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    frame.setResizable(false);

    textovepole.setBackground(new Color(25,25,25));
    textovepole.setForeground(new Color(25,255,0));
    textovepole.setFont(new Font("Ink Free",Font.BOLD,75));
    textovepole.setHorizontalAlignment(JLabel.CENTER);
    textovepole.setText("Piškotvorky");
    textovepole.setOpaque(true);

    titul_panel.setLayout(new BorderLayout());
    titul_panel.setBounds(0,0,800,100);

    titul_panel.add(textovepole);
    frame.add(titul_panel,BorderLayout.NORTH);

    tlacitka_panel.setLayout(new GridLayout(3,3));
    tlacitka_panel.setBackground(new Color(150, 150, 150));

    frame.add(tlacitka_panel);

    rozhrani.setLayout(new GridLayout(1, 3));
    rozhrani.setBounds(0,0,800,30);

    frame.add(rozhrani, BorderLayout.SOUTH);

    for (int i=0;i<9;i++){
        tlacitka[i] = new JButton();
        tlacitka_panel.add(tlacitka[i]);
        tlacitka[i].setBackground(Color.GRAY);
        tlacitka[i].setFont(new Font("MV Boli", Font.BOLD, 120));
        tlacitka[i].setFocusable(false);
        tlacitka[i].addActionListener(this);


    }

    for(int j = 0; j<3;j++){
        tlacitka_rozhrani[j] = new JButton();
        rozhrani.add(tlacitka_rozhrani[j]);
        tlacitka_rozhrani[j].setFont(new Font("MV Boli", Font.BOLD, 25));
        tlacitka_rozhrani[j].setFocusable(false);
        tlacitka_rozhrani[j].addActionListener(this);
    }

    tlacitka_rozhrani[0].setText("X: "+xvyhranehry);
    tlacitka_rozhrani[2].setText("O: "+Ovyhranehry);
    tlacitka_rozhrani[1].setText("Nová hra");

    prvnitah();


    }

    @Override
    public void actionPerformed (ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == tlacitka[i]) {
                if (hrac1_tah) {
                    if (tlacitka[i].getText() == "") {
                        tlacitka[i].setForeground(new Color(255, 0, 0));
                        tlacitka[i].setText("X");
                        hrac1_tah = false;
                        textovepole.setText("O je na řadě");
                        kontrola();
                    }
                } else {
                    if (tlacitka[i].getText() == "") {
                        tlacitka[i].setForeground(new Color(38, 38, 255));
                        tlacitka[i].setText("O");
                        hrac1_tah = true;
                        textovepole.setText("X je na řadě");
                        kontrola();
                    }
                }
            }
        }
        if (e.getSource() == tlacitka_rozhrani[1]){
            for(int i = 0; i<9;i++){
                tlacitka[i].setText("");
                tlacitka[i].setBackground(Color.GRAY);
                tlacitka[i].setEnabled(true);
                if(random.nextInt(2)==0){
                    hrac1_tah = true;
                    textovepole.setText("X na řadě");
                }
                else{
                    hrac1_tah = false;
                    textovepole.setText("O na řadě");
                }
            }
        }
    }

    public void prvnitah(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            hrac1_tah = true;
            textovepole.setText("X na řadě");
        }
        else{
            hrac1_tah = false;
            textovepole.setText("O na řadě");
        }
    }
    public void kontrola(){
        // kontrola X  vyhrál
         if (
                 (tlacitka[0].getText()=="X")&&
                 (tlacitka[1].getText()=="X")&&
                 (tlacitka[2].getText()=="X")
         ){
             xVyhral(0, 1, 2);
         }
        if (
                (tlacitka[3].getText()=="X")&&
                (tlacitka[4].getText()=="X")&&
                (tlacitka[5].getText()=="X")
        ){
            xVyhral(3, 4, 5);
        }
        if (
                (tlacitka[6].getText()=="X")&&
                (tlacitka[7].getText()=="X")&&
                (tlacitka[8].getText()=="X")
        ){
            xVyhral(6, 7, 8);
        }
        if (
                (tlacitka[0].getText()=="X")&&
                (tlacitka[3].getText()=="X")&&
                (tlacitka[6].getText()=="X")
        ){
            xVyhral(0, 3, 6);
        }
        if (
                (tlacitka[1].getText()=="X")&&
                (tlacitka[4].getText()=="X")&&
                (tlacitka[7].getText()=="X")
        ){
            xVyhral(1, 4, 7);
        }
        if (
                (tlacitka[2].getText()=="X")&&
                (tlacitka[5].getText()=="X")&&
                (tlacitka[8].getText()=="X")
        ){
            xVyhral(2, 5, 8);
        }
        if (
                (tlacitka[0].getText()=="X")&&
                (tlacitka[4].getText()=="X")&&
                (tlacitka[8].getText()=="X")
        ){
            xVyhral(0, 4, 8);
        }
        if (
                (tlacitka[2].getText()=="X")&&
                (tlacitka[4].getText()=="X")&&
                (tlacitka[6].getText()=="X")
        ){
            xVyhral(2, 4, 6);
        }

            if (
                    (tlacitka[0].getText()=="O")&&
                            (tlacitka[1].getText()=="O")&&
                            (tlacitka[2].getText()=="O")
            ){
                oVyhral(0, 1, 2);
            }
            if (
                    (tlacitka[3].getText()=="O")&&
                            (tlacitka[4].getText()=="O")&&
                            (tlacitka[5].getText()=="O")
            ){
                oVyhral(3, 4, 5);
            }
            if (
                    (tlacitka[6].getText()=="O")&&
                            (tlacitka[7].getText()=="O")&&
                            (tlacitka[8].getText()=="O")
            ){
                oVyhral(6, 7, 8);
            }
            if (
                    (tlacitka[0].getText()=="O")&&
                            (tlacitka[3].getText()=="O")&&
                            (tlacitka[6].getText()=="O")
            ){
                oVyhral(0, 3, 6);
            }
            if (
                    (tlacitka[1].getText()=="O")&&
                            (tlacitka[4].getText()=="O")&&
                            (tlacitka[7].getText()=="O")
            ){
                oVyhral(1, 4, 7);
            }
            if (
                    (tlacitka[2].getText()=="O")&&
                            (tlacitka[5].getText()=="O")&&
                            (tlacitka[8].getText()=="O")
            ){
                oVyhral(2, 5, 8);
            }
            if (
                    (tlacitka[0].getText()=="O")&&
                            (tlacitka[4].getText()=="O")&&
                            (tlacitka[8].getText()=="O")
            ){
                oVyhral(0, 4, 8);
            }
            if (
                    (tlacitka[2].getText()=="O")&&
                            (tlacitka[4].getText()=="O")&&
                            (tlacitka[6].getText()=="O")
            ){
                oVyhral(2, 4, 6);
        }
        // kontrola O  vyhrál


    }
    public void xVyhral(int a, int b, int c) {
        tlacitka[a].setBackground(Color.GREEN);
        tlacitka[b].setBackground(Color.GREEN);
        tlacitka[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            tlacitka[i].setEnabled(false);
        }
textovepole.setText("X vyhrál");
        xvyhranehry++;
        tlacitka_rozhrani[0].setText("X: "+xvyhranehry);

    }
    public void oVyhral(int a, int b, int c){
        tlacitka[a].setBackground(Color.GREEN);
        tlacitka[b].setBackground(Color.GREEN);
        tlacitka[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            tlacitka[i].setEnabled(false);
        }
        textovepole.setText("O vyhrál");
        Ovyhranehry++;
        tlacitka_rozhrani[2].setText("O: "+Ovyhranehry);
    }
}