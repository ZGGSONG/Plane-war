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
 * 开始界面类
 */
public class Main {
	public static void main(String[] args) {
		//	创建MyPlane类的对象
		PlaneEvent x = new PlaneEvent();
		//	创建窗体
		JFrame jf = new JFrame("飞机大战小游戏");
		//	创建容器	
		Container c = jf.getContentPane();
		//	创建一个按钮
		JButton jb = new JButton("开始游戏");
		//	定义按钮属性
		jb.setBackground(Color.GRAY);
		jb.setFont(new Font("华文隶书", 80, 80));
		//	创建画板
		class A extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO 自动生成的方法存根
				super.paint(g);
				//	调用开始图片，并打印相应文字
				g.drawImage(new ImageIcon("./image/start.jpg").getImage(), 0, 0, 650 ,960, null);
				g.setFont(new Font("华文楷体", 20,20));
				g.setColor(Color.BLACK);
				g.drawString("游戏规则:", 16, 750);
				g.drawString("小飞机被击中3次消失", 16, 780);
				g.drawString("大飞机被击中5次消失", 16, 810);
				g.drawString("飞机碰撞后生命值减少-1/-5", 16, 840);
				g.drawString("未打掉飞机则生命值减少", 16, 870);
				g.drawString("分数到一定值出现虫洞，若碰到圆虫则生命值减少", 16, 900);
			}
		}
		//	创建鼠标监听者
		class Mouse implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				//	当鼠标点击按钮，则此窗体消失，游戏窗体打开
				jf.setVisible(false);
				x.print();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根	
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根	
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根	
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根	
			}
		}
		//	创建画板对象
		A cp = new A();
		//	绑定按钮和鼠标监听者
		jb.addMouseListener(new Mouse());
		//	将画板分为五行一列
		cp.setLayout(new GridLayout(5,1));
		//	设置分块画板属性
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		//	将按钮添加到第四块面板上
		jp4.add(jb);
		//	将5块面板都添加到画板上
		cp.add(jp1);
		cp.add(jp2);
		cp.add(jp3);
		cp.add(jp4);
		cp.add(jp5);
		//	将画板添加到窗体容器内
		c.add(cp);
		//	设置窗体基本属性
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(800, 20);
		jf.setSize(650, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
