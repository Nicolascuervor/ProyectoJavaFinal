
package Ventanas.personalizados;

 
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ThemeManager {

    private static ThemeManager instance;
    private boolean isDarkMode = false;  // Estado del tema
    private final List<ThemedFrame> frames = new ArrayList<>();

    private ThemeManager() {}

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    // Cambiar el estado de modo oscuro y notificar a los frames
    public void toggleDarkMode() {
        isDarkMode = !isDarkMode;
        for (ThemedFrame frame : frames) {
            frame.applyTheme();
        }
    }

    // Registrar un frame para ser actualizado
    public void registerFrame(ThemedFrame frame) {
        frames.add(frame);
    }

    // Desregistrar un frame
    public void unregisterFrame(ThemedFrame frame) {
        frames.remove(frame);
    }
}