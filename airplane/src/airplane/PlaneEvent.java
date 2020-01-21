package airplane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlaneEvent {
//	定义窗体的大小
	int JFW = 650;
	int JFH = 1000;
//	定义窗体位置
	int LX = 800;
	int LY = 20;
//	定义获取到的鼠标初始位置
	int mouseX = 0;
	int mouseY = 0;
//	定义我方飞机大小
	int LEN = 110;
//	定义我方飞机初始位置
	int CX = 150;
	int CY = 600;
//	定义子弹数量
	int num = 8;
//	定义子弹的大小
	int BL = 25;
//	定义子弹初始位置
	int BLX[] = new int[num];
	int BLY[] = new int[num];
//	初始化子弹的各项属性
	{
		BLX[0] = CX + 30;
		BLY[0] = CY - 40;
		for (int i = 1; i < num; i++) {
			BLX[i] = CX + 50;
			BLY[i] = BLY[i - 1] - 50;
		}
	}
/*
 * 敌方普通飞机
 */
//  飞机的数量随机
	int num1 = new Random().nextInt(6) + 3;
//	飞机的大小
	int len = 100;
//	飞机的坐标
	int planeX[] = new int[num1];
//	飞机的坐标
	int planeY[] = new int[num1];
//  飞机的速度
	int speed[] = new int[num1];
	{

//	初始化敌方飞机的各个属性
		for (int i = 0; i < num1; i++) {
//	横坐标随机 纵坐标固定
			planeX[i] = new Random().nextInt(JFW - 150);
//	纵坐标为负 创造出平滑飞出的结果而不是突然出现
			planeY[i] = -50;
//	设置不同种速度的飞机以增加难度  速度在1到5之间
			speed[i] = new Random().nextInt(4) + 2;
		}
	}
	/*
	 * 敌方boss飞机
	 */
//  boss飞机的数量随机
	int num2 = new Random().nextInt(2) + 1;
//	boss飞机的大小
	int len1 = 160;
//	boss飞机的横坐标
	int planeX1[] = new int[num2];
//	boss飞机的纵坐标
	int planeY1[] = new int[num2];
//  boss飞机的速度
	int speed1[] = new int[num2];
	{
//		初始化boss飞机的各个属性
		for (int i = 0; i < num2; i++) {
//		横坐标随机 纵坐标固定
			planeX1[i] = new Random().nextInt(JFW - 200);
//		纵坐标为负 创造出平滑飞出的结果而不是突然出现
			planeY1[i] = -80;
//		设置不同种速度的飞机以增加难度  速度在1到4之间
			speed1[i] = new Random().nextInt(3) + 2;
		}
	}
//	定义虫洞位置
	int holeX=150;
	int holeY=200;
//	定义虫洞大小
	int holeS=300;
//	虫洞开启钥匙
	boolean ishole=false;
//	定义圆虫数量
	int insectnum=10;
//	定义圆虫大小
	int insectS[]=new int [insectnum];
//	定义圆虫位置
	int insectX[]=new int [insectnum];
	int insectY[]=new int [insectnum];
//	圆虫移动方向
	int insectXDirect[]=new int [insectnum];
	int insectYDirect[]=new int [insectnum];
//	初始化圆虫属性
	{
		for(int i=0;i<insectnum;i++) {
//			圆虫移动方向参数设置
			insectXDirect[i]=1;
			insectYDirect[i]=1;
//			圆虫的随机大小
			insectS[i]=new Random().nextInt(5)+25;
//			圆虫的随机位置
			insectX[i]=holeX+holeS/2;
			insectY[i]=holeY+holeS/2;
		}
	}

//	生命值所在位置设定
	int lifeX =  JFW-140;
	int lifeY = 50;
//	设置血量
	int lifenum = 50;
	
//	定义分数并初始化
/*
 *   为什么用数组？在不同的花括号中的运算结果不能够共用，比如A线程分数在我方飞机击落敌机时变化，B线程分数没有改变，运算结果无法共用；
 *   用数组开辟一个确定的空间来存储运算结果，每次变化都存放在这个地方，要用的时候调用，可以实现运算结果的实时变化和共用，也可用指针实现。
 */
	int score[] = new int[1];
	{
		for(int s=0;s<1;s++)    //因为只需要用到一个分数，所以只开辟一个空间
			score[s]=0;
	}
	//	设置敌方普通飞机爆炸效果参数
	boolean isboom = false;
	int boomx = -100;	//爆炸位置
	int boomy = -100;	//爆炸位置
	int booms = 0;	//爆炸大小

//	设置敌方boss飞机爆炸效果参数
	boolean isboom1 = false;
	int boomx1 = -100;	//爆炸位置
	int boomy1 = -100;	//爆炸位置
	int booms1 = 0;	//爆炸大小
	
	public void print() {
//		创建退出类的对象
		Exit exit = new Exit();
//		创建爆炸声的对象
		TestMusic sound = new TestMusic("./music/BGM.wav");
		InputStream stream = new ByteArrayInputStream(sound.getSamples());
// 创建窗体
		JFrame jf = new JFrame("飞机大战小游戏");
// 获取容器
		Container c = jf.getContentPane();
//	创建画板组件
		class A extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO 自动生成的方法存根
				super.paint(g);
//	在窗体下方划出一道境界红线---敌方飞机未被击毁碰到红线则生命值减少
				g.setColor(Color.red);
				g.setFont(new Font("华文琥珀",50,50));
				g.drawString("———————————————", 0, 973);
//	画出虫洞效果图   （在下方会判断是否画出虫洞圆虫，然后对ishole进行进行改变）
				if(ishole) {
					if(ishole) {
						g.drawImage(new ImageIcon("./image/黑洞.png").getImage(), holeX, holeY,holeS,holeS,null);
//						画出一定数量的圆虫
						for(int i=0;i<insectnum;i++) {
						g.drawImage(new ImageIcon("./image/圆虫.png").getImage(),insectX[i],insectY[i],insectS[i],insectS[i],null);
						}
						}
				}
//	调用我方飞机的图片			
				g.drawImage(new ImageIcon("./image/我方飞机.png").getImage(), CX, CY, LEN, LEN, null);
//	调用子弹图片   画出一定量子弹
				for (int i = 0; i < num; i++) {
					g.drawImage(new ImageIcon("./image/子弹.png").getImage(), BLX[i], BLY[i], BL, BL, null);
				}
				
//	 画出飞机    画出一定量飞机
				for (int i = 0; i < num1; i++) {
					g.drawImage(new ImageIcon("./image/普通敌机.png").getImage(), planeX[i], planeY[i], len, len, null);
				}
//	画出boss飞机      画出一定量Boss飞机
				for (int i = 0; i < num2; i++) {
					g.drawImage(new ImageIcon("./image/敌方boss.png").getImage(), planeX1[i], planeY1[i], len1, len1,
							null);
				}
//	画出敌方普通爆炸效果图
				if(isboom) {
					g.drawImage(new ImageIcon("./image/爆炸.png").getImage(), boomx, boomy, booms, booms, null);
				}
//	画出敌方boss爆炸效果图
				if(isboom1) {
					g.drawImage(new ImageIcon("./image/爆炸.png").getImage(), boomx1, boomy1, booms1, booms1, null);
				}
				
//	在右上方注释生命值
				g.setColor(Color.BLACK);
				g.setFont(new Font("微软雅黑",18,18));
				for(int s=0;s<1;s++) {			
				g.drawString("分数:"+score[s], lifeX, lifeY+20);
				}
//	生命值颜色低于30时变成红色
				if(lifenum>=30) {
					g.setColor(Color.BLACK);		//颜色属性
					g.drawString("血量:"+lifenum, lifeX, lifeY);	//文字、位置
				}
				else {
					g.setColor(Color.RED);	//颜色属性
					g.drawString("血量:"+lifenum, lifeX, lifeY);	//文字、位置
				}
			}
		}
