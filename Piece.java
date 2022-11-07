import java.util.ArrayList;
import java.util.List;

public class Piece {
    int x;
    int y;
    char direction;

    List<Turn> turns;

    public Piece(int x, int y, char direction){
        this.x = x;
        this.y = y;
        this.direction =direction;
        turns = new ArrayList<Turn>();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void draw(){
        StdDraw.picture(x, y, "pip1.png", 1,1);
    }

    public void move(){
        if(turns.size()>0) {
            if (turns.get(0).x == x && turns.get(0).y == y) {
                direction = turns.get(0).direction;
                turns.remove(0);
            }
        }
        if(direction=='a'){
            x--;
        }
        else if(direction=='d'){
            x++;
        }
        else if(direction=='w'){
            y++;
        }
        else if (direction=='s'){
            y--;
        }
    }

    public void turn(int x,int y, char direction) {
        turns.add(new Turn(x,y, direction));
    }
}
