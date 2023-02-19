package study14;

import java.util.TreeSet;

public class TreeSetMachRun {
    public static void main(String[] args) {
        TreeSet<String> tset1 = new TreeSet<>();
        String str1 = new String("당신");
        String str2 = new String("당신");
        tset1.add(str1);
        tset1.add(str2);
        System.out.println(tset1);

        CompareMemberTreeSet1 cts = new CompareMemberTreeSet1();
        Member1 song = new Member1(103, "구준표", 18);
        cts.addMember(song);
        Member1 lee = new Member1(101, "이순신", 32);
        cts.addMember(lee);
        Member1 koo = new Member1(101, "송시열", 32);
        cts.addMember(koo);
        cts.showAll();

    }
}
