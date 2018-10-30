/**
 * 
 * @author Sakura
 * @feature Լɪ������
 * 
 */

public class Test {
	public static void main (String args[]) {
		CycLink cycLink = new CycLink();
		cycLink.setLen(5);
		cycLink.createLink();
		cycLink.setK(2);
		cycLink.setM(2);
		cycLink.play();
		//cycLink.show();
	}
}

class Child{
	int no;
	//��һ��ָ��
	Child nextChile = null;
	//��һ��ָ��
	Child proveChile = null;
	//���췽��
	public Child(int no)
	{
		this.no = no;
	}	
}
 
class CycLink{
	//�����ͷ��
	Child firstChild = null;
	//��ʱ
	Child temp = null;
	//����
	private int len;
	//��������������
	public void setLen(int len) {
		this.len = len;
	}
	//���Ŀ�ʼ
	private int k;
	public void setK(int k)
	{
		this.k = k;
	}
	//ÿ��������
	private int m;
	public void setM(int m)
	{
		this.m = m;
	}
	
	//��ʼ����Ϸ
	public void play() {
		temp = this.firstChild;
		//Ѱ�ҿ�ʼ��λ��
		for (int i=1; i<k;i++)
		{
			temp = temp.nextChile;
		}
		while(this.len !=1) {
			//��ʼ����
			for (int i=1;i<m;i++)
			{
				temp = temp.nextChile;
			}
			//ɾ��
			temp.proveChile.nextChile = temp.nextChile;
			temp.nextChile.proveChile = temp.proveChile;
			System.out.println(temp.no);
			temp = temp.nextChile;
			this.len--;
		}
	}
	//����ѭ������
	public void createLink() {
		for (int i=1; i<=len; i++)
		{
			if (i==1)
			{
				Child ch = new Child(i);
				this.firstChild = ch;
				this.temp = ch;
			}
			else if (i==len) 
			{
				Child ch = new Child(i);
				temp.nextChile = ch;
				temp.nextChile.proveChile = temp;
				this.temp = ch;
				this.firstChild.proveChile = temp;
				temp.nextChile = this.firstChild;
			}
			else 
			{
				Child ch = new Child(i);
				temp.nextChile = ch;
				temp.nextChile.proveChile = temp;
				this.temp = ch;
			}
		}
	}
	//չʾ
	public void show()
	{
		Child temp = this.firstChild;
		do {
			System.out.println(temp.proveChile.no);
			temp = temp.proveChile;
		}while(temp != this.firstChild);
	}
}