package Lesson_07.Ex003;

public class Program {

    public static void main(String[] args) {
        Point2D a = new Point2D(0, 2);

        System.out.println(a.getX());
        // Point2D a = new Point2D(0, 2);
        System.out.println(a.getX());
        System.out.println(a.getY());
        Point2D b = new Point2D(0);
        System.out.println(b);
        // Point2D b = new Point2D(0, 10);


        /*
        * Если есть static, то обращаться нужно через имя типа, здесь например поинт2д а
        * не через конкретный экземпляр а или b 
        */
        var dis = Point2D.distance(a, b);
        System.out.println(dis);
    }
}

