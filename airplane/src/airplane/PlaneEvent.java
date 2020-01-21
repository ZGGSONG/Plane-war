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
//	���崰��Ĵ�С
	int JFW = 650;
	int JFH = 1000;
//	���崰��λ��
	int LX = 800;
	int LY = 20;
//	�����ȡ��������ʼλ��
	int mouseX = 0;
	int mouseY = 0;
//	�����ҷ��ɻ���С
	int LEN = 110;
//	�����ҷ��ɻ���ʼλ��
	int CX = 150;
	int CY = 600;
//	�����ӵ�����
	int num = 8;
//	�����ӵ��Ĵ�С
	int BL = 25;
//	�����ӵ���ʼλ��
	int BLX[] = new int[num];
	int BLY[] = new int[num];
//	��ʼ���ӵ��ĸ�������
	{
		BLX[0] = CX + 30;
		BLY[0] = CY - 40;
		for (int i = 1; i < num; i++) {
			BLX[i] = CX + 50;
			BLY[i] = BLY[i - 1] - 50;
		}
	}
/*
 * �з���ͨ�ɻ�
 */
//  �ɻ����������
	int num1 = new Random().nextInt(6) + 3;
//	�ɻ��Ĵ�С
	int len = 100;
//	�ɻ�������
	int planeX[] = new int[num1];
//	�ɻ�������
	int planeY[] = new int[num1];
//  �ɻ����ٶ�
	int speed[] = new int[num1];
	{

//	��ʼ���з��ɻ��ĸ�������
		for (int i = 0; i < num1; i++) {
//	��������� ������̶�
			planeX[i] = new Random().nextInt(JFW - 150);
//	������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
			planeY[i] = -50;
//	���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��5֮��
			speed[i] = new Random().nextInt(4) + 2;
		}
	}
	/*
	 * �з�boss�ɻ�
	 */
//  boss�ɻ����������
	int num2 = new Random().nextInt(2) + 1;
//	boss�ɻ��Ĵ�С
	int len1 = 160;
//	boss�ɻ��ĺ�����
	int planeX1[] = new int[num2];
//	boss�ɻ���������
	int planeY1[] = new int[num2];
//  boss�ɻ����ٶ�
	int speed1[] = new int[num2];
	{
//		��ʼ��boss�ɻ��ĸ�������
		for (int i = 0; i < num2; i++) {
//		��������� ������̶�
			planeX1[i] = new Random().nextInt(JFW - 200);
//		������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
			planeY1[i] = -80;
//		���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��4֮��
			speed1[i] = new Random().nextInt(3) + 2;
		}
	}
//	����涴λ��
	int holeX=150;
	int holeY=200;
//	����涴��С
	int holeS=300;
//	�涴����Կ��
	boolean ishole=false;
//	����Բ������
	int insectnum=10;
//	����Բ���С
	int insectS[]=new int [insectnum];
//	����Բ��λ��
	int insectX[]=new int [insectnum];
	int insectY[]=new int [insectnum];
//	Բ���ƶ�����
	int insectXDirect[]=new int [insectnum];
	int insectYDirect[]=new int [insectnum];
//	��ʼ��Բ������
	{
		for(int i=0;i<insectnum;i++) {
//			Բ���ƶ������������
			insectXDirect[i]=1;
			insectYDirect[i]=1;
//			Բ��������С
			insectS[i]=new Random().nextInt(5)+25;
//			Բ������λ��
			insectX[i]=holeX+holeS/2;
			insectY[i]=holeY+holeS/2;
		}
	}

//	����ֵ����λ���趨
	int lifeX =  JFW-140;
	int lifeY = 50;
//	����Ѫ��
	int lifenum = 50;
	
