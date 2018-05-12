class Encode {
	static void encode() {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        long key = 8839_4312;

        System.out.println("Original message: " + msg);

        for (int i = 0; i < msg.length(); i++)
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);
        System.out.println("Encoded message: " + encmsg);

        for (int i = 0; i < msg.length(); i++)
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
        System.out.println("Decoded message: " + decmsg);
    }

	public static void main(String[] args) {
		encode();
	}	
}

// Original message: This is a test
// Encoded message: ??????????????
// Decoded message: This is a test
