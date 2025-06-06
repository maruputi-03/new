import java.util.*;

public class Main {
    public static int countReturnsToOrigin(int[] A) {
        int position = 0;
        int count = 0;

        for (int move : A) {
            position += move;
            if (position == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // Read number of moves
        int[] A = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int result = countReturnsToOrigin(A);
        System.out.println(result);  // Output the count
    }
}