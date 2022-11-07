import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Game {
    public static void main(String[] args){
        int size = 17;
        StdDraw.setScale(-0.5, size-0.5);
        Schlange n = new Schlange(6,6);
        Mouse[] objects = new Mouse[2];
        objects[0] = new Mouse(7,9, "mouse.png");
        objects[1] = new Mouse(7,9, "bird.png");
        Leaf[] l = new Leaf[7];
        for(int i=0; i<l.length; i++){
            l[i]=new Leaf(size);
        }
        drawGrid(size, n, objects,l);
        drawIntro(size);
        StdDraw.show();
        while(!StdDraw.hasNextKeyTyped()){

        }
        int count = 0;
        StdDraw.nextKeyTyped();
        while(gameOver(n, size)){
            if(StdDraw.hasNextKeyTyped()){
                char x = StdDraw.nextKeyTyped();
                if(x=='a'||x=='s'||x=='d'||x=='w'){
                    n.turn(x);
                }
            }
            if(objects[0].x<0 && objects[0].y<0){
                objects[0].x = StdRandom.uniformInt(0,size);
                objects[0].y = StdRandom.uniformInt(0,size);
            }
            count += n.move(objects);
            StdDraw.pause(100);
            drawGrid(size, n, objects,l);
        }

        drawOver(size, count);
    }

    private static void drawGrid(int size, Schlange s, Mouse[] m, Leaf[] l){
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        for(int i = 0; i<size; i++){
            for(int j=0; j<size; j++){
                StdDraw.setPenColor(168, 96, 2);
                StdDraw.filledSquare(i, j, 0.5);
                StdDraw.setPenColor(StdDraw.BLACK);
            }
        }
        for(int i=0; i<l.length; i++){
            l[i].draw();
        }
        s.draw();
        for(int i=0; i<m.length; i++){
            m[i].draw();
        }
        StdDraw.show();
    }

    private static boolean gameOver(Schlange s, int size){
        if(s.schlange.get(0).x==size||s.schlange.get(0).x<0){
            return false;
        }
        if(s.schlange.get(0).y==size||s.schlange.get(0).y<0){
            return false;
        }
        for(int i=1; i<s.schlange.size(); i++){
            if(s.schlange.get(0).y==s.schlange.get(i).y && s.schlange.get(0).x==s.schlange.get(i).x){
                return false;
            }
        }
        return true;
    }

    private static void drawOver(int size, int count){
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(size/2.-0.5,size/2.-0.5, 5, 2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(size/2.-0.5, size/2.-0.5, "Score : " + count);
        StdDraw.show();
    }
    private static void drawIntro(int size){
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(size/2.-0.5,size/2.-0.5, 5.5, 2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(size/2.-0.5, size/2.+0.5, "Pip Snake Game: catch the birds and mice");
        StdDraw.text(size/2.-0.5, size/2.-0.5, "Press any key to start");
        StdDraw.show();
    }
}
