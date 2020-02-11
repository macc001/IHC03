package ihc03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Interfaz01 extends JFrame {

    private JPanel contentPane;
    private JTextField txtCajaDeTexto;
    static Interfaz01 frame;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new Interfaz01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz01() {
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

        textArea();
        contra();
        incrementador();
        separador();

    }

    private void ventana(String titulo) {
        this.setTitle(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 200, 458, 363);
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

    private void textArea() {
        JTextArea txtrAreaDeTexto = new JTextArea();
        txtrAreaDeTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtrAreaDeTexto.setRows(3);
        txtrAreaDeTexto.setText("Arearnderntexto.");
        txtrAreaDeTexto.setBounds(224, 11, 205, 58);
        contentPane.add(txtrAreaDeTexto);
    }

    private void incrementador() {
        JSpinner spinner = new JSpinner();
        spinner.setBounds(224, 111, 101, 20);
        contentPane.add(spinner);
    }

    private void contra() {
        passwordField = new JPasswordField();
        passwordField.setBounds(224, 80, 152, 20);
        passwordField.setText("Contraseña");
        contentPane.add(passwordField);
    }

    private void separador() {
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(211, 11, 2, 297);
        contentPane.add(separator);
    }
}
