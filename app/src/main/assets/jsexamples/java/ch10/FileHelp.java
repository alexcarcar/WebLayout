    import java.io.*;

// 10-2: A help program that uses a disk file to store help information.

class Help {
    String helpfile; // name of help file

    Help(String fname) {
        helpfile = fname;
    }

    // Display help on a topic.
    boolean helpOn(String what) {
        int ch;
        String topic, info;
        try (BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile))) {
            do {
                // read characters until a # is found
                ch = helpRdr.read();
                if (ch == '#') {
                    topic = helpRdr.readLine();
                    if (what.compareTo(topic) == 0) {
                        do {
                            info = helpRdr.readLine();
                            if (info != null) System.out.println(info);
                        } while ((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while (ch != -1);
        } catch (IOException e) {
            System.out.println("Error accessing help file.");
            return false;
        }
        return false; // topic not found
    }

    String getSelection() {
        String topic = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter topic: ");
        try {
            topic = br.readLine();
        } catch (IOException e) {
            System.out.println("Error reading console.");
        }
        return topic;
    }
}

class FileHelp {
    public static void main(String[] args) {
        Help hlpobj = new Help("helpfile.txt");
        String topic;

        System.out.println("Try the help system. Enter 'stop' to end.");
        do {
            topic = hlpobj.getSelection();
            if (!hlpobj.helpOn(topic))
                System.out.println("Topic not found.\n");
        } while (topic.compareTo("stop") != 0);
    }
}

// Try the help system. Enter 'stop' to end.
// Enter topic: if
// if(condition) statement;
// else statement;

// Enter topic: switch
// switch(expression) {
//         case constant:
//                 statement sequence
//                 break;
//                 // ...
//         }

// Enter topic: done
// Topic not found.

// Enter topic: exit
// Topic not found.