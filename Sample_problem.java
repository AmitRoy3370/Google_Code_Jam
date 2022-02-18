import java.util.Scanner;

public class Sample_problem {

    static Scanner in=new Scanner(System.in);
    
    static int testCases,n,m;
    
    static long c[];
    
    static void solve(int testCases){
        
        long sum=0;
        
        for(long i: c){
            
            sum+=i;
            
        }
        
        long remain=(sum%m);
        
        System.out.println("Case #"+testCases+": "+remain);
        
    }
    
    public static void main(String[] amit) {
        
        testCases=in.nextInt();
        
        for(int t=1;t<=testCases;t++){
            
            n=in.nextInt();
            m=in.nextInt();
            
            c=new long[n];
            
            for(int i=0;i<n;i++){
                
                c[i]=in.nextLong();
                
            }
            
            solve(t);
            
        }
        
    }
    
}
