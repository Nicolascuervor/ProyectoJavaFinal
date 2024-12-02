package Ventanas;


import Ventanas.ventanaIngreso;
import cvx.Aplication.Services.EquipoService;
import cvx.Aplication.Services.ReservaService;
import cvx.Aplication.Services.UsuarioService;
import cvx.Domain.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.util.List;

public class IngresoDeUsuario extends JFrame {
    
    private final EquipoService equipoService;
    private final UsuarioService usuarioService;
    private final ReservaService reservaService;
    private Usuario usuario;
    
    private final int WIDTH;
    private final int HEIGHT;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private CardLayout cardLayout;
 
    private Timer slideTimer;
    private Timer fadeTimer;
    private float currentOpacity = 0f;
    private boolean isLoginView = true;

  
    public IngresoDeUsuario(UsuarioService usuarioService,EquipoService equipoService,ReservaService reservaService,Usuario usuarioActual) {
       
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.WIDTH = screenSize.width;
    this.HEIGHT = screenSize.height;
    
    this.equipoService = equipoService;
    this.usuarioService = usuarioService;
    this.reservaService = reservaService;
    this.usuario = usuarioActual;
    
    initializeFrame();
    initializeComponents();
    startFadeInAnimation();
    }

    // Frame Initialization
    private void initializeFrame() {
         setTitle("Modern Authentication");
    setSize(WIDTH, HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
    setUndecorated(true);
    setShape(new RoundRectangle2D.Double(0, 0, WIDTH, HEIGHT, 20, 20));
    }

    private void initializeComponents() {
         mainPanel = new JPanel(new BorderLayout());
    mainPanel.setBackground(new Color(245, 245, 245));
    
    // Crear primero el panel izquierdo
    leftPanel = createLeftPanel();
    
    // Luego crear el panel derecho
    rightPanel = createRightPanel();
    
    
    
    // Crear la barra de título
    JPanel titleBar = createTitleBar();
    
    // Crear el panel de contenido y agregar los paneles
    JPanel contentPanel = new JPanel(new BorderLayout());
    contentPanel.add(leftPanel, BorderLayout.WEST);
    contentPanel.add(rightPanel, BorderLayout.EAST);
    
    // Agregar todo al panel principal
    mainPanel.add(titleBar, BorderLayout.NORTH);
    mainPanel.add(contentPanel, BorderLayout.CENTER);
    
    
        
    
    // Finalmente, agregar el panel principal al frame
    add(mainPanel);
    
    // Asegurarse de que todo esté visible
    mainPanel.revalidate();
    mainPanel.repaint();
    
    }

    // Panel Creation Methods
    private JPanel createLeftPanel() {
        JPanel panel = new GradientPanel();
    panel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
    
    
    // Títulos con animación mejorada
    JLabel welcomeLabel = new AnimatedLabel("Bienvenido", 48);
    JLabel descLabel = new AnimatedLabel("Inicie sesion para continuar", 24);
    
    // Añadir espaciado vertical
    panel.add(Box.createVerticalStrut(HEIGHT/6));
   
    panel.add(Box.createVerticalStrut(50));
    panel.add(welcomeLabel);
    panel.add(Box.createVerticalStrut(20));
    panel.add(descLabel);
    panel.add(Box.createVerticalGlue());
    
    return panel;
    }

    private JPanel createRightPanel() {
        rightPanel = new JPanel();
        cardLayout = new CardLayout();
        rightPanel.setLayout(cardLayout);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        
        rightPanel.add(createLoginPanel(), "login");
        rightPanel.add(createRegisterPanel(), "register");
        
        return rightPanel;
    }

    private JPanel createLoginPanel() {
     JPanel loginPanel = new JPanel(null) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, new Color(255, 255, 255), getWidth(), getHeight(), new Color(230, 230, 250));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
    };
    loginPanel.setBackground(Color.WHITE);

    int fieldWidth = 300;
    int fieldHeight = 45;
    int buttonHeight = 50;

    JLabel titleLabel = new JLabel("Iniciar Sesión");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JTextField usernameField = new JTextField();
    setupPlaceholder(usernameField, "Nombre de usuario");

