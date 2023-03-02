package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TetrisGB extends JFrame {
    static int blocksize = 20;
    int hgt=20;
    int wid=100;
    int rotation = 0;
    int random = 3 , random2 = new Random().nextInt(7);
    int End = 0;
    int score = 0;
    JButton btn = new JButton("재도전");
    JLabel lbl = new JLabel();
    JLabel lbl2 = new JLabel();


    TetrisThread th;
    boolean limit = false;
    TetrisPanel TP = new TetrisPanel();
    JDialog JD = new JDialog();



    int curX[]= new int[4], curY[] = new int [4]; // 블록들의 좌표 저장
    TetrisGB(){
        setTitle("테트리스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        TP.setSize(720,900);
        add(TP);


        JD.setTitle("점수");
        JD.setSize(250,190);
        JD.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 30));

        lbl.setFont(new Font("arial",Font.PLAIN,15));
        lbl2.setText("점  수");
        lbl2.setFont(new Font("나눔고딕",Font.PLAIN,15));
        th = new TetrisThread();

        TP.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                 if(keyCode == KeyEvent.VK_UP)
                    TP.moveUp();
                if(keyCode == KeyEvent.VK_DOWN){
                    TP.moveDown();}
                if(keyCode == KeyEvent.VK_LEFT)
                    TP.moveLeft();
                if(keyCode == KeyEvent.VK_RIGHT)
                    TP.moveRight();
            }
        });
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limit = false;
                for(int y=0; y<19;y++)
                    for(int x=1; x<12; x++)
                        gameboard[y][x] =0 ;
                score =0;
                wid =100; hgt = 0;
            }
        });


        TP.setBackground(Color.WHITE);
        setSize(530,520);
        setVisible(true);

        //화면 중앙정렬
        {
            Dimension frameSize = this.getSize();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            JD.setLocation((screenSize.width - frameSize.width)/2 + 220, (screenSize.height - frameSize.height)/2 +220);
        }

        TP.requestFocus(true);
        th.start();
    }


    class TetrisPanel extends JPanel {
        public void paintComponent(Graphics g){
            int cnt = 0 , cnt2 = 0;
            TP.requestFocus(true);
            super.paintComponent(g);
            lbl2.setLocation(353,120);
            TP.add(lbl2);

            lbl.setLocation(360,145);
            TP.add(lbl);
            lbl.setText(Integer.toString(score*100));

            g.setColor(Color.ORANGE); // 새로 떨어지는 블럭,미리보기  블럭 색깔
            // 다음 나올 도형 출력
            // 벽이 천장에 닿으면 ,게임 오버
            gameOverCheck();
//            // 한 행이 모두 블록으로 채워진 경우 블록들 제거(채워지지않은 경우 블록 떨어지도록)
            blockLocationSave(g);
            blockToWall(g);
            removeBlock(g);
            if(End == 1){
                random2 = new Random().nextInt(7);
                End = 0;
            }
            nextBlock_Draw(g);
            blockLocationDraw(g);
            makeBlock(g);
            makeBorder(g);

            // 블록이 벽에 착지하면 블록->벽으로 변환(떨어지는 블록 초기화)

            // 벽들을 생성

            // 테두리 생성

        }
        public void removeBlock(Graphics g){
            int cnt=0;
            for(int y =0;y<19;y++){
                for(int x =1; x<12 ; x++){
                    if(gameboard[y][x] == 1){
                        cnt++;
                    }
                }
                if(cnt == 11){
                    for(int i=y;i>1;i--)
                        for(int j=1;j<13;j++){
                            gameboard[i][j] = 0;
                            gameboard[i][j] = gameboard[i-1][j];
                        }
                    score++;
                }
                cnt = 0 ;
            }
        }

        public void blockToWall(Graphics g){
            for(int z = 0; z<4 ; z++)
                if(gameboard[curY[z]][curX[z]] == 1){
                    for (int j= 0; j<4;j++){
                        gameboard[curY[j]-1][curX[j]] = 1;
                        hgt-=blocksize;
                    }
                    wid =100;
                    hgt =0;
                    End = 1;
                    rotation = 0;
                    random = random2;
                }
        }

        public void makeBlock(Graphics g){
            g.setColor(Color.GRAY);
            for(int y=0; y<19;y++){
                for(int x=1; x<12; x++){
                    if(gameboard[y][x]== 1){
                        g.fill3DRect( x*20+20, y*20+60, 20, 20, true);
                    }
                }
            }
        }

        public void blockLocationSave(Graphics g){
            int cnt = 0;
            for(int j = 0; j<4 ;j++){
                for(int k = 0; k<4;k++){
                    if(blocks[random][rotation][j][k] == 1){
                        curX[cnt] = k+wid/blocksize; curY[cnt] = j+hgt/blocksize;//curX,Y[0][1][2][3]에 좌표 4개 저장
                        cnt ++;
                    }
                }
            }
        }

        public void blockLocationDraw(Graphics g){
            g.setColor(Color.ORANGE);
            int cnt = 0;
            for(int j = 0; j<4 ;j++){
                for(int k = 0; k<4;k++){
                    if(blocks[random][rotation][j][k] == 1){
                        g.fill3DRect((k+wid/blocksize)*blocksize+20, (j+hgt/blocksize)*blocksize+60, blocksize, blocksize, true);
                        cnt ++;
                    }
                }
            }
        }
        public void gameOverCheck(){
            for(int x=1;x<12;x++)
                if(gameboard[2][x]==1){
                    limit = true;
//                lbl.setLocation(50,50);
                    btn.setLocation(50,30);
                    JD.add(lbl);
                    JD.add(btn);
                    JD.setVisible(true);
                    break;
                }
        }

        public void rotationCheck() {
            int cnt2=0;
            boolean retun = false;
            int rotation2 = (rotation+1)%4;
            for(int j = 0; j<4 ;j++){
                for(int k = 0; k<4;k++){
                    if(blocks[random][rotation2][j][k] == 1){
                        curX[cnt2] = k+wid/blocksize;
                        curY[cnt2] = j+hgt/blocksize;
                        if(gameboard[j+hgt/blocksize][k+wid/blocksize]==1){
                            wid-=20;
                            if(gameboard[j+hgt/blocksize][k+(wid)/blocksize]==1){
                                wid+=20;
                                retun=true;
                            }
                        }
                        cnt2++;
                    }
                }
            }
            if(retun==false)rotation=rotation2;
        }
        public void makeBorder(Graphics g){
            g.setColor(Color.GRAY);

            g.draw3DRect(28, 70, 5, 375,true); // 기둥
            g.draw3DRect(265, 70, 5, 375, true); // 기둥
            g.draw3DRect(15, 445, 270, 5,true); // 바닥
           // g.draw3DRect(15, 65, 270, 5, true); // 천장
        }
        public void nextBlock_Draw(Graphics g){
            g.setColor(Color.YELLOW);
            for(int a = 0; a<4 ;a++){
                for(int b = 0; b<4;b++){
                    if(blocks[random2][0][a][b] == 1){
                        g.fill3DRect(b*20+120, a*20, 20, 20, true);
                    }
                }
            }
        }
        void moveUp(){
            rotationCheck();
            if(limit == false)
                repaint();
        }
        void moveDown(){
            if(limit == false){
                hgt+=blocksize;
                TP.repaint();
            }
        }
        void moveLeft(){
            int sel = collision_LEFT();// sel이 1이면 충돌
            if(sel != 1 && limit == false){
                wid -= blocksize;
                TP.repaint();
            }
        }
        void moveRight(){
            int sel = collision_LEFT();// sel이 2이면 충돌
            if(sel != 2 && limit == false){
                wid += blocksize;
                TP.repaint();
            }
        }
        // 왼쪽 벽에 충돌하면 못움직이도록
        public int collision_LEFT(){
            for(int i=0; i<4; i++){
                if(gameboard[curY[i]][curX[i]-1] == 1)  return 1;// 충돌시 1 반환
                else if(gameboard[curY[i]][curX[i]+1] == 1) return 2;
            }
            return 0; // 충돌하지 않으면 0 반환
        }
    }

    class TetrisThread extends Thread{
        TetrisPanel TP = new TetrisPanel();
        public void run(){
            while(true){
                try{
                    sleep(700);
                    if(limit == false){ // limit이 false일 경우에만 작동. true가 되면 테트리스 작동중지
                    TP.moveDown();}
                }catch(InterruptedException e){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new TetrisGB();
    }


    int[][] gameboard = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    int blocks[][][][]  =
            {
                    {
                            //■
                            //■■■
                            {
                                    {1,0,0,0},
                                    {1,1,1,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,0,0},
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,1,0},
                                    {0,0,1,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,1,0,0},
                                    {0,1,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0}
                            }
                    },
                    {

                            //  ■
                            //■■■
                            {
                                    {0,0,1,0},
                                    {1,1,1,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,1,0},
                                    {1,0,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,0,0},
                                    {0,1,0,0},
                                    {0,1,0,0},
                                    {0,0,0,0}
                            }
                    },
                    {
                            //  ■■
                            //  ■■
                            {
                                    {1,1,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,0,0},
                                    {1,1,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            }
                    },
                    {
                            // ■■■■
                            {
                                    {1,1,1,1},
                                    {0,0,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {1,0,0,0}
                            },
                            {
                                    {1,1,1,1},
                                    {0,0,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {1,0,0,0},
                                    {1,0,0,0}
                            }
                    },
                    {
                            //■
                            //■■■
                            {
                                    {0,1,0,0},
                                    {1,1,1,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,1,0,0},
                                    {1,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,1,1,0},
                                    {0,1,0,0},
                                    {0,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,1,0,0},
                                    {1,1,0,0},
                                    {0,1,0,0},
                                    {0,0,0,0}
                            }
                    },
                    {
                            //  ■■
                            //   ■■
                            {
                                    {0,0,0,0},
                                    {1,1,0,0},
                                    {0,1,1,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,1,0,0},
                                    {1,1,0,0},
                                    {1,0,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,0,0,0},
                                    {1,1,0,0},
                                    {0,1,1,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,1,0,0},
                                    {1,1,0,0},
                                    {1,0,0,0},
                                    {0,0,0,0}
                            }
                    },
                    {
                            //  ■■
                            // ■■
                            {
                                    {0,0,0,0},
                                    {0,1,1,0},
                                    {1,1,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,1,0,0},
                                    {0,1,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {0,0,0,0},
                                    {0,1,1,0},
                                    {1,1,0,0},
                                    {0,0,0,0}
                            },
                            {
                                    {1,0,0,0},
                                    {1,1,0,0},
                                    {0,1,0,0},
                                    {0,0,0,0}
                            }
                    }
            };

}
