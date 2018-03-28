
import javax.swing.*;





public class mainC {
    static Board snakeBoard;
    static MyPanel m;
    static JFrame j;

    public static void main(String [] args){

        j = new JFrame();  //JFrame is the window; window is a depricated class
        m = new MyPanel();
        j.setSize(m.getSize());
        j.add(m); //adds the panel to the frame so that the picture will be drawn
        //use setContentPane() sometimes works better then just add b/c of greater efficiency.
        j.addKeyListener(m);
        j.addMouseListener(m);
        j.setVisible(true); //allows the frame to be shown.

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.


        //choose color

        snakeBoard = new Board();                                       //Create Gameboard

        snakeBoard.getSnakeOne().snakeList.get(0).setX(60);             //Set default positions for player 1 and 2
        snakeBoard.getSnakeOne().snakeList.get(0).setY(60);
        snakeBoard.getSnakeTwo().snakeList.get(0).setX(600);
        snakeBoard.getSnakeTwo().snakeList.get(0).setY(60);

        mainC.getM().preGame(mainC.getM().getGraphics());               //Start PreGame sequence


        mainLoop temp = new mainLoop();                                 //Create instance of Main Loop
        Thread t = new Thread(temp);                                    //Add loop to thread
        t.start();                                                      //Start Thread


    }

    public static Board getsnakeBoard() {
        return snakeBoard;
    }

    public static JFrame getJ() {
        return j;
    }

    public static MyPanel getM() {
        return m;
    }
}
