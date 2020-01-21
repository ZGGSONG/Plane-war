package airplane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plane {
//      飞机的数量随机
	int num = new Random().nextInt(6) + 3;
//		飞机的大小
	int len = 150;
//		飞机的坐标
	int planeX[] = new int[num];
//		飞机的坐标
	int planeY[] = new int[num];
//      飞机的速度
	int speed[] = new int[num];
//      boss飞机的数量随机
	int num1 = new Random().nextInt(2) + 2;
//		boss飞机的大小
	int len1 = 180;
//		boss飞机的横坐标
	int planeX1[] = new int[num1];
//		boss飞机的纵坐标
	int planeY1[] = new int[num1];
//      boss飞机的速度
	int speed1[] = new int[num1];
//		屏幕的大小
	int jfw = 650;
	int jfh = 1000;

	{

//		初始化飞机的各个属性
		for (int i = 0; i < num; i++) {
//		横坐标随机 纵坐标固定
			planeX[i] = new Random().nextInt(jfw - 100);
//		纵坐标为负 创造出平滑飞出的结果而不是突然出现
			planeY[i] = -50;
//		设置不同种速度的飞机以增加难度  速度在1到5之间
			speed[i] = new Random().nextInt(4) + 1;
		}

	}

	{

//			初始化boss飞机的各个属性
		for (int i = 0; i < num1; i++) {
//			横坐标随机 纵坐标固定
			planeX1[i] = new Random().nextInt(jfw - 150);
//			纵坐标为负 创造出平滑飞出的结果而不是突然出现
			planeY1[i] = -80;
//			设置不同种速度的飞机以增加难度  速度在1到4之间
			speed1[i] = new Random().nextInt(3) + 1;
		}

	}

	public void print() {
//	1 创建窗体对象
		JFrame jf = new JFrame("飞机大战");
//	2 获取容器
		Container c = jf.getContentPane();
//	3 创建组件 此处只需要创建画板组件
		class PlanePainter extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
//	 画出背景

//	  画出飞机
				for (int i = 0; i < num; i++) {
					g.drawImage(new ImageIcon("./image/普通敌机.png").getImage(), planeX[i], planeY[i], len, len, null);
				}
//	画出boss飞机
				for (int i = 0; i < num1; i++) {
					g.drawImage(new ImageIcon("./image/敌方boss.png").getImage(), planeX1[i], planeY1[i], len1, len1, null);
				}
			}
		}
//		创建画板组件对象
		PlanePainter sp = new PlanePainter();
		sp.setBackground(Color.pink);

//	4 添加组件
		c.add(sp);
//	6 设置窗体属性
		jf.setVisible(true);
		jf.setSize(jfw, jfh);
		jf.setLocation(30, 50);// 窗体左上角的位置
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//	创建线程 改变图片位置 刷新图片 实现动态效果

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean t = true;
				while (t) {
//		改变位置
					for (int i = 0; i < num; i++) {
						planeY[i] += speed[i];

						if (planeY[i] > jfh) {
//      如果飞机超出最下面的窗体，就把飞机送回窗体最上面
							planeY[i] = -50;
//      飞机回去后，重新创建新的横坐标位置							
							planeX[i] = new Random().nextInt(jfw);
//		飞机回去后速度也随机
							speed[i] = new Random().nextInt(4) + 1;
						}
					}

//					线程休眠 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					图片重绘
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
//		改变位置
					for (int i = 0; i < num1; i++) {
						planeY1[i] += speed1[i];

						if (planeY1[i] > jfh) {
//      如果boss飞机超出最下面的窗体，就把飞机送回窗体最上面
							planeY1[i] = -80;
//      boss飞机回去后，重新创建新的横坐标位置							
							planeX1[i] = new Random().nextInt(jfw);
//		boss飞机回去后速度也随机
							speed1[i] = new Random().nextInt(3) + 1;
						}
					}

//					线程休眠 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					图片重绘
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