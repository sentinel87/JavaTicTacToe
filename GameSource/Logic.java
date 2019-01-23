import javax.swing.JOptionPane;

public class Logic {
	private int player=0;
	private String[][] Arr={{"-","-","-"},{"-","-","-"},{"-","-","-"}};
	public Boolean GameEnd=false;
	
	public String gameTurn(int x,int y)
	{
		String result=setMark();
		Arr[x][y]=result;
		if(checkWinningConditions(result))
		{
			JOptionPane.showMessageDialog(null, "Player "+result+" wins!","INFO",JOptionPane.INFORMATION_MESSAGE);
			GameEnd=true;
		}
		if(player==0){player=1;}
		else{player=0;}
		return result;
	}
	
	private String setMark()
	{
		String result="X";
		if(player==1)
		{
			result="O";
		}
		return result;
	}
	
	public void ResetGame()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				Arr[i][j]="-";
			}
		}
		player=0;
		GameEnd=false;
	}
	
	private Boolean checkWinningConditions(String mark)
	{
		if(Arr[0][0]==mark&&Arr[0][1]==mark&&Arr[0][2]==mark){return true;}
		if(Arr[1][0]==mark&&Arr[1][1]==mark&&Arr[1][2]==mark){return true;}
		if(Arr[2][0]==mark&&Arr[2][1]==mark&&Arr[2][2]==mark){return true;}
		if(Arr[0][0]==mark&&Arr[1][0]==mark&&Arr[2][0]==mark){return true;}
		if(Arr[0][1]==mark&&Arr[1][1]==mark&&Arr[2][1]==mark){return true;}
		if(Arr[0][2]==mark&&Arr[1][2]==mark&&Arr[2][2]==mark){return true;}
		if(Arr[0][0]==mark&&Arr[1][1]==mark&&Arr[2][2]==mark){return true;}
		if(Arr[2][0]==mark&&Arr[1][1]==mark&&Arr[0][2]==mark){return true;}
		return false;
	}
}
