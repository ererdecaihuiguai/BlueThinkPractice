import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

public class ManyEars extends JFrame {

    private JButton button;
    private JTextArea textArea;
    private JScrollPane panel;

    public ManyEars(String title) {
        super(title);

        button = new JButton("test");
        textArea = new JTextArea(20, 20);
        //在垂直方向总是显示滚动条，在水平方向只有当需要的时候才会显示滚动条
        panel = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //JButton注册5个ActionListener监听器
        for (int i = 0; i < 5; i++) {
            button.addActionListener(new ListenerA());

        }
    }

    //统计ListenerA的实例的数目
    private static int count;

    class ListenerA implements ActionListener {

        private int serialNumber;

        public ListenerA() {
            count++;
            serialNumber = count;
        }

        private void print(String str) {
            textArea.setText(textArea.getText() + str + "\n");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            print("ListenerA" + serialNumber + "receives ActionEvent");
        }
    }

    class ListenerB extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            //获得所有的向JButton注册的ActionListener
            ActionListener[] listeners=(ActionListener[])button.getListeners(ActionListener.class);
            //print();
            //从JButton中注销一个ActionListener
            if (listeners.length>0){
                button.removeActionListener(listeners[0]);

            }
        }
    }

    public static void main(String[] args) {
        new ManyEars("Hello");

    }
}
