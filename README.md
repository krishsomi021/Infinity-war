ForgeStormBreaker.java
Print to the output file the sum of the 2D array from the input file.

LocateTitan.java
Create the adjacency matrix using the input file. Each vertex represents a generator.
Divide each value in the adjacency matrix (so matrix[I][j]) with the functionality values of
vertex i and vertex j (meaning functionalities[i] and
functionalities([j])
Use Dilkstra’s algorithm to find the minimum cost from vertex 0 and the last vertex.
Print the minimum cost to the output file.

MindStoneNeighborNeurons.java
Create a graph representation from the input file. Each vertex represents a nerve and each edge represents a synapse. All the vertices have a varying out-degree EXCEPT the Mind Stone vertex which has out-degree O.
Find the Mind Stone vertex, and identify the vertices that neighbor (have an edge) the Mind Stone vertex.
Print Mind Stone vertex neighbors to the output file.

UseTimeStone.java
Create the adjacency matrix using the input file. Each vertex is an event, each path with connecting vertices is a
timeline. Each vertex has an EU value.
Determine the TOTAL number of timelines.
Determine the number of timelines where sum_of_EU_of_all_vertices_in_the_timeline >= threshold EU.
Print the number from step (3) to the output file.

PredictThanosSnap.java
Create the adjacency matrix using the input file. Each vertex represents a person, and each edge represents a connection.
Use the StdRandom.uniform() function and the given pseudocode to determine which vertices to delete.
Delete the vertices (this can be done directly on the adjacency matrix).
Determine if the resulting graph is connected. A graph is connected with there is a path from each vertex to every other vertex. 
Print true to the output file if the graph is connected, false otherwise.
