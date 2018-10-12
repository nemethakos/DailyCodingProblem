package Sep16;

public class Pr17 {



	public static void main(String...args) {
		
		//System.out.println("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
		//System.out.println(Arrays.asList("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".split("\n")));
		//System.out.println(DirectoryTree.of("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

		System.out.println(DirectoryTree.of("root\n\t_____________________________________dir1\n\t\tveryLongFile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

	}
	
}
