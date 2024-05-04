package graph.test;

import graph.*;

public class TestProgram {

    public static void main(String[] args) {

        // Graph initialization using setEdge(u, v, cost)

        IGraph g1 = new Graph(6);

        g1.setCost(1, 2, 6);
        g1.setCost(1, 3, 1);
        g1.setCost(1, 4, 5);
        g1.setCost(2, 1, 6);
        g1.setCost(2, 3, 5);
        g1.setCost(2, 5, 3);
        g1.setCost(3, 1, 1);
        g1.setCost(3, 2, 5);
        g1.setCost(3, 4, 8);
        g1.setCost(3, 5, 6);
        g1.setCost(3, 6, 4);
        g1.setCost(4, 1, 5);
        g1.setCost(4, 3, 8);
        g1.setCost(4, 6, 2);
        g1.setCost(5, 2, 3);
        g1.setCost(5, 3, 6);
        g1.setCost(5, 6, 9);
        g1.setCost(6, 3, 4);
        g1.setCost(6, 4, 2);
        g1.setCost(6, 5, 9);

        System.out.println(g1.toString("Graph G1"));

        // Graph initialization using a cost matrix

        int [][] cost = { { -1,  6,  1,  5, -1, -1 },
                {  6, -1,  5, -1,  3, -1 },
                {  1,  5, -1,  8,  6,  4 },
                {  5, -1,  8, -1, -1,  2 },
                { -1,  3,  6, -1, -1,  9 },
                { -1, -1,  4,  2,  9, -1 } };

        IGraph g2 = new Graph(cost);

        System.out.println(g2.toString("Graph G2"));
    }
}
