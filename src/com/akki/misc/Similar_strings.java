package com.akki.misc;

public class Similar_strings {
	 // Counts the no of manipulations required
    static int countManipulations(String s1, String s2)
    {
        int count = 0;
 
        // store the count of character
        int char_count[] = new int[26];
 
        // iterate though the first String and update 
         
        for (int i = 0; i < s1.length(); i++) 
            char_count[s1.charAt(i) - 'a']++;        
 
        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++) 
            if (char_count[s2.charAt(i) - 'a']-- <= 0)
                count++;
         
        return count;
    }
 
    // Driver code
    public static void main(String[] args)
    {
 
        String s1 = "addcf";
        String s2 = "cedkb";
        System.out.println(countManipulations(s1, s2));
    }
}
