package study15;

import study14.Member1;

public class Member implements Comparable<Member>{
    private Integer memberId;
    private String memberName;
    private Integer memberAge;

    public Member(int memberId, String name, int memberAge) {
        this.memberId = memberId;
        this.memberName = name;
        this.memberAge = memberAge;
    }
    public Integer getMemberId() {return memberId;}
    public void setMemberId(Integer memberId) {this.memberId = memberId;}
    public String getMemberName() {return memberName;}
    public void setMemberName(String memberName) {this.memberName = memberName;}
    public Integer getMemberAge() {return memberAge;}
    public void setMemberAge(Integer memberAge) {this.memberAge = memberAge;}

    @Override
    public int hashCode() {return memberId.hashCode();}
    @Override
    public String toString() {return String.format("||Id: "+memberId+"||이름: "+memberName+"||나이: "+memberAge);}
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            return ((Member) obj).getMemberId() == this.memberId;
        }else return false;
    }
        @Override
    public int compareTo(Member mem) {
        //return this.memberId.compareTo(mem.getMemberId());
        return this.memberName.compareTo(mem.getMemberName());
        // return this.memberage.compareTo(mem.getmemberAge());
    }
}

class Point {
    private int point;

    public Point(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "포인트 =" + point;
    }
}
