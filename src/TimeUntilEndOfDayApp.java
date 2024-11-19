import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class TimeUntilEndOfDayApp extends JFrame {

    private DigitalClockPanel clockPanel;

    public TimeUntilEndOfDayApp() {
        setTitle("Time Until End of Day");
        setSize(500, 200);
        setLocationRelativeTo(null); // Center window on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set app icon
        try {
            Image icon = ImageIO.read(new File("src/icon.jpg"));
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize and add the digital clock panel
        clockPanel = new DigitalClockPanel();
        add(clockPanel);

        // Timer to update countdown every second
        Timer timer = new Timer(1000, e -> updateCountdown());
        timer.start();
    }

    private void updateCountdown() {
        String timeLeft = CountdownTimer.getTimeLeft();
        clockPanel.getCountdownLabel().setText(timeLeft);
    }

    public static void main(String[] args) {
        TimeUntilEndOfDayApp app = new TimeUntilEndOfDayApp();
        app.setVisible(true);
    }
}
