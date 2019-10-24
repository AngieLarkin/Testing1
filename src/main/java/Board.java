import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


// игровая доска
public class Board extends JPanel {

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawDonut(g);
    }

    // Метод отрисовки изображения
    private void drawDonut(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // делегируем рисование специальному методу, копоненте работы с 2д графионом


        // ништячки рендернига нужны для улучшения качества изображения, всё рисуется поровней и попиздаче
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // Получаем размер окна, что бы держать наш пончик по середине.
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        // Рисуем элипс
        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        // Вращаем овал пока не получится пончик
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
    public Board() {}

}
