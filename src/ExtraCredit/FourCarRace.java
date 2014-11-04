package ExtraCredit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import static java.lang.Math.max;

@SuppressWarnings("serial")
public class FourCarRace extends JPanel implements ActionListener, Runnable {
    private static final int SCRHEIGHT = 300;    // Delay to start the race
    private static final int SCRWIDTH = 800;     // Delay between each step
    private final int GAMEONMARK = 0;            // Game state at beginning
    private final int GAMEGO = 2;                // Game state when race going
    private final int GAMEOVER = 3;              // Game state when game over
    private final int STARTDELAY = 2000;         // Delay to start the race
    private final int STEPDELAY = 20;            // Delay between each step
    private final int STEPPORTION = 60;          // Screen portion per step
    private final int HEADERSZ = 60;             // Height in header area

    private static Image carRight;               // car image
    private static int carX1, carX2;             // the car x positions
    private static int carY1, carY2;             // the car y positions
    private static int carX3, carX4;
    private static int carY3, carY4;

    private static int carWidth;                 // car width
    private static int carHeight;                // car height

    private static Color headerCol;              // Header background color
    private static Color trackCol;               // Track background color
    private static Color trackBkgCol;            // Track background color

    private static Timer timer;                  // Timer to start game

    private static JPanel mainPanel;             // Main game panel
    private static String headLabel;             // String at top

    private static Vector<String> car1list = new Vector<String>();
    private static Vector<String> car2list = new Vector<String>();
    private static Vector<String> car3list = new Vector<String>();
    private static Vector<String> car4list = new Vector<String>();

    private static String titleBarStr = "Threaded Car Race";
    private static String state1Str = "On Your Mark...";
    private static String state2Str = "Get Set...";
    private static String state3Str = "Go!!!";
    private static int gameState;

    private static boolean runCars;
    private static boolean car1Running;
    private static boolean car2Running;
    /**
     *
     */
    private static boolean car3Running;
    private static boolean car4Running;

    // No Arg Constructor - the thread process runs this
    public FourCarRace() {
    }

    // One Arg Constructor - main panel process runs this
    public FourCarRace(String label, int width, int height) {
        carRight = new ImageIcon("carright.png").getImage();
        MediaTracker track = new MediaTracker(this);
        track.addImage(carRight,0);
        try {
            track.waitForAll();
        } catch ( InterruptedException e ) { }

        carWidth = carRight.getWidth(null);
        carHeight = carRight.getHeight(null);

        // First car's height
        carY1 = HEADERSZ + (height - HEADERSZ - 3*carHeight) / 2
                + carHeight/4;
        // Second car is 1 1/2 car heights below the first
        carY2 = carY1 + carHeight + carHeight/2;
        carX1 = carX2 = 5;


        // Third car
        /**
         * Insert third car information.
         */
        carY3 = carY2 + carHeight + carHeight/2;
        carX2 = carX3 = 5;

        // Fourth car
        /**
         * Insert fourth car information.
         */
        carY4 = carY3 + carHeight + carHeight/2;
        carX3 = carX4 = 5;


        headLabel = label;
        headerCol = new Color(255,182,193);
        trackBkgCol = Color.green;
        trackCol = Color.white;
        gameState = 0;

        setBackground(headerCol);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        timer = new Timer(STARTDELAY,this);
        timer.start();
    }

    // runs once just to start the traversal thread
    public void actionPerformed(ActionEvent event) {
        if (gameState == GAMEONMARK) {
            ++gameState;
            headLabel = state2Str;
            repaint();
        } else {
            timer.stop();
            ++gameState;
            (new Thread(new FourCarRace())).start();
        }
    }

    // starts the traversal thread
    public void run() {
        // Create runnables
        Runnable car1move = new car1move();
        Runnable car2move = new car2move();

        // Create 3rd and 4th car runnables below
        /**
         * Runnable car3move = new car3move();
         * Runnable car4move = new car4move();
         */
        Runnable car3move = new car3move();
        Runnable car4move = new car4move();

        // Create threads
        Thread thread1 = new Thread(car1move);
        Thread thread2 = new Thread(car2move);

        // Create 3rd and 4th car threads below
        /**
         * Thread thread3 = new Thread(car3move);
         * Thread thread4 = new Thread(car4move);
         */
        Thread thread3 = new Thread(car3move);
        Thread thread4 = new Thread(car4move);

        // Update the header and runCars state
        runCars = true;
        headLabel = state3Str;
        drawHeadLabel(null,true);

        // Start threads
        thread1.start();
        thread2.start();

        // Start 3rd and 4th car Threads
        /**
         * thread3.start();
         * thread4.start();
         */
        thread3.start();
        thread4.start();

        // Variables to determine how large a step each car takes
        int stepWidth = SCRWIDTH / STEPPORTION;
        int maxStep, step1, step2, step3, step4;

        // Car race loop / Game loop
        while (gameState == GAMEGO) {
            pause(2 * STEPDELAY);               // Delay so threads can act
            runCars = false;                    // Stops the threads
            while (car1Running || car2Running)  // Waits for threads to stop
                pause(STEPDELAY);

            // Implement 3rd and 4th car
            /**
             * while (car1Running || car2Running || car3Running || car4Running)
             * pause(STEPDELAY);
             */

            step1 = car1list.size();            // Get car 1 list sizes
            step2 = car2list.size();            // Get car 2 list sizes
            step3 = car3list.size();
            step4 = car4list.size();

            maxStep = max(step1, step2);    // Get max sixe
            // maxStep = Math.max(step1, step2, step3, step4);

            // calculate car stes
            step1 = (maxStep == step1) ? stepWidth :
                    (int) (((double)step1/maxStep) * stepWidth);
            step2 = (maxStep == step2) ? stepWidth :
                    (int) (((double)step2/maxStep) * stepWidth);

            step3 = (maxStep == step3) ? stepWidth :
                    (int) (((double)step3/maxStep) * stepWidth);
            step4 = (maxStep == step4) ? stepWidth :
                    (int) (((double)step4/maxStep) * stepWidth);

            carX1 += step1;   // Move car 1
            carX2 += step2;   // Move car 2

            carX3 += step3;
            carX4 += step4;

            // Determine if any car reached the end
//            if (carX1 + carWidth >= SCRWIDTH ||
//                    carX2 + carWidth >= SCRWIDTH)
                if (carX1 + carWidth >= SCRWIDTH ||
                        carX2 + carWidth >= SCRWIDTH ||
                          carX3 + carWidth >= SCRWIDTH ||
                            carX4 + carWidth >= SCRWIDTH)
                ++gameState;
            else {  // If no care is done, cleanup and go again
                car1list.clear();
                car2list.clear();
                car3list.clear();
                car4list.clear();
                runCars = true;
            }
            mainPanel.repaint();
        }
    }

