package edu.spbu.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemaliev on 07/09/15.
 */
public class IntSort {
	static private void qsort(int[] array,int left,int right){//[left,right)
		int l=left,r=right-1;
		int mid=array[(r+l)/2];
		int a;
		
		while(l<=r){
			while((l<right) && (array[l]<mid)) l++;
			while(r>=left && array[r]>mid) r--;
			if(l<=r) {
				a=array[l];
				array[l]=array[r];
				array[r]=a;
				l++;
				r--;
			}
			
		}
		if(r>left) qsort(array,left,r+1);
		if(l<right-1) qsort(array,l,right);
		
	}
	public static void sort (int array[]) {
		int l=array.length;
		qsort(array,0,l);
	}

  public static void sort (List<Integer> list) {
 //   Collections.sort(list);
 	int[] array;
 	int l=list.size();
 	array=new int[l];
 	for(int i=0;i<l;i++) array[i]=list.get(i);
 	qsort(array,0,l);
	int j=0;
 	for(int i=0;i<l;i++) list.set(i, array[i]);
 	}
}
