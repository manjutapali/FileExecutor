package ops;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Queue;


public class ReadRunner implements Runnable {

	
	private File file;
	private Queue<String> queue;
	
	public ReadRunner(File file, Queue<String> queue) {
		this.file = file;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		System.out.println("Current thread - " + Thread.currentThread().getName() + 
				"Current File - " + file.getName());
		
		BufferedReader reader = null;
		
		try {
			
			reader =  new BufferedReader(new FileReader(file));
			
			String line = reader.readLine();
			
			while(line != null) {
				String res = file.getName() + "--------------" + line + "\n";
				queue.add(res);
				line = reader.readLine();
			}
			
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
