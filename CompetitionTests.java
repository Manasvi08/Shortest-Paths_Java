import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {
	@Test
	public void testCompetitionDijkstra() {
		//testing constructor
		CompetitionDijkstra cityIntersections;
		String filename = "tinyEWD.txt";
		int sA = 60;
		int sB = 80;
		int sC = 50;
		cityIntersections = new CompetitionDijkstra(filename, sA, sB, sC);
		assertEquals(-1, cityIntersections.timeRequiredforCompetition());
	}
		
	@Test
	public void testTinyEWDInputFileDijkstra() {
		//Testing the tinyEWD input file
		CompetitionDijkstra cityIntersectionsTinyEWD = new CompetitionDijkstra("tinyEWD.txt", 50,90,70);
		assertEquals(-1, cityIntersectionsTinyEWD.timeRequiredforCompetition());
	}
	
	
	@Test
	public void testNoSpeedDijkstra() {	
		//Testing Zero Speed of the contestants
		CompetitionDijkstra cityIntersectionsTinyEWD0 = new CompetitionDijkstra("tinyEWD.txt", 0,0,90);
		assertEquals(-1, cityIntersectionsTinyEWD0.timeRequiredforCompetition());
	}
	
	@Test
	public void testNoFileNameDijkstra() {
		//Testing Filename not found
		CompetitionDijkstra cityIntersectionsNotFoundFilename = new CompetitionDijkstra("NotFound.txt", 50,90,70);
		assertEquals( -1, cityIntersectionsNotFoundFilename.timeRequiredforCompetition());
	}
	
	@Test
	public void testSpeedNegativeDijkstra() {
		//Testing negative speed of one contestant
		CompetitionDijkstra cityIntersectionsTinyEWDNegative = new CompetitionDijkstra("tinyEWD.txt", -1,70,90);
		assertEquals("Test competition with negative speed", -1, cityIntersectionsTinyEWDNegative.timeRequiredforCompetition());
	}
	
	@Test
	public void testValueDijkstra() {
		//Testing when the speed is below 50
		CompetitionDijkstra cityIntersectionsTinyEWDValue = new CompetitionDijkstra("tinyEWD.txt", 40,90,70);
		assertEquals( -1, cityIntersectionsTinyEWDValue.timeRequiredforCompetition());
	}
		
	
	
	@Test
	public void testCompetitionFloydWarshall() {
		//testing constructor
		CompetitionFloydWarshall cityIntersections1;
		String filename = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		cityIntersections1 = new CompetitionFloydWarshall(filename, sA, sB, sC);
		assertEquals(38, cityIntersections1.timeRequiredforCompetition());
	}
	
	@Test
	public void testTinyEWDInputFileFloydWarshall() {
		//Testing the tinyEWD input file
		CompetitionFloydWarshall cityIntersectionsTinyEWD1 = new CompetitionFloydWarshall("tinyEWD.txt", 50,97,65);
		assertEquals(38, cityIntersectionsTinyEWD1.timeRequiredforCompetition());
	}
	
	@Test
	public void testNoSpeedFloydWarshall() {
		//Testing Zero Speed of the contestants
		CompetitionFloydWarshall cityIntersectionsTinyEWD01 = new CompetitionFloydWarshall("tinyEWD.txt", 0,0,70);
		assertEquals(-1, cityIntersectionsTinyEWD01.timeRequiredforCompetition());
	}
	
	@Test
	public void testNoFilenameFloydWarshall() {	
		//Testing Filename not found
		CompetitionFloydWarshall cityIntersectionsNotFoundFilename1 = new CompetitionFloydWarshall("NotFound.txt", 50,90,70);
		assertEquals( -1, cityIntersectionsNotFoundFilename1.timeRequiredforCompetition());
	}
	
	@Test
	public void testSpeedNegativeFloydWarshall() {	
		//Testing negative speed of two contestants
		CompetitionFloydWarshall cityIntersectionsTinyEWDNegative1 = new CompetitionFloydWarshall("tinyEWD.txt", -1,-5,50);
		assertEquals("Test competition with negative speed", -1, cityIntersectionsTinyEWDNegative1.timeRequiredforCompetition());
	}
	
	@Test
	public void testValueFloydWarshall() {	
		//Testing when the speed is below 50
		CompetitionFloydWarshall cityIntersectionsTinyEWDValue1 = new CompetitionFloydWarshall("tinyEWD.txt", 40,90,60);
		assertEquals( -1, cityIntersectionsTinyEWDValue1.timeRequiredforCompetition());
		
	}
}