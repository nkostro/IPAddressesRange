package main;

/**
 * IP Address v4.
 */
class IPAddress {
    private int ip;

    /**
     * Create IP address from given String.
     */
    public IPAddress(String ip) {
        String[] bytes = ip.split("\\.");
        set(Integer.parseInt(bytes[0]), Integer.parseInt(bytes[1]),
                Integer.parseInt(bytes[2]), Integer.parseInt(bytes[3]));
    }

    /**
     * set IP address to given bytes.
     */
    private void set(int a, int b, int c, int d) {
        ip = (a << 24) + (b << 16) + (c << 8) + d;
    }
}

