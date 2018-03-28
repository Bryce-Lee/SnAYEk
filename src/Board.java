import java.util.*;

public class Board {
    // This Class contains all elements on the board (Apple and Snake obj's)

    private int appleX,appleY;       // Current Coordiantes of apple
    private Snake snakeOne;          // Contains player one's snake
    private Snake snakeTwo;          // Contains player two's snake

    public Board(){
    snakeOne = new Snake();
    snakeTwo = new Snake();
    appleX = 600;
    appleY = 420;
    }


    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public ArrayList<Snakelet> getSnakeOneList() {
        return snakeOne.snakeList;
    }

    public Snake getSnakeOne(){
        return snakeOne;
    }

    public Snake getSnakeTwo() {
        return snakeTwo;
    }

    public ArrayList<Snakelet> getSnakeTwoList() {
        return snakeTwo.snakeList;
    }





    public void addSnake1(Snake snek){
        snakeOne = snek;
    }

    public void addSnake2(Snake snek){
        snakeTwo = snek;
    }




    public void spawnApple()
    {
        appleX = ((int)(Math.random()*78) * 15) +15;
        appleY = ((int)(Math.random()*45) * 15) +15;

    }

}
