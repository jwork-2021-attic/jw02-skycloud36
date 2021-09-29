package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {
    public int[] makeRandomArray(int min, int max, int count){
        int len = max - min + 1;
        int [] source = new int[len];
        int [] result = new int[count];
        for(int i = min; i < min + len; i++){
            source[i - min] = i;
        }
        Random r = new Random();
        int index = 0;
        for(int i = 0; i < count; i++)
        {
            index = Math.abs(r.nextInt() % len);
            len--;
            result[i] = source[index];
            source[index] = source[len];
        }
        return result;
    }
    public static void main(String[] args) throws IOException {

        Scene s = new Scene();
        int n = 16;
        int m = n * n;
        Matrix matrix = new Matrix(n, n);
        int[] r = s.makeRandomArray(0,255,m);
        int[] g = s.makeRandomArray(0,255,m);
        int[] b = s.makeRandomArray(0,255,m);
        // int[] color = s.makeRandomArray(0, 256*256*256-1, m);
        int[] len = s.makeRandomArray(0, m-1, m);
        for(int i = 0; i < m; i++)
        {
            Gorblin t = new Gorblin(r[i], g[i], b[i]);
            // Gorblin t = new Gorblin(color[i]);
            matrix.put(t, len[i]);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        // Sorter sorter = new BubbleSorter();
        // Sorter sorter = new QuickSort();
        Sorter sorter = new AlterSort();

        theGeezer.setSorter(sorter);

        // String log = theGeezer.lineUp(line);
        String log = theGeezer.matrixUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("task3result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
