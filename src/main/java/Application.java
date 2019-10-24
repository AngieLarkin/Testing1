import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    //
    public Application() {
        initUI();
    }
// Создаем точку входя игры
    private void initUI(){
        add(new Board()); // точка входа

        setSize(250, 200); // размер контейнера

        setTitle("wtf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход по кресту
        setLocationRelativeTo(null); // Ставим окошко в центр
    }

    // Создаем инстанс и делаем окно видимым
    public static void main(String[] args){

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }


}
