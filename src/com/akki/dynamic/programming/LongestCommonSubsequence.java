package com.akki.dynamic.programming;

/**
 * @author Akhilesh.Agarwal
 *
 */
public class LongestCommonSubsequence {

	static int lcs(char[] l,char[] r,int m,int n){
		if(m==0 || n==0)
			return 0;
		if(l[m-1]==r[n-1]){
			return 1+lcs(l, r, m-1, n-1);
		}else{
			return Math.max(lcs(l, r, m-1, n), lcs(l, r, m, n-1));
		}
	}
	
	
	/** Incomplete
	 * @param l
	 * @param r
	 * @param m
	 * @param n
	 * @return
	 */
	/*static int lcs_memoised(char[] l,char[] r,int m,int n){
		int L[][] = new int[m+1][n+1];
		if(m==0 || n==0)
			return 0;
		
		if(l[m-1]==r[n-1]){
			int lcs = 1+lcs(l, r, m-1, n-1);
			
			return 1+lcs(l, r, m-1, n-1);
		}else{
			return Math.max(lcs(l, r, m-1, n), lcs(l, r, m, n-1));
		}
	}*/
	
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	 static int lcs_tabulated( char[] X, char[] Y, int m, int n )
	  {
	    int L[][] = new int[m+1][n+1];
	 
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++)
	    {
	      for (int j=0; j<=n; j++)
	      {
	        if (i == 0 || j == 0)
	            L[i][j] = 0;
	        else if (X[i-1] == Y[j-1])
	            L[i][j] = L[i-1][j-1] + 1;
	        else
	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
	      }
	    }
	  return L[m][n];
	  }
	 
	 public static void print_lcs(char[] X, char[] Y, int m, int n){
		 int L[][] = new int[m+1][n+1];
		 
		    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
		         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		    for (int i=0; i<=m; i++)
		    {
		      for (int j=0; j<=n; j++)
		      {
		        if (i == 0 || j == 0)
		            L[i][j] = 0;
		        else if (X[i-1] == Y[j-1])
		            L[i][j] = L[i-1][j-1] + 1;
		        else
		            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
		      }
		    }
		    
		    int index=L[m][n];
		    int temp = index;
		    char[] lcs=new char[index];
		    //lcs[index]='\0';
		    
		    int i=m,j=n;
		    while(i>0 && j >0){
		    	if(X[i-1]==Y[j-1]){
		    		lcs[index-1]=X[i-1];
		    		i--;
		    		j--;
		    		index--;
		    	}else if(L[i-1][j]>L[i][j-1]){
		    		i--;
		    	}else{
		    		j--;
		    	}
		    }
		    
		    // Print the lcs
	       // System.out.print("LCS of "+X+" and "+Y+" is ");
	        for(int k=0;k<temp;k++)
	            System.out.print(lcs[k]);
		    
	 }
	 
	public static void main(String[] args) {
		/*String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";*/
		String s1="ABC";
		String s2="BBC";
		char[] l=s1.toCharArray();
		char[] r=s2.toCharArray();
		print_lcs(l,r , l.length, r.length);

	}

}
