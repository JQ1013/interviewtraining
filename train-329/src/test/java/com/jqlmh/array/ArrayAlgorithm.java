package com.jqlmh.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LMH
 * @create 2020-05-02 15:29
 */
public class ArrayAlgorithm {

	/**
	 * 选择排序
	 */
	@Test
	public void test1() {
		//1.直接选择排序[双层循环]
		/*
		  1.外层循环是控制已经排好序的索引的,所以最多只能到数组的倒数第二位,也就是   [<长度-1]
		  2.内存循环是控制未排序的索引开始位置的,排序已经排好序的,从i+1开始,到最后一位
		  3.内层循环需要找打最小值的索引,外层循环需要交换当前未排序第一位的值和最小索引处的值
		 */
		int[] arr = {56, 48, 13, 46, 18, 6, 23, 45, 6, 23, 8, 99, 13, 49, 1, -23, 46, 1, 3, 1, 43, 13, 56};

		int minIndex;

		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}


	//交换排序:冒泡排序
	@Test
	public void test2() {

		int[] arr = {56, 48, 13, 18, 3};

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					System.out.println(Arrays.toString(arr));
				}
			}

			System.out.println("第" + (j + 1) + "次排序为:" + Arrays.toString(arr));
		}
	}


	/**
	 * 快速排序
	 */
	@Test
	public void test3() {

		int[] arr = {1, 2, 3, 4, 5, 6, 4, 8};
		int[] arr2 = new int[10000000];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = new Random().nextInt(100000000);
		}

		quickSort(arr2, 0, arr2.length - 1);
		System.out.println(Arrays.toString(arr2));

	}


	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || low < 0 || high > arr.length - 1) {
			throw new IllegalArgumentException("参数不合要求");
		}
		if (low > high) {
			return;
		}
		int i = low;
		int j = high;
		int base = arr[low];  //基准值
		int temp;

		while (i < j) {
			while (base <= arr[j] && i < j) {
				j--;
			}
			while (arr[i] <= base && i < j) {
				i++;
			}
			if (i < j) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		//最后将基准与i和j相等位置的数字交换
		arr[low] = arr[i];
		arr[i] = base;

		quickSort(arr, low, j - 1);
		quickSort(arr, j + 1, high);
	}



	@Test
	public void test5(){

	}

	/**
	 * 求最小公倍数
	 * @param x
	 * @param y
	 * @return
	 */
	public int lowestCommonMultiple(int x,int y){

		return 0;
	}

}
