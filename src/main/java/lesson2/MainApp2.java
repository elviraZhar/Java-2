package lesson2;

import java.util.Arrays;

public class MainApp2 {
    public static void main (String [] args) throws Throwable {
    class MyArraySizeException extends Throwable{
        MyArraySizeException(String s) {
            super(s);
        }
    }
    class MyArrayDataExceotion extends Throwable{
        MyArrayDataExceotion(int i, int j) {
                super();
        }
    }

    public void changeArray(String[][] arr){

        String[][] arr = {{"1","2","3","4"}, {"5","6","7","8"}, {"9","16","10","11"}, {"12","13","14","15"}};
        int [][] arrI = new int[4][4];
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException("Неверное количество строк");
            for (int i = 0; i <arr.length; i++) {
                if (arr[i].length != 4) throw new MyArraySizeException("Неверное количество столбцов");
                int j;
                for (j = 0; j < arr.length; j++) {
                    try {
                        arrI[i][j] = Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataExceotion(i,j);
                    }
                    System.out.println("Ошибка в поле " + i + j);
                }
                sum = sum + arrI[i][j];
            }
        }
        System.out.println(sum);
    }

    }
}