//	�����������ʼ��
/*
 *   Ϊʲô�����飿�ڲ�ͬ�Ļ������е����������ܹ����ã�����A�̷߳������ҷ��ɻ�����л�ʱ�仯��B�̷߳���û�иı䣬�������޷����ã�
 *   �����鿪��һ��ȷ���Ŀռ����洢��������ÿ�α仯�����������ط���Ҫ�õ�ʱ����ã�����ʵ����������ʵʱ�仯�͹��ã�Ҳ����ָ��ʵ�֡�
 */
	int score[] = new int[1];
	{
		for(int s=0;s<1;s++)    //��Ϊֻ��Ҫ�õ�һ������������ֻ����һ���ռ�
			score[s]=0;
	}
	//	���õз���ͨ�ɻ���ըЧ������
	boolean isboom = false;
	int boomx = -100;	//��ըλ��
	int boomy = -100;	//��ըλ��
	int booms = 0;	//��ը��С

//	���õз�boss�ɻ���ըЧ������
	boolean isboom1 = false;
	int boomx1 = -100;	//��ըλ��
	int boomy1 = -100;	//��ըλ��
	int booms1 = 0;	//��ը��С
	
	public void print() {
//		�����˳���Ķ���
		Exit exit = new Exit();
//		������ը���Ķ���
		TestMusic sound = new TestMusic("./music/BGM.wav");
		InputStream stream = new ByteArrayInputStream(sound.getSamples());
// ��������
		JFrame jf = new JFrame("�ɻ���սС��Ϸ");
// ��ȡ����
		Container c = jf.getContentPane();
//	�����������
		class A extends JPanel {
			@Override
			public void paint(Graphics g) {
				// TODO �Զ����ɵķ������
				super.paint(g);
//	�ڴ����·�����һ���������---�з��ɻ�δ��������������������ֵ����
				g.setColor(Color.red);
				g.setFont(new Font("��������",50,50));
				g.drawString("������������������������������", 0, 973);
//	�����涴Ч��ͼ   �����·����ж��Ƿ񻭳��涴Բ�棬Ȼ���ishole���н��иı䣩
				if(ishole) {
					if(ishole) {
						g.drawImage(new ImageIcon("./image/�ڶ�.png").getImage(), holeX, holeY,holeS,holeS,null);
//						����һ��������Բ��
						for(int i=0;i<insectnum;i++) {
						g.drawImage(new ImageIcon("./image/Բ��.png").getImage(),insectX[i],insectY[i],insectS[i],insectS[i],null);
						}
						}
				}
//	�����ҷ��ɻ���ͼƬ			
				g.drawImage(new ImageIcon("./image/�ҷ��ɻ�.png").getImage(), CX, CY, LEN, LEN, null);
//	�����ӵ�ͼƬ   ����һ�����ӵ�
				for (int i = 0; i < num; i++) {
					g.drawImage(new ImageIcon("./image/�ӵ�.png").getImage(), BLX[i], BLY[i], BL, BL, null);
				}
				
//	 �����ɻ�    ����һ�����ɻ�
				for (int i = 0; i < num1; i++) {
					g.drawImage(new ImageIcon("./image/��ͨ�л�.png").getImage(), planeX[i], planeY[i], len, len, null);
				}
//	����boss�ɻ�      ����һ����Boss�ɻ�
				for (int i = 0; i < num2; i++) {
					g.drawImage(new ImageIcon("./image/�з�boss.png").getImage(), planeX1[i], planeY1[i], len1, len1,
							null);
				}
//	�����з���ͨ��ըЧ��ͼ
				if(isboom) {
					g.drawImage(new ImageIcon("./image/��ը.png").getImage(), boomx, boomy, booms, booms, null);
				}
//	�����з�boss��ըЧ��ͼ
				if(isboom1) {
					g.drawImage(new ImageIcon("./image/��ը.png").getImage(), boomx1, boomy1, booms1, booms1, null);
				}
				
//	�����Ϸ�ע������ֵ
				g.setColor(Color.BLACK);
				g.setFont(new Font("΢���ź�",18,18));
				for(int s=0;s<1;s++) {			
				g.drawString("����:"+score[s], lifeX, lifeY+20);
				}
//	����ֵ��ɫ����30ʱ��ɺ�ɫ
				if(lifenum>=30) {
					g.setColor(Color.BLACK);		//��ɫ����
					g.drawString("Ѫ��:"+lifenum, lifeX, lifeY);	//���֡�λ��
				}
				else {
					g.setColor(Color.RED);	//��ɫ����
					g.drawString("Ѫ��:"+lifenum, lifeX, lifeY);	//���֡�λ��
				}
			}
		}
//	��������Ķ���
		A sp = new A();
//	��������ƶ�������
		class S implements MouseMotionListener {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO �Զ����ɵķ������
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
//	����ȡ�������λ�ø�ֵ���ɻ�������λ������     ʵ�ַɻ�������궯��Ч��
					CX = e.getX() - LEN / 2;
					CY = e.getY() - LEN / 2;
//	�ػ滭��
				sp.repaint();
			}

		}
