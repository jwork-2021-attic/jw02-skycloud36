package task2;

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
        int n = 256;
        Line line = new Line(n);
        int[] r = s.makeRandomArray(0,255,n);
        int[] g = s.makeRandomArray(0,255,n);
        int[] b = s.makeRandomArray(0,255,n);
        // int[] color = s.makeRandomArray(0, 256*256*256-1, n);
        int[] len = s.makeRandomArray(0, n-1, n);
        for(int i = 0; i < n; i++)
        {
            Gorblin t = new Gorblin(r[i], g[i], b[i]);
            // Gorblin t = new Gorblin(color[i]);
            line.put(t, len[i]);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        
        // Sorter sorter = new BubbleSorter();
        // Sorter sorter = new QuickSort();
        Sorter sorter = new AlterSort();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("task2result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
