import java.util.Scanner;

public class poj1458 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			//amnmnmnmnmnmnmnmnmnmnmnmnbcqwqwqwqwqwqwqwqwqwd  ayuyuyuyuyuyubcopopopopopopopopod
			//String inline = in.next();
			//String one = inline.substring(0, inline.indexOf(' '));
			//int k = 0;
			//for(int i = 1; i< inline.length(); i++) if(inline.charAt(i)!=' '&&inline.charAt(i-1)==' ') k = i;
			//String two = inline.substring(k,inline.length());
			//System.out.println("String 1: "+ one + "\nString 2: "+two);
			String one = in.next();
			String two = in.next();
			int[][] thematrix = new int[one.length()+1][two.length()+1];
			for(int i =0; i<=one.length(); i++)
				for(int j = 0; j<=two.length(); j++)
					thematrix[i][j] = 0;
			for(int i =1; i<=one.length(); i++){
				for(int j = 1; j<=two.length(); j++){
					if(one.charAt(i-1)==two.charAt(j-1)){
						//System.out.println(one.charAt(i-1) + ":" +i+" matches " + two.charAt(j-1)+":"+j);
						thematrix[i][j] = thematrix[i-1][j-1] +1;
					}
					else
						thematrix[i][j] = Math.max(thematrix[i-1][j], thematrix[i][j-1]); 
				}
			}
			/*
			for(int i =0; i<=one.length(); i++){
				for(int j = 0; j<=two.length(); j++){
					System.out.print(thematrix[i][j]+" ");
				}
				System.out.println();
			}
			
					*/
					
				System.out.println(thematrix[one.length()][two.length()]);
					
		}
		
	}

}
