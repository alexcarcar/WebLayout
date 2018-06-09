import java.io.*;

// Usage: java HyphenCopy.java input.txt output.txt
//
// Copys a text file, replacing spaces with hyphens (-)


class HyphenCopy {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        if (args.length != 2) {
            System.out.println("Usage: java HypenCopy input.txt output.txt");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
            do {
                i = fin.read();
                if ((char) i == ' ') {
                    i = (int) '-';
                }
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Error Closing Input File");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Error Closing Output File");
            }
        }
    }
    // % type h-in.txt
    // This is a test
    // another line
    // % java HyphenCopy h-in.txt h-out.txt

    // % type h-out.txt
    // This-is-a-test
    // another-line
}