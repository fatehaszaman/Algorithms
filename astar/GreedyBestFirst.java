package astar;

public class GreedyBestFirst implements ICostFunction {

    public int cost (int g, int h){
        return h;
    }
}
