package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagemFundoPanel extends JPanel {

    private Image imagem;

    public ImagemFundoPanel(String caminho) {
        imagem = new ImageIcon(getClass().getResource(caminho)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagem != null) {
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
