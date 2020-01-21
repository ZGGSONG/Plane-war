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
 * 游戏结束类
 */
public class Exit {
	public void print() {
	// 创建窗体
			JFrame jf = new JFrame("飞机大战小游戏");
	// 获取容器
			Container c = jf.getContentPane();
			//			创建画板组件
			class A extends JPanel {
				@Override
				public void paint(Graphics g) {
					// TODO 自动生成的方法存根
					super.paint(g);
					//			调用结束游戏的图片，并在画板上显示各类文字信息
					g.drawImage(new ImageIcon("./image/end.png").getImage(), 0, 0, 650, 960, null);
					g.setColor(Color.BLACK);
					g.setFont(new Font("华文行楷",80,80));
					g.drawString("游戏结束", 160, 700);
					g.setColor(Color.red);
					g.setFont(new Font("小豆岛默陌纸鸢草书简",40,40));
					g.drawString("点击任意位置结束", 80, 850);
				}
			}
			//		创建鼠标监听者
			class Mouse implements MouseListener{

				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO 自动生成的方法存根
					//		鼠标点击则退出
					System.exit(0);
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
			//		绑定窗体和监听者
			jf.addMouseListener(new Mouse());
			//		创建画板对象
			A sp = new A();
			//		将画板添加到窗体容器中
			c.add(sp);
			//		设置窗体属性
			jf.setVisible(true);
			jf.setResizable(false);
			jf.setLocation(800, 20);
			jf.setSize(650, 1000);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}