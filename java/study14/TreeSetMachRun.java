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

        CompareMemberTreeSet cts = new CompareMemberTreeSet();
        Member lee = new Member(101, "이순신", 45);
        cts.addMember(lee);
        Member koo = new Member(102, "송시열", 32);
        cts.addMember(koo);
        Member song = new Member(103, "구준표", 18);
        cts.addMember(song);
        cts.showAll();

    }
}
