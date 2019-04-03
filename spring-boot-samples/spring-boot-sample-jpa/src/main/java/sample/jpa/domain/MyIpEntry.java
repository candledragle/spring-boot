package sample.jpa.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class MyIpEntry {

    /**
     * ip : 115.164.168.88
     * country : MY
     * asn : {"asnum":4818,"org_name":"DiGi Telecommunications Sdn. Bhd."}
     * geo : {"city":"Kuala Lumpur","region":"14","postal_code":"50250","latitude":3.1419,"longitude":101.6934,"tz":"Asia/Kuala_Lumpur"}
     * method : GET
     * httpVersion : 1.1
     * url : /echo.json
     * headers : {"Host":"lumtest.com","Connection":"Keep-Alive","User-Agent":"Apache-HttpClient/4.5.7 (Java/1.8.0_171)","Accept-Encoding":"gzip,deflate"}
     */

    private String ip;
    private String country;
    private AsnBean asn;
    private GeoBean geo;
    private String method;
    private String httpVersion;
    private String url;
    private HeadersBean headers;


    @Data
    public static class AsnBean {
        /**
         * asnum : 4818
         * org_name : DiGi Telecommunications Sdn. Bhd.
         */

        private int asnum;
        private String org_name;
    }

    @Data
    public static class GeoBean {
        /**
         * city : Kuala Lumpur
         * region : 14
         * postal_code : 50250
         * latitude : 3.1419
         * longitude : 101.6934
         * tz : Asia/Kuala_Lumpur
         */

        private String city;
        private String region;
        private String postal_code;
        private double latitude;
        private double longitude;
        private String tz;
    }

    @Data
    public static class HeadersBean {
        /**
         * Host : lumtest.com
         * Connection : Keep-Alive
         * User-Agent : Apache-HttpClient/4.5.7 (Java/1.8.0_171)
         * Accept-Encoding : gzip,deflate
         */

        private String Host;
        private String Connection;
        private String UserAgent;
        private String AcceptEncoding;
    }
}