    JPasswordField passwordField = new JPasswordField();
    setupPlaceholder((JTextField) passwordField, "Contraseña");

    JButton loginButton = createStyledButton("Iniciar Sesión");
    loginButton.addActionListener(e -> handleLogin(usernameField.getText(), new String(passwordField.getPassword())));

    JButton registerLink = new JButton("¿No tiene una cuenta? Registrarse");
    styleAsLink(registerLink);
    registerLink.addActionListener(e -> {
        cardLayout.show(rightPanel, "register");
        updateLeftPanelContent(false);
    });

    JLabel helpLabel = new JLabel("<html><center>¿Olvidaste tu contraseña?<br>Haz clic aquí para recuperarla.</center></html>");
    helpLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    helpLabel.setForeground(new Color(100, 100, 100));
    helpLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel welcomeMessage = new JLabel("<html><center>Bienvenido de nuevo!<br>Por favor, ingresa tus credenciales.</center></html>");
    welcomeMessage.setFont(new Font("Arial", Font.PLAIN, 14));
    welcomeMessage.setForeground(new Color(80, 80, 80));
    welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);

    // Responsive layout
    loginPanel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            int centerX = loginPanel.getWidth() / 2;
            int centerY = loginPanel.getHeight() / 3;

            titleLabel.setBounds(centerX - fieldWidth / 2, centerY - 120, fieldWidth, 50);
            welcomeMessage.setBounds(centerX - fieldWidth / 2, centerY - 70, fieldWidth, 40);
            usernameField.setBounds(centerX - fieldWidth / 2, centerY, fieldWidth, fieldHeight);
            passwordField.setBounds(centerX - fieldWidth / 2, centerY + 60, fieldWidth, fieldHeight);
            loginButton.setBounds(centerX - fieldWidth / 2, centerY + 140, fieldWidth, buttonHeight);
            registerLink.setBounds(centerX - fieldWidth / 2, centerY + 200, fieldWidth, 30);
            helpLabel.setBounds(centerX - fieldWidth / 2, centerY + 250, fieldWidth, 50);
        }
    });

    loginPanel.add(titleLabel);
    loginPanel.add(welcomeMessage);
    loginPanel.add(usernameField);
    loginPanel.add(passwordField);
    loginPanel.add(loginButton);
    loginPanel.add(registerLink);
    loginPanel.add(helpLabel);

      ParticlePanel particlePanel = new ParticlePanel();
    particlePanel.setBounds(0, 0, loginPanel.getWidth(), loginPanel.getHeight());
    loginPanel.add(particlePanel);

    return loginPanel;
}
    
    // Nueva clase para animación de partículas
class ParticlePanel extends JPanel {
    private List<Particle> particles = new ArrayList<>();
    private Timer animationTimer;

    public ParticlePanel() {
        setOpaque(false);
        for (int i = 0; i < 50; i++) {
            particles.add(new Particle());
        }

        animationTimer = new Timer(50, e -> {
            particles.forEach(Particle::update);
            repaint();
        });
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        particles.forEach(p -> p.draw(g2d));
    }

    private class Particle {
        private float x, y;
        private float speed;
        private float size;
        private float alpha;

        public Particle() {
            reset();
        }

        private void reset() {
            x = (float) (Math.random() * getWidth());
            y = (float) (Math.random() * getHeight());
            speed = (float) (1 + Math.random() * 2);
            size = (float) (3 + Math.random() * 5);
            alpha = (float) (0.1 + Math.random() * 0.4);
        }

        public void update() {
            y -= speed;
            if (y < -size) {
                reset();
                y = getHeight() + size;
            }
        }

        public void draw(Graphics2D g2d) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.setColor(new Color(65, 131, 215));
            g2d.fill(new Ellipse2D.Float(x, y, size, size));
        }
    }
}

// Nueva clase para el logo animado
class AnimatedLogoLabel extends JLabel {
    private float rotation = 0;
    private Timer rotationTimer;
    
