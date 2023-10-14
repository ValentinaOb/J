import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = 0;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("File: ");
            String fileName = in.next();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String Str = "";

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            Str = scanner.nextLine();
            while (scanner.hasNextLine()) {
                Str = Str + "\n" + scanner.nextLine();
            }
            char[] ca = Str.toCharArray();

            /*
             * int[] ia = new int[100];
             * int j = 0;
             * while (scanner.hasNextInt()) {
             * ia[j++] = scanner.nextInt();
             * }
             */

            System.out.println("\nCA: ");
            for (int i = 0; i < ca.length; i++) {
                System.out.print(ca[i]);
            }

            // int ia = Integer.parseInt(new String(ca));

            int count = 0;
            int count1 = 0;
            for (int i = 0; i < ca.length; i++) {
                if ((ca[i] >= '0') && (ca[i] <= '9')) {
                    count += 1;

                } else
                    count1 += 1;
            }

            int[] ia = new int[count];

            for (int i = 0; i < ca.length; i++) {
                if ((ca[i] >= '0') && (ca[i] <= '9')) {
                    for (int j = 0; j < count; j++)
                        ia[j] = ca[i] - '0';
                    /*
                     * for (int i = 0; i < Str.length(); i++) {
                     * if ((Str.charAt(i) >= '0') && (Str.charAt(i) <= '9'))
                     * for (int k = 0; k < count; k++) {
                     * ia[k] = Str.charAt(i) - '0';
                     * }
                     */
                }
            }

            /*
             * System.out.println("\nIA: ");
             * for (int i : ia) {
             * System.out.println(i);
             * }
             */
            System.out.println("\n\nIA: ");
            for (int i = 0; i < ia.length; i++) {
                System.out.println(ia[i]);
            }

            System.out.println("\nLine: " + count + "\nLineW: " + count1);

            int sum = 0;
            for (int i = 0; i < ia.length; i++) {
                sum += ia[i];
            }
            int sa = sum / ia.length;

            System.out.println("\nSum: " + sum + "\nSA: " + sa);

            Arrays.sort(ia);
            System.out.println("\nFinall: ");

            for (int i = 0; i < ia.length; i++) {
                if (ia[i] < sa) {
                    System.out.println(ia[i]);

                } else {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    writer.write("\n\n\n" + ia[i]);
                }
            }
        }
    }
}