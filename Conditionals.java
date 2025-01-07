public class Conditionals{
    public static void main(String []args){
        if (20 > 18){
            System.out.println("20 is greater than 18");
        }
        int time = 20;

        if (time < 18){
            System.out.println("good evening");
        }
        else {
            System.out.println("good evening");
        }


        // short hand

        String result = (time < 18) ? " good day " : "good evening";

        System.out.println(result);
    }
}