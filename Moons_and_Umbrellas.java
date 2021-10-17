import java.util.Scanner;

public class Moons_and_Umbrellas{
	
	static Scanner in=new Scanner(System.in);
	
	static int testCases,n;
	
	static long x,y;
	
	static char a[];
	
	static void solve(int testCases){
		
		//for the best cases
		
		if( !new String(a).contains("?") ){
		
		long ans=0;
		
		for(int i=1;i<n;i++){
			
			if( a[i]=='c' && a[i-1]=='j' ){
				
				ans+=y;
				
			}else if( a[i]=='j' && a[i-1]=='c' ){
				
				ans+=x;
				
			}
			
		}
		
		System.out.println("Case #"+testCases+": "+ans);
		
		return;
		
		}
		
		long dp[][]=new long[n+1][2];
		
		//0 index for the j
		//1 index for the c 
		
		for(int i=1;i<=n;i++){
			
			dp[i][0]=Integer.MAX_VALUE;
			dp[i][1]=Integer.MAX_VALUE;
			
		}
		
		dp[0][0]=0;
		dp[0][1]=0;
		
		/*for(int i=0;i<=n;i++){
			
			System.out.print(dp[i][0]+" "+dp[i][1] );
			
		}
		
		System.out.println();*/
		
		for(int i = 1; i <= n; i++){
    
    for(int c = 0; c < 2; c++){
     
	 boolean falg=false;
	 
        if(c == 0 && a[i-1] == 'j') falg=true; 
        if(c == 1 && a[i-1] == 'c') falg=true; 
     
	 if(!falg){
	 
        for(int d = 0; d < 2; d++){ 
            
			int cost = 0; 
           
		   if(i > 1){

if(d == 0 && c == 1) cost += x;

if(d == 1 && c == 0) cost += y;

            }

dp[i][c] = Math.min(dp[i][c], dp[i-1][d] + cost);
            
        }
        
	 }
		
    }

}

		/*for(int i=0;i<=n;i++){
			
			System.out.print(dp[i][0]+" "+dp[i][1] );
			
		}
		
		System.out.println();*/
		
		System.out.println( "Case #"+testCases+": "+Math.min( dp[n][0],dp[n][1] ) );
		
		/*
		
		for(int i=1;i<n;i++){
			
			if( a[i]=='j' ){
				
				if( a[i-1]=='c' ){
					
					//for the jc sequence
					
					if( i==1 ){
                    
                    //if it is the first case then just set the orginal value 
					
					dp[i][0]=y;
					dp[i][1]=y;
					
					}else{
					
					//or add x or y with the minimum of previous state
					
						dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] );
						dp[i][1]=Math.min( dp[i-1][0],dp[i-1][1] )+y;
						
					}
					
				}else if( a[i-1]=='j' ) {
					
					if( i!=1 ){
						
						//for the jj sequence
						
						dp[i][0]=dp[i-1][0];
						dp[i][1]=dp[i-1][1];
						
					}
					
				}else{
					
					if(i==1){
                    
					  //for the ?j sequence 
                     //and for the first index we store both of them					  
						
						dp[i][0]=y;
						dp[i][1]=y;
						
					}else{
						
						//other wise add x and y with the min of the previous index
						
						dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] )+x;
						dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+y;
						
					}
					
				}
				
			}else if( a[i]=='c' ){
				
				if( a[i-1]=='j' ){
					
					//this is for the cj sequence 
					
					if( i==1 ){
					
					//if it is first then just store x in both of them 
					
					dp[i][0]=x;
					dp[i][1]=x;
					
					}else{
						
						//other wise add x with the previous index
						
						dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] )+x;
						dp[i][1]=Math.min( dp[i-1][0],dp[i-1][1] );
						
					}
					
				}else if( a[i-1]=='c' ) {
					
					//this is for the cc sequence 
					
					if( i!=1 ){
						
						// from the second index we just copy the previous value 
						
						dp[i][0]=dp[i-1][0];
						dp[i][1]=dp[i-1][1];
						
					}
					
				}else{
					
					//this is for the ?c sequence 
					
					if(i==1){
						
						//for the first index we keep both of them jc and cc 
						
						dp[i][0]=Math.min(x,0);
						dp[i][1]=Math.min(0,y);
						
					}else{
						
						dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] )+x;
						dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+y;
						
					}
					
				}
				
			}else{
				
				//this for the j? or c? or ?? sequence 
				
				if( a[i-1]=='c' ){
					
					dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] )+x;//cj
					dp[i][1]=Math.min( dp[i-1][0],dp[i-1][1] );//cc 
					
				}else if(a[i-1]=='j'){
					
					dp[i][0]=Math.min( dp[i-1][0],dp[i-1][1] );//jj
					dp[i][1]=Math.min( dp[i-1][0],dp[i-1][1] )+y;//jc 
					
				}else{
					
					//if we get the two consecutive letter's are ? then we skip it or other wise we add x or y
					
					dp[i][0]=Math.min(Math.min( dp[i-1][0],dp[i-1][1] )+x,Math.min(dp[i-1][0],dp[i-1][1]) );
					dp[i][1]=Math.min(Math.min( dp[i-1][0],dp[i-1][1] )+y,Math.min( dp[i-1][0],dp[i-1][0] ) );
					
				}
				
			}
			
		}
			
		System.out.println( "Case #"+testCases+": "+Math.min( dp[n-1][0],dp[n-1][1] ) );
		
		*/
		
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=1;t<=testCases;t++){
			
			x=in.nextLong();
			y=in.nextLong();
			
			a=in.next().toLowerCase().toCharArray();
			
			n=a.length;
			
			solve(t);
			
		}
		
	}
	
}