import java.io.*;

// Usage: java HyphenCopy.java input.txt output.txt
//
// Copys a text file, replacing spaces with hyphens (-)


class HyphenCharCopy {
    public static void main(String[] args) {
        int i;

        if (args.length != 2) {
            System.out.println("Usage: java HypenCharCopy input.txt output.txt");
            return;
        }

        try (
                BufferedReader fin = new BufferedReader(new FileReader(args[0]));
                FileWriter fout = new FileWriter(args[1]);
        ) {
            do {
                i = fin.read();
                if ((char) i == ' ') {
                    i = (int) '-';
                }
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    // % type h2-in.txt
    // This is a test
    // another line
    // % java HyphenCharCopy h2-in.txt h2-out.txt

    // % type h2-out.txt
    // This-is-a-test
    // another-line
}