/**
 * 
 * @author Sakura
 * @feature 约瑟夫问题
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
	//下一个指向
	Child nextChile = null;
	//上一个指向
	Child proveChile = null;
	//构造方法
	public Child(int no)
	{
		this.no = no;
	}	
}
 
class CycLink{
	//链表的头标
	Child firstChild = null;
	//临时
	Child temp = null;
	//总数
	private int len;
	//设置人数的总数
	public void setLen(int len) {
		this.len = len;
	}
	//从哪开始
	private int k;
	public void setK(int k)
	{
		this.k = k;
	}
	//每次数几个
	private int m;
	public void setM(int m)
	{
		this.m = m;
	}
	
	//开始玩游戏
	public void play() {
		temp = this.firstChild;
		//寻找开始的位置
		for (int i=1; i<k;i++)
		{
			temp = temp.nextChile;
		}
		while(this.len !=1) {
			//开始数数
			for (int i=1;i<m;i++)
			{
				temp = temp.nextChile;
			}
			//删除
			temp.proveChile.nextChile = temp.nextChile;
			temp.nextChile.proveChile = temp.proveChile;
			System.out.println(temp.no);
			temp = temp.nextChile;
			this.len--;
		}
	}
	//创建循环链表
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
	//展示
	public void show()
	{
		Child temp = this.firstChild;
		do {
			System.out.println(temp.proveChile.no);
			temp = temp.proveChile;
		}while(temp != this.firstChild);
	}
}