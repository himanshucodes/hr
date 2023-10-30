package hr2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BandwidthDistributionTest {
    BandwidthDistribution bandwidthDistribution;

    @BeforeEach
    void setUp() {
        bandwidthDistribution = new BandwidthDistribution();
    }

    @Test
    @DisplayName(value = "1 Bandwidths and Requests With 1 Total Bandwidth Returns 1")
    void v1BandWidthsAndRequestsWith1Returns1() {
        List<Integer> bandwidths = new ArrayList<>(1);
        bandwidths.add(1);
        List<Integer> requests = new ArrayList<>(1);
        requests.add(1);
        int totalBandwidth = 1;

        assertEquals(1, bandwidthDistribution.getMaxRequests(bandwidths, requests, totalBandwidth));
    }

    @Test
    @DisplayName(value = "3 Bandwidths and Requests With 1 Total Bandwidth Returns 0")
    void v3BandWidthsAndRequestsWith10Returns0() {
        List<Integer> bandwidths = new ArrayList<>(3);
        bandwidths.add(15);
        bandwidths.add(33);
        bandwidths.add(95);
        List<Integer> requests = new ArrayList<>(3);
        requests.add(35);
        requests.add(33);
        requests.add(150);
        int totalBandwidth = 1;

        assertEquals(0, bandwidthDistribution.getMaxRequests(bandwidths, requests, totalBandwidth));
    }

    @Test
    @DisplayName(value = "3 Records With 100 Total Bandwidth Returns 15")
    void v3RecordsTotalBandwidth100Return15() {
        List<Integer> bandwidth = new ArrayList<>(3);
        bandwidth.add(25);
        bandwidth.add(20);
        bandwidth.add(15);
        List<Integer> request = new ArrayList<>(3);
        request.add(5);
        request.add(5);
        request.add(5);
        int totalBandwidth = 100;

        assertEquals(15, bandwidthDistribution.getMaxRequests(bandwidth, request, totalBandwidth));
    }

    @Test
    @DisplayName(value = "5 Records With 500 Total Bandwidth Returns 763")
    void v5RecordsTotalBandwidth500Return230() {
        List<Integer> bandwidth = new ArrayList<>(5);
        bandwidth.add(200);
        bandwidth.add(100);
        bandwidth.add(350);
        bandwidth.add(50);
        bandwidth.add(100);
        List<Integer> request = new ArrayList<>(5);
        request.add(270);
        request.add(142);
        request.add(450);
        request.add(124);
        request.add(189);
        int totalBandwidth = 500;

        assertEquals(763, bandwidthDistribution.getMaxRequests(bandwidth, request, totalBandwidth));
    }

    @Test
    @DisplayName(value = "5 Records With 200 Total Bandwidth Returns 230")
    void v5RecordsTotalBandwidth200Return230() {
        List<Integer> bandwidth = new ArrayList<>(5);
        bandwidth.add(100);
        bandwidth.add(500);
        bandwidth.add(80);
        bandwidth.add(25);
        bandwidth.add(400);
        List<Integer> request = new ArrayList<>(5);
        request.add(100);
        request.add(1000);
        request.add(120);
        request.add(110);
        request.add(100);
        int totalBandwidth = 200;

        assertEquals(230, bandwidthDistribution.getMaxRequests(bandwidth, request, totalBandwidth));
    }
}