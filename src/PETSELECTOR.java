import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PETSELECTOR {
    private final JFrame frame;
    private final JPanel panel;
    private final ButtonGroup petGroup;
    private final JLabel imageLabel;

    public PETSELECTOR() {
        frame = new JFrame("Pet Display App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        petGroup = new ButtonGroup();

        JPanel radioButtonPanel = new JPanel(new GridLayout(5, 1)); // Panel to hold radio buttons vertically

        JRadioButton birdButton = new JRadioButton("bird");
        JRadioButton catButton = new JRadioButton("cat");
        JRadioButton dogButton = new JRadioButton("dog");
        JRadioButton rabbitButton = new JRadioButton("rabbit");
        JRadioButton pigButton = new JRadioButton("pig");

        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        radioButtonPanel.add(birdButton);
        radioButtonPanel.add(catButton);
        radioButtonPanel.add(dogButton);
        radioButtonPanel.add(rabbitButton);
        radioButtonPanel.add(pigButton);

        panel.add(radioButtonPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);

        ActionListener petSelectionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();
                if (selectedButton.isSelected()) {
                    String selectedPet = selectedButton.getText();
                    displayPetImage(selectedPet);
                }
            }
        };

        birdButton.addActionListener(petSelectionListener);
        catButton.addActionListener(petSelectionListener);
        dogButton.addActionListener(petSelectionListener);
        rabbitButton.addActionListener(petSelectionListener);
        pigButton.addActionListener(petSelectionListener);

        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private void displayPetImage(String pet) {
        String imagePath = "images/"; // Update this to the correct path
        ImageIcon icon = new ImageIcon(imagePath + pet + ".jpg");
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PETSELECTOR();
            }
        });
    }
}