    // The task for adding to the list of car 1
    class car1move implements Runnable {
        @Override /** Tell the thread how to run */
        public void run() {
            while (true) {
                if (runCars) {
                    car1Running = true;
                    addToListNoSynch(car1list,2);
                    addToListNoSynch(car2list,1);
                    addToListNoSynch(car3list,3);
                    addToListNoSynch(car4list,4);

                } else {
                    car1Running = false;
                    pause(STEPDELAY);
                }
            }
        }
    }

    // The task for adding to the list of car 2
    class car3move implements Runnable {
        @Override /** Tell the thread how to run */
        public void run() {
            while (true) {
                if (runCars) {
                    car3Running = true;
                    addToListNoSynch(car1list,1);
                    addToListNoSynch(car2list,2);
                    addToListNoSynch(car3list,3);
                    addToListNoSynch(car4list,4);
                } else {
                    car3Running = false;
                    pause(STEPDELAY);
                }
            }
        }
    }

    // The task for adding to the list of car 2
    class car4move implements Runnable {
        @Override /** Tell the thread how to run */
        public void run() {
            while (true) {
                if (runCars) {
                    car4Running = true;
                    addToListNoSynch(car1list,1);
                    addToListNoSynch(car2list,2);
                    addToListNoSynch(car3list,3);
                    addToListNoSynch(car4list,4);
                } else {
                    car4Running = false;
                    pause(STEPDELAY);
                }
            }
        }
    }

    // The task for adding to the list of car 2
    class car2move implements Runnable {
        @Override /** Tell the thread how to run */
        public void run() {
            while (true) {
                if (runCars) {
                    car2Running = true;
                    addToListNoSynch(car1list,1);
                    addToListNoSynch(car2list,2);
                    addToListNoSynch(car3list,3);
                    addToListNoSynch(car4list,4);
                } else {
                    car2Running = false;
                    pause(STEPDELAY);
                }
            }
        }
    }

    // Changes the given list without any synching
    public void addToListNoSynch(List<String> list, int amt) {
        for (int i = 0; i < amt; ++i)
            list.add("*");
    }

    // Updates the window
    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        drawHeadLabel(page,false);
        page.setColor(trackBkgCol);
        page.fillRect(0,HEADERSZ,SCRWIDTH,SCRHEIGHT-HEADERSZ);

        page.setColor(trackCol);
        // top and bottom track lines
        page.fillRect(0, carY1-carHeight/4, SCRWIDTH, 2);
        page.fillRect(0, carY2+carHeight+carHeight/4, SCRWIDTH,2);

        // Implement car3
        // Implement car4

        for (int i = 0; i <= SCRWIDTH; i += 40) {    // middle track lines
            page.fillRect(i, carY2-carHeight/4, 20, 2);
            // add more track lines
        }

        page.drawImage(carRight, carX1, carY1, null);     //first car
        page.drawImage(carRight, carX2, carY2, null);     //second car

        // implement 3rd car
        // implement 4th car
        page.drawImage(carRight, carX3, carY3, null);     //second car

        page.drawImage(carRight, carX4, carY4, null);     //second car

    }

    // Draws the header contents at the top of the window
    public void drawHeadLabel(Graphics page, boolean update) {
        if (page == null)
            page = mainPanel.getGraphics();

        if (gameState == GAMEOVER) {
            int max = max(carX1, carX2);
            if (carX1 == max) {
                if (carX2 == carX1) {
                    // add argument for 3rd and 4th car
                    headLabel = "Car #1 and Car #2 Win!!!";
                } else {
                    headLabel = "Car #1 Wins!!!";
                }
            } else {
                headLabel = "Car #2 Wins!!!";
            }
        }

        // Draws the header
        page.setColor(headerCol);
        page.fillRect(0,0,SCRWIDTH,HEADERSZ);

        page.setColor(Color.black);
        page.fillRect(0,HEADERSZ-3,SCRWIDTH,3);

        page.setColor(Color.black);
        page.setFont(new Font("Arial",Font.BOLD,24));
        FontMetrics metrics = page.getFontMetrics();
        page.drawString(headLabel,
                (SCRWIDTH-metrics.stringWidth(headLabel))/2,
                HEADERSZ-20);

        if (update)               // Flag to force an update
            mainPanel.repaint();
    }

    //  Pauses the program for the given number of milliseconds
    public void pause(long millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
        }
    }

    //  The main method
    public static void main(String[] args) {
        JFrame frame = new JFrame(titleBarStr);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new FourCarRace(state1Str,SCRWIDTH,SCRHEIGHT);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}