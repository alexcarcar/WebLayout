class FindAverage {
    public static void main(String[] args) {
        double data[] = {12.2, 32.4, 54.5, 90.4, 87.2, 95.1, 43.2, 47.2, 71.2, 88.8};
        double total = 0;
        for (double d : data) total += d;
        System.out.println("Average: " + total / data.length);
        // Average: 62.21999999999999
    }
}