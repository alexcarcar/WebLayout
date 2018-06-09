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

    static void randomAccessDemo() {
        double data[] = {19.4, 10.1, 123.54, 33.0, 87.9, 74.25};
        double d;

        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")) {
            for (int i = 0; i < data.length; i++) {
                raf.writeDouble(data[i]);
            }
            raf.seek(0);
            d = raf.readDouble();
            System.out.println("First value is " + d); // 19.4

            raf.seek(8);
            d = raf.readDouble();
            System.out.println("Second value is " + d); // 10.1

            raf.seek(8 * 3);
            d = raf.readDouble();
            System.out.println("Fourth value is " + d); // 33.0

            System.out.println();
            for (int i = 0; i < data.length; i += 2) {
                raf.seek(8 * i);
                d = raf.readDouble();
                System.out.print(d + " "); // 19.4. 123.54 87.9
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    static void readChars() throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, period to quit.");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != '.');
        // Enter characters, period to quit.
        // One Two.
        // O
        // n
        // e

        // T
        // w
        // o
        // .
    }

    // Read a string from console using a BufferedReader.
    static void readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));
        // Enter lines of text.
        // Enter 'stop' to quit.
        // This is a test.
        // This is a test.
        // another line
        // another line
        // stop
        // stop
    }

    static void printWriterDemo() {
        PrintWriter pw = new PrintWriter(System.out, true);
        int i = 10;
        double d = 123.65;
        pw.println("Using a PrintWriter.");
        pw.println(i);
        pw.println(d);
        pw.println(i + " + " + d + " is " + (i + d));
        // 10 + 123.65 is 133.65
    }

    static void kToD() {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text ('stop' to quit).");
        try (FileWriter fw = new FileWriter("kToD.txt")) {
            do {
                System.out.print(": ");
                str = br.readLine();
                if (str.compareTo("stop") == 0) break;
                str = str + "\r\n"; // add newline
                fw.write(str);
            } while (str.compareTo("stop") != 0);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        // Enter text ('stop' to quit).
        // : This is a test
        // : Here is another line
        // : stop

        // % type kToD.txt
        // This is a test
        // Here is another line
    }

    static void dToS() {
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader("kToD.txt"))) {
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("I/O Error: " + e);
        }
        // This is a test
        // Here is another line
    }

    static void avgNums() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int n;
        double sum = 0.0;
        double avg, t;

        System.out.print("How many numbers will you enter: ");
        str = br.readLine();
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid format");
            n = 0;
        }

        System.out.println("Enter " + n + " values.");
        for (int i = 0; i < n; i++) {
            System.out.print(": ");
            str = br.readLine();
            try {
                t = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid format");
                t = 0.0;
            }
            sum += t;
        }
        avg = sum / n;
        System.out.println("Average is " + avg);
        // How many numbers will you enter: 5
        // Enter 5 values.
        // : 1.1
        // : 2.2
        // : 3.3
        // : 4.4
        // : 5.5
        // Average is 3.3
    }

    public static void main(String[] args) throws IOException {
        // readBytes();
        // writeDemo();
        // showFile();
        // copyFile();
        copyFileWithResources();
        rwData();
        randomAccessDemo();
        // readChars();
        // readLines();
        printWriterDemo();
        // kToD();
        dToS();
        // avgNums();

        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble("123.23"))));
        // 100000001011110110011101011100001010001111010111000010100011111
    }
}