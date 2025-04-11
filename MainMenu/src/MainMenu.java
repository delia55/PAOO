import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Meniu Principal Joc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setBackgroundImage("C:\\Users\\Sergiu\\Desktop\\faith-spark-background1.jpg");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        int buttonWidth = 300;
        int buttonHeight = 150;

        JButton startButton = createImageButton("C:\\Users\\Sergiu\\Downloads\\—Pngtree—game button switch start game_5321038.png", buttonWidth, buttonHeight);
        JButton loadButton = createImageButton("C:\\Users\\Sergiu\\Downloads\\91f1e741b24dc5e4c1e862c044b87d97.png", buttonWidth, buttonHeight);
        JButton exitButton = createImageButton("C:\\Users\\Sergiu\\Downloads\\—Pngtree—exit button vector web_7021808.png", buttonWidth, buttonHeight);

        buttonPanel.add(Box.createVerticalStrut(200)); // distanță de sus
        buttonPanel.add(centerComponent(startButton));
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(centerComponent(loadButton));
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(centerComponent(exitButton));

        startButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Jocul începe..."));
        loadButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Jocul este încărcat..."));
        exitButton.addActionListener(e -> System.exit(0));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private Component centerComponent(JButton button) {
        JPanel wrapper = new JPanel();
        wrapper.setOpaque(false);
        wrapper.setLayout(new FlowLayout(FlowLayout.CENTER));
        wrapper.add(button);
        return wrapper;
    }

    private void setBackgroundImage(String imagePath) {
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();

            JLabel backgroundLabel = new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(originalImage, 0, 0, getWidth(), getHeight(), this);
                }
            };

            backgroundLabel.setLayout(new BorderLayout());
            setContentPane(backgroundLabel);

        } catch (Exception e) {
            System.err.println("Eroare la încărcarea imaginii de fundal: " + e.getMessage());
        }
    }

    private JButton createImageButton(String imagePath, int width, int height) {
        JButton button = new JButton() {
            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
            }
        };

        try {
            ImageIcon buttonIcon = new ImageIcon(imagePath);
            Image buttonImage = buttonIcon.getImage();
            Image scaledButtonImage = buttonImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledButtonImage));
        } catch (Exception e) {
            System.err.println("Eroare la încărcarea imaginii pentru buton: " + e.getMessage());
        }

        return button;
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
