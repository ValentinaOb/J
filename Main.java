import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Ex: ");

        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();

            switch (a) {
                case 1:
                    main1(args);
                    break;

                case 2:
                    main2(args);

            }
        }
    }

    public static void main1(String[] args) throws IOException {

        int n = 0;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("File: ");
            String fileName = in.next();
            System.out.print("File1: ");
            String fileName1 = in.next();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String Str = "";

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            Str = scanner.nextLine();
            while (scanner.hasNextLine()) {
                Str = Str + "\n" + scanner.nextLine();
            }
            char[] ca = Str.toCharArray();

            System.out.println("\nCA: ");
            for (int i = 0; i < ca.length; i++) {
                System.out.print(ca[i]);
            }

            int count = 0;

            for (int i = 0; i < ca.length; i++) {
                if ((ca[i] >= '0') && (ca[i] <= '9')) {
                    count += 1;

                }
            }

            int[] ia = new int[count];

            for (int i = 0, j = 0; i < ca.length; i++) {
                if ((ca[i] >= '0') && (ca[i] <= '9')) {
                    ia[j++] = ca[i] - '0';
                }
            }

            System.out.println("\n\nIA: ");
            for (int i = 0; i < ia.length; i++) {
                System.out.println(ia[i]);
            }

            System.out.println("\nLine: " + count);

            int sum = 0;
            for (int i = 0; i < ia.length; i++) {
                sum += ia[i];
            }
            int sa = sum / ia.length;

            System.out.println("\nSum: " + sum + "\nSA: " + sa);

            Arrays.sort(ia);
            System.out.println("\nFinall: ");

            for (int i = 0; i < ia.length; i++) {
                if (ia[i] >= sa) {
                    System.out.println(ia[i]);

                } else {
                    FileWriter fw = new FileWriter(fileName1, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("\n" + ia[i]);
                    bw.newLine();
                    bw.close();
                }
            }
        }
        System.out.println();
    }

    public static void main2(String[] args) throws IOException {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("N: ");
            int n = in.nextInt();

            int[] count = new int[n];

            Scanner s = new Scanner(System.in);
            String[] fileName = new String[n];

            System.out.println("Name: ");

            for (int k = 0; k < n; k++) {
                fileName[k] = s.nextLine();
            }
            System.out.println("\n");
            for (int i = 0; i < n; i++) {
                try (Scanner sc = new Scanner(new FileInputStream(fileName[i]))) {
                    while (sc.hasNext()) {
                        sc.next();
                        count[i] += 1;
                    }
                    System.out.println("File: " + fileName[i] + "  |  Number: " + count[i]);
                }
            }
            System.out.println("\n");
        }
    }
}
