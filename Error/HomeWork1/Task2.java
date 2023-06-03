// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

public class Task2 {
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
}

// 1) Если длина второго массива больше 5, будет выход за пределы массива.  ArrayIndexOutOfBoundsException
// 2) Если будет значение элемента массива которое нельзя привести к типу Integer. NumberFormatException
// 3) Если в ссылки массива arr будет null. NullPointerException