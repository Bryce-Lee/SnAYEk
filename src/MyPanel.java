import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MyPanel extends JPanel implements MouseListener , KeyListener {
    public int playerOneColor;
    public int playerTwoColor;
    private int GameState;
    MyPanel()
    {
        GameState = 0;
        setSize(1200, 800);
        setVisible(true); //it's like calling the repaint method.
        //drawGrid();
    }


    public void preGame(Graphics g)
    {
        GameState =1;
        String[] colors = {"RED", "GREEN", "PINK","ORANGE","YELLOW"};


        while(!mainC.getsnakeBoard().getSnakeOne().ready && !mainC.getsnakeBoard().getSnakeTwo().ready )
            {

                g.setColor(Color.BLACK);
                g.drawString("Press Up or Down to select your color!",700,100);
                g.drawString("Player One Color: " ,100,400);
                g.drawString("Player Two Color: ",800,400);
                g.setColor(getColor(colors[playerOneColor]));
                g.fillRect(225,383,25,25);
                g.setColor(getColor(colors[playerTwoColor]));
                g.fillRect(925,383,25,25);

            }
        mainC.getsnakeBoard().getSnakeOne().snakeColor = colors[playerOneColor];
        mainC.getsnakeBoard().getSnakeTwo().snakeColor = colors[playerTwoColor];
        GameState = 0;

    }
    public void paintComponent(Graphics g)
    {

        g.setColor(new Color(244, 66, 66));
        g.fillRect(0,0,1200,800);
        g.setColor(new Color(46, 53, 193));
        g.fillRect(15,15,1185,705);

    }
    public void drawApple(){
        Graphics temp = mainC.getM().getGraphics();
        temp.setColor(Color.RED);
        temp.fillRect(mainC.getsnakeBoard().getAppleX(),mainC.getsnakeBoard().getAppleY(),14,14);
    }
    public Color getColor(String colorString)
    {
        switch(colorString)
        {
            case "RED":
                return Color.red;
            case "BLUE":
                return Color.blue;
            case "GREEN":
                return Color.green;
            case "PINK":
                return Color.pink;
            case "ORANGE":
                return Color.orange;
            case "YELLOW":
                return Color.yellow;

        }
        return null;
    }
    public  void drawSnake(Snake snakeOne, Snake snakeTwo)
    {
        Color snake1 = getColor(snakeOne.snakeColor);
        Color snake2 = getColor(snakeTwo.snakeColor);
        Graphics tempGraphics = getGraphics();

        tempGraphics.setColor(snake1);
        for(int temp1=0;temp1 < snakeOne.snakeList.size();temp1++)
        {
            tempGraphics.fillRect(snakeOne.snakeList.get(temp1).getX(),snakeOne.snakeList.get(temp1).getY(),14,14);
        }


        tempGraphics.setColor(snake2);
        for(int temp2=0;temp2 < snakeTwo.snakeList.size();temp2++)
        {
            tempGraphics.fillRect(snakeTwo.snakeList.get(temp2).getX(),snakeTwo.snakeList.get(temp2).getY(),14,14);
        }




    }

    public void setGameState(int gameState)
    {
        GameState = gameState;
    }

    public void toggleColor(int snake,int direction) {                                               // 0 = up 1 = down
        String[] colors = {"RED", "GREEN", "PINK","ORANGE","YELLOW"};

        if (snake == 1) {
            if (direction == 0) {
                if (playerOneColor == 4)
                    playerOneColor = 0;
                else
                    playerOneColor++;
            }
            else
            {
                if (playerOneColor == 0)
                    playerOneColor = 4;
                else
                    playerOneColor--;
            }

        }
        else
        {
            if (direction == 0) {
                if (playerTwoColor == 4)
                    playerTwoColor = 0;
                else
                    playerTwoColor += 1;
             }
             else
             {
                 if (playerTwoColor == 0)
                     playerTwoColor = 4;
                 else
                     playerTwoColor--;
             }

        }
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    System.out.println("KEY PRESSED BOYOS");
     if(GameState == 0){
        switch (e.getKeyCode())                                //Determines which persons methods need
            {                                                 //to be called and passes needed parameters
                                                              //up = 1004 , down = 1005 , left = 1006 right = 1007
                case KeyEvent.VK_UP:
                    mainC.getsnakeBoard().getSnakeTwo().setDirection(3);
                    break;

                case KeyEvent.VK_DOWN:
                    mainC.getsnakeBoard().getSnakeTwo().setDirection(1);
                    break;

                case KeyEvent.VK_LEFT:
                    mainC.getsnakeBoard().getSnakeTwo().setDirection(0);
                    break;

                case KeyEvent.VK_RIGHT:
                    mainC.getsnakeBoard().getSnakeTwo().setDirection(2);
                    break;

                case KeyEvent.VK_W:
                    mainC.getsnakeBoard().getSnakeOne().setDirection(3);
                    break;

                case KeyEvent.VK_A:
                    mainC.getsnakeBoard().getSnakeOne().setDirection(0);
                    break;

                case KeyEvent.VK_S:
                    mainC.getsnakeBoard().getSnakeOne().setDirection(1);
                    break;

                case KeyEvent.VK_D:
                    mainC.getsnakeBoard().getSnakeOne().setDirection(2);
                    break;
        }
     }
        else
     {
         /*Chose color screen*/
         switch (e.getKeyCode())                                             //Determines which persons methods need
         {                                                                   //to be called and passes needed parameters
             case KeyEvent.VK_UP:
                 toggleColor(2,0);
                 break;

             case KeyEvent.VK_DOWN:
                 toggleColor(2,1);
                 break;

             case KeyEvent.VK_W:
                 toggleColor(1,0);
                 break;

             case KeyEvent.VK_S:
                 toggleColor(1,1);
                 break;

             case KeyEvent.VK_ENTER:
                 mainC.getsnakeBoard().getSnakeOne().ready = true;
                 mainC.getsnakeBoard().getSnakeTwo().ready = true;
                 break;
         }
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
