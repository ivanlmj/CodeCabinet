import java.io.File;

public class FileReader {

	public static void main(String[] args) throws Exception {
		
		File file = new File("/tmp/file");		
		if (file.createNewFile()) {
			System.out.println("File has been created.");
		} else {
			System.out.println("File already exists...");
		}
		
	}

}
