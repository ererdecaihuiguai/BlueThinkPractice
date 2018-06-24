import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo extends JFrame {
    private final Color colorValues[] = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
    private JRadioButtonMenuItem colorItems[], fonts[];
    private JCheckBoxMenuItem styleItems[];
    private JLabel displayeLabel;
    private ButtonGroup fontGroup, colorGroup;
    private int style;

    public MenuDemo(String title) {
        super(title);
        JMenu fileMenu = new JMenu("File");
        //设置快捷键
        fileMenu.setMnemonic('F');

        JMenuItem aboutItem = new JMenuItem("About…");
        aboutItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示一个消息对话框
                JOptionPane.showMessageDialog(MenuDemo.this,"本例子用于演示菜单的用法","About",JOptionPane.PLAIN_MESSAGE);
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener((param)->System.exit(0));

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);

        JMenu formatMenu = new JMenu("Format");
        formatMenu.setMnemonic('r');
        String colors[]={"Black","Blue","Red","Green"};
        JMenu colorMenu = new JMenu("color");
        colorMenu.setMnemonic('C');

        colorItems = new JRadioButtonMenuItem[colors.length];
        colorGroup = new ButtonGroup();
        //ItemHandler itemHandler = new ItemHandler();
    }
}
