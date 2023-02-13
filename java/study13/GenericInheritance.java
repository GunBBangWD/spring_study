package study13;

class Parents<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t=t;
    }
}
class FirstChild<T> extends Parents<T>{

}
class SecondChild<T,V> extends Parents<T>{
    private V v;

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v=v;
    }

}

public class GenericInheritance {
    public static void main(String[] args) {
        Parents<String> parents = new Parents<>();
        parents.setT("parents generic class");
        System.out.println(parents.getT());

        FirstChild<String> firstChild = new FirstChild<>();
        firstChild.setT("ekekekek");
        System.out.println(firstChild.getT());

        SecondChild<String,Double> secondChild = new SecondChild<>();
        secondChild.setT("secondeeeeee");
        secondChild.setV(3.14);
        System.out.println(secondChild.getT()+"        V값 : "+secondChild.getV());

        Sup s = new Sup();
        s.testMethod(10);
        s.<Integer>testMethod(10);
        s.<Double>testMethod(34.12);

        Under un = new Under();
        un.<Double>testMethod(11.4);
    }
}
class Sup{
    <T extends Number> void testMethod(T t) {
        System.out.println(t);
    }
}

class Under extends Sup{}