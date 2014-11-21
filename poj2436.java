import java.util.Scanner;
public class poj2436 {
	public static int testcow(boolean[] test, boolean[] cow){
		boolean invalid = false;
		for(int i = 0; i< test.length; i++)
			if(!test[i]&&cow[i])
				invalid = true;
		return invalid?0:1;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num_cows, num_diseases, num_acceptable, healthy_cows;
		String temp = in.nextLine();
		String[] temparr = temp.split(" ");
		num_cows = Integer.parseInt(temparr[0]);
		num_diseases = Integer.parseInt(temparr[1]);
		num_acceptable = Integer.parseInt(temparr[2]);
		healthy_cows = 0;
		boolean[][] dismatrix = new boolean[num_cows][num_diseases];
		int i = 0;
		while(i<num_cows-healthy_cows){
			temp = in.nextLine();
			if(!temp.equals("0")){
				String diseases[] = temp.split(" ");
				for(int j = 1; j<diseases.length; j++){
					dismatrix[i][Integer.parseInt(diseases[j])-1] = true;
				}
				i++;
			}
			else{
				healthy_cows++;
			}
		}
		/*
		 // Print loop for the disease matrix
		for(i=0;i<num_cows;i++){
			for(int j=0;j<num_diseases;j++){
				System.out.print(dismatrix[i][j]?"1 ":"0 ");
			}
			System.out.println();
		}
		System.out.println(healthy_cows + " healthy cows");
		*/
		//System.out.println("test sets");
		int bestsofar = 0, currentcount;
		boolean[] testset = new boolean[num_diseases];
		for(int dec = 0; dec<Math.pow(2, num_diseases); dec++){
			//if this is a valid test set number
			if(Integer.bitCount(dec)==num_acceptable){
				//temp = Integer.toBinaryString(dec);
				//generate the test set
				for(int j = 0; j<testset.length; j++) testset[j] = false;
				int num = dec;
				for(int j = 0; j<testset.length; j++){
					 testset[j] = num%2!=0;
					 num/=2;
				}
				/*
				for(int k = 0; k< testset.length; k++)
					System.out.print(testset[k]?"1 ":"0 ");
				System.out.println();
				*/
				//test the dataset with this set
				currentcount = healthy_cows;
				for(i = 0; i<num_cows-healthy_cows; i++){
					currentcount+=testcow(testset,dismatrix[i]);
				}
				if(currentcount>=bestsofar){
					bestsofar = currentcount;
					
					
				}
			}
		}
		
		System.out.println(bestsofar);
		
		
	}
}
