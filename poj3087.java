import java.util.*;

public class poj3087{


	public static void main(String[] args)
	{
		char[] stack1;
		char[] stack2;
		int stackheight;
		Scanner scanner = new Scanner(System.in);
		String cases = scanner.nextLine();
		int c = Integer.parseInt(cases);
		for(int r=1; r<=c; r++)
		{
			String temp = scanner.nextLine();
			stackheight = Integer.parseInt(temp);
			temp = scanner.nextLine();
			String temp2 = scanner.nextLine();
			stack1 = temp.toCharArray();
			stack2 = temp2.toCharArray();
			char[] firstresult = new char[stackheight*2];
			char[] goal = scanner.nextLine().toCharArray();
			firstresult = shuffle(stack1,stack2);
			int shufflenum = 1;
			char[] result;
			boolean found = false;
			do{
				result = shuffle(stack1,stack2);
				shufflenum++;
				if(chareq(result, goal)){
					System.out.println(r+" "+shufflenum);
					found = true;
				}
			}while(!chareq(firstresult,result));
			if(!found)
				System.out.println(r+" -1");
		}
	}

	private static char[] shuffle(char[] s1, char[] s2)
	{
		char[] res = new char[s1.length*2];
		for(int i=0; i<s1.length*2; i++)
		{
			if(i%2==0)
				res[i]=s2[i/2];
			else
				res[i]=s1[i/2];
		}
		for(int i=0; i<s1.length; i++)
		{
			s1[i] = res[i];
			s2[i] = res[s1.length+i];
		}
		//System.out.println(res);
		return res;
	}

	private static boolean chareq(char[] fr, char[] r)
	{
		for(int i=0; i<fr.length; i++)
			if(fr[i]!=r[i]){
				//System.out.println("false");
				return false;
			}
		//System.out.println("true");
		return true;
	}
}
