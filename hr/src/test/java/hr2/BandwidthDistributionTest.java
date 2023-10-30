package hr2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BandwidthDistributionTest {
    BandwidthDistribution bandwidthDistribution;
    int MAXBANDWIDTHCOUNT = 100;

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

    @Test
    @DisplayName(value = "100 Records With 100,000 Returns 0")
    void v100ZeroesTotalBandwidth100_000Returns0() {
        List<Integer> zeroes = new ArrayList<>(MAXBANDWIDTHCOUNT);
        for (int i = 0; i < MAXBANDWIDTHCOUNT; i++) {
            zeroes.add(0);
        }
        int totalBandwidth = 100_000;

        assertEquals(0, bandwidthDistribution.getMaxRequests(zeroes, zeroes, totalBandwidth));
    }

    @Test
    @DisplayName(value = "100 Bandwidths and Requests With 100,000 Total Bandwidth Returns 756,450")
    void v100BandWidthsAndRequestsWith100_000Returns756450() {
        List<Integer> bandwidths = get100Bandwidths();
        List<Integer> requests = get100Requests();
        int totalBandwidth = 100_000;

        assertEquals(756450, bandwidthDistribution.getMaxRequests(bandwidths, requests, totalBandwidth));
    }

    @Test
    @DisplayName(value = "100 Bandwidths and Requests With 27,013 Total Bandwidth Returns 422,730")
    void v100BandWidthsAndRequestsWith100_000Returns8931() {
        List<Integer> bandwidths = get100Bandwidths();
        List<Integer> requests = get100Requests();
        int totalBandwidth = 27_013;

        assertEquals(422_730, bandwidthDistribution.getMaxRequests(bandwidths, requests, totalBandwidth));
    }

    private List<Integer> get100Bandwidths() {
        List<Integer> bandwidths = new ArrayList<>(MAXBANDWIDTHCOUNT);
        bandwidths.add(15247);
        bandwidths.add(20914);
        bandwidths.add(87266);
        bandwidths.add(11151);
        bandwidths.add(96373);
        bandwidths.add(53889);
        bandwidths.add(77128);
        bandwidths.add(29063);
        bandwidths.add(79200);
        bandwidths.add(95207);
        bandwidths.add(89311);
        bandwidths.add(37924);
        bandwidths.add(34142);
        bandwidths.add(34343);
        bandwidths.add(86155);
        bandwidths.add(48298);
        bandwidths.add(63239);
        bandwidths.add(40149);
        bandwidths.add(6615);
        bandwidths.add(18779);
        bandwidths.add(30108);
        bandwidths.add(86966);
        bandwidths.add(33219);
        bandwidths.add(83111);
        bandwidths.add(65639);
        bandwidths.add(28782);
        bandwidths.add(79507);
        bandwidths.add(75716);
        bandwidths.add(52726);
        bandwidths.add(93062);
        bandwidths.add(86120);
        bandwidths.add(28865);
        bandwidths.add(83316);
        bandwidths.add(28930);
        bandwidths.add(75126);
        bandwidths.add(17955);
        bandwidths.add(74348);
        bandwidths.add(69828);
        bandwidths.add(35994);
        bandwidths.add(81975);
        bandwidths.add(22875);
        bandwidths.add(36230);
        bandwidths.add(68724);
        bandwidths.add(5179);
        bandwidths.add(53956);
        bandwidths.add(72257);
        bandwidths.add(16234);
        bandwidths.add(97315);
        bandwidths.add(57665);
        bandwidths.add(60183);
        bandwidths.add(19199);
        bandwidths.add(74284);
        bandwidths.add(87160);
        bandwidths.add(8349);
        bandwidths.add(36619);
        bandwidths.add(27937);
        bandwidths.add(31620);
        bandwidths.add(13419);
        bandwidths.add(92347);
        bandwidths.add(14780);
        bandwidths.add(79472);
        bandwidths.add(38485);
        bandwidths.add(980);
        bandwidths.add(8504);
        bandwidths.add(38565);
        bandwidths.add(90731);
        bandwidths.add(44143);
        bandwidths.add(59439);
        bandwidths.add(2874);
        bandwidths.add(26883);
        bandwidths.add(98119);
        bandwidths.add(18733);
        bandwidths.add(36266);
        bandwidths.add(24716);
        bandwidths.add(72464);
        bandwidths.add(68636);
        bandwidths.add(37739);
        bandwidths.add(55981);
        bandwidths.add(65289);
        bandwidths.add(25413);
        bandwidths.add(27465);
        bandwidths.add(1852);
        bandwidths.add(67944);
        bandwidths.add(78145);
        bandwidths.add(9326);
        bandwidths.add(35584);
        bandwidths.add(28116);
        bandwidths.add(97273);
        bandwidths.add(30621);
        bandwidths.add(94106);
        bandwidths.add(3360);
        bandwidths.add(29062);
        bandwidths.add(86246);
        bandwidths.add(54683);
        bandwidths.add(81712);
        bandwidths.add(13716);
        bandwidths.add(96107);
        bandwidths.add(38547);
        bandwidths.add(89556);
        bandwidths.add(27013);
        return bandwidths;
    }

    private List<Integer> get100Requests() {
        List<Integer> requests = new ArrayList<>(MAXBANDWIDTHCOUNT);
        requests.add(55179);
        requests.add(28222);
        requests.add(80204);
        requests.add(26264);
        requests.add(17492);
        requests.add(24505);
        requests.add(68416);
        requests.add(34483);
        requests.add(8166);
        requests.add(59742);
        requests.add(72042);
        requests.add(10125);
        requests.add(90733);
        requests.add(40850);
        requests.add(79075);
        requests.add(5450);
        requests.add(50318);
        requests.add(74141);
        requests.add(623);
        requests.add(48222);
        requests.add(53249);
        requests.add(88179);
        requests.add(61891);
        requests.add(5277);
        requests.add(31453);
        requests.add(64199);
        requests.add(32214);
        requests.add(28847);
        requests.add(68792);
        requests.add(43061);
        requests.add(48519);
        requests.add(64880);
        requests.add(87363);
        requests.add(52383);
        requests.add(40852);
        requests.add(12145);
        requests.add(68910);
        requests.add(95704);
        requests.add(84405);
        requests.add(13801);
        requests.add(21234);
        requests.add(47554);
        requests.add(78077);
        requests.add(45133);
        requests.add(17187);
        requests.add(87746);
        requests.add(82581);
        requests.add(90995);
        requests.add(38826);
        requests.add(18864);
        requests.add(88958);
        requests.add(34529);
        requests.add(12981);
        requests.add(95245);
        requests.add(44783);
        requests.add(37870);
        requests.add(91319);
        requests.add(28261);
        requests.add(38870);
        requests.add(18576);
        requests.add(46837);
        requests.add(14247);
        requests.add(78693);
        requests.add(82520);
        requests.add(4629);
        requests.add(25033);
        requests.add(47981);
        requests.add(21196);
        requests.add(58372);
        requests.add(58281);
        requests.add(56145);
        requests.add(20189);
        requests.add(53952);
        requests.add(61938);
        requests.add(59480);
        requests.add(97151);
        requests.add(44549);
        requests.add(3401);
        requests.add(94868);
        requests.add(62973);
        requests.add(52877);
        requests.add(50987);
        requests.add(90338);
        requests.add(64809);
        requests.add(95);
        requests.add(12525);
        requests.add(71889);
        requests.add(70481);
        requests.add(16160);
        requests.add(8308);
        requests.add(56913);
        requests.add(17953);
        requests.add(30985);
        requests.add(70167);
        requests.add(64747);
        requests.add(61869);
        requests.add(68152);
        requests.add(92108);
        requests.add(60316);
        requests.add(8931);
        return requests;
    }
}