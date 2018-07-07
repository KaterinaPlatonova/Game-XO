package geekbrains.Java;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameScreen extends JFrame {
    protected int size = 4;
    protected JPanel[][] field = new JPanel[size][size];
    protected int x, y;
    GamePlay play = new GamePlay();

    protected GameScreen() {
        setTitle("Игра в крестики - нолики");                      //устанавливаем название окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //выход при закрытии
        setBounds(size * 100, size * 100, size * 100, size * 100);         //размеры окна
        setLocationRelativeTo(null);                               // расположение окна в центре экрана
        Container container = getContentPane();                    //создать контейнер в окне
        container.setLayout(new GridLayout(size, size));      //устанавливаем менеджер для контейнера

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                JPanel panel = new JPanel();            //создание панели, которую будем помещать в Контейнер(container), менеджер у которого установлен GridLayout

                Border raisedbevel = BorderFactory.createRaisedBevelBorder(); //создание переменной типа Border(чтобы установить вид панели), raisedbevel делает похожими на кнопки(другие варианты см.Using the Borders Provided by Swing)
                panel.setBorder(raisedbevel);                           //устанавливаем панелям созданную выше границу
                field[i][j] = panel;                                       //заполняем массив панелями
                container.add(field[i][j]);                                //добавляем в контейнер массив панелей с границами
                field[i][j].addMouseListener(new MouseAdapter() {          //на каждую панель устанавливается слушатель клика мыши
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        playerOne(panel);
                        setVisible(true);
                    }
                });
            }
        }
        setVisible(true);
    }

    public void playerOne(JPanel panel) {
        x = panel.getX();                               //получаем координату х ПОЛНОСТЬЮ панели
        y = panel.getY();                               //получаем координату y ПОЛНОСТЬЮ панели
        System.out.println("X= " + x + " " + "Y= " + y); //вывод в консоль полученных координат (только для рабочей информации)
        play.player1(panel);                    // при клике по панели меняется вид (нажатая панель) и появляется картинка
    }

//    public void playerTwo(JPanel panel) {
//        x = panel.getX();                               //получаем координату х ПОЛНОСТЬЮ панели
//        y = panel.getY();                               //получаем координату y ПОЛНОСТЬЮ панели
//        System.out.println("X= " + x + " " + "Y= " + y); //вывод в консоль полученных координат (только для рабочей информации)
//        play.player2(panel);                    // при клике по панели меняется вид (нажатая панель) и появляется картинка
//    }

}





