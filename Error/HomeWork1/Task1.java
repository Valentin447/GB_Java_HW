//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Task1 {
    static int[] arr = {1, 2, 3};

    public static void main(String[] args) {
        divisionByZero();
        arrayIndexOut(arr);
        nullPointerException();
    }

    static int divisionByZero() {
        return 5 / 0;
    }

    static void arrayIndexOut(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void nullPointerException() {
        int[] arrNull = null;
        int l = arrNull.length;
    }
}
