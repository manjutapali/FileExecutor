package ops;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class FileOps {

	public List<String> getAllTextFileNames(String folderPath) {
		
		List<String> files = new ArrayList<>();
		
		File dir = new File(folderPath);
		
		for(File f : dir.listFiles()) {
			
			if(f.getName().endsWith(".txt")) {
				files.add(f.getName());
			}
		}
		
		return files;
	}
	
	
	public boolean createFolder(String path, String folderName) {
		
		String finalPath = path + folderName;
		
		return new File(finalPath).mkdirs();
	}
	
	public boolean createFolder(String path) {
		
		return new File(path).mkdirs();
	}
	
	public boolean createNewFile(String path) throws IOException {
		
		return new File(path).createNewFile();
	}
	
	
}
