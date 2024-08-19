package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);


        int generatorCount = StdIn.readInt();
int[] generatorValues = new int[generatorCount];
double[] functionValues = new double[generatorCount];
int[][] edgeMatrix = new int[generatorCount][generatorCount];

for (int i = 0; i < generatorCount; i++) {
    generatorValues[i] = StdIn.readInt();
    functionValues[i] = StdIn.readDouble();
}

for (int row = 0; row < generatorCount; row++) {
    for (int col = 0; col < generatorCount; col++) {
        edgeMatrix[row][col] = (int) (StdIn.readInt() / (functionValues[row] * functionValues[col]));
    }
}

int[] minimumCost = findShortestPath(edgeMatrix);

StdOut.print(minimumCost[generatorCount - 1]);

}

private static int[] findShortestPath(int[][] edgeMatrix) {
    int[] minCost = new int[edgeMatrix.length];
    boolean[] visitedNodes = new boolean[edgeMatrix.length];

    for (int i = 1; i < minCost.length; i++) minCost[i] = Integer.MAX_VALUE;

    for (int i = 0; i < minCost.length; i++) {
        int currentNode = findLowestCostNode(minCost, visitedNodes);
        visitedNodes[currentNode] = true;

        for (int j = 0; j < edgeMatrix.length; j++) {
            int updatedCost = minCost[currentNode] + edgeMatrix[currentNode][j];
            if (edgeMatrix[currentNode][j] != 0 && !visitedNodes[j] && updatedCost < minCost[j]) {
                minCost[j] = updatedCost;
            }
        }
    }

    return minCost;
}

private static int findLowestCostNode(int[] costArray, boolean[] visitedSet) {
    int minimum = Integer.MAX_VALUE, minIndex = -1;

    for (int i = 0; i < costArray.length; i++) {
        if (!visitedSet[i] && costArray[i] < minimum) {
            minimum = costArray[i];
            minIndex = i;
        }
    }

    return minIndex;
}


    }


