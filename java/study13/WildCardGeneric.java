package study13;

import java.time.temporal.Temporal;

class Top{}
class Sub extends Top{}
class Cen extends Sub{}
class Bot extends Cen{}

class Team<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
class Member{
    void show1(Team<Top> t){};
    void show2(Team<?> t){};
    void show3(Team<? extends Sub> t){};
    void show4(Team<? super Sub> t){};


}

public class WildCardGeneric {
    public static void main(String[] args) {
       /* Member mem = new Member();
        mem.show1(new Team<Top>());
        mem.show1(new Team<Sub>());
        mem.show1(new Team<Cen>());
        mem.show1(new Team<Bot>());

        mem.show2(new Team<Top>());
        mem.show2(new Team<Sub>());
        mem.show2(new Team<Cen>());
        mem.show2(new Team<Bot>());

        mem.show3(new Team<Top>());
        mem.show3(new Team<Sub>());
        mem.show3(new Team<Cen>());
        mem.show3(new Team<Bot>());

        mem.show4(new Team<Top>());
        mem.show4(new Team<Sub>());
        mem.show4(new Team<Cen>());
        mem.show4(new Team<Bot>());*/
    }
}