//	创建画板的对象
		A sp = new A();
//	创建鼠标移动监听者
		class S implements MouseMotionListener {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO 自动生成的方法存根
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
//	将获取到的鼠标位置赋值给飞机的中心位置坐标     实现飞机随着鼠标动的效果
					CX = e.getX() - LEN / 2;
					CY = e.getY() - LEN / 2;
//	重绘画板
				sp.repaint();
			}

		}
//	绑定画板和监听者
		sp.addMouseMotionListener(new S());
//	将画板添加到容器
		c.add(sp);
//	设置窗体属性
//		jf.setUndecorated(true);
		jf.setVisible(true);		//显示窗体
		jf.setResizable(false);		//窗体大小不可调
		jf.setLocation(LX, LY);		//窗体位置
		jf.setSize(JFW, JFH);		//窗体大小
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//窗体关闭则程序结束运行
/*
 * 创建子弹飞行线程
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				boolean t = true;
//	创建一个死循环，让子弹一直飞行
				while (t) {
					for (int i = 0; i < num; i++) {
//	子弹飞行速度为80（向上飞）
						BLY[i] -= 80;
//	判断子弹是否到达窗体顶端，如果是回到飞机现在为止并逐个射出
						if (BLY[i] < 0) {
							BLX[i] = CX + 40;
							BLY[i] = CY - 40*i;
						}
//	设置休眠时间
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					}
//	重绘画板
					sp.repaint();
				}
			}
		}).start();
		
/*
 * 创建敌机线程 改变图片位置 刷新图片 实现动态效果
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean t = true;
				while (t) {
/*
 * 敌方普通飞机
 */
