package geekbrains.Java;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;

public class GamePlay {
    public int pointToWin = 4;
    public Random random = new Random();

    private ImageIcon iconX = createImageIcon("img/X.png", "X"); //создание переменной для картинки Х
    private JLabel labelX = new JLabel(iconX);                                      // помещение картинки в label
    private ImageIcon iconO = createImageIcon("img/O.png", "O"); //картинка О
    private JLabel labelO = new JLabel(iconO);

    protected void player1(JPanel panel) {                                  // передача панели в качестве аргумента для метода
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();             //меняем вид панели (визуально смотрится нажатой при клике)
        panel.setBorder(loweredbevel);                                              //добавляем новый border в панель
        panel.add(labelO).setBounds(73, 73, 73, 73);            //добавляем картинку в панель
    }

//    protected void player2(JPanel panel) {
//        int x = random.nextInt(size - 1);
//        int y = random.nextInt(size - 1);
//        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
//        panel.setBorder(loweredbevel);
//        panel.add(labelX).setBounds(73, 73, 73, 73);
//    }

    protected ImageIcon createImageIcon(String path,
                                        String description) {       // метод для создания картинки (взят из документации How to Use Borders)
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