    public AnimatedLogoLabel(int size) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/contrast.png"));
        Image scaled = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaled));
        
        rotationTimer = new Timer(50, e -> {
            rotation += 0.1f;
            repaint();
        });
        rotationTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        
        g2d.rotate(rotation, cx, cy);
        super.paintComponent(g2d);
        g2d.dispose();
    }
}

    private JPanel createRegisterPanel() {
    JPanel registerPanel = new JPanel(null);
    registerPanel.setBackground(Color.WHITE);

    JLabel titleLabel = new JLabel("Registro");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JTextField usernameField = new JTextField();
    setupPlaceholder(usernameField, "Nombre de usuario");

    JComboBox<String> roleComboBox = new JComboBox<>(new String[]{
        "Estudiante", "Profesor", "Administrador"
    });
    styleComboBox(roleComboBox);

    JButton registerButton = createStyledButton("Registrarse");
    registerButton.addActionListener(e -> handleRegister(
        usernameField.getText(), roleComboBox.getSelectedItem().toString()
    ));

    JButton loginLink = new JButton("¿Ya tiene una cuenta? Iniciar Sesión");
    styleAsLink(loginLink);
    loginLink.addActionListener(e -> {
        cardLayout.show(rightPanel, "login");
        updateLeftPanelContent(true);
    });

    JLabel infoLabel1 = new JLabel("• Los nombres de usuario deben ser únicos");
    JLabel infoLabel2 = new JLabel("• El rol determina los permisos del sistema");
    Font infoFont = new Font("Arial", Font.PLAIN, 12);
    infoLabel1.setFont(infoFont);
    infoLabel2.setFont(infoFont);
    infoLabel1.setForeground(new Color(128, 128, 128));
    infoLabel2.setForeground(new Color(128, 128, 128));

    // Responsive layout
    registerPanel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            int centerX = registerPanel.getWidth() / 2;
            int centerY = registerPanel.getHeight() / 3;
            int fieldWidth = registerPanel.getWidth() / 3;
            int fieldHeight = 35;
            int buttonHeight = 40;

            titleLabel.setBounds(centerX - fieldWidth / 2, centerY - 100, fieldWidth, 40);
            usernameField.setBounds(centerX - fieldWidth / 2, centerY, fieldWidth, fieldHeight);
            roleComboBox.setBounds(centerX - fieldWidth / 2, centerY + 50, fieldWidth, fieldHeight);
            registerButton.setBounds(centerX - fieldWidth / 2, centerY + 110, fieldWidth, buttonHeight);
            loginLink.setBounds(centerX - fieldWidth / 2, centerY + 160, fieldWidth, 30);
            infoLabel1.setBounds(centerX - fieldWidth / 2, centerY + 200, fieldWidth, 20);
            infoLabel2.setBounds(centerX - fieldWidth / 2, centerY + 220, fieldWidth, 20);
        }
    });

    registerPanel.add(titleLabel);
    registerPanel.add(usernameField);
    registerPanel.add(roleComboBox);
    registerPanel.add(registerButton);
    registerPanel.add(loginLink);
    registerPanel.add(infoLabel1);
    registerPanel.add(infoLabel2);

    return registerPanel;
}
   private void styleComboBox(JComboBox<String> comboBox) {
    comboBox.setUI(new BasicComboBoxUI() {
        @Override
        protected JButton createArrowButton() {
            JButton button = super.createArrowButton();
            button.setBackground(Color.WHITE);
            button.setBorder(BorderFactory.createEmptyBorder());
            return button;
        }
    });
    
    // Añadir bordes y padding
    comboBox.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(200, 200, 200)),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    
    // Estilizar el desplegable
    Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
    if (comp instanceof JPopupMenu) {
        JPopupMenu popup = (JPopupMenu) comp;
        popup.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
    }
}
    
    
    private JPanel createInfoPanel() {
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setOpaque(false);
    
    // Estilo para las etiquetas de información
    Font infoFont = new Font("Arial", Font.PLAIN, 11);
    Color infoColor = new Color(102, 102, 102);
    
    JLabel infoLabel1 = new JLabel("• Los nombres de usuario deben ser únicos");
    JLabel infoLabel2 = new JLabel("• El rol determina los permisos del sistema");
    
    infoLabel1.setFont(infoFont);
    infoLabel2.setFont(infoFont);
    infoLabel1.setForeground(infoColor);
    infoLabel2.setForeground(infoColor);
    
    infoPanel.add(infoLabel1);
    infoPanel.add(Box.createVerticalStrut(5));
    infoPanel.add(infoLabel2);
    
    return infoPanel;
}

   private JPanel createTitleBar() {
    JPanel titleBar = new JPanel(new BorderLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, new Color(65, 131, 215), getWidth(), 0, new Color(41, 128, 185));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    titleBar.setPreferredSize(new Dimension(WIDTH, 30));

    // Window control buttons
    JButton closeButton = new AnimatedButton("×");
    closeButton.setForeground(Color.WHITE);
    closeButton.setPreferredSize(new Dimension(30, 30));
    closeButton.addActionListener(e -> startFadeOutAnimation());

    JButton minimizeButton = new AnimatedButton("−");
    minimizeButton.setForeground(Color.WHITE);
    minimizeButton.setPreferredSize(new Dimension(30, 30));
    minimizeButton.addActionListener(e -> setState(Frame.ICONIFIED));

    JButton resizeButton = new AnimatedButton("⬜");
    resizeButton.setForeground(Color.WHITE);
    resizeButton.setPreferredSize(new Dimension(30, 30));
    resizeButton.addActionListener(e -> {
        if (getExtendedState() == Frame.MAXIMIZED_BOTH) {
            setExtendedState(Frame.NORMAL);
        } else {
            setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    });

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    buttonPanel.setOpaque(false);
    buttonPanel.add(minimizeButton);
    buttonPanel.add(resizeButton);
    buttonPanel.add(closeButton);

    titleBar.add(buttonPanel, BorderLayout.EAST);

    // Window drag functionality
    MouseAdapter dragListener = new MouseAdapter() {
        private Point mouseDownCompCoords;

        @Override
        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    };
    titleBar.addMouseListener(dragListener);
    titleBar.addMouseMotionListener(dragListener);

    return titleBar;
}

    // UI Update Methods
    private void updateLeftPanelContent(boolean isLogin) {
        if (leftPanel == null) return;
        
        leftPanel.removeAll();
        
        JLabel welcomeLabel = new AnimatedLabel(
            isLogin ? "Bienvenido" : "Crear cuenta",
            24
        );
        JLabel descLabel = new AnimatedLabel(
            isLogin ? "Inicie sesion para continuar" : "Registra tu usuario para accerder al sistema",
            16
        );
        
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(welcomeLabel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(descLabel);
        leftPanel.add(Box.createVerticalGlue());
        
        leftPanel.revalidate();
        leftPanel.repaint();
    }

    // UI Helper Methods
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
    button.setBackground(new Color(65, 131, 215));
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setBorderPainted(false);
    button.setFont(new Font("Arial", Font.BOLD, 16));
    button.setHorizontalAlignment(SwingConstants.CENTER); // Centrado
    
    // Añadir bordes redondeados
    button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    
    button.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            button.setBackground(new Color(41, 128, 185));
        }
        public void mouseExited(MouseEvent e) {
            button.setBackground(new Color(65, 131, 215));
        }
    });
    
    return button;
    }

    private void styleAsLink(JButton button) {
         button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setForeground(new Color(41, 128, 185));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.setFont(new Font("Arial", Font.BOLD, 14)); // Ajustado tamaño
    button.setHorizontalAlignment(SwingConstants.CENTER); // Centrado
    }

    private void setupPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        
         field.setBorder(BorderFactory.createCompoundBorder(
        field.getBorder(),
        BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding interno
    ));
        
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField)field).setEchoChar('●');
                    }
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField)field).setEchoChar((char)0);
                    }
                }
            }
        });
    }

    // Animation Methods
    private void startFadeInAnimation() {
        fadeTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOpacity += 0.05f;
                if (currentOpacity >= 1f) {
                    currentOpacity = 1f;
                    fadeTimer.stop();
                }
                setOpacity(currentOpacity);
            }
        });
        fadeTimer.start();
    }

    private void startFadeOutAnimation() {
        fadeTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOpacity -= 0.05f;
                if (currentOpacity <= 0f) {
                    currentOpacity = 0f;
                    fadeTimer.stop();
                    dispose();
                }
                setOpacity(currentOpacity);
            }
        });
        fadeTimer.start();
    }
