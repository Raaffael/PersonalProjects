import java.io.File; 
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Rename {

	public static void main(String[] args) throws IOException {
		String path = "blank";
		try(Stream<Path> paths = Files.walk(Paths.get(path))){
			//paths.forEach(System.out::println);
			//paths.filter(Files::isRegularFile).forEach(System.out::println);
			//BasicFileAttributes attr = Files.readAttributes(Paths.get(path), BasicFileAttributes.class);
			//System.out.println(attr.creationTime());
		}
		File foldr = new File(path);		
		File[] listOfEps = foldr.listFiles();
		ArrayList<File> woa = new ArrayList<File>();
		for(int i=0; i<listOfEps.length; i++) {
			BasicFileAttributes attr = Files.readAttributes(Paths.get(listOfEps[i].getPath()), BasicFileAttributes.class);
			for(int k =0; k<woa.size();k++) {
				if(woa.get(k)!=null) {
					BasicFileAttributes wo = Files.readAttributes(Paths.get(woa.get(k).getPath()), BasicFileAttributes.class);
					if(attr.creationTime().toMillis()<wo.creationTime().toMillis()) {
						woa.add(k, listOfEps[i]);
						listOfEps[i]=null;
						break;
					}
				}				
			}
			woa.add(listOfEps[i]);
		}
		woa.removeAll(Collections.singleton(null));
		for(int j=0;j<woa.size(); j++) {
			try {
				System.out.println(woa.get(j));
				BasicFileAttributes attr = Files.readAttributes(Paths.get(woa.get(j).getPath()), BasicFileAttributes.class);
				System.out.println(attr.creationTime());
			} catch (Exception e) {}
		}
		for(int i=0;i<woa.size();i++) {
			int index = i+1;
			String newFilePath = "blank" + index + ".mp4";
			new File(woa.get(i).getPath()).renameTo(new File(newFilePath));
		}
	}

}
