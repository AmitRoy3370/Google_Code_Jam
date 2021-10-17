import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Reversort{
	
	 static Scanner in=new Scanner();
    
    static PrintWriter out=new PrintWriter( new OutputStreamWriter(System.out) );

    static int testCases,n;
	
	static long a[];
	
	static void solve(int testCases){
		
		long ans=0;
		
		for(int i=1;i<=n-1;i++){
			
			int j=i;
			
			long min=a[i];
			
		    for(int k=i;k<=n;k++){
				
				if( min>=a[k] ){
					
					min=a[k];
					
					j=k;
					
				}
				
			}
			
			/*for(int k=i;k<=(j-i+1)/2;k++){
				
				long temp=a[k];
				a[k]=a[(j+1)-k+1];
				a[(j+1)-k+1]=temp;
				
			}*/
			
			int i1=i,j1=j;
			
			while(j1>i1){
				
				long temp=a[i1];
				a[i1]=a[j1];
				a[j1]=temp;
				
				i1++;
				j1--;
				
			}
			
			ans+=(j-i+1);
			
		}
		
		out.println("Case #"+testCases+": "+ans);
		out.flush();
		
		/*for(long i: a){
			
			out.print(i+" ");
			out.flush();
			
		}
		
		out.println();
		out.flush();*/
		
	}

	public static void main(String [] amit) throws IOException{
		
		testCases=in.nextInt();
		
		for(int t=1;t<=testCases;t++){
			
			n=in.nextInt();
		    
			a=new long[n+1];
             
			for(int i=1;i<=n;i++){
				
				a[i]=in.nextInt();
				
			} 
			 
		    solve(t);
		
		}

        in.close(); 
		
	}
	
	  static class Scanner{
        
        BufferedReader in;
        StringTokenizer st;

        public Scanner() {
        
            in=new BufferedReader( new InputStreamReader(System.in) );
            
        }
        
        String next() throws IOException{
            
            while(st==null || !st.hasMoreElements()){
                
                st=new StringTokenizer(in.readLine());
                
            }
            
            return st.nextToken();
            
        }
        
        int nextInt() throws IOException{
            
            return Integer.parseInt(next());
            
        }
        
        long nextLong() throws IOException{
            
            return Long.parseLong(next());
            
        }
        
        String nextLine() throws IOException{
            
            return in.readLine();
            
        }
        
        char nextChar() throws IOException{
            
            return next().charAt(0);
            
        }
        
        double nextDouble() throws IOException{
            
            return Double.parseDouble(next());
            
        }
        
        float nextFloat() throws IOException{
            
            return Float.parseFloat(next());
            
        }
        
        boolean nextBoolean() throws IOException{
            
            return Boolean.parseBoolean(next());
            
        }
        
		
        void close() throws IOException{
            
            in.close();
            
        }
        
    }
	
}