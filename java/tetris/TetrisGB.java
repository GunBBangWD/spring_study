package tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.util.List;

public class TetrisGB extends JFrame {
    Dimension frameSize = this.getSize();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static int blocksize = 20;
    int hgt=20;
    int wid=100;
    int rotation = 0;
    int random = 3;
    int random2 = new Random().nextInt(7);
    int End = 0;
    int score = 0;
    JButton btn = new JButton("재도전");
    JLabel lbl = new JLabel();
    JLabel lbl2 = new JLabel();


    TetrisThread th;
    boolean limit = false;
    boolean saveCheck = true;
    boolean saveCheck2 = true;
    boolean saveCheck3 = true;
    TetrisPanel TP = new TetrisPanel();
    JDialog JD = new JDialog();
    JDialog RankList = new JDialog();

    int ABC = 0;
    JLabel lb1 = new JLabel("A");
    JLabel lb2 = new JLabel("B");
    JLabel lb3 = new JLabel("C");
    JLabel lb4 = new JLabel("▼");
    JLabel[] jLabel = new JLabel[11];


    int lb4Wid=75;

    GridBagConstraints c=new GridBagConstraints();


    int curX[]= new int[4], curY[] = new int [4]; // 블록들의 좌표 저장

    public void layout(Component obj, int x, int y,int width, int height)
    {
        c.gridx=x; // 시작위치 x
        c.gridy=y; // 시작위치 y
        c.gridwidth=width; // 컨테이너 너비
        c.gridheight=height;  // 컨테이너 높이
        add(obj,c);
    };

