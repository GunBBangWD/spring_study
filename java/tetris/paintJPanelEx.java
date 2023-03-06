package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paintJPanelEx extends JFrame {
    JButton btn = new JButton("다시");
    MyPanel MP = new MyPanel();

    paintJPanelEx() {
        setTitle("JPanel의 paintComponent() 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,200);
        btn.setLocation(100,30);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                paintJPanelEx.super.dispose();

                new paintJPanelEx();
            }
        });

        MP.add(btn);
        add(MP);




        setVisible(true);

    }

    // JPanel을 상속받는 새 패널 구현
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE); // 파란색 선택
            g.fill3DRect(10,10,50,50,true);
            g.drawRect(50,50,50,50);
            g.setColor(Color.MAGENTA); // 마젠타색 선택
            g.drawRect(90,90,50,50);
        }
    }

    public static void main(String [] args) {
        new paintJPanelEx();
    }
}
