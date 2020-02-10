package ihc03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Principal extends JFrame {

    private JPanel contentPane;
    private JTextField txtCajaDeTexto;
    static Principal frame;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Principal() {
        ventana("Ventana principal");
        etiqueta("componentes");
        input("texto");
        String elementos[] = {"Seleccione", "Elemento 1", "Elemento 2", "Elemento 3"};
        combo(elementos);
        boton("click", "Mensaje");
        btnRadios("Radio Button1", 10, 151, 109, 23);
        btnRadios("Radio Button2", 10, 177, 109, 23);

        checkB("Check1", 10, 203, 166, 23);
        checkB("Check2", 10, 229, 152, 23);


        // el área de texto
        JTextArea txtrAreaDeTexto = new JTextArea();
        // con una linea en el borde
        txtrAreaDeTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
        // tres lineas de texto permitidas
        txtrAreaDeTexto.setRows(3);
        // el texto
        txtrAreaDeTexto.setText("Arearnderntexto.");
        txtrAreaDeTexto.setBounds(224, 11, 205, 58);
        contentPane.add(txtrAreaDeTexto);

        // el texto de contrasela
        passwordField = new JPasswordField();
        passwordField.setBounds(224, 80, 152, 20);
        // contraseña inicial
        passwordField.setText("supercontraseña");
        contentPane.add(passwordField);

        // el llamado 'hilandero'
        JSpinner spinner = new JSpinner();
        spinner.setBounds(224, 111, 101, 20);
        contentPane.add(spinner);

      

        // el separador
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(211, 11, 2, 297);
        contentPane.add(separator);

        // inicializacion de la barra de progreso,
        // la barra de desplazamiento y el deslizador.
        // los he puesto aquí juntos porque los uso
        // después y era necesario.
        final JProgressBar progressBar = new JProgressBar();
        final JScrollBar scrollBar = new JScrollBar();
        final JSlider slider = new JSlider();

        // configuraciones de la barra de progreso
        progressBar.setValue(50);
        progressBar.setBounds(224, 203, 205, 14);
        contentPane.add(progressBar);

        // la barra de desplazamiento
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent arg0) {
                // mueve a la vez la barra de progreso y el deslizador 
                progressBar.setValue(scrollBar.getValue());
                slider.setValue(scrollBar.getValue());
            }
        });
        // valor inicial
        scrollBar.setValue(50);
        scrollBar.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar.setBounds(224, 233, 205, 23);
        contentPane.add(scrollBar);

        // el deslizador, capturando evento
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                // mueve la barra de progreso y la de desplazamiento
                // cada vez que se mueve el deslizador.
                progressBar.setValue(slider.getValue());
                scrollBar.setValue(slider.getValue());
            }
        });
        // valores para que salga la regla numerada
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setToolTipText("");
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(224, 267, 200, 52);
        contentPane.add(slider);

    }

    private void ventana(String titulo) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 200, 458, 363);
        contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void etiqueta(String componentes) {
        JLabel lblEtiqueta = new JLabel(componentes);
        lblEtiqueta.setBounds(10, 11, 500, 14);
        contentPane.add(lblEtiqueta);
    }

    private void input(String texto) {
        txtCajaDeTexto = new JTextField();
        txtCajaDeTexto.setText(texto);
        txtCajaDeTexto.setBounds(30, 36, 152, 20);
        contentPane.add(txtCajaDeTexto);
        txtCajaDeTexto.setColumns(10);
    }

    private void combo(String[] elementos) {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(elementos));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(10, 67, 191, 20);
        contentPane.add(comboBox);
    }

    private void boton(String click, String mensaje) {
        JButton btnBotn = new JButton(click);
        btnBotn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(frame, mensaje);
            }
        });
        btnBotn.setBounds(53, 95, 89, 23);
        contentPane.add(btnBotn);
    }

    private void btnRadios(String texto, int x, int y, int ancho, int alto) {
        JRadioButton rdbtn1 = new JRadioButton(texto);
        rdbtn1.setBounds(x, y, ancho, alto);
        contentPane.add(rdbtn1);
    }

    private void checkB(String texto, int x, int y, int ancho, int alto) {
        JCheckBox chckbx1 = new JCheckBox(texto);
        chckbx1.setBounds(x, y, ancho, alto);
        contentPane.add(chckbx1);
    }
}
