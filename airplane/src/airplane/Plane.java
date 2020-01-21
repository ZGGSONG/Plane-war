package airplane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plane {
//      �ɻ����������
	int num = new Random().nextInt(6) + 3;
//		�ɻ��Ĵ�С
	int len = 150;
//		�ɻ�������
	int planeX[] = new int[num];
//		�ɻ�������
	int planeY[] = new int[num];
//      �ɻ����ٶ�
	int speed[] = new int[num];
//      boss�ɻ����������
	int num1 = new Random().nextInt(2) + 2;
//		boss�ɻ��Ĵ�С
	int len1 = 180;
//		boss�ɻ��ĺ�����
	int planeX1[] = new int[num1];
//		boss�ɻ���������
	int planeY1[] = new int[num1];
//      boss�ɻ����ٶ�
	int speed1[] = new int[num1];
//		��Ļ�Ĵ�С
	int jfw = 650;
	int jfh = 1000;

	{

//		��ʼ���ɻ��ĸ�������
		for (int i = 0; i < num; i++) {
//		��������� ������̶�
			planeX[i] = new Random().nextInt(jfw - 100);
//		������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
			planeY[i] = -50;
//		���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��5֮��
			speed[i] = new Random().nextInt(4) + 1;
		}

	}

	{

//			��ʼ��boss�ɻ��ĸ�������
		for (int i = 0; i < num1; i++) {
//			��������� ������̶�
			planeX1[i] = new Random().nextInt(jfw - 150);
//			������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
			planeY1[i] = -80;
//			���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��4֮��
			speed1[i] = new Random().nextInt(3) + 1;
		}

	}

	public void print() {
//	1 �����������
		JFrame jf = new JFrame("�ɻ���ս");
//	2 ��ȡ����
		Container c = jf.getContentPane();
//	3 ������� �˴�ֻ��Ҫ�����������
		class PlanePainter extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
//	 ��������

//	  �����ɻ�
				for (int i = 0; i < num; i++) {
					g.drawImage(new ImageIcon("./image/��ͨ�л�.png").getImage(), planeX[i], planeY[i], len, len, null);
				}
//	����boss�ɻ�
				for (int i = 0; i < num1; i++) {
					g.drawImage(new ImageIcon("./image/�з�boss.png").getImage(), planeX1[i], planeY1[i], len1, len1, null);
				}
			}
		}
//		���������������
		PlanePainter sp = new PlanePainter();
		sp.setBackground(Color.pink);

//	4 ������
		c.add(sp);
//	6 ���ô�������
		jf.setVisible(true);
		jf.setSize(jfw, jfh);
		jf.setLocation(30, 50);// �������Ͻǵ�λ��
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//	�����߳� �ı�ͼƬλ�� ˢ��ͼƬ ʵ�ֶ�̬Ч��

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean t = true;
				while (t) {
//		�ı�λ��
					for (int i = 0; i < num; i++) {
						planeY[i] += speed[i];

						if (planeY[i] > jfh) {
//      ����ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������
							planeY[i] = -50;
//      �ɻ���ȥ�����´����µĺ�����λ��							
							planeX[i] = new Random().nextInt(jfw);
//		�ɻ���ȥ���ٶ�Ҳ���
							speed[i] = new Random().nextInt(4) + 1;
						}
					}

//					�߳����� 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					ͼƬ�ػ�
					sp.repaint();

				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean m = true;
				while (m) {
//		�ı�λ��
					for (int i = 0; i < num1; i++) {
						planeY1[i] += speed1[i];

						if (planeY1[i] > jfh) {
//      ���boss�ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������
							planeY1[i] = -80;
//      boss�ɻ���ȥ�����´����µĺ�����λ��							
							planeX1[i] = new Random().nextInt(jfw);
//		boss�ɻ���ȥ���ٶ�Ҳ���
							speed1[i] = new Random().nextInt(3) + 1;
						}
					}

//					�߳����� 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					ͼƬ�ػ�
					sp.repaint();
				}

			}
		}).start();

	}
	public static void main(String[] args) {
		Plane z = new Plane();
		z.print();
	}

}