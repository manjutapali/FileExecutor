package ops;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Queue;

public class WriteRunner implements Runnable {
	
	private File file;
	private Queue<String> queue;
	
	public WriteRunner(File file, Queue<String> queue) {
		this.queue = queue;
		this.file = file;
	}
	
	@Override
	public void run() {
		
		BufferedWriter writer = null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(file, true));
			
			while(queue != null && (!queue.isEmpty())) {
				
				if(queue.isEmpty()) {
				}
				else {
					
					String res = queue.poll();
					
					System.out.println("Queue size - " + queue.size());
					
					writer.write(res);
					
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
