public class Leaf {
    int x;
    int y;

    public Leaf(int size){
        x=StdRandom.uniformInt(0, size);
        y=StdRandom.uniformInt(0,size);
    }

    public void draw(){
        StdDraw.picture(x, y, "leaf.png", 1,1);
    }
}
