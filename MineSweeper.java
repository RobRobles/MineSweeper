import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class MineSweeper {
	

	public MineSweeper() throws FileNotFoundException
	{
		//Creating a scanner 
		File file = new File("input.txt");
		Scanner input = new Scanner(file);

		findSolution(input); 

	}

	private void findSolution(Scanner input) {

		PrintStream print = System.out;
		@SuppressWarnings("unused")
		int size = 0; 
		int field = 0;

		while(input.hasNextLine())
		{
			field++; 
			//getting n and m 
			int row = input.nextInt(); 
			int col = input.nextInt(); 
			size = row*col;

			//if row(n) and col(m) is equal to 0 then we reached the end of the list
			if(row == 0 && col == 0)
			{
				break; 
			}

			char minesweep[][] = new char[row][]; 
			
			//read the next lines to get the grid
			for(int i = 0; i < row; i++)
			{
				minesweep[i] = input.next().toCharArray(); 
			}

			//looking for blanks, '.' searching around their neigboring cells for possible mines 
			for(int i = 0; i < row; i ++)
			{
				for(int j = 0; j < col; j ++)
				{
					if(minesweep[i][j] == '.')
					{
						//mine counter
						int count = 0;

						for(int ixi = i - 1; ixi <= i + 1; ixi ++)
						{
							for(int jxj = j - 1; jxj <= j + 1; jxj++)
							{
								//making sure we do not go out of bounds, got plenty of those errors 
								if(ixi >= 0 && ixi < row && jxj >= 0 && jxj < col && minesweep[ixi][jxj] == '*')
								{
									count++; 
								}
							}

							//replacing the blanks with the amount of mines adjacent to them
							minesweep[i][j] = (char)('0' + count); 
						}
					}
				}
			}
			
			System.out.println("");
			System.out.println("Field #" + field + ":"); 

			for(int i = 0; i < row; i ++)
			{
				print.println(new String(minesweep[i]));
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {

		MineSweeper mine = new MineSweeper();
		

	}
}









