package study15_2;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoEx {
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        new LottoEx().lottoStart();
    }
    public void lottoStart() {
        while (true) {
            //탈출조건
            //메뉴 출력 (구매, 종료)
            lottoMenu();
            //메뉴 입력
            System.out.print("메뉴선택: ");
            int menu = scan.nextInt();
            if (menu == 2) {
                System.out.println("종료");
                break;
            } else if (menu == 1) {
                getLotto();
                //구입금액
                //로또번호 생성
                //기타 정보
            } else System.out.println("입력오류");

            //반복 끝
        }
    }

    public void getLotto() {
        //구입금액
        System.out.print("금액입력: ");
        int money = scan.nextInt();
        if (money < 1000) {
            System.out.println("1000원이 안됩니다");
            return;
        }else if(money>100000){
            System.out.println("십만원이상은 구매불가");
            return;
        }
        //로또번호 생성
        makeLotto(money);
        System.out.println("받은금액 "+money+"원");
        System.out.println("거스름돈 "+(money%1000)+"원");

    }
    public void makeLotto(int money) {
        TreeSet<Integer> lottoset = new TreeSet<>();
        int count = money/1000;
        System.out.println("로또 번호 출력");
        for(int i=0;i<count;i++){
            while (lottoset.size() < 6) {
                lottoset.add(new Random().nextInt(45)+1);
            }
            for(int j:lottoset) System.out.print(j+" ");
            System.out.println();
            lottoset.clear();
        }

    }

    public void lottoMenu() {
        System.out.println("lotto 판매점");
        System.out.println("------메뉴------");
        System.out.println("1.lotto 구입");
        System.out.println("2. 종  료");
        System.out.println("---------------");
    }
}
