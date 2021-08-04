import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimeThread extends Thread{
	private JLabel timeLabel;
	
	public TimeThread(JLabel timeLabel) {
		this.timeLabel = timeLabel;
		
	}

	@Override
	public void run() {
		while(true) {
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			int sec = cal.get(Calendar.SECOND);
			timeLabel.setText(Integer.toString(hour)+"시"+Integer.toString(min)+"분"+Integer.toString(sec)+"초");
			sec++;
			if (sec == 60) {
				sec = 0;
			min++;
			}
			if(min == 60) {
				min = 0;
			hour++;
			}
			try {
				Thread.sleep(1000);
			}
			catch(Exception e){
				return;
			}
		}
	}
}

public class DigitalClock extends JFrame{
	public DigitalClock() {
		this.setTitle("디지털시계");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timeLabel = new JLabel();
		timeLabel.setFont(new Font("Gothic", Font.ITALIC, 50));
		c.add(timeLabel);
		
		TimeThread th = new TimeThread(timeLabel);
		
		this.setSize(400,170);
		this.setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new DigitalClock();

	}

}
