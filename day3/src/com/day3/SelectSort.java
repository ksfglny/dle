package com.day3;


public class SelectSort {  
	  
    public static void main(String[] aa) {  
        int a[]={1,3,5,2,4};
        for (int i = 0; i < a.length; i++) {  
            int min = i; /* ����ǰ�±궨��Ϊ��Сֵ�±� */  
  
            for (int j = i + 1; j < a.length; j++) {  
                if (a[min] > a[j]) { /* �����С�ڵ�ǰ��Сֵ�Ĺؼ��� */  
                    min = j; /* ���˹ؼ��ֵ��±긳ֵ��min */  
                    
                }  
            }  
            if (i != min) {/* ��min������i��˵���ҵ���Сֵ������ */  
                int tmp = a[min];  
                a[min] = a[i];  
                a[i] = tmp;  
            }  
        } 
        for(int i:a){
        	System.out.println(i);
        }
    }  
}  