package ihc03;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Interfaz02 extends JFrame implements ItemListener {

    JPanel p1, p2;
    JComboBox mesC;
    JComboBox year;
    int dias[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String semanas[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    String mes[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public Interfaz02(String title) {
        super();
        this.setTitle(title);
        p1 = new JPanel();
        mesC = new JComboBox();
        for (int i = 0; i < mes.length; i++) {
            mesC.addItem(mes[i]);
        }
        mesC.addItemListener(this);
        year = new JComboBox();
        for (int i = 1980; i <= 2099; i++) {
            year.addItem(i);
        }
        year.addItemListener(this);
        p1.add(mesC);
        p1.add(year);
        p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 7, 5, 5));
        Date date = new Date();
        this.drawCalendar(mes[date.getMonth()], (1900 + date.getYear()));
        year.setSelectedItem((1900 + date.getYear()));
        mesC.setSelectedItem(mes[date.getMonth()]);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        this.add(p1);
        this.add(p2);
        this.setVisible(true);
        this.setBounds(200, 200, 350, 300);
        this.setSize(230, 220);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            drawCalendar((String) mesC.getSelectedItem(), (Integer) year.getSelectedItem());
        }
    }

    public void drawCalendar(String inputMonth, int inputYear) {
        p2.removeAll();
        for (int i = 0; i < semanas.length; i++) {
            JLabel label = new JLabel(semanas[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            p2.add(label);
        }
        Date date = new Date("01-" + inputMonth + "-" + inputYear);
        int noOfDaysInMonth = dias[date.getMonth()];
        if (date.getYear() % 4 == 0 && date.getMonth() == 1) {
            noOfDaysInMonth = 29;
        }

        for (int i = 1, day = 1; day <= noOfDaysInMonth; i++) {
            for (int j = 0; j < 7; j++) {
                if (day == 1) {
                    if (j == date.getDay()) {
                        JLabel label = new JLabel(String.valueOf(day));
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                        p2.add(label);
                        day++;
                    } else {
                        JLabel label = new JLabel("");
                        p2.add(label);
                    }
                } else {
                    JLabel label = new JLabel(String.valueOf(day));
                    label.setHorizontalAlignment(SwingConstants.RIGHT);
                    p2.add(label);
                    day++;
                }
                if (day > noOfDaysInMonth) {
                    break;
                }
            }
        }
        p2.validate();
        setTitle(inputMonth + ", " + inputYear);
    }

    public static void main(String[] args) {
        Interfaz02 ventana = new Interfaz02("Calendar");
    }

}
