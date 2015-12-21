/*package pracexamen1;

public class nthNum_void 
{	
	public static int n=3;
	public static int ban=0;
	public static void nth(int secNum)
	{
		int res=1;
		
		if(secNum==0)
		{
			System.out.println(secNum);	
		}
		
		if(secNum==1)
		{
			System.out.println(secNum+1);	
		}
		
		if(secNum>1)
		{
			ban++;
			int x = nth(secNum-1);
			res=n*x;
			
			
			if(ban==secNum)
			{
				System.out.println(res);
			}
		}
		
		
		
	}
	public static void main(String[] args) 
	{
		nth(6);

	}

}
*/
