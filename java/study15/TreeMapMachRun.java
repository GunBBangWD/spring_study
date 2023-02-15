package study15;

import study14.Member1;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapMachRun {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tmap1 = new TreeMap<>();
        Integer intval1 = 30;
        Integer intVal2 = 20;
        tmap1.put(intval1, 1);
        tmap1.put(intVal2, 3);
        System.out.println(tmap1);

        TreeMap<String, String > tmap2 = new TreeMap<>();
        String str1 = new String("당신");
        String  str2 = new String("우리");
        tmap2.put(str1, "you");
        tmap2.put(str2, "we");
        System.out.println(tmap2);

        ComparMemberTreeMap ctm = new ComparMemberTreeMap();
        Member lee = new Member(101, "이순신", 32);
        Point leep = new Point(1000);
        ctm.addMember(lee,leep);
        Member koo = new Member(102, "송시열", 32);
        Point koop = new Point(1000);
        ctm.addMember(koo,koop);
        Member song = new Member(103, "구준표", 18);
        Point songp = new Point(1000);
        ctm.addMember(song,songp);
        ctm.showAll();
        System.out.println("------------------------------");
        if (ctm.removeMember(101)) {
            System.out.println("삭제완료");
        } else System.out.println("해당 아이디 없음");
        ctm.showAll();


    }
}

class ComparMemberTreeMap {
    private TreeMap<Member, Point> tmap;
    public ComparMemberTreeMap() {tmap = new TreeMap<Member, Point>();}
    public void addMember(Member member, Point point) {tmap.put(member, point);}
    public void showAll() {
        for (Map.Entry<Member, Point> entry : tmap.entrySet()) {
            Member m = entry.getKey();
            Point p = entry.getValue();
            System.out.println(m.toString());
            System.out.println(p.toString());

        }
    }

    public boolean removeMember(Integer MemberId) {
        /*Iterator<Member> itr = tmap.keySet().iterator();
        while (itr.hasNext()) {
            Member mem = itr.next();
            if (mem.getMemberId() == MemberId) {
                tmap.remove(mem);
                return true;
            }
        }*/
        for (Member mem:tmap.keySet()) {
            if (mem.getMemberId()==MemberId){
                tmap.remove(mem);
                return true;
            }
        }
        return false;
    }
    public TreeMap<Member, Point> getTmap() {return tmap;}
    public void setTmap(TreeMap<Member, Point> tmap) {this.tmap = tmap;}

}
