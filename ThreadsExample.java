package Projects;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
//import com.sun.java.swing.*;  //old package name
import javax.swing.*;           //new package name

public class ThreadsExample {

    /**
     * This is strictly boilerplate: set the look and feel, configure the
     * frame, pack(), show().
     */
    public static void main(String[] args) {
        String laf = UIManager.getCrossPlatformLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(laf);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        JFrame f = new JFrame("Worker Thread Examples");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        };
        f.addWindowListener(l); 

        Container contentPane = f.getContentPane();
        final Example1 ex1 = new Example1();
        contentPane.setLayout(new GridLayout(1, 0));
        contentPane.add(ex1);
        contentPane.add(new Example2());
        f.pack();
        f.show();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ex1.getStartButton().requestFocus();  //XXX: can't do this until now
            }
        });
    }
}
