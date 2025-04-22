package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecordParser {

    public static void main(String[] args) {
        String response =
                "1PETROCAN70892261791000683096 ONTARIO INC              20240620C                                                                                                                                         \n" +
                "2000029 2024061808412711 TEST FILE 1234     ON  G2REG UNLEADED     000000855000000000000000 00001570 00000000 0000013480          0000003I030020087LOUIS DEJONG                  35278                  \n" +
                "2000003 202406141731383 KING TEST 1   WELLANON  G2REG UNLEADED     000001246000000000000000 00002206 00000000 0000018926          0000003I026066326DISPATCH                      00901                  \n" +
                "2000106 202406171736HAMILTON                ON  D1DIESEL-LS        000007301000993725390900 00012696 00000000 0000110354                12406171736MIKE VELDHOEN                 92010                  \n" +
                "2000105 202406171741HAMILTON-KENORA AVE     ON  EFDEF BULK         000000290001149600000000 00000433 00000000 0000003767                12406171741MIKE VELDHOEN                 92010                  \n" +
                "2000113 202406141155BVD - COMBER WEST       ON  D1DIESEL-LS        000003163000979025390900 00005440 00000000 0000047283                12406141155Jim Devries                   22738                  \n" +
                "2000114 202406151123SARNIA                  ON  D1DIESEL-LS        000007050000978625390900 00012121 00000000 0000105357                12406151123ERIC THIESSEN                 42467                  \n" +
                "2000115 202406151129SARNIA TEST 2           ON  EFDEF BULK         000000190001149600000000 00000284 00000000 0000002468                12406151129ERIC THIESSEN                 42467                  \n" +
                "2000114 202406181951BVD - SARNIA WEST       ON  EFDEF BULK         000000140101140700000000 00000208 00000000 0000001806                12406181951ERIC THIESSEN                 22739                  \n" +
                "2000114 202406181959BVD - SARNIA WEST       ON  D1DIESEL-LS        000003000000976525390900 00005150 00000000 0000044762                12406181959ERIC THIESSEN                 22739                  \n" +
                "2000115 202406191736HAMILTON-KENORA AVE     ON  EFDEF BULK         000000276801149600000000 00000414 00000000 0000003596                12406191736GILLES VEAUDRY                92010                  \n" +
                "2000125 202406191746GRAND   -KENORA AVE     ON  D1DIESEL-LS        000004070001008725390900 00007157 00000000 0000062208                12406191746GILLES VEAUDRY                92010                  \n" +
                "2000120 202406152015HAMILTON-KENORA AVE     ON  EFDEF BULK         000000412601149600000000 00000617 00000000 0000005360                12406152015BILL BAXTER                   92010                  \n" +
                "2000120 202406152023HAMILTON-KENORA AVE     ON  D1DIESEL-LS        000004889000993725390900 00008501 00000000 0000073896                12406152023BILL BAXTER                   92010                  \n" +
                "2000127 202406181736KINGSTON-CENTENNIAL WESTON  D1DIESEL-LS        000002790901048825390900 00005053 00000000 0000043922                12406181736MIKE REID                     42537                  \n" +
                "2000131 202406181721TEST 3   KENORA AVE     ON  D1DIESEL-LS        000002958000998725390900 00005163 00000000 0000044877                12406181721ALEX YEVSTAFYEV               92010                  \n" +
                "2000132 202406131204HAMILTON-KENORA AVE     ON  D1DIESEL-LS        000002018000980725390900 00003475 00000000 0000030205                12406131204DAVE FOURNIER                 92010                  \n" +
                "2000133 202406131207WESTERN         AVE     ON  EFDEF BULK         000000073901149600000000 00000110 00000000 0000000960                12406131207DAVE FOURNIER                 92010                  \n" +
                "2000134 202406171357BOWMANVILLE             ON  EFDEF BULK         000000134701149600000000 00000201 00000000 0000001750                12406171357LARRY MCINTYRE                22726                  \n" +
                "2000134 202406171406BOWMANVILLE             ON  D1DIESEL-LS        000004828000991825390900 00008383 00000000 0000072871                12406171406LARRY MCINTYRE                22726                  \n" +
                "2000134 202406181744GRAND FALLS             NB  D1DIESEL-LS        000005034601118825391545 00011533 00000000 0000088421                12406181744LARRY MCINTYRE                21954                  \n" +
                "2000136 202406191833GRAND FALLS TEST 4      NB  EFDEF BULK         000000320801216500000000 00000585 00000000 0000004488                12406191833LARRY MCINTYRE                21954                  \n" +
                "2000137 202406191840GRAND TEST 5            NB  D1DIESEL-LS        000005745301127825391545 00013239 00000000 0000101498                12406191840LARRY MCINTYRE                21954                  \n" +
                "2000140 202406172227BVD - SARNIA WEST       ON  D1DIESEL-LS        000002692000971525390900 00004603 00000000 0000040014                12406172227EDWARD SKALJIN                22739                  \n" +
                "2000141 202406172229TEST  SARNIA WEST       ON  EFDEF BULK         000000129001140700000000 00000191 00000000 0000001663                12406172229EDWARD SKALJIN                22739                  \n" +
                "30000026                                                           0000596087               00109333 00000000 0000923932 0002585089 0000000000 0000000000 0001247798 0000000000 0000000000             \n";

        List<HeaderRecord> headerRecords = new ArrayList<>();
        List<DetailRecord> detailRecords = new ArrayList<>();
        TrailerRecord trailerRecord = null;

        // Split the response into records based on the record type at the beginning
        int currentIndex = 0;
        while (currentIndex < response.length()) {
            char recordType = response.charAt(currentIndex);
            String record = response.substring(currentIndex, currentIndex + 200);
            currentIndex += 200;

            if (recordType == '1') {
                headerRecords.add(parseHeaderRecord(record));
            } else if (recordType == '2') {
                detailRecords.add(parseDetailRecord(record));
            } else if (recordType == '3') {
                trailerRecord = parseTrailerRecord(record);
            }
        }

        // Print parsed records for demonstration
        for (HeaderRecord header : headerRecords) {
            System.out.println(header);
        }
        for (DetailRecord detail : detailRecords) {
            System.out.println(detail);
        }
        if (trailerRecord != null) {
            System.out.println(trailerRecord);
        }
    }

    private static HeaderRecord parseHeaderRecord(String record) {
        return new HeaderRecord(
                record.substring(1, 9).trim(),   // Petrocan Header
                record.substring(9, 19).trim(),  // Customer Account Number
                record.substring(19, 51).trim(), // Customer Name
                record.substring(51, 53).trim(), // Header Creation Country Code
                record.substring(53, 59).trim(), // Header Creation Date
                record.substring(59, 60).trim()  // Header Currency
        );
    }

    private static DetailRecord parseDetailRecord(String record) {
        return new DetailRecord(
                record.substring(1, 7).trim(),    // Detail Card Number
                record.substring(7, 8).trim(),    // Filler
                record.substring(8, 10).trim(),   // Document Creation Country Code
                record.substring(10, 12).trim(),  // Document Year
                record.substring(12, 16).trim(),  // Document Month and Day
                record.substring(16, 20).trim(),  // Document Time
                record.substring(20, 44).trim(),  // Station Address
                record.substring(44, 46).trim(),  // Station Province
                record.substring(46, 49).trim(),  // Product Code
                record.substring(49, 64).trim(),  // Product Description
                record.substring(64, 76).trim(),  // Quantity
                record.substring(76, 88).trim(),  // Net Price
                record.substring(88, 94).trim(),  // FET Rate
                record.substring(94, 100).trim(), // PFT Rate
                record.substring(100, 109).trim(),// GST Amount
                record.substring(109, 118).trim(),// PST Amount
                record.substring(118, 129).trim(),// Amount
                record.substring(129, 139).trim(),// Miscellaneous
                record.substring(139, 145).trim(),// Odometer
                record.substring(145, 146).trim(),// Sales Type
                record.substring(146, 152).trim(),// Transaction Number
                record.substring(152, 157).trim(),// Broker Name
                record.substring(157, 167).trim(),// Station Number
                record.substring(167, 172).trim(),// Authorization ID
                record.substring(172, 182).trim(),// Call Origin City
                record.substring(182, 192).trim() // Call Destination City
        );
    }

    private static TrailerRecord parseTrailerRecord(String record) {
        return new TrailerRecord(
                record.substring(1, 8).trim(),   // Record Count
                record.substring(67, 77).trim(), // Tape Trailer Quantity
                record.substring(92, 100).trim(),// Total GST Amount
                record.substring(101, 109).trim(),// Total PST Amount
                record.substring(110, 120).trim(),// Total Amount
                record.substring(121, 131).trim() // Trailer Balance Amount
        );
    }
}

