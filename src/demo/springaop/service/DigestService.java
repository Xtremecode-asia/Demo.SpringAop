package demo.springaop.service;

import demo.springaop.service.messages.DigestRequest;
import demo.springaop.service.messages.DigestResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/16/12
 * Time: 3:20 PM
 */

@Service
public class DigestService implements IDigestService {
    @Override
    public DigestResponse digest(DigestRequest request) {
        MessageDigest messageDigest = DigestUtils.getDigest(request.getHashAlgorithm());
        messageDigest.update(request.getPlainString().getBytes());
        byte[] digestedBytes = messageDigest.digest();
        return new DigestResponse(Base64.encodeBase64String(digestedBytes));
    }
}
