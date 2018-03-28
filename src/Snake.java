import java.util.*;


public class Snake {

    public String snakeColor;
    public int direction;                                  // 0 = left, 1= down, 2= right, 3 = up
    public int timer;
    public ArrayList<Snakelet> snakeList;
    public int growth;
    public boolean ready;
    //private boolean isHead;


    public Snake()
    {
        snakeColor = "blue";
        snakeList = new ArrayList<Snakelet>();
        snakeList.add(new Snakelet(10,10));
        direction = 1;
        growth =0;
        System.out.println("zzz");

    }


    public void setDirection(int temp)
    {
        switch(temp)
        {
            case 0:
                direction =0;
                break;
            case 1:
                direction =1;
                break;
            case 2:
                direction =2;
                break;
            case 3:
                direction =3;
                break;
            default: break;
        }
    }
    public Snake(String color)
    {
        snakeColor = color;
    }
    public int getX() {
        return snakeList.get(0).getX();
    }

    public int getY() {
        return snakeList.get(0).getY();
    }


    public void moveSnake(){
        Snakelet temp = snakeList.get(0);                                   //Temp incase size is 1 and list becomes empty

        if(growth > 0)                                                        //If growing no need to pop
        {
            growth--;
        }
        else
            snakeList.remove(snakeList.size() - 1);

        if(direction == 0)                                                  // Snake is moving left
        {
                //add snakelet to front of current snake
                snakeList.add(0,new Snakelet(temp.getX() - 15 ,temp.getY()));
        }
        else if(direction == 1)                                             // Snake is moving down
        {
            //add snakelet to front of current snake
            snakeList.add(0,new Snakelet(temp.getX() ,temp.getY() +15 ));
        }
        else if(direction == 2)                                             // Snake is moving right
        {

            snakeList.add(0,new Snakelet(temp.getX() + 15,temp.getY()));
        }
        else                                                                // Snake is moving up
        {

            snakeList.add(0,new Snakelet(temp.getX() ,temp.getY() -15 ));
        }


    }



}
