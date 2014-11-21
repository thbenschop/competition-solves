#include <cstdio> 
#include <iostream>
using namespace std; 
const int xlocs[8] ={-1,0,1,-1,1,-1,0,1}; 
const int ylocs[8] ={1,1,1,0,0,-1,-1,-1}; 
bool field[100][100]={false}; 
void removeneighbors(int a, int b, int maxx, int maxy) {
	if(!field[a][b]||a>=maxx||a<0||b<0||b>=maxy) return;
	else
	{
		field[a][b]=false;
		for(int r=0;r<8;r++)
			removeneighbors(a+xlocs[r],b+ylocs[r],maxx,maxy);
	}
}
int main() {
	//freopen("test.txt","r",stdin);
	int x,y;
	int islands=0;
	while(scanf("%d %d",&x,&y)&&x!=0)
	{
		islands=0;
		for(int i=0;i<100;i++) for(int j=0;j<100;j++) 
field[i][j]=false;
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
			{
				char temp;
				cin>>temp;
				if(temp=='*') field[i][j]=false;
				else field[i][j]=true;
			}
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
				{
					if(field[i][j])
					{
						islands++;
						removeneighbors(i,j,x,y);
					}
				}
		}
		printf("%d\n",islands);
	}
}
