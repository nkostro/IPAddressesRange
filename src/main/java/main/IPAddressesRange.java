package main;

import java.util.Scanner;

/**
 * Exclusive range of IP addresses.
 */
public class IPAddressesRange {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st IP address: ");
        String ipString1 = scanner.nextLine();

        System.out.print("Enter 2nd IP address: ");
        String ipString2 = scanner.nextLine();

        IPAddress ip1 = new IPAddress(ipString1);
        IPAddress ip2 = new IPAddress(ipString2);
    }
}

