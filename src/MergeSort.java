import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;


public class MergeSort {
    private final ForkJoinPool pool;

    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int low;
        private final int high;
        private final int THRESHOLD;


        protected MergeSortTask(int[] array, int low, int high, int min) {
            this.array = array;
            this.low = low;
            this.high = high;
            this.THRESHOLD = min;
        }

        @Override
        protected void compute() {
            if (high - low <= THRESHOLD) {
                Arrays.sort(array, low, high);
            } else {
                int middle = low + ((high - low) >> 1);
                // Execute the sub tasks and wait for them to finish
                invokeAll(new MergeSortTask(array, low, middle,THRESHOLD), new MergeSortTask(array, middle, high,THRESHOLD));
                // Then merge the results
                merge(middle);
            }
        }

        private void merge(int middle) {
            if (array[middle - 1] < array[middle]) {
                return; // the arrays are already correctly sorted, so we can skip the merge
            }
            int[] copy = new int[high - low];
            System.arraycopy(array, low, copy, 0, copy.length);
            int copyLow = 0;
            int copyHigh = high - low;
            int copyMiddle = middle - low;

            for (int i = low, p = copyLow, q = copyMiddle; i < high; i++) {
                if (q >= copyHigh || (p < copyMiddle && copy[p] < copy[q]) ) {
                    array[i] = copy[p++];
                } else {
                    array[i] = copy[q++];
                }
            }
        }

    }


    public MergeSort(int parallelism) {
        pool = new ForkJoinPool(parallelism);
    }


    public void sort(int[] array, int min) {
        ForkJoinTask<Void> job = pool.submit(new MergeSortTask(array, 0, array.length, min));
        job.join();
    }
}