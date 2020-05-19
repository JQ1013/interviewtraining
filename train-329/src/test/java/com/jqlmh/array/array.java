package com.jqlmh.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LMH
 * @create 2020-05-02 12:17
 */
public class array {


	/**
	 * 数组的最大值、最小值、平均数、总和
	 */
	@Test
	public void test3() {

		//最大值
		int[] a1 = {18, 233, 3, 47, 23};
		int max = a1[0];
		for (int i = 0; i < a1.length - 1; i++) {
			if (max < a1[i + 1]) {
				max = a1[i + 1];
			}
		}
		System.out.println(max);


		//最小值
		int[] a2 = {124, 263, -33, 47, -23};
		int min = a2[0];
		for (int i = 0; i < a2.length - 1; i++) {
			if (min > a2[i + 1]) {
				min = a2[i + 1];
			}
		}
		System.out.println(min);

		//总和
		int sum = 0;
		for (int i1 : a2) {
			sum += i1;
		}
		System.out.println(sum);


	}

	/*
	数组的赋值、复制、反转
	 */
	@Test
	public void test2() {


		//1.复制:操作的是两个不同内存地址的对象,操作a1的内容,a2的内容不会改变
		int[] a1 = {1, 2, 3, 4};
		int[] a2 = new int[a1.length];
		System.arraycopy(a1, 0, a2, 0, a1.length);
		System.out.println(Arrays.toString(a2));


		//2、赋值:将a1的引用赋值给a3[将a1堆空间的内存地址引用赋值为a3]:操作的是同一个对线,任何一个引用操作这个数字对象的值,另外一个引用都会变化
		int[] a3 = a1;
		System.out.println(a3[1]);
		System.out.println(a1);

		//3.反转[]
		//方式一、硬编码
		int[] a4 = {1, 2, 3, 4};
		for (int i = 0; i < a4.length / 2; i++) {
			int temp = a4[i];
			a4[i] = a4[a4.length - i - 1];
			a4[a4.length - i - 1] = temp;
		}
		System.out.println(Arrays.toString(a4));


		//方式二:使用Collections工具类的reverse()方法   [list的泛型为Integer]
		Integer[] a5 = {1, 2, 3, 4};
		Integer[] a6 = a5;
		System.out.println("-----" + a6[1]);
		List<Integer> list = Arrays.asList(a5);

		Collections.reverse(list);
		System.out.println(list);

	}

	@Test
	public void test() {
		int[] a1 = new int[5];
		System.out.println(a1[0]);


		String[] s = new String[5];
		System.out.println(s[1]);

		boolean[] b = new boolean[5];
		System.out.println(b[3]);

		char[] c = new char[5];
		System.out.println(stringToUnicode(new String(Character.toString(c[1]))));

		int[][] a2 = new int[5][];
		System.out.println(a2[1]);

		int[] arr1 = new int[]{1, 2, 3};
		arr1 = null;
		System.out.println(arr1[0]);
	}


	/**
	 * 手写二分查找
	 */
	@Test
	public void test1() {
		int[] arr = new int[]{-99, -54, -2, 0, 2, 33, 43, 256, 999};
		//定义一个是否找到的标志,flag
		boolean flag = false;

		int num = -99; //要查找的数
		int head = 0;  //首索引位置
		int end = arr.length - 1; //尾索引位置

		while (head <= end) {

			//中间索引
			int mid = (head + end) / 2;

			if (arr[mid] == num) {
				//等于
				System.out.println("找到了" + num + "索引为:" + mid);
				flag = true;
				break;  //=========================
			} else if (arr[mid] < num) {
				//中间索引数<要找的数
				head = mid + 1;  //首索引变为mid+1
			} else {
				//中间索引数>要找的数
				end = mid - 1;
			}

		}
		if (!flag) {
			System.out.println("没有找到" + num);
		}
	}


	/**
	 * 字符串转unicode
	 *
	 * @param str
	 * @return
	 */
	public static String stringToUnicode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			sb.append("\\u").append(Integer.toHexString(c[i]));
		}
		return sb.toString();
	}
}
