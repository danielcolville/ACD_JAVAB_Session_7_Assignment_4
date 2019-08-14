package session7;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str = {"dog","god","odg","cold","clod"};
		String [] sorted=new String[str.length];
		for(int i=0;i<str.length;i++) {
			sorted[i]= new String(selSort(str[i].toCharArray(),str[i].length()));
		}
		
		Arrays.sort(sorted);
		for(int i=0;i<sorted.length;i++) {
			for(int j=0;j<sorted[i].length();j++) {
				System.out.print(sorted[i].charAt(j));
			}
			System.out.println();
		}
		for(int i=0)
	
	}/*
	public static boolean isAnagram(String s1,String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		else {
			
		}
	}*/

	
	public static char[] selSort(char[] sort,int len) {
		if(len==1) {
			return sort;
		}
		int currMinInd=sort.length-len;
		for(int j=sort.length-len+1;j<sort.length;j++) {
			if(sort[j]<sort[currMinInd]) {
				currMinInd=j;
			}
		}
		char[] next=new char[sort.length];
		int j;
		
		for(j=0;j<(sort.length-len);j++) {
			next[j]=sort[j];
		}
		char temp=sort[j];
		next[j++]=sort[currMinInd];
		
		for(int i=j;i<sort.length;i++) {
			if(i!=currMinInd) {
				next[i]=sort[i];
			}
			else {
				next[i]=temp;
			}
		}
		return selSort(next,len-1);
	}
}