    TetrisGB(){

        setTitle("테트리스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        TP.setSize(720,900);
        add(TP);

//        JD.setTitle("점수");
//        JD.setSize(300,450);
//        JD.setLayout(new GridBagLayout());

        JD.setTitle("점수기록");
        JD.setSize(250,190);
        JD.setLayout(null);

        RankList.setTitle("랭킹목록");
        RankList.setSize(530,520);
        RankList.setLayout(null);


        TP.setBackground(Color.WHITE);
        setSize(530,520);
        setVisible(true);


        lbl.setFont(new Font("arial",Font.PLAIN,15));
        lbl2.setText("점  수");
        lbl2.setFont(new Font("나눔고딕",Font.PLAIN,15));
        th = new TetrisThread();

        //화면 중앙정렬
        {
//            setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
//            JD.setLocation((screenSize.width - frameSize.width)/2 + 220, (screenSize.height - frameSize.height)/2 +220);
//            RankList.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

            setLocation((screenSize.width - frameSize.width) / 2/2, (screenSize.height - frameSize.height) / 2/2);
            JD.setLocation((screenSize.width - frameSize.width)/2/2+220, (screenSize.height - frameSize.height)/2/2+220);
            RankList.setLocation((screenSize.width - frameSize.width) / 2/2, (screenSize.height - frameSize.height) / 2/2);

        }




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

        JD.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP) {
                    if(ABC == 0){
                        if(lb1.getText().charAt(0)==90)lb1.setText("A");
                        else lb1.setText(String.valueOf((char)(lb1.getText().charAt(0)+1)));
                    }else if(ABC == 1){
                        if(lb2.getText().charAt(0)==90)lb2.setText("A");
                        else lb2.setText(String.valueOf((char)(lb2.getText().charAt(0)+1)));
                    }else{
                        if(lb3.getText().charAt(0)==90)lb3.setText("A");
                        else lb3.setText(String.valueOf((char)(lb3.getText().charAt(0)+1)));
                    }
                }
                if(keyCode == KeyEvent.VK_DOWN){
                    if(ABC == 0){
                        if(lb1.getText().charAt(0)==65)lb1.setText("Z");
                        else lb1.setText(String.valueOf((char)(lb1.getText().charAt(0)-1)));
                    }else if(ABC == 1){
                        if(lb2.getText().charAt(0)==65)lb2.setText("Z");
                        else lb2.setText(String.valueOf((char)(lb2.getText().charAt(0)-1)));
                    }else{
                        if(lb3.getText().charAt(0)==65)lb3.setText("Z");
                        else lb3.setText(String.valueOf((char)(lb3.getText().charAt(0)-1)));
                    }
                }
                if(keyCode == KeyEvent.VK_ENTER){
                    ABC++;
                    lb4Wid+=25;
                    lb4.setBounds(lb4Wid,75,20,20);
                    if(ABC==3){
                        JD.setVisible(false);
                        makeRankList();
                    }
                }

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
                TP.setVisible(true);
                RankList.setVisible(false);
                RankList.removeAll();

                RankList = new JDialog();
                RankList.setTitle("랭킹목록");
                RankList.setSize(530,520);
                RankList.setLayout(null);
                jLabel = new JLabel[11];
                RankList.setLocation((screenSize.width - frameSize.width) / 2/2, (screenSize.height - frameSize.height) / 2/2);
                setVisible(true);

            }
        });




        TP.requestFocus(true);
        th.start();
        random2 = new Random().nextInt(7);
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



            // 벽이 천장에 닿으면 ,게임 오버
            gameOverCheck();



            //블록 좌표 생성, 저장
            blockLocationSave(g);
            // 블록이 바닥에 닿으면
            blockToWall(g);
            // 블록 한줄이 완성되면 지워줌
            removeBlock(g);
            // 다음 블록 미리 그려줌
            nextBlock_Draw(g);
            // 블록 상태 gui로 그려줌
            blockLocationDraw(g);
            // 맵의 벽돌 상태 gui로 그려줌
            makeBlock(g);
            // 맵 틀 gui로 그려줌
            makeBorder(g);



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

            if(End == 1){
                random2 = new Random().nextInt(7);
                End = 0;
            }
        }

        public void blockToWall(Graphics g){
            for(int z = 0; z<4 ; z++)
                if(gameboard[curY[z]][curX[z]] == 1){
                    for (int j= 0; j<4;j++){
                        if(limit==false)
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
                   // btn.setLocation(50,30);
//                    String s = "점수 : "+lbl.getText();

                    lbl.setText("점수 : "+lbl.getText());
                    lbl.setFont(new Font("Serif", Font.CENTER_BASELINE,20));
                    lbl.setBounds(75,0,100,50);

                    lb1.setBounds(75,100,20,20);
                    lb1.setFont(new Font("Serif", Font.CENTER_BASELINE,20));
                    lb2.setBounds(100,100,20,20);
                    lb2.setFont(new Font("Serif", Font.CENTER_BASELINE,20));
                    lb3.setBounds(125,100,20,20);
                    lb3.setFont(new Font("Serif", Font.CENTER_BASELINE,20));
                    lb4.setBounds(lb4Wid,75,20,20);
                    lb4.setFont(new Font("Serif", Font.CENTER_BASELINE,20));


                    JD.add(lbl);
                    JD.add(lb1);
                    JD.add(lb2);
                    JD.add(lb3);
                    JD.add(lb4);

//                    JD.add(btn);
                    JD.setVisible(true);
                    TP.setVisible(false);
                    JD.requestFocus();
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

    public void makeRankList(){
        String RankFile = "tetris/rank.txt";
        saveCheck=true;
        saveCheck2 = true;
        saveCheck3 = true;
        List<String[]> RankFileList = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(RankFile)));
        ) {
            String line=null;
            while ((line = br.readLine()) != null) {
                RankFileList.add(line.split("      "));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int x=20,y=20,ListWid=450,ListHgt=50;
        String rankstr = "";
        String schScorce="";
        String schName="";
        for (int i=0;i<RankFileList.size();i++) {
            for(int j=0;j<3;j++){
                System.out.print(RankFileList.get(i)[j]+" ");
                rankstr+=RankFileList.get(i)[j]+"      ";
            }

            if(rankstr.split("      ")[1].equals("-")){
                if(saveCheck){
                    saveCheck=false;
                    if(!saveCheck2){
                        saveCheck2=true;
                        jLabel[i] = new JLabel(rankstr.split("      ")[0]+"      "+schScorce+"      "+schName);
                        schScorce = "";
                        schName = "";
                    }else {
                        jLabel[i] = new JLabel(rankstr.split("      ")[0]+"      "+Integer.toString(score*100)+"      "+lb1.getText()+lb2.getText()+lb3.getText());
                    }
                }else {
                    jLabel[i]=new JLabel(rankstr);
                }
            }else {
                if(saveCheck){
                    if(score*100 <= Integer.parseInt(rankstr.split("      ")[1])){
                        if(i==9)jLabel[i] = new JLabel(rankstr.split("      ")[0]+"      "+Integer.toString(score*100)+"      "+lb1.getText()+lb2.getText()+lb3.getText());
                        else {
                            jLabel[i] = new JLabel(rankstr);
                        }
                    } else{
                        jLabel[i] = new JLabel(rankstr.split("      ")[0]+"      "+Integer.toString(score*100)+"      "+lb1.getText()+lb2.getText()+lb3.getText());
                        schScorce=rankstr.split("      ")[1];
                        schName=rankstr.split("      ")[2];
                        score = Integer.parseInt(schScorce)/100;
                        saveCheck2=false;
                    }
                }else{
                    jLabel[i]=new JLabel(rankstr);
                }
            }

            jLabel[i].setBounds(x,y,ListWid,ListHgt);
            jLabel[i].setFont(new Font("Serif", Font.CENTER_BASELINE,20));
            RankList.add(jLabel[i]);
            rankstr="";
            System.out.println();
            y+=28;
        }

        try (
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(RankFile));
                BufferedWriter bw = new BufferedWriter(osw)
        ) {
            String line = null;
            for (int i=0;i<10;i++){
                bw.write(jLabel[i].getText() + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        btn.setBounds(150,400,200,30);
        RankList.add(btn);
        RankList.repaint();
        RankList.setVisible(true);
        setVisible(false);


        ABC=0;
        lb4Wid=75;
        lb1.setText("A");
        lb2.setText("B");
        lb3.setText("C");
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
