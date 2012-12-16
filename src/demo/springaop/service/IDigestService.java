package demo.springaop.service;

import demo.springaop.service.messages.DigestRequest;
import demo.springaop.service.messages.DigestResponse;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/16/12
 * Time: 3:19 PM
 */
public interface IDigestService {
    public DigestResponse digest(DigestRequest request);
}
