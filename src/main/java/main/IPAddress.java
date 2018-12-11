package main;

/**
 * IP Address v4.
 */
class IPAddress implements Comparable {
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
     * Create a copy of given IP address.
     */
    public IPAddress(IPAddress other) {
        this.ip = other.ip;
    }

    /**
     * set IP address to given bytes.
     */
    private void set(int a, int b, int c, int d) {
        ip = (a << 24) + (b << 16) + (c << 8) + d;
    }

    /**
     * Add given number to current IP address.
     */
    public void add(int number) {
        ip += number;
    }

    @Override
    public int compareTo(Object rhs) {
        return ip - ((IPAddress)rhs).ip;
    }

    @Override
    public String toString() {
        int a = (ip >>> 24);
        int b = (ip >>> 16) & 0xff;
        int c = (ip >>> 8) & 0xff;
        int d = ip & 0xff;

        return new String(a + "." + b + "." + c + "." + d);
    }

    @Override
    public boolean equals(Object other) {
        return ip == ((IPAddress)other).ip;
    }

    @Override
    public int hashCode() {
        return ip;
    }
}

