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
}