class HeaderRecord {
    String petrocanHeader;
    String customerAccountNumber;
    String customerName;
    String hdrCreCC;
    String hdrCreDT;
    String hdrCurrency;

    public HeaderRecord(String petrocanHeader, String customerAccountNumber, String customerName, String hdrCreCC, String hdrCreDT, String hdrCurrency) {
        this.petrocanHeader = petrocanHeader;
        this.customerAccountNumber = customerAccountNumber;
        this.customerName = customerName;
        this.hdrCreCC = hdrCreCC;
        this.hdrCreDT = hdrCreDT;
        this.hdrCurrency = hdrCurrency;
    }

    @Override
    public String toString() {
        return "HeaderRecord{" +
                "petrocanHeader='" + petrocanHeader + '\'' +
                ", customerAccountNumber='" + customerAccountNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", hdrCreCC='" + hdrCreCC + '\'' +
                ", hdrCreDT='" + hdrCreDT + '\'' +
                ", hdrCurrency='" + hdrCurrency + '\'' +
                '}';
    }
}

class DetailRecord {
    String dtlCard;
    String filler;
    String dtlDocCC;
    String docYY;
    String docMMDD;
    String dtlDocTime;
    String dtlStnAddr;
    String dtlStnPrv;
    String dtlPrdCd;
    String dtlPrdDesc;
    String dtlQty;
    String dtlNetPrice;
    String dtlFetRt;
    String dtlPftRt;
    String dtlGstAmt;
    String dtlPstAmt;
    String dtlAmt;
    String dtlMisc;
    String dtlOdometer;
    String dtlSlsType;
    String dtlTranNo;
    String dtlBrknName;
    String dtlStnNo;
    String dtlAuthID;
    String dtlCallOrigCity;
    String dtlCallDestCity;

