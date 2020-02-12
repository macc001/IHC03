package ihc03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
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
        ventana("Formulario Interfaz01", 300, 200, 458, 363);
        etiqueta("Introducir nombre", 10, 11, 500, 14);
        input("Juan", 30, 36, 152, 20);
        String elementos[] = {"Seleccio sexo", "Musciliton", "Femenino", "Otro"};
        combo(elementos, 10, 67, 191, 20);

        ButtonGroup bgroup = new ButtonGroup();
        etiqueta("Elejir Departamento", 10, 100, 500, 14);
        btnRadios("Santa Cruz", bgroup, 10, 120, 109, 23);
        btnRadios("Tarija", bgroup, 10, 145, 109, 23);

        checkB("Recordar contrtaseña", 10, 170, 152, 23);

        textArea("comentario", 224, 11, 205, 58);
        contra("Contraseña", 224, 80, 152, 20);
        boton("Guardar", "Guardado Exitosamente", 50, 200, 89, 23);

        incrementador(224, 111, 101, 20);
        separador(211, 11, 2, 297);

    }

    private void ventana(String titulo, int x, int y, int ancho, int alto) {
        this.setTitle(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(x, y, ancho, alto);
        contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void etiqueta(String componentes, int x, int y, int ancho, int alto) {
        JLabel lblEtiqueta = new JLabel(componentes);
        lblEtiqueta.setBounds(x, y, ancho, alto);
        contentPane.add(lblEtiqueta);
    }

    private void input(String texto, int x, int y, int ancho, int alto) {
        txtCajaDeTexto = new JTextField();
        txtCajaDeTexto.setText(texto);
        txtCajaDeTexto.setBounds(x, y, ancho, alto);
        contentPane.add(txtCajaDeTexto);
        txtCajaDeTexto.setColumns(10);
    }

    private void combo(String[] elementos, int x, int y, int ancho, int alto) {
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(elementos));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(x, y, ancho, alto);
        contentPane.add(comboBox);
    }

    private void boton(String click, String mensaje, int x, int y, int ancho, int alto) {
        JButton btnBotn = new JButton(click);
        btnBotn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(frame, mensaje);
            }
        });
        btnBotn.setBounds(x, y, ancho, alto);
        contentPane.add(btnBotn);
    }

    private void btnRadios(String texto, ButtonGroup bgroup, int x, int y, int ancho, int alto) {
        JRadioButton rdbtn1 = new JRadioButton(texto);
        rdbtn1.setBounds(x, y, ancho, alto);
        contentPane.add(rdbtn1);
        bgroup.add(rdbtn1);
    }

    private void checkB(String texto, int x, int y, int ancho, int alto) {
        JCheckBox chckbx1 = new JCheckBox(texto);
        chckbx1.setBounds(x, y, ancho, alto);
        contentPane.add(chckbx1);
    }

    private void textArea(String texto, int x, int y, int ancho, int alto) {
        JTextArea txtrAreaDeTexto = new JTextArea();
        txtrAreaDeTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtrAreaDeTexto.setRows(3);
        txtrAreaDeTexto.setText(texto);
        txtrAreaDeTexto.setBounds(x, y, ancho, alto);
        contentPane.add(txtrAreaDeTexto);
    }

    private void contra(String texto, int x, int y, int ancho, int alto) {
        passwordField = new JPasswordField();
        passwordField.setBounds(x, y, ancho, alto);
        passwordField.setText(texto);
        contentPane.add(passwordField);
    }

    private void incrementador(int x, int y, int ancho, int alto) {
        JSpinner spinner = new JSpinner();
        spinner.setBounds(x, y, ancho, alto);
        contentPane.add(spinner);
    }

    private void separador(int x, int y, int ancho, int alto) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(x, y, ancho, alto);
        contentPane.add(separator);
    }
}
