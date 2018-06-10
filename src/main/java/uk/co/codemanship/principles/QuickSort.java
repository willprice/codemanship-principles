package uk.co.codemanship.principles;

public class QuickSort {
    public int[] sortAsc(int[] input) {
        return quicksort(input, 0, input.length - 1);
    }

    private int[] quicksort(int[] input, int left, int right) {
        int lowerBound = left, upperBound = right;
        int pivot = input[(left + right) / 2];

        int index = partition(input, pivot, lowerBound, upperBound);
        if (left < index - 1){
            quicksort(input, left, index - 1);
        }
        if (index < right - 1){
            quicksort(input, index, right);
        }
        return input;
    }

    private int partition(int[] input, int pivot, int lowerBound, int upperBound) {
        while (lowerBound < upperBound) {
            while (input[lowerBound] < pivot)
                lowerBound++;
            while (input[upperBound] > pivot)
                upperBound--;
            if (lowerBound < upperBound) {
                swap(input, lowerBound, upperBound);
                lowerBound++;
                upperBound--;
            }
        }

        return lowerBound;
    }

    private void swap(int[] input, int i, int j) {
        int old_left = input[i];
        input[i] = input[j];
        input[j] = old_left;
    }

}
