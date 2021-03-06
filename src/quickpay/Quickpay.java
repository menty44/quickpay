  /* 
Make sure the downloaded quickpay.java file and it is in the classpath or has been added to referenced libraries if you are using an SDK like eclipse or netbeans
*/

package quickpay;

//import quickpay.QuickPay;
import quickpay.Quickpaygateway;
import org.json.JSONObject;

/**
 * @author
 */
public class Quickpay {

    public static void main(String[] args) {

//        Set up authenitication data. 
        String secretKey = "QPNR45RFEGG42G5TG42GT2GT";

//      Create new instance of gateway class
        Quickpaygateway qpay = new Quickpaygateway(secretKey);

//      Set up the valiables. 
        String orderInfo = "HYARET45DJO8ASD";
        String referenceNo = "ET45DJO8ASDH456YARO8ASD";
        int amount = 1278;
        String Card = "34Y6sy34ik3UU8DDJ32092J83R8H92DKSKD308";
        String Currency = "KES";

//     Call QuickPay method to charge customer
        try {
            JSONObject charge = qpay.pack(referenceNo, orderInfo, amount, Card, Currency);

            if (!charge.getString("responseCode").equals("00")) {
//            print out the response for success transaction. 
                System.out.println("Response received from payment server: "
                        + "Response Code: " + charge.getString("responseCode")
                        + "amount:" + charge.getString("amount")
                        + "authorisation Id: " + charge.getString("authID")
                        + "Reference No : " + charge.getString("tnxReference ")
                        + "receiptNo: " + charge.getString("receiptNo")
                );
            } else {
                System.out.println("Transaction failed with response code :" + charge.getString("responseCode"));
            }

        } catch (Exception e) {
            System.out.println("Experienced an error while charging " + e.getMessage());
        }
    } }