import java.io.*;

class Example {
    // Read an array of bytes from the keyboard.
    static void readBytes() throws IOException {
        byte data[] = new byte[10];

        System.out.println("Enter some characters.");
        System.in.read(data); // Read an array of bytes from the keyboard
        System.out.print("You entered: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }
        // Enter some characters.
        // This is a test
        // You entered: This is a
    }

    // Demonstrate System.out.write().
    static void writeDemo() {
        int b;

        b = 'X';
        System.out.print(b); // 88
        System.out.print('\n');
    }

    // Display a file: TEST.TXT
    static void showFile() {
        int i;
        FileInputStream fin = null;

        try {
            // Read bytes until EOF is encountered
            do {
                fin = new FileInputStream("TEST.TXT");
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
        } catch (IOException exc) {
            System.out.println("I/O error: " + exc);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException exc) {
                System.out.println("Error closing file.");
            }
        }
        // this is a test file
        // this is the second line
    }

    // Copy "TEST.TXT" to "TEXTCOPY.TXT"
    static void copyFile() {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream("TEST.TXT");
            fout = new FileOutputStream("TESTCOPY.TXT");

            do {
                i = fin.read();
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
        // % type TESTCOPY.TXT
        // this is a test file
        // this is the second line
    }

    static void copyFileWithResources() {
        int i;
        try (
                FileInputStream fin = new FileInputStream("TEST.TXT");
                FileOutputStream fout = new FileOutputStream("TESTCOPY2.TXT");
        ) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        // % type TESTCOPY2.TXT
        // this is a test file
        // this is the second line
    }

    // Write and then read back binary data.
    static void rwData() {
        int i = 10;
        double d = 1023.56;
        boolean b = true;

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("testdata"))) {
            System.out.println("Writing " + i);
            dataOut.writeInt(i);

            System.out.println("Writing " + d);
            dataOut.writeDouble(d);

            System.out.println("Writing " + b);
            dataOut.writeBoolean(b);

            System.out.println("Writing " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);
        } catch (IOException e) {
            System.out.println("Write error.");
        }
        // Writing 10
        // Writing 1023.56
        // Writing true
        // Writing 90.28

        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("testdata"))) {
            i = dataIn.readInt();
            System.out.println("Reading " + i);

            d = dataIn.readDouble();
            System.out.println("Reading " + d);

            b = dataIn.readBoolean();
            System.out.println("Reading " + b);

            d = dataIn.readDouble();
            System.out.println("Reading " + d);
        } catch (IOException e) {
            System.out.println("Read error.");
        }
        // Reading 10
        // Reading 1023.56
        // Reading true
        // Reading 90.28
    }

    public static void main(String[] args) throws IOException {
        // readBytes();
        // writeDemo();
        // showFile();
        // copyFile();
        copyFileWithResources();
        rwData();
    }
}