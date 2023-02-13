package study13;

class GrandParent{}
class Parent extends GrandParent{}
class Child extends Parent{}

class Family<T extends Parent>{
    private T t;
    public T getT(){
        return t;
    }
    public void setT(T t){
        this.t=t;
    }
}
public class LimitedTypeGenericClass {
    public static void main(String[] args) {
        Family f = new Family();
       // Family<GrandParent> f2 = new Family<>();
        Family<Parent> f3 = new Family<>();
        Family<Child> f4 = new Family<>();

        f3.setT(new Parent());
        f3.setT(new Child());

        f4.setT(new Child());

        //f.setT(new GrandParent());
        f.setT(new Parent());
        f.setT(new Child());
    }
}
