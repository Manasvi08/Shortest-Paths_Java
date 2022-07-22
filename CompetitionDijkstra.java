import java.io.File;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
	public String filename;
	public int walkingSpeedOfA;
	public int walkingSpeedOfB;
	public int walkingSpeedOfC;
	public int totalNumberOfEdges;
	public int edgeTo [][];
	public double distTo [][];


	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra (String filename, int sA, int sB, int sC){
		this.walkingSpeedOfA = sA;
		this.walkingSpeedOfB = sB;
		this.walkingSpeedOfC = sC;

		try
		{
			File readFile = new File(filename);
			
			Scanner scanner = new Scanner(readFile);
			
			int lineIndex = 0;

			while(scanner.hasNextLine()){
				
				String [] line = scanner.nextLine().trim().split("\\s+");
				
				if(lineIndex == 0){

					distTo = new double[Integer.parseInt(line[lineIndex])][Integer.parseInt(line[lineIndex])];
					edgeTo = new int[Integer.parseInt(line[lineIndex])][Integer.parseInt(line[lineIndex])];

					for(int source = 0; source < distTo.length; source++)
					{
						for(int destination = 0; destination < distTo[source].length; destination++)
						{
							distTo[source][destination] = Integer.MAX_VALUE;
							if(source == destination)
							{
								distTo[source][destination] = 0;
							}
						}	
					}
				}

				else if(lineIndex == 1){
					
					totalNumberOfEdges = Integer.parseInt(line[lineIndex - 1]);
					
				}

				else{
					
					distTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Double.parseDouble(line[2]);
					edgeTo[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = Integer.parseInt(line[0]);
					
				}

				lineIndex++;	
				
			}

			scanner.close();
			
		}

		catch(Exception e)
		{
			
			distTo = null;
			return;
			
		}
	}
	
	
	public void shortestPath(int vertex)
	{
		boolean [] shortestPathMatrix = new boolean[distTo.length];
		
		shortestPathMatrix[vertex] = true;

		while(true){
			
			int x = -1;
			for(int i = 0; i < distTo.length; i ++) 
			{
				if((shortestPathMatrix[i] == false) && (distTo[vertex][i] != Integer.MAX_VALUE)){
					
					x = i;
					break; 
					
				}
			}

			if(x == -1){
				
				return;
				
			}

			shortestPathMatrix[x] = true;

			for(int i = 0; i < distTo.length; i++)
			{
				if(distTo[vertex][x] + distTo[x][i] < distTo[vertex][i]){
					
					distTo[vertex][i] = distTo[vertex][x] + distTo[x][i];
					shortestPathMatrix[i] = false;
					edgeTo[vertex][i] = x;
					
				}
			}

		}
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can meet
	 */
	public int timeRequiredforCompetition(){
		//TO DO

		if (this.totalNumberOfEdges == 0) {

			return -1;

		}

		if ((walkingSpeedOfA > 100 || walkingSpeedOfA < 50) || (walkingSpeedOfB > 100 || walkingSpeedOfB < 50) || (walkingSpeedOfC > 100 || walkingSpeedOfC < 50)) {

			return -1;

		}

		int slowestContestantSpeed = Math.min(walkingSpeedOfC, Math.min( walkingSpeedOfA, walkingSpeedOfB));

		double maximumLongestShortestPath = 0.0;

		for(int i = 0; i < distTo.length; i++)

		{
			for(int j = 0; j < distTo[i].length; j++)

			{

				if(distTo[i][j] == Integer.MAX_VALUE){

					return - 1;

				}

				else if(distTo[i][j] > maximumLongestShortestPath){

					maximumLongestShortestPath = distTo[i][j];

				}
			}
		}

		int maximumSlowestContestantSpeed = (int) Math.ceil((maximumLongestShortestPath*1000)/slowestContestantSpeed);

		if(slowestContestantSpeed <= 0 || maximumLongestShortestPath == 0){
			return -1;
		}
		return maximumSlowestContestantSpeed;
	}


}









