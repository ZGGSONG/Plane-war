package airplane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��ʼ������
 */
public class Main {
	public static void main(String[] args) {
		//	����MyPlane��Ķ���
		PlaneEvent x = new PlaneEvent();
		//	��������
		JFrame jf = new JFrame("�ɻ���սС��Ϸ");
		//	��������	
		Container c = jf.getContentPane();
		//	����һ����ť
		JButton jb = new JButton("��ʼ��Ϸ");
		//	���尴ť����
		jb.setBackground(Color.GRAY);
		jb.setFont(new Font("��������", 80, 80));
		//	��������
		class A extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO �Զ����ɵķ������
				super.paint(g);
				//	���ÿ�ʼͼƬ������ӡ��Ӧ����
				g.drawImage(new ImageIcon("./image/start.jpg").getImage(), 0, 0, 650 ,960, null);
				g.setFont(new Font("���Ŀ���", 20,20));
				g.setColor(Color.BLACK);
				g.drawString("��Ϸ����:", 16, 750);
				g.drawString("С�ɻ�������3����ʧ", 16, 780);
				g.drawString("��ɻ�������5����ʧ", 16, 810);
				g.drawString("�ɻ���ײ������ֵ����-1/-5", 16, 840);
				g.drawString("δ����ɻ�������ֵ����", 16, 870);
				g.drawString("������һ��ֵ���ֳ涴��������Բ��������ֵ����", 16, 900);
			}
		}
		//	������������
		class Mouse implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
				//	���������ť����˴�����ʧ����Ϸ�����
				jf.setVisible(false);
				x.print();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO �Զ����ɵķ������	
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO �Զ����ɵķ������	
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO �Զ����ɵķ������	
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO �Զ����ɵķ������	
			}
		}
		//	�����������
		A cp = new A();
		//	�󶨰�ť����������
		jb.addMouseListener(new Mouse());
		//	�������Ϊ����һ��
		cp.setLayout(new GridLayout(5,1));
		//	���÷ֿ黭������
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		//	����ť��ӵ����Ŀ������
		jp4.add(jb);
		//	��5����嶼��ӵ�������
		cp.add(jp1);
		cp.add(jp2);
		cp.add(jp3);
		cp.add(jp4);
		cp.add(jp5);
		//	��������ӵ�����������
		c.add(cp);
		//	���ô����������
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(800, 20);
		jf.setSize(650, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
