import java.util.*;
public class mainLoop implements Runnable{

    boolean running=true;
    int tickCount = 0;
    @Override

    public void run() {

        int fps = 12; //number of update per second.
        double tickPerSecond = 1000000000 / fps;                // Time per frame
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();




        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / tickPerSecond;

            lastTime = now;
            tickCount++;


            if (delta >= 1) {                               // Determines if enough time has passed to execute cycle

                tick();
                checkLoss(mainC.getsnakeBoard().getSnakeOne(),mainC.getsnakeBoard().getSnakeTwo());
                System.out.println(running);
                render();
                delta--;
            }


        }
    }



        private void tick(){




            mainC.getsnakeBoard().getSnakeOne().moveSnake();                    //Move Snake One
            mainC.getsnakeBoard().getSnakeTwo().moveSnake();                    //Move Snake Two
            appleEaten(mainC.getsnakeBoard().getSnakeOne(),mainC.getsnakeBoard().getSnakeTwo());


            System.out.println("\n");
            for(Snakelet temp:mainC.getsnakeBoard().getSnakeTwo().snakeList)
                System.out.println("(" +temp.getX() + " ," + temp.getY() + ")");

        System.out.println("Snake One is Moving in direction: " + mainC.getsnakeBoard().getSnakeOne().direction  );
        System.out.println("Snake Two is moving in direction: " + mainC.getsnakeBoard().getSnakeTwo().direction  );
        System.out.println("Snake One growth: " + mainC.getsnakeBoard().getSnakeOne().growth);
        System.out.println("Snake Two growth: " + mainC.getsnakeBoard().getSnakeTwo().growth);



        }
        public void appleEaten(Snake one,Snake two)
        {
            if(one.getX() == mainC.getsnakeBoard().getAppleX() && one.getY() == mainC.getsnakeBoard().getAppleY()) {
                one.growth = 5;
                mainC.getsnakeBoard().spawnApple();
            }
            if(two.getX() == mainC.getsnakeBoard().getAppleX() && two.getY() == mainC.getsnakeBoard().getAppleY()) {
                two.growth = 5;
                mainC.getsnakeBoard().spawnApple();
            }


        }
        public void checkLoss(Snake snakeOne,Snake snakeTwo)
        {

                for(int temp1=0;temp1 < snakeOne.snakeList.size();temp1++)          //Checks loss conditions pertaining to player 1
                {
                    if (snakeOne.getX() > 1190 || snakeOne.getX() < 15 || snakeOne.getY() < 15 || snakeOne.getY() > 710) //Checks for out of bounds head
                    {
                        System.out.println("Player One Out of Bounds");
                        running = false;
                    }
                    for (int temp3 = 0; temp3 < snakeTwo.snakeList.size(); temp3++) {                   // Iterat
                        if (snakeOne.getX() == snakeTwo.snakeList.get(temp3).getX() && snakeOne.getY() == snakeTwo.snakeList.get(temp3).getY()) //Checks head collision w player 2
                        {
                            System.out.println("Player One Collision");
                            running = false;
                        }

                    }
                    if(snakeOne.getX() == snakeOne.snakeList.get(temp1).getX() && snakeOne.getY() == snakeOne.snakeList.get(temp1).getY()) {
                        if(temp1 != 0)
                        {
                            System.out.println("Player One Collision w self");
                            running = false;
                        }
                    }
                }

                for(int temp2=0;temp2 < snakeTwo.snakeList.size();temp2+=1)         //Checks loss conditions pertaining to player 2
                {
                    if(snakeTwo.getX() > 1190 || snakeTwo.getX() < 15 || snakeTwo.getY() < 15 || snakeTwo.getY() > 710)  //Checks for out of bound head
                    {
                        System.out.println("Player Two Out of Bounds");
                        running = false;
                    }
                    for(int temp4 =0;temp4 < snakeOne.snakeList.size();temp4++) {
                        if (snakeTwo.getX() == snakeOne.snakeList.get(temp4).getX() && snakeTwo.getY() == snakeOne.snakeList.get(temp4).getY())    //Checks head collision w player 1
                        {
                            System.out.println("Player Two Collision");
                            running = false;
                        }
                    }
                    if(snakeTwo.getX() == snakeTwo.snakeList.get(temp2).getX() && snakeTwo.getY() == snakeTwo.snakeList.get(temp2).getY())
                    {
                        if(temp2 != 0)
                        {
                            System.out.println("Player Two Collided w self");
                            running = false;
                        }
                    }
                }

        }
        private void render(){
            System.out.println("Position of Snakes are:   One: " + mainC.getsnakeBoard().getSnakeOne().getX() + ", " + mainC.getsnakeBoard().getSnakeOne().getY() +
                                " Two:  " + mainC.getsnakeBoard().getSnakeTwo().getX() + ", " + mainC.getsnakeBoard().getSnakeTwo().getY() + " \n" );
            mainC.getM().paintComponent(mainC.getM().getGraphics());
            mainC.getM().drawApple();                                                                                                    //Draws Apple
            mainC.getM().drawSnake( mainC.getsnakeBoard().getSnakeOne(), mainC.getsnakeBoard().getSnakeTwo());  //Draws Snakes
        }
    }