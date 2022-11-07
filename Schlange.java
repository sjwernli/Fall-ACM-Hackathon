import java.util.ArrayList;
import java.util.List;

public class Schlange {
    int x;
    int y;
    List<Piece> schlange;
    char direction;

    public Schlange(int x, int y){
        this.x = x;
        this.y = y;
        direction = 'a';
        schlange = new ArrayList<Piece>();
        for(int i=0; i<4; i++){
            schlange.add(new Piece(x+i, y,this.direction));
        }
    }
    public void draw(){
        for(int i = 0; i<schlange.size(); i++){
            schlange.get(i).draw();
        }
    }

    public int move(Mouse[] m){
        for(int i=0; i<schlange.size(); i++){
            schlange.get(i).move();
        }
        m[1].move();
        for(int i=0; i<m.length; i++){
            if (Math.round(m[i].x)==schlange.get(0).x && m[i].y==schlange.get(0).y) {
                m[i].x = -1;
                m[i].y = -1;
                int x1 = schlange.get(schlange.size() - 1).x;
                int y1 = schlange.get(schlange.size() - 1).y;
                List<Turn> t = new ArrayList<Turn>();
                move(m);
                t.addAll(schlange.get(schlange.size() - 1).turns);
                char dir = schlange.get(schlange.size() - 1).direction;
                schlange.add(new Piece(x1, y1, dir));
                schlange.get(schlange.size() - 1).turns = t;
                return 1;
            }
        }
        return 0;
    }


    public void turn(char direction){
        if(!((this.direction =='a'&& direction=='d')||(this.direction=='w' && direction=='s')||(this.direction=='d' && direction=='a')||(this.direction=='s' && direction=='w'))) {
            this.direction = direction;
            for (int i = 0; i < schlange.size(); i++) {
                schlange.get(i).turn(schlange.get(0).getX(),schlange.get(0).getY(), direction);
            }
        }
    }
}
