package DZ_8_fin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static DZ_8_fin.logics.start;

class MyWindow extends JFrame {
    private JLabel Label_result;
    private JButton btn_exit;
    private JPanel content;
    private buffer_class bufferClass;

    public MyWindow() {
        content = new JPanel();
        content.setLayout(null);
        // GridLayout gl = new GridLayout(3, 1);
        // content.setLayout(gl);
        setBounds(400, 400, 500, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("guess the number");
        Dimension labelSize = new Dimension(80, 80);
        Font font = new Font("Verdana", Font.BOLD, 24);
        JLabel Label_info = new JLabel("Выберите число от 0 до 9");
        Label_info.setBounds(85, 25, 385, 30);
        Label_info.setPreferredSize(labelSize);
        Label_info.setFont(font);
        content.add(Label_info);

        JButton[] jbs = new JButton[10];
        for (int i = 0; i < 10; i++) {
            jbs[i] = new JButton("" + i);
            jbs[i].setBounds(3+50*i, 80, 45, 45);
            content.add(jbs[i]);
            Mouse m = new Mouse();
            jbs[i].addMouseListener(m);
        }


        Label_result = new JLabel("Some Text");
        Label_result.setBounds(5, 155, 490, 50);
        Label_result.setPreferredSize(labelSize);
        Label_result.setFont(font);
        content.add(Label_result);

        btn_exit = new JButton("Выход");
        btn_exit.setBounds(45, 325, 200, 30);



        content.add(btn_exit);
        content.add(Label_result);

        setContentPane(content);




        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bufferClass = new buffer_class(this);
    }

    public void setTextInToLabel(String text) {
        this.Label_result.setText(text);
    }

    public static void main(String[] args) {
        start();
        MyWindow my_win = null;
        my_win = new MyWindow();
        my_win.setVisible(true);
    }
}