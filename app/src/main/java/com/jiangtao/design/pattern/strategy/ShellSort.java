package com.jiangtao.design.pattern.strategy;

/**
 * Created by kevin on 16/9/5.
 * 希尔排序
 */
public class ShellSort implements SortAlgorithm {
  @Override public int[] sortArray(int[] arr) {
    int gap = 1, i, j, len = arr.length;
    int temp;
    while (gap < len / 3)
      gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
    for (; gap > 0; gap /= 3)
      for (i = gap; i < len; i++) {
        temp = arr[i];
        for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
          arr[j + gap] = arr[j];
        arr[j + gap] = temp;
      }
    return arr;
  }
}
