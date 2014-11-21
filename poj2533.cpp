#include <cstdio>
using namespace std;


int main()
{
	//freopen("test.txt","r",stdin);
	
	
	int elements=0;
	
	scanf("%d",&elements);
	int nums[elements];
	int longest[elements];
	
	for(int i=0;i<elements;i++)
	{
		scanf("%d ",&nums[i]);
		longest[i]=0;
	}
	
	for(int i=0;i<elements;i++)
	{
			int biggest=0;
			for(int k=0;k<i;k++)
				if(nums[i]>nums[k]&&longest[k]>biggest)
					biggest=longest[k];
			longest[i]=1+biggest;
	}
	int longseq=longest[0];
	for(int i=1;i<elements;i++)
	{
		if(longest[i]>longseq)
			longseq=longest[i];
	}

		printf("%d\n",longseq);
}