    public DetailRecord(String dtlCard, String filler, String dtlDocCC, String docYY, String docMMDD, String dtlDocTime,
                        String dtlStnAddr, String dtlStnPrv, String dtlPrdCd, String dtlPrdDesc, String dtlQty, String dtlNetPrice,
                        String dtlFetRt, String dtlPftRt, String dtlGstAmt, String dtlPstAmt, String dtlAmt, String dtlMisc,
                        String dtlOdometer, String dtlSlsType, String dtlTranNo, String dtlBrknName, String dtlStnNo,
                        String dtlAuthID, String dtlCallOrigCity, String dtlCallDestCity) {
        this.dtlCard = dtlCard;
        this.filler = filler;
        this.dtlDocCC = dtlDocCC;
        this.docYY = docYY;
        this.docMMDD = docMMDD;
        this.dtlDocTime = dtlDocTime;
        this.dtlStnAddr = dtlStnAddr;
        this.dtlStnPrv = dtlStnPrv;
        this.dtlPrdCd = dtlPrdCd;
        this.dtlPrdDesc = dtlPrdDesc;
        this.dtlQty = dtlQty;
        this.dtlNetPrice = dtlNetPrice;
        this.dtlFetRt = dtlFetRt;
        this.dtlPftRt = dtlPftRt;
        this.dtlGstAmt = dtlGstAmt;
        this.dtlPstAmt = dtlPstAmt;
        this.dtlAmt = dtlAmt;
        this.dtlMisc = dtlMisc;
        this.dtlOdometer = dtlOdometer;
        this.dtlSlsType = dtlSlsType;
        this.dtlTranNo = dtlTranNo;
        this.dtlBrknName = dtlBrknName;
        this.dtlStnNo = dtlStnNo;
        this.dtlAuthID = dtlAuthID;
        this.dtlCallOrigCity = dtlCallOrigCity;
        this.dtlCallDestCity = dtlCallDestCity;
    }

