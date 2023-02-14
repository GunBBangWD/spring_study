package study13;

public class UtilBoxRun {
    public static void main(String[] args) {
        UtilBox ub = new UtilBox();
        System.out.println(ub.<String>boxing(("사과")));
        System.out.println(ub.boxing("오렌지"));

        System.out.println(ub.<Integer>boxing(3, 3));
        System.out.println(ub.<String>boxing("우리", "나"));

        String str1 = new String("당신");
        String str2 = new String("당신");
        System.out.println(str1.equals(str2));
        System.out.println(ub.<String>boxing(str1, str2));

        ub.<String,Integer>boxing2("java", 90);

    }
}
