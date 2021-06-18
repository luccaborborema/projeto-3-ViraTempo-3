package inatividade;

import java.awt.PointerInfo;
import java.awt.MouseInfo;
import java.awt.Point;

public class Inativo extends Thread{
    int counter = 0;

    @Override
    public void run() {
        double x = -1;
        double y = -1;
        while (true){
            try {
                Thread.sleep(300000);
            } catch(InterruptedException e) {
                //System.out.println("got interrupted!");
            }
            if (x == MouseInfo.getPointerInfo().getLocation().getX() &&
            y == MouseInfo.getPointerInfo().getLocation().getY()){
                //System.out.println("Inativo");
                counter++;
            }
            x = MouseInfo.getPointerInfo().getLocation().getX();
            y = MouseInfo.getPointerInfo().getLocation().getY();
            //System.out.println("X: "+ x + "Y:"+ y);
            //System.out.println(counter);

        }
    }

    public int callback(){
        return counter;
    }

}