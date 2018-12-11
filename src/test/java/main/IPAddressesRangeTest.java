package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * Unit test for IP addresses range program.
 */
public class IPAddressesRangeTest
{
    /**
     * Test of simple range (192.168.0.1; 192.168.0.5).
     */
    @Test
    public void simpleRange()
    {
        List<IPAddress> addresses = new ArrayList<>(3);
        addresses.add(new IPAddress("192.168.0.2"));
        addresses.add(new IPAddress("192.168.0.3"));
        addresses.add(new IPAddress("192.168.0.4"));

        IPAddressesRange range = new IPAddressesRange(new IPAddress("192.168.0.1"),
                new IPAddress("192.168.0.5"));

        List<IPAddress> result = new ArrayList<>(3);
        for (IPAddress ip : range) {
            result.add(new IPAddress(ip));
        }

        assertEquals(addresses, result);
    }

    /**
     * Test of range with byte overflow (192.168.10.254; 192.168.11.4).
     */
    @Test
    public void byteOverflowRange()
    {
        List<IPAddress> addresses = new ArrayList<>(4);
        addresses.add(new IPAddress("192.168.10.255"));
        addresses.add(new IPAddress("192.168.11.1"));
        addresses.add(new IPAddress("192.168.11.2"));
        addresses.add(new IPAddress("192.168.11.3"));

        IPAddressesRange range = new IPAddressesRange(new IPAddress("192.168.10.254"),
                new IPAddress("192.168.11.4"));

        List<IPAddress> result = new ArrayList<>(4);
        for (IPAddress ip : range) {
            result.add(new IPAddress(ip));
        }

        assertEquals(addresses, result);
    }

    /**
     * Test of range with two bytes overflow (192.168.255.254; 192.169.0.4).
     */
    @Test
    public void twoBytesOverflowRange()
    {
        List<IPAddress> addresses = new ArrayList<>(4);
        addresses.add(new IPAddress("192.168.255.255"));
        addresses.add(new IPAddress("192.169.0.1"));
        addresses.add(new IPAddress("192.169.0.2"));
        addresses.add(new IPAddress("192.169.0.3"));

        IPAddressesRange range = new IPAddressesRange(new IPAddress("192.168.255.254"),
                new IPAddress("192.169.0.4"));

        List<IPAddress> result = new ArrayList<>(4);
        for (IPAddress ip : range) {
            result.add(new IPAddress(ip));
        }

        assertEquals(addresses, result);
    }

    /**
     * Test of range with three bytes overflow (192.255.255.254; 193.0.0.4).
     */
    @Test
    public void threeBytesOverflowRange()
    {
        List<IPAddress> addresses = new ArrayList<>(4);
        addresses.add(new IPAddress("192.255.255.255"));
        addresses.add(new IPAddress("193.0.0.1"));
        addresses.add(new IPAddress("193.0.0.2"));
        addresses.add(new IPAddress("193.0.0.3"));

        IPAddressesRange range = new IPAddressesRange(new IPAddress("192.255.255.254"),
                new IPAddress("193.0.0.4"));

        List<IPAddress> result = new ArrayList<>(4);
        for (IPAddress ip : range) {
            result.add(new IPAddress(ip));
        }

        assertEquals(addresses, result);
    }
}
