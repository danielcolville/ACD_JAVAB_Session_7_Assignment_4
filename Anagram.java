package session7;

import java.util.Arrays;
import java.util.Comparator;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str = {"dog","god","cold","clod","listen","silent","state","taste","pot","opt","top"};
		int []ind=new int[str.length];
		for(int i=0;i<ind.length;i++) {
			ind[i]=i;
		}
		Word [] sorted=new Word[str.length];
		for(int i=0;i<str.length;i++) {	
			String temp=new String(selSort(str[i].toCharArray(),str[i].length()));
			System.out.println(temp);
			sorted[i]=new Word(temp,i);
		}
		
		Arrays.sort(sorted,new strC());
		for (int i = 0; i<str.length;i++)  {
            System.out.print(str[sorted[i].index] + " ");
		}
	
	}
	static class strC implements Comparator<Word> {
		 public int compare(Word a, Word b) 
	        { 
	            return a.str.compareTo(b.str); 
	        } 
	}
	
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
	static class Word{
		public String str;
		public int index;
		Word(String str,int index) {
			this.str=str;
			this.index=index;
		}
	}
}
