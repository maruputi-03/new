public class LCS{
  public static int lcs(char[] x,char[] y,int m,int n){
    if(m == 0 || n == 0){
	   return 0;
	}
	if(x[m-1] == y[n-1]){
	  return 1+lcs(x,y,m-1,n-1);
	}
	else{
	  return Math.max(lcs(x,y,m,n-1),lcs(x,y,m-1,n));
	}
  }
   public static void main(String[] args) {
        String s1 = "bcd";
        String s2 = "bcda";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        int result = lcs(x, y, x.length, y.length);
        System.out.println("Length of LCS is " + result);
    }
}