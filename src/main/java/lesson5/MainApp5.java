package lesson5;

public class MainApp5 {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main (String [] args) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("time filling " + a);//время заполнения "1"

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("time calculation " + (System.currentTimeMillis()));//время заполнения по формуле
        System.out.println(System.currentTimeMillis() - a);//разница времени

        float[] a1 = new float[5000000];
        float[] a2 = new float[5000000];

        System.arraycopy(arr, 0, a1, 0, 5000000);
        System.arraycopy(arr, 5000000, a2, 0, 5000000);
        long b = System.currentTimeMillis();
        System.out.println("time division " + b);//время деления

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        long d = System.currentTimeMillis();
        System.out.println("time flov 1 " + d);//время исполнения 1 потока

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread2.start();
        long e = System.currentTimeMillis();
        System.out.println("time flov 2 " + e);//время исполнения 2 потока

        System.arraycopy(a1, 0, arr, 0, 5000000);
        System.arraycopy(a2, 0, arr, 5000000, 5000000);
        long c = System.currentTimeMillis();
        System.out.println("time gluing " + c);//время склейки
    }
}