    @Override
    public String toString() {
        return "DetailRecord{" +
                "dtlCard='" + dtlCard + '\'' +
                ", filler='" + filler + '\'' +
                ", dtlDocCC='" + dtlDocCC + '\'' +
                ", docYY='" + docYY + '\'' +
                ", docMMDD='" + docMMDD + '\'' +
                ", dtlDocTime='" + dtlDocTime + '\'' +
                ", dtlStnAddr='" + dtlStnAddr + '\'' +
                ", dtlStnPrv='" + dtlStnPrv + '\'' +
                ", dtlPrdCd='" + dtlPrdCd + '\'' +
                ", dtlPrdDesc='" + dtlPrdDesc + '\'' +
                ", dtlQty='" + dtlQty + '\'' +
                ", dtlNetPrice='" + dtlNetPrice + '\'' +
                ", dtlFetRt='" + dtlFetRt + '\'' +
                ", dtlPftRt='" + dtlPftRt + '\'' +
                ", dtlGstAmt='" + dtlGstAmt + '\'' +
                ", dtlPstAmt='" + dtlPstAmt + '\'' +
                ", dtlAmt='" + dtlAmt + '\'' +
                ", dtlMisc='" + dtlMisc + '\'' +
                ", dtlOdometer='" + dtlOdometer + '\'' +
                ", dtlSlsType='" + dtlSlsType + '\'' +
                ", dtlTranNo='" + dtlTranNo + '\'' +
                ", dtlBrknName='" + dtlBrknName + '\'' +
                ", dtlStnNo='" + dtlStnNo + '\'' +
                ", dtlAuthID='" + dtlAuthID + '\'' +
                ", dtlCallOrigCity='" + dtlCallOrigCity + '\'' +
                ", dtlCallDestCity='" + dtlCallDestCity + '\'' +
                '}';
    }
}

class TrailerRecord {
    String trlRecCount;
    String tapeTrlQty;
    String totalGstAmt;
    String totalPstAmt;
    String totalAmt;
    String trlBalAmt;

    public TrailerRecord(String trlRecCount, String tapeTrlQty, String totalGstAmt, String totalPstAmt, String totalAmt, String trlBalAmt) {
        this.trlRecCount = trlRecCount;
        this.tapeTrlQty = tapeTrlQty;
        this.totalGstAmt = totalGstAmt;
        this.totalPstAmt = totalPstAmt;
        this.totalAmt = totalAmt;
        this.trlBalAmt = trlBalAmt;
    }

    @Override
    public String toString() {
        return "TrailerRecord{" +
                "trlRecCount='" + trlRecCount + '\'' +
                ", tapeTrlQty='" + tapeTrlQty + '\'' +
                ", totalGstAmt='" + totalGstAmt + '\'' +
                ", totalPstAmt='" + totalPstAmt + '\'' +
                ", totalAmt='" + totalAmt + '\'' +
                ", trlBalAmt='" + trlBalAmt + '\'' +
                '}';
    }
}
