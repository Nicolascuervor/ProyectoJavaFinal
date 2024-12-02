package Ventanas.personalizados;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class RoundedButton extends JButton {
    private int cornerRadius = 30;  // Radio de las esquinas
    private int borderThickness = 3;  // Grosor del borde
    private boolean isPressed = false;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));

        // Añadir listeners para el efecto de presión
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Sombra alrededor del botón
        g2.setColor(new Color(0, 0, 0, 50));  // Sombra ligera
        g2.fill(new RoundRectangle2D.Float(4, 4, getWidth() - 8, getHeight() - 8, cornerRadius, cornerRadius));

        // Dibujar el borde
        g2.setColor(new Color(0, 63, 112));  // Color del borde
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Fondo del botón (blanco por defecto, cambia solo cuando está presionado)
        g2.setColor(isPressed ? new Color(220, 220, 220) : Color.WHITE);  // Gris claro cuando está presionado
        g2.fill(new RoundRectangle2D.Float(
            borderThickness, borderThickness,
            getWidth() - borderThickness * 2,
            getHeight() - borderThickness * 2,
            cornerRadius, cornerRadius
        ));

        super.paintComponent(g2);
        g2.dispose();
    }
}