//	�󶨻���ͼ�����
		sp.addMouseMotionListener(new S());
//	��������ӵ�����
		c.add(sp);
//	���ô�������
//		jf.setUndecorated(true);
		jf.setVisible(true);		//��ʾ����
		jf.setResizable(false);		//�����С���ɵ�
		jf.setLocation(LX, LY);		//����λ��
		jf.setSize(JFW, JFH);		//�����С
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//����ر�������������
/*
 * �����ӵ������߳�
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				boolean t = true;
//	����һ����ѭ�������ӵ�һֱ����
				while (t) {
					for (int i = 0; i < num; i++) {
//	�ӵ������ٶ�Ϊ80�����Ϸɣ�
						BLY[i] -= 80;
//	�ж��ӵ��Ƿ񵽴ﴰ�嶥�ˣ�����ǻص��ɻ�����Ϊֹ��������
						if (BLY[i] < 0) {
							BLX[i] = CX + 40;
							BLY[i] = CY - 40*i;
						}
//	��������ʱ��
						try {
							Thread.sleep(3);
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
						
					}
//	�ػ滭��
					sp.repaint();
				}
			}
		}).start();
		
/*
 * �����л��߳� �ı�ͼƬλ�� ˢ��ͼƬ ʵ�ֶ�̬Ч��
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean t = true;
				while (t) {
/*
 * �з���ͨ�ɻ�
 */
