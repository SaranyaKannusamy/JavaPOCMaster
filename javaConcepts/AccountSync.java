package javaConcepts;
import modelObjects.Accounts;

public class AccountSync implements Runnable {
	
	Accounts acc=new Accounts();
	public static void main(String args[])
	{
		AccountSync accSync=new AccountSync();
		
		
		Thread th1=new Thread(accSync);
		Thread th2=new Thread(accSync);
		th1.setName("Nikhil");
		th2.setName("Nishan");
		th1.start();
		th2.start();
		
		
	}
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			withDrawAmount(30);
			if(acc.getBalance()<0)
			{
				System.out.println("Low Account Balance");
			}
		}
		
	}
	
	public  synchronized void withDrawAmount(int amount)
	{
		if (acc.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			acc.withDraw(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + acc.getBalance());
		}
	}
	}
	
	


