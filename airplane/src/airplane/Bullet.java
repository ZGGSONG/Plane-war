package airplane;

public class Bullet {
	// �ӵ�����
	int num = 10;
	// �ӵ�����
	int BulletX[] = new int[num];
	int BulletY[] = new int[num];
	// �ӵ�λ��
	int BulletLx = 240;	
	int BulletLy = 400;
	// ��ʼ���ӵ���λ��
	{
		for (int i = 0; i < num; i++) {
			BulletX[i] = BulletLx;
			BulletY[i] = BulletLy - 100 * i;
		}
	}

//	public void print() {
//		// ��������
//		JFrame jf = new JFrame();
//		Container c = jf.getContentPane();
//		// ���� �ӵ�
//		class BulletPainter extends JPanel {
//			@Override
//			public void paint(Graphics g) {
//				// TODO Auto-generated method stub
//				super.paint(g);
//				for (i = 0; i < num; i++) {
//					g.drawImage(new ImageIcon("./image/�ӵ�.png").getImage(), BulletX[i], BulletY[i], 50, 50, null);
//				}
//
//			}
//		}
//		// ��������ɫ����Ϊ��ɫ
//		BulletPainter bp = new BulletPainter();
//		bp.setBackground(Color.WHITE);
//		// ������
//		c.add(bp);
//		// ���ô�������
//		jf.setVisible(true);
//		jf.setLocation(20, 20);
//		jf.setSize(800, 600);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// ���ӵ���
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				boolean t = true;
//				while (t) {
//					for (i = 0; i < num; i++) {
//						BulletY[i] -= 30;
//
//						if (BulletY[i] < 0) {
//							BulletY[i] = jf.getHeight();
//
//						}
//					}
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					bp.repaint();
//				}
//			}
//		}).start();
//		
//	}
//	public static void main(String[] args) {
//		Bullet z = new Bullet();
//		z.print();
//	}
}
