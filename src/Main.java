import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(args[0]);
        int count =  getlength(args[0]);
        Scanner scanner = new Scanner(new File(args[0]));
        int i = 0;
        int [] data = new int [count];
        while(scanner.hasNextInt())
        {
            data[i++] = scanner.nextInt();
        }

        MergeSort ms = new MergeSort(Integer.parseInt(args[2]));
        System.out.print("Data before sort : ");
        printArr(data);
        System.out.println();
        ms.sort(data,Integer.parseInt(args[1]));
        System.out.print("Data after  sort : ");
        printArr(data);
    }

    private static int getlength(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int i = 0;
        while(scanner.hasNextInt())
        {
            scanner.nextInt();
            i++;
        }
        return i;
    }

    private static void printArr(int[] arr) {
        for(int i : arr){
            System.out.print(i+" ");
        }
    }


}

