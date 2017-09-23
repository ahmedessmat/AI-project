import java.util.Random;


public class Escape {
	public static int [][] gengrid(){
		Random rand= new Random();
		int rows= rand.nextInt(10)+1;
		int cols= rand.nextInt(10)+1;
		System.out.println(rows + "    "+ cols);
		int [][] grid= new int[rows][cols];
		int totalCells= rows * cols;
		
		//Put the R2-R4 initial location randomally
		
		int intialLocationRow = rand.nextInt(rows);
		int intialLocationCol = rand.nextInt(cols);
		grid[intialLocationRow][intialLocationCol]=1;
		
		//Put the teleportal
		
		boolean teleportalPositionfound= false;
		while(!teleportalPositionfound){
			int teleportalPositionRow= rand.nextInt(rows);
			int teleportalPositionCol= rand.nextInt(cols);
			if(grid[teleportalPositionRow][teleportalPositionCol]==0){
				teleportalPositionfound=true;
				grid[teleportalPositionRow][teleportalPositionCol]=2;
			}
				
		}
		
		//Put obstacles
		boolean correctNoObst = false;
		int numberOfObstacles=0;
		while(!correctNoObst){
		 numberOfObstacles= rand.nextInt(rows * cols) +1;
		 if(numberOfObstacles<= 0.25*cols*rows){
			 correctNoObst= true;
		 }
		}
		System.out.println(numberOfObstacles);
		for(int i=0; i<numberOfObstacles; i++){
			boolean obsLocationFound= false;
			while(!obsLocationFound){
			int obsRow= rand.nextInt(rows);
			int obsCol= rand.nextInt(cols);
				if(grid[obsRow][obsCol]==0){
					obsLocationFound=true;
					grid[obsRow][obsCol]=3;
				}
			}
		}
		
		// Put Rocks & Pressure pods
		boolean correctNoRocks= false;
		int numberOfRocks=0;
		while(!correctNoRocks){
			numberOfRocks= rand.nextInt(rows * cols) +1;
			if(numberOfRocks<= 0.1*rows*cols){
				correctNoRocks= true;
			}
		}
		System.out.println(numberOfRocks);
		for(int i=0; i<numberOfRocks; i++){
			boolean rockPlaced= false;
			while(!rockPlaced){
				int rockRow= rand.nextInt(rows);
				int rockCol= rand.nextInt(cols);
					if(grid[rockRow][rockCol]==0){
						rockPlaced=true;
						grid[rockRow][rockCol]=4;
					}
			}
		}
		
		for(int i=0; i<numberOfRocks; i++){
			boolean pressurePlaced= false;
			while(!pressurePlaced){
				int pressureRow= rand.nextInt(rows);
				int pressureCol= rand.nextInt(cols);
					if(grid[pressureRow][pressureCol]==0){
						pressurePlaced=true;
						grid[pressureRow][pressureCol]=5;
					}
			}
		}
		
		
		
		
		return grid;
	}
	public static void main(String [] args){
		int[][] generatedGrid=gengrid();
		for(int i=0;i<generatedGrid.length;i++){
			for(int j=0;j<generatedGrid[i].length;j++){
				System.out.print(generatedGrid[i][j]);
			}
			System.out.println();
		}
	}
}
