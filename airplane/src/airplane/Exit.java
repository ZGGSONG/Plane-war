package airplane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ��Ϸ������
 */
public class Exit {
	public void print() {
	// ��������
			JFrame jf = new JFrame("�ɻ���սС��Ϸ");
	// ��ȡ����
			Container c = jf.getContentPane();
			//			�����������
			class A extends JPanel {
				@Override
				public void paint(Graphics g) {
					// TODO �Զ����ɵķ������
					super.paint(g);
					//			���ý�����Ϸ��ͼƬ�����ڻ�������ʾ����������Ϣ
					g.drawImage(new ImageIcon("./image/end.png").getImage(), 0, 0, 650, 960, null);
					g.setColor(Color.BLACK);
					g.setFont(new Font("�����п�",80,80));
					g.drawString("��Ϸ����", 160, 700);
					g.setColor(Color.red);
					g.setFont(new Font("С����Ĭİֽ�����",40,40));
					g.drawString("�������λ�ý���", 80, 850);
				}
			}
			//		������������
			class Mouse implements MouseListener{

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO �Զ����ɵķ������
					//		��������˳�
					System.exit(0);
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
			//		�󶨴���ͼ�����
			jf.addMouseListener(new Mouse());
			//		�����������
			A sp = new A();
			//		��������ӵ�����������
			c.add(sp);
			//		���ô�������
			jf.setVisible(true);
			jf.setResizable(false);
			jf.setLocation(800, 20);
			jf.setSize(650, 1000);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}