// Método mejorado para mostrar errores
    
    


    // Event Handlers
    private void handleLogin(String username, String password) {
        
          java.util.List<Usuario> usuarios = usuarioService.listaUsuarios();
        boolean usuarioEncontrado = false;
        Usuario usuarioActual = null;

        for (Usuario usuario : usuarios) {
            if (username.equals(usuario.getNombre())) {
                usuarioEncontrado = true;
                usuarioActual = usuario; // Guarda el usuario encontrado
                break;
            }
        }

        if (usuarioEncontrado) {
            // Pasa el usuario autenticado al nuevo JFrame
            ventanaIngreso v = new ventanaIngreso(usuarioService, equipoService, reservaService, usuarioActual);
            v.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado en registros");
        }
    
        
        
        
        if (username.isEmpty() || password.isEmpty()) {
           JOptionPane.showMessageDialog(null, "No has llenado los datos");
            return;
        }
        System.out.println("Login attempt with username: " + username);
    }

    private void handleRegister(String username, String role) {
    try {
        // Validar que el nombre de usuario no esté vacío
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Por favor ingrese un nombre de usuario");
        }

        // Validar que el nombre de usuario no contenga números
        if (!username.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El nombre de usuario no debe contener números");
        }

        // Validar que el rol sea uno de los permitidos
        if (!role.equals("Estudiante") && !role.equals("Profesor") && !role.equals("Administrador")) {
            throw new IllegalArgumentException("Rol no válido");
        }

        // Intentar registrar al usuario
        Usuario usuario = new Usuario(username, role);
        usuarioService.registrarUsuario(usuario);
        JOptionPane.showMessageDialog(
            this,
            "Usuario registrado exitosamente",
            "Registro Completado",
            JOptionPane.INFORMATION_MESSAGE
        );
        cardLayout.show(rightPanel, "login");
        updateLeftPanelContent(true);
    } catch (IllegalArgumentException e) {
        showError(e.getMessage());
    } catch (Exception e) {
        showError("Error al registrar usuario: " + e.getMessage());
    }
}

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    
}