//			�ı�λ��
					for (int i = 0; i < num1; i++) {
						if (planeY[i] > JFH) {
							lifenum -= 1;
//	      ����ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������
							planeY[i] = -100;
//	      �ɻ���ȥ�����´����µĺ�����λ��							
							planeX[i] = new Random().nextInt(JFW-150);
//			�ɻ���ȥ���ٶ�Ҳ���
							speed[i] = new Random().nextInt(4) + 2;
						}
//		����һ���ӵ�ײ���з���ͨ�ɻ��ļ����� b������ʼ��Ϊ0
						int b=0;
						for(int j = 0 ;j < num; j++ ) {
//			����if�ж��ӵ��Ƿ���ез���ͨ�ɻ�
							if(((BLX[j]+BL)>=planeX[i]) && (BLX[j]<=planeX[i]) && BLY[j]<=(planeY[i]+len))  {
//			������У���������һ
								b++;
				//����ӵ����ел��ӵ���ʧ
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
//			��ըЧ��ʵ�֣��жϼ����������Ƿ񵽴�����
							if(b>=3) {
//			�Ƿ�ը
								isboom = true;
//			��ը��λ��
								boomx = planeX[i];
								boomy = planeY[i];
//			��ը�Ĵ�С�͵з���ͨ�ɻ�һ��
								booms = len; 
							}
//			�ӵ����ез���ͨ�ɻ�3�μ����ϵз��ɻ��ͻ�ص���ʼλ�ã����������治�ɼ���λ��
							if(b>=3) {
								planeY[i] = -100;
								planeX[i] = new Random().nextInt(JFW-150);
								speed[i] = new Random().nextInt(4) + 2;
//			��һ���з���ͨ�ɻ���һ��
								for(int s=0;s<1;s++){
									score[s] +=1;
								}
//			�����ը���ӵ�����ѭ��ֹͣ�����������һֱ����
								break;
							}
							
						}
/*
 * �з���ͨ�ɻ����ҷ��ɻ���ײ��������ֵ���ҵз���ͨ�ɻ���ʧ������������жϣ�
 */
//			�ҷ��ɻ�����ڵл�X�᷶Χ�ڵ���ײ
						 if(((CX+LEN)/2>=(planeX[i]/2))&&((CX/2)<=(planeX[i]/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		����з���ͨ�ɻ����ҷ��ɻ���ײ��������ֵ��һ�����ҵз���ͨ�ɻ��ص���ʼ���λ��
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//			�ҷ��ɻ��Ҷ��ڵл�X�᷶Χ�ڵ���ײ			
						else if((CX/2<=((planeX[i]+len)/2))&&(((CX+LEN)/2)>=((planeX[i]+len)/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		����з���ͨ�ɻ����ҷ��ɻ���ײ��������ֵ��һ�����ҵз���ͨ�ɻ��ص���ʼ���λ��
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//			�з��ɻ����ҷ��ɻ�X�᷶Χ�ڵ���ײ����Ϊ�ҷ��ɻ�ģ�ʹ��ڵط��ɻ�ģ�ͣ�			
						else if((CX/2<=(planeX[i]/2))&&(((CX+LEN)/2)>=((planeX[i]+len)/2)) && (((CY/2)<=((planeY[i]+len)/2))&&(CY+LEN)/2>=(planeY[i]/2))) {
//		����з���ͨ�ɻ����ҷ��ɻ���ײ��������ֵ��һ�����ҵз���ͨ�ɻ��ص���ʼ���λ��
							lifenum -=1;
							isboom = true;
							boomx = planeX[i];
							boomy = planeY[i];
							booms = len; 
							planeY[i] = -100;
							planeX[i] = new Random().nextInt(JFW-150);
							speed[i] = new Random().nextInt(4) + 2;
							
						}
//		��ͨ�ɻ��ɻ����·��е��ٶ�
						planeY[i] += speed[i];
					}
/*
 * �з�boss�ɻ�		
 */
//			�ı�λ��
					for (int i = 0; i < num2; i++) {
//	      ���boss�ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������						
						if (planeY1[i] > JFH) {
							lifenum -= 3;
//		boss�ɻ��ص������⿴������λ��
							planeY1[i] = -150;
//	      boss�ɻ���ȥ�����´����µĺ�����λ��							
							planeX1[i] = new Random().nextInt(JFW-200);
//			boss�ɻ���ȥ���ٶ�Ҳ���
							speed1[i] = new Random().nextInt(3) + 2;
						}
//		����һ���ӵ�ײ���з���ͨ�ɻ��ļ����� a������ʼ��Ϊ0
						int a = 0;
						for (int k = 0; k < num; k++) {
//		�����ӵ�ײ��boss�ɻ�������ж�
							if((((BLX[k]+BL)>=planeX1[i]) && (BLX[k]<=planeX1[i])) && (BLY[k]<=(planeY1[i]+len1)))  {
//		����ײ�����������һ
								a++;
//		�ӵ��ص��ɻ����ڵ�λ��
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
//			����������5����ըЧ��ʵ��
							if(a>=5) {
//			ײ���ж���������Ϊtrue
								isboom1 = true;
//			��boss�ɻ������ٵ�λ�ø�����ըͼƬ
								boomx1 = planeX1[i];
								boomy1 = planeY1[i];
//			��boss�ɻ��Ĵ�С������ըͼƬ
								booms1 = len1;
							}
//			boss�ɻ������ٺ���ʧ(�ص���ʼ���λ��)
							if(a>=5) {
								planeY1[i] = -150;
								planeX1[i] = new Random().nextInt(JFW-200);
								speed1[i] = new Random().nextInt(3) + 2;
//			����һ�ܵз�boss�ɻ�,score������5��
								for(int s=0;s<1;s++) {
								score[s] +=5;
								}
//			���ٺ�,��ֹͣ�ӵ�����,������������ۼ�
								break;
							}
						}
				/*
				 *�з�boss�ɻ����ҷ��ɻ���ײ��������ֵ���ҵз�boss�ɻ���ʧ 
				 */
//		�ҷ��ɻ�����ڵз�boss��X�᷶Χ�ڵ���ײ
						 if(((CX+LEN)/2>=(planeX1[i]/2))&&((CX/2)<=(planeX1[i]/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
//		�ҷ��ɻ���з�boss�ɻ���ײ,������ֵ����
							 lifenum -=5;
//				�ж��Ƿ�ը
							 isboom1 = true;
//				��boss�ɻ������ٵ�λ�ø�����ըͼƬ
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				��boss�ɻ��Ĵ�С������ըͼƬ
							booms1 = len1;
//		�з�boss�ɻ��ص���ʼ���λ��
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		�ҷ��ɻ��Ҷ��ڵз�boss��X�᷶Χ�ڵ���ײ
						 else if((CX/2<=((planeX1[i]+len1)/2))&&(((CX+LEN)/2)>=((planeX1[i]+len1)/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
							 lifenum -=5;
//				�ж��Ƿ�ը
							 isboom1 = true;
//				��boss�ɻ������ٵ�λ�ø�����ըͼƬ
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				��boss�ɻ��Ĵ�С������ըͼƬ
							booms1 = len1;
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		�ҷ��ɻ��ڵз�boss����Χ�ڵ���ײ���з�boss�����ҷ��ɻ���
						 else if((CX/2>=(planeX1[i]/2))&&(((CX+LEN)/2)<=((planeX1[i]+len1)/2)) && (((CY/2)<=((planeY1[i]+len1)/2))&&(CY+LEN)/2>=(planeY1[i]/2))) {
							 lifenum -=5;
//				�ж��Ƿ�ը
							 isboom1 = true;
//				��boss�ɻ������ٵ�λ�ø�����ըͼƬ
							boomx1 = planeX1[i];
							boomy1 = planeY1[i];
//				��boss�ɻ��Ĵ�С������ըͼƬ
							booms1 = len1;
							 planeY1[i] = -150;
							 planeX1[i] = new Random().nextInt(JFW-200);
							 speed1[i] = new Random().nextInt(3)+2;
						 }
//		�з�boss�ɻ����·��е��ٶ�
						 planeY1[i] += speed1[i];
					}
//		�������ֵС�ڵ���0,�����˳����棬���رմ˴���
					if(lifenum<=0) {
						t=false;
						jf.setVisible(false);
						exit.print();
					}

//						�߳����� 
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//						ͼƬ�ػ�
					sp.repaint();
//		���з���ͨ�ɻ��ı�ըЧ�����
					isboom = false;
//		���з�boss�ɻ��ı�ըЧ�����
					isboom1 = false;
				}

			}
		}).start();
		/*
		 * ���ű�������
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				while(true) {
					sound.play(stream);
				}
			}}).start();
/*
 * �涴�߳�
 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
//		�����ﵽһ��ֵ�����ֳ涴
				boolean insectT=true;
				while(insectT) {
					for(int s=0;s<1;s++) {
						score[s]=score[s];
//		����������100�������涴��������Ϸ�Ѷ�
						if(score[s]>=100)
						{
							ishole=true;
							for(int i=0;i<insectnum;i++)
							{
//		��Բ���������壬�ı䷽�򷴵���ȥ
								if(insectX[i]>JFW) 
									insectXDirect[i]=-1;
								else if(insectX[i]<0) 
									insectXDirect[i]=1;
//		Բ����ƶ��ٶ�
								insectX[i]+=(i+1)*insectXDirect[i];
//		��Բ���������壬�ı䷽�򷴵���ȥ
								if(insectY[i]>JFH) 
									insectYDirect[i]=-1;
								else if(insectY[i]<0) 
									insectYDirect[i]=1;	
//		Բ����ƶ��ٶ�
								insectY[i]+=(i+1)*insectYDirect[i];
//		�жϷɻ��Ƿ�����Բ�棬����������ֵ��2��Ȼ��Բ��Ӵ���������λ�ó��֣����봰�壬�ҷɻ�����
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
//		��������ʱ��
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}sp.repaint();
					}
				}
			}}).start();	
}
}