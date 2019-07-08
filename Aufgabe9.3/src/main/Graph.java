package main;

import java.util.Arrays;

public class Graph
{
	int nNodes;
	double distances[][];

	public Graph(int nNodes)
	{
		this.nNodes = nNodes;
		distances = new double[nNodes][nNodes];
		for (int i = 0; i < nNodes; i++)
			for (int j = 0; j < nNodes; j++)
				distances[i][j] = -1;
	}

	public double getEdge(int vertexIndex1, int vertexIndex2)
	{
		return distances[vertexIndex1][vertexIndex2];
	}

	public void setEdge(double distance, int vertexIndex1, int vertexIndex2)
	{
		distances[vertexIndex1][vertexIndex2] = distance;
	}

	public void setEdgeBidirectional(double distance, int vertexIndex1, int vertexIndex2)
	{
		setEdge(distance, vertexIndex1, vertexIndex2);
		setEdge(distance, vertexIndex2, vertexIndex1);
	}

	public double shortestDistanceBetween(int source, int target)
	{
		// i)
		double ar[] = new double[nNodes];
		Arrays.fill(ar, Double.MAX_VALUE);
		ar[source] = 0;
		// ii)
		PriorityQueue pQ = new PriorityQueue();
		pQ.enqueue(source, 0);
		// iii)iv)v)
		while (!pQ.isEmpty())
		{
			for (int i = 0; i < nNodes; i++)
			{
				if (distances[source][i] > 0)
				{
					pQ.enqueue(i, distances[source][i]);
					pQ.blockInFuture(i);
					//ar[i]=?????
				}
			}
			pQ.pop();
		}
		// vi)
		return ar[target];
	}
}
