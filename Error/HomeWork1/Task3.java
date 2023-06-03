//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
// необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {1, 2, 3};
        arraysDivision(arr1, arr2);
    }

    public static int[] arraysDivision(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Один из массивов равен null.");
        }
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны.");
        }

        int[] rez = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Делить на ноль нельзя.");
            }
            rez[i] = arr1[i] / arr2[i];
        }
        return rez;
    }

}