// Custom Component Classes
class AnimatedButton extends JButton {
    private float scale = 1.0f;
    private boolean isHovered = false;
    private Timer pulseTimer;
    
    public AnimatedButton(String text) {
        super(text);
        setupButton();
    }
    
    private void setupButton() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        
        pulseTimer = new Timer(50, (e) -> {
            if (isHovered) {
                scale += 0.03f;
                if (scale > 1.2f) scale = 1.2f;
            } else {
                scale -= 0.03f;
                if (scale < 1.0f) scale = 1.0f;
            }
            repaint();
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                pulseTimer.start();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int w = getWidth();
        int h = getHeight();
        int x = (int) (w * (1 - scale) / 2);
        int y = (int) (h * (1 - scale) / 2);
        int w2 = (int) (w * scale);
        int h2 = (int) (h * scale);
        
        g2d.setColor(isHovered ? new Color(41, 128, 185) : new Color(65, 131, 215));
        g2d.fillRoundRect(x, y, w2, h2, 10, 10);
        
        FontMetrics fm = g2d.getFontMetrics();
        String text = getText();
        int textX = (w - fm.stringWidth(text)) / 2;
        int textY = (h + fm.getAscent() - fm.getDescent()) / 2;
        g2d.setColor(getForeground());
        g2d.drawString(text, textX, textY);
        
        g2d.dispose();
    }
}

class AnimatedLabel extends JLabel {
    private float opacity = 0f;
    private Timer fadeTimer;
    
    public AnimatedLabel(String text, int fontSize) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, fontSize));
        setForeground(Color.WHITE);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        
        fadeTimer = new Timer(50, (e) -> {
            opacity += 0.1f;
            if (opacity >= 1f) {
                opacity = 1f;
                fadeTimer.stop();
            }
            repaint();
        });
        fadeTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        super.paintComponent(g2d);
        g2d.dispose();
    }
}

class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint gp = new GradientPaint(
            0, 0, new Color(65, 131, 215),
            0, getHeight(), new Color(41, 128, 185)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
