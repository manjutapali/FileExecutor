import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ops.ReadRunner;
import ops.WriteRunner;

public class Driver {
	
	public static void main(String args[]) {
		
		// Get all the files in the folder
		File file = new File("/Users/tapalim/Password/");
		
		ArrayList<File> files = new ArrayList<>();
		
		for(File f : file.listFiles()) {
			
			if(!f.isDirectory() && f.getName().endsWith(".txt")) {
				files.add(f);
			}
		}
		
		// Common queue
		Queue<String> queue = new LinkedList<>();
		
		// Creating the reader thread pool
		ExecutorService readerExecutor = Executors.newFixedThreadPool(1);
		
		// Creating writer thread pool
		ExecutorService writerExecutor = Executors.newFixedThreadPool(1);
		
		for(File f : files) {
			ReadRunner reader = new ReadRunner(f, queue);
			readerExecutor.execute(reader);
		}
		
		File writeFile = new File("/Users/tapalim/AllPasswords.txt");
		
		writerExecutor.execute(new WriteRunner(writeFile, queue));
		
		readerExecutor.shutdown();
		
		while(!readerExecutor.isTerminated()) {
			
		}
		
		if(readerExecutor.isTerminated() ) {
			queue = null;
		}
		
		writerExecutor.shutdown();
		
		while(!writerExecutor.isTerminated()) {
			
		}
		if(writerExecutor.isTerminated()) {
			System.out.println("--------------------END------------------------");
		}
	}
}
