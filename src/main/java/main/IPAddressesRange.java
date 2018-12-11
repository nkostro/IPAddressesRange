package main;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Exclusive range of IP addresses.
 */
public class IPAddressesRange implements Iterable<IPAddress> {
    private IPAddress start;
    private IPAddress end;

    /**
     * Create range (start; end) of IP addresses.
     */
    public IPAddressesRange(IPAddress start, IPAddress end) {
        this.start = new IPAddress(start);
        this.end = new IPAddress(end);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st IP address: ");
        String ipString1 = scanner.nextLine();

        System.out.print("Enter 2nd IP address: ");
        String ipString2 = scanner.nextLine();

        IPAddressesRange range = new IPAddressesRange(new IPAddress(ipString1), new IPAddress(ipString2));

        for (IPAddress ip : range) {
            System.out.println(ip);
        }
    }

    public Iterator<IPAddress> iterator() {
        return new Iterator<IPAddress>() {
            private IPAddress current = new IPAddress(start);

            @Override
            public boolean hasNext() {
                return current.compareTo(end) < -1;  // -1 because range is exclusive
            }

            @Override
            public IPAddress next() {
                current.add(1);

                return current;
            }
        };
    }
}

