package airplane;

public class Bullet {
	// 子弹个数
	int num = 10;
	// 子弹数组
	int BulletX[] = new int[num];
	int BulletY[] = new int[num];
	// 子弹位置
	int BulletLx = 240;	
	int BulletLy = 400;
	// 初始化子弹的位置
	{
		for (int i = 0; i < num; i++) {
			BulletX[i] = BulletLx;
			BulletY[i] = BulletLy - 100 * i;
		}
	}

//	public void print() {
//		// 创建窗体
//		JFrame jf = new JFrame();
//		Container c = jf.getContentPane();
//		// 画笔 子弹
//		class BulletPainter extends JPanel {
//			@Override
//			public void paint(Graphics g) {
//				// TODO Auto-generated method stub
//				super.paint(g);
//				for (i = 0; i < num; i++) {
//					g.drawImage(new ImageIcon("./image/子弹.png").getImage(), BulletX[i], BulletY[i], 50, 50, null);
//				}
//
//			}
//		}
//		// 背景板颜色设置为白色
//		BulletPainter bp = new BulletPainter();
//		bp.setBackground(Color.WHITE);
//		// 添加组件
//		c.add(bp);
//		// 设置窗体属性
//		jf.setVisible(true);
//		jf.setLocation(20, 20);
//		jf.setSize(800, 600);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// 让子弹飞
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
