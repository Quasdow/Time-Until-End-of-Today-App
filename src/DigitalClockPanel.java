import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DigitalClockPanel extends JPanel {

    private JLabel countdownLabel;
    private JLabel messageLabel;

    public DigitalClockPanel() {
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 25));

        // Load digital clock font
        Font digitalFont;
        try {
            digitalFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/digital-7.ttf"))
                    .deriveFont(85f);
        } catch (FontFormatException | IOException e) {
            digitalFont = new Font("Times New Roman", Font.PLAIN, 85);
            e.printStackTrace();
        }

        // Initialize countdown label with digital font
        countdownLabel = new JLabel();
        countdownLabel.setFont(digitalFont);
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countdownLabel.setForeground(new Color(196, 196, 196));

        // Initialize message label
        messageLabel = new JLabel("until New Day");
        messageLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(new Color(105, 105, 105));

        // Add labels to panel
        add(countdownLabel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
    }

    public JLabel getCountdownLabel() {
        return countdownLabel;
    }
}
