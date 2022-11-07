public class Mouse {
    double x;
    int y;

    String file;

    public Mouse(int x, int y, String file){
        this.x=x;
        this.y=y;
        this.file = file;
    }

    public void draw(){
        StdDraw.picture(x, y, file, 1,1);
    }

    public void move(){
        if(y<0||x>17||y>17){
            x=-1;
            y=StdRandom.uniformInt(0,17);
        }
        else{
            x+=0.5;
        }
    }
}
