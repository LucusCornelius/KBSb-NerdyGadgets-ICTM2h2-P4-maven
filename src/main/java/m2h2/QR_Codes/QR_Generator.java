package m2h2.QR_Codes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class QR_Generator {


    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
            throws WriterException, IOException
    {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }

//    public static void main(String[] args)
//            throws WriterException, IOException,
//            NotFoundException
//    {
//
//        // The data that the QR code will contain
//        String data = "http://www.reallylong.link/rll/g6HJPNMeUHccigUAVzHlYTalDuo79vRKjS2ntqcyXJemUdVPYPJSqwk3FMDUHV35HRPiQv8JUk1Tw1LexZjfWpwr5Ws8z5vnLmx_3keUGqKEsGA0nODHNavH7/v7dex5JQ5IDcheprb_oiu0mBOxvdt6F69GShy1pyteBBXjV3j6ExUtX8hU1K_r5xOtelc6U6J8JZ3jynGVNIYPM11D/usi2/nYQ/OTjh/Kl6MSNp5ciBwju03TlYx/CyogDcWGVdwutYTduU8BbDLkzUBVBr36pZnbR_3v7rdBbNTEwfYsJa4j2/mXLgCR/rcsWaIJZVRSD3OZFXu0hzAGUzUOkvzuPMnHUh_8Y8Z3pGZyM2H6EwwUZFjYaXhYGbuqnRbaJ5f6diNwzg/3Y7qYkrOUpObKX5_pexdJNKQvOPMIqY75jOnSPQuAMtzQe7FRZzy4ixcbf/lvNUEglsDb3CuTaBd2QLPy8noJBBwWkROrh022pnUK8noGoPAZDHQRR1XIw3RlVovjkmq_AjFXSj2G0uy2yad02drxYKXJZzzwVG4ev3GLPIlDjri8KuLnvQWODpdv8NVQWc6VRoUHGX5qE7A_5BZ1XhfVHxa5tNtwOsCjIxa6yoSABDqW9n7Uf80BRtpnii00EYdq9hMIsngDKToHH86pwSxHtVuO_NDKCor8Or7LX1C7Zej3L7XJ4hG3qlN9zvpfuyTZqZX/3P67AjEJll1GQ29kg/Hx7stvDtuKjgX4ffMsJquIqiqse2uMAN8L5LIKpCdb6KzxfiXrrRpEC7x3hl19ynK0NypCxG9UKgka8BuDJKSWj_Pvm/XySYWf43uoFLAlXy6_W8RfjlXdxnASk8mQ7HNBe9dszkRGUiL92469LmWFm0IGKk_wfEoe5MQaxCxH6CHN84J7M3c0eLaW4dWm4dCCum7MtXFwNDSEh2ikh4F0OKzTcZYkrsA6pmeilOh9Uat_l/uk0PUBySi3zbF7WP6rdh/rEvr_8rSIVVfNu8dvEBH4MnvYwV6wwydEILSqI_qXDT6VmPTLvneMyuzjXmhFh_GAJCNkvWsyb5/EjE45SI454JtbrTz1egnxl1Hr_/ndWwsKOjQ3mCouEn3CwMRNkVlxo80Jm_EK7cgX_TijYVQCFU1oa4usz1vgDD_qWOS1LFaI8Wqbx0_c2n3u2H1tLFD_dIEP9uDJOLMWFH5wzRU_gWe8V74Vsyc5v_qpeER8jyv8/0jftEybfPnVdd2h8OFgt2IIWNFRT1MT5IoUGJ_2FoLNfnV6PzJX/YPV64fAlGXvpMneLdbRNDCIJQtyxHpWUTtnmI5ImhuJGCsClTS7oMM6Ifn1qckbDZyeR15aI0zXT2x_7U1aJMJGyU7ERIwIq3UbcfkC3AwIkadzFxzloBixe_Ate_Gt9APieZg7lSMMN/y6MVHvCi6BVoJT9LE_T3BuyHzla_AidRehp6FlZSoCdSjAmZb4Ndp7ZTghG2_9OggcXc7C8el6mg7JniXcfIG2YIV29/OHGvravSN6iSio_dkiqajl6B/S/KV/H_U1z36_/gnvZc_ilPHA0jr4GAjBmbAe0LQo7lr3FwsGqF/Lbx6Bbc5Njb3Nq441whaqcuDveQxCpZPVyq97k6FGS4tSNJVFFLKO88QPRpSqm3bnRgINA_VQG0DEWj/sgWyuHjp6z/RzfxyTikxovxzBT/72OdQicLXE2XBlZUwvjELnsqyYsNq3OYZ5AtibPu8XXqzxHlkNZ9hQ2MTG_Ash29XU_T8fCV51DV4gSS/pHr6PEJFQ8drKyEg8x_c5zwij8YBbw79ahPSyTyeEvxjOvGMGdP36wI9fRqRPoMFz2_81SfDjA1nPOaT7hesmPy9RLqNVB1/xP/IoKbqPznxvdPJ4a5FGPEcuNcEW0YcoQJkbACCu3Lyj0EzA2LtmJvoBt5HhDHUAuQPdmED8zwXiS4QcOKa";
//
//        // The path where the image will get saved
//        String path = "demo.png";
//
//        // Encoding charset
//        String charset = "UTF-8";
//
//        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
//                = new HashMap<EncodeHintType,
//                ErrorCorrectionLevel>();
//
//        hashMap.put(EncodeHintType.ERROR_CORRECTION,
//                ErrorCorrectionLevel.L);
//
//        // Create the QR code and save
//        // in the specified folder
//        // as a jpg file
//        createQR(data, path, charset, hashMap, 400, 400);
//        System.out.println("QR Code Generated ");
//    }



}
