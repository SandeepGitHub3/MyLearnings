package org.algorithms.sorting;

/**
 * Hello world!
 *
 */
public class App 
{
	static int a=0;
	static int b=0;
	
    public static void main( String[] args )
    {
    	System.out.println(isPermutation("ABC","CAB"));
    }
    
    static boolean isPermutation(String s1,String s2) {
    	if(strUnicodeSum(s1)==strUnicodeSum(s2))
    	return true;
    	else return false;
    }
    
    static int strUnicodeSum(String s) {
    	int length=0;
    	for(char c:s.toCharArray()) {
    		length = length+Integer.valueOf(c);
    	}
    	System.out.println(s +": Length :" + length);
    	return length;
    }
}
