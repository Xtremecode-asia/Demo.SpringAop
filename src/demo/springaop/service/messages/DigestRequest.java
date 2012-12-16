package demo.springaop.service.messages;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/16/12
 * Time: 6:59 PM
 */
public class DigestRequest {
    private String plainString;
    private String hashAlgorithm;

    public DigestRequest(String plainString, String hashAlgorithm) {
        this.plainString = plainString;
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getPlainString() {
        return plainString;
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }
}
