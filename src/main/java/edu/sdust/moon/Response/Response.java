package edu.sdust.moon.Response;

import java.util.Base64;

/**
 * Response 的抽象类
 */
public abstract class Response {
    protected static final Base64.Decoder decoder = Base64.getDecoder();
}