//			改变位置
					for (int i = 0; i < num1; i++) {
						if (planeY[i] > JFH) {
							lifenum -= 1;
//	      如果飞机超出最下面的窗体，就把飞机送回窗体最上面
							planeY[i] = -100;
//	      飞机回去后，重新创建新的横坐标位置							
							planeX[i] = new Random().nextInt(JFW-150);
//			飞机回去后速度也随机
							speed[i] = new Random().nextInt(4) + 2;
						}
//		创建一个子弹撞击敌方普通飞机的计数器 b，并初始化为0
						int b=0;
						for(int j = 0 ;j < num; j++ ) {
//			三个if判断子弹是否击中敌方普通飞机
							if(((BLX[j]+BL)>=planeX[i]) && (BLX[j]<=planeX[i]) && BLY[j]<=(planeY[i]+len))  {
//			如果击中，计数器加一
								b++;
				//如果子弹打中敌机子弹消失
								BLX[j] = CX + 40;
								BLY[j] = CY - 40*j;
							}
							else if(((BLX[j]+BL)>=(planeX[i]+len)) && (BLX[j]<=(planeX[i]+len)) && BLY[j]<=(planeY[i]+len))  {
								b++;
								BLX[j] = CX + 40;
								BLY[j] = CY - 40*j;
							}
							else if(((BLX[j]+BL)<=(planeX[i]+len)) && (BLX[j]>=(planeX[i])) && BLY[j]<=(planeY[i]+len))  {
								b++;
								BLX[j] = CX + 40;
								BLY[j] = CY - 40*j;
							}
//			爆炸效果实现，判断计数器次数是否到达三次
							if(b>=3) {
//			是否爆炸
								isboom = true;
//			爆炸的位置
								boomx = planeX[i];
								boomy = planeY[i];
//			爆炸的大小和敌方普通飞机一致
								booms = len; 
							}
//			子弹击中敌方普通飞机3次及以上敌方飞机就会回到起始位置，即窗体上面不可见的位置
							if(b>=3) {
								planeY[i] = -100;
								planeX[i] = new Random().nextInt(JFW-150);
								speed[i] = new Random().nextInt(4) + 2;
//			打爆一个敌方普通飞机加一分
								for(int s=0;s<1;s++){
									score[s] +=1;
								}
//			如果爆炸则子弹遍历循环停止，否则分数会一直增加
								break;
							}
							
						}
/*
 * 敌方普通飞机与我方飞机碰撞减少生命值并且敌方普通飞机消失（三种情况的判断）
 */
//			我方飞机左端在敌机X轴范围内的碰撞
						 if(((CX+LEN)/2>=(planeX[i]/2))&&((CX/2)<=(planeX[i]/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		如果敌方普通飞机与我方飞机相撞，则生命值减一，并且敌方普通飞机回到起始随机位置
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//			我方飞机右端在敌机X轴范围内的碰撞			
						else if((CX/2<=((planeX[i]+len)/2))&&(((CX+LEN)/2)>=((planeX[i]+len)/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		如果敌方普通飞机与我方飞机相撞，则生命值减一，并且敌方普通飞机回到起始随机位置
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//			敌方飞机在我方飞机X轴范围内的碰撞（因为我方飞机模型大于地方飞机模型）			
						else if((CX/2<=(planeX[i]/2))&&(((CX+LEN)/2)>=((planeX[i]+len)/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		如果敌方普通飞机与我方飞机相撞，则生命值减一，并且敌方普通飞机回到起始随机位置
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//		普通飞机飞机向下飞行的速度
						planeY[i] += speed[i];
					}
/*
 * 敌方boss飞机		
 */
//			改变位置
					for (int i = 0; i < num2; i++) {
//	      如果boss飞机超出最下面的窗体，就把飞机送回窗体最上面						
						if (planeY1[i] > JFH) {
							lifenum -= 3;
//		boss飞机回到窗体外看不见的位置
							planeY1[i] = -150;
//	      boss飞机回去后，重新创建新的横坐标位置							
							planeX1[i] = new Random().nextInt(JFW-200);
//			boss飞机回去后速度也随机
							speed1[i] = new Random().nextInt(3) + 2;
						}
//		创建一个子弹撞击敌方普通飞机的计数器 a，并初始化为0
						int a = 0;
						for (int k = 0; k < num; k++) {
//		三种子弹撞击boss飞机的情况判断
							if((((BLX[k]+BL)>=planeX1[i]) && (BLX[k]<=planeX1[i])) && (BLY[k]<=(planeY1[i]+len1)))  {
//		若相撞，则计数器加一
								a++;
//		子弹回到飞机现在的位置
								BLX[k] = CX + 40;
								BLY[k] = CY - 40*i;
							}
							else if((((BLX[k]+BL)>=(planeX1[i]+len1)) && (BLX[k]<=(planeX1[i]+len1))) && (BLY[k]<=(planeY1[i]+len1)))  {
								a++;
								BLX[k] = CX + 40;
								BLY[k] = CY - 40*i;
							}
							else if((((BLX[k]+BL)<=(planeX1[i]+len1)) && (BLX[k]>=(planeX1[i]))) && (BLY[k]<=(planeY1[i]+len1)))  {
								a++;
								BLX[k] = CX + 40;
								BLY[k] = CY - 40*i;
							}
//			计数器到达5，爆炸效果实现
							if(a>=5) {
//			撞击判断条件设置为true
								isboom1 = true;
//			将boss飞机被击毁的位置附给爆炸图片
								boomx1 = planeX1[i];
								boomy1 = planeY1[i];
//			将boss飞机的大小附给爆炸图片
								booms1 = len1;
							}
//			boss飞机被击毁后消失(回到初始随机位置)
							if(a>=5) {
								planeY1[i] = -150;
								planeX1[i] = new Random().nextInt(JFW-200);
								speed1[i] = new Random().nextInt(3) + 2;
//			击毁一架敌方boss飞机,score分数加5分
								for(int s=0;s<1;s++) {
								score[s] +=5;
								}
//			击毁后,则停止子弹遍历,否则分数无限累计
								break;
							}
						}
				/*
				 *敌方boss飞机与我方飞机碰撞减少生命值并且敌方boss飞机消失 
				 */
//		我方飞机左端在敌方boss机X轴范围内的碰撞
						 if(((CX+LEN)/2>=(planeX1[i]/2))&&((CX/2)<=(planeX1[i]/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
//		我方飞机与敌方boss飞机相撞,则生命值减五
							 lifenum -=5;
//				判断是否爆炸
							 isboom1 = true;
//				将boss飞机被击毁的位置附给爆炸图片
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				将boss飞机的大小附给爆炸图片
							booms1 = len1;
//		敌方boss飞机回到初始随机位置
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		我方飞机右端在敌方boss机X轴范围内的碰撞
						 else if((CX/2<=((planeX1[i]+len1)/2))&&(((CX+LEN)/2)>=((planeX1[i]+len1)/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
							 lifenum -=5;
//				判断是否爆炸
							 isboom1 = true;
//				将boss飞机被击毁的位置附给爆炸图片
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				将boss飞机的大小附给爆炸图片
							booms1 = len1;
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		我方飞机在敌方boss机范围内的碰撞（敌方boss机比我方飞机大）
						 else if((CX/2>=(planeX1[i]/2))&&(((CX+LEN)/2)<=((planeX1[i]+len1)/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
							 lifenum -=5;
//				判断是否爆炸
							 isboom1 = true;
//				将boss飞机被击毁的位置附给爆炸图片
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				将boss飞机的大小附给爆炸图片
							booms1 = len1;
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		敌方boss飞机向下飞行的速度
						 planeY1[i] += speed1[i];
					}
//		如果生命值小于等于0,调出退出界面，并关闭此窗口
					if(lifenum<=0) {
						t=false;
						jf.setVisible(false);
						exit.print();
					}

//						线程休眠 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//						图片重绘
					sp.repaint();
//		将敌方普通飞机的爆炸效果清除
					isboom = false;
//		将敌方boss飞机的爆炸效果清除
					isboom1 = false;
				}

			}
		}).start();
		/*
		 * 播放背景音乐
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				while(true) {
					sound.play(stream);
				}
			}}).start();
/*
 * 虫洞线程
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
//		分数达到一定值，出现虫洞
				boolean insectT=true;
				while(insectT) {
					for(int s=0;s<1;s++) {
						score[s]=score[s];
//		当分数大于100，启动虫洞，增加游戏难度
						if(score[s]>=100)
						{
							ishole=true;
							for(int i=0;i<insectnum;i++)
							{
//		当圆虫碰到窗体，改变方向反弹回去
								if(insectX[i]>JFW) 
									insectXDirect[i]=-1;
								else if(insectX[i]<0) 
									insectXDirect[i]=1;
//		圆虫的移动速度
								insectX[i]+=(i+1)*insectXDirect[i];
//		当圆虫碰到窗体，改变方向反弹回去
								if(insectY[i]>JFH) 
									insectYDirect[i]=-1;
								else if(insectY[i]<0) 
									insectYDirect[i]=1;	
//		圆虫的移动速度
								insectY[i]+=(i+1)*insectYDirect[i];
//		判断飞机是否碰到圆虫，碰到则生命值减2，然后圆虫从窗体外的随机位置出现，划入窗体，找飞机碰瓷
								if((((insectX[i]+insectS[i])>=CX) && (insectX[i]+insectS[i]<=CX+LEN)) && ((insectY[i]+insectS[i]>=CY) && insectY[i]<=CY)) {
									lifenum-=2;
									insectX[i]=JFW+new Random().nextInt(20);
									insectY[i]=0-new Random().nextInt(20);
								}
								else if(((insectX[i]>=CX) && (insectX[i]<=CX+LEN)) && ((insectY[i]+insectS[i]>=CY)&& insectY[i]<=CY)) {
									lifenum-=2;
									insectX[i]=0-new Random().nextInt(20);
									insectY[i]=JFH;
								}
								else if((insectX[i]+insectS[i]>=CX)&&(insectX[i]+insectS[i]<=CX+LEN)&&((insectY[i]<=CY+LEN)&&(insectY[i]+insectS[i])>=CY+LEN)){
									lifenum-=2;
									insectX[i]=0-new Random().nextInt(20);
									insectY[i]=0-new Random().nextInt(20);
								}
								else if((insectX[i]>=CX)&&(insectX[i]<=CX+LEN)&&((insectY[i]<=CY+LEN)&&(insectY[i]+insectS[i])>=CY+LEN)) {
									lifenum-=2;
									insectX[i]=JFW+new Random().nextInt(20);
									insectY[i]=JFH+new Random().nextInt(20);
							}
						}
					}
//		设置休眠时间
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}sp.repaint();
					}
				}
			}}).start();	
}
}