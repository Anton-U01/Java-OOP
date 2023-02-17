package WorkingwithAbstractionLab.PointinRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(coordinates[0],coordinates[1]);
        Point topRight = new Point(coordinates[2],coordinates[3]);
        Rectangle rectangle = new Rectangle(bottomLeft,topRight);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Point point = new Point(data[0],data[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
