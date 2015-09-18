package edu.spbu.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class IntSort {

	static private void qsort(List<Integer> list,int left,int right){
		int l=left,r=right-1;
		int mid=list.get((r+l)/2);
		int a;
		while(l<=r){
			while(l<right && list.get(l)<mid) l++;
			while(r>=left && list.get(r)>mid) r--;
			if(l<=r){
				a=list.get(l);
				list.set(l, list.get(r));
				list.set(r, a);
				l++;
				r--;
			}
		}
		if(r>left) qsort(list,left,r+1);
		if(l<right-1) qsort(list,l,right);		
	}
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

		qsort(array,0,array.length);
	}

  public static void sort (List<Integer> list) {
 //   Collections.sort(list);
 	int[] array;
 	int l=list.size();
 //	qsort(list,0,l);
 	long startTime = System.nanoTime();
 	array=new int[l];
 	for(int i=0;i<l;i++) array[i]=list.get(i);
 	
    long estimatedTime = System.nanoTime() - startTime;
    System.out.println("Execution time(ms) " + (estimatedTime/ 1000000));
    
 	qsort(array,0,l);
 	
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("Execution time(ms) " + (estimatedTime/ 1000000));

    for(int i=0;i<l;i++) list.set(i,array[i]);
 
 
 
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("Execution time(ms) " + (estimatedTime/ 1000000));
 	}
}
