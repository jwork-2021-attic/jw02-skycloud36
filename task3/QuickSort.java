package task3;

public class QuickSort implements Sorter{
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        // plan += "" + a[i] + "<->" + a[j] + "\n";
        plan += "" + i + "<->" + j + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        quickSort(0, a.length);
    }

    public void quickSort(int start, int end){
        int pa = p(start, end);
        if(pa != -1){
            quickSort(start, pa);
            quickSort(pa+1, end);
        }
    }
    public int p(int start, int end){
        if(start >= end - 1)
            return -1;
        int res = start;
        int temp = a[start];
        for(int i = start + 1; i < end; i++){
            if(a[i] < temp){
                if(i == res+1)
                    res++;
                else{
                    res++;
                    swap(i, res);
                }
            }
        }
        if(res != start)
            swap(start, res);
        return res;
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
