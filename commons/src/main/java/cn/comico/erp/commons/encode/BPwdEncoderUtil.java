package cn.comico.erp.commons.encode;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BPwdEncoderUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 编码
     * @param source
     * @return
     */
    public static String encode(String source) {
        return encoder.encode(source);
    }

    /**
     * 验证
     * @param source
     * @param encodedSource
     * @return
     */
    public static boolean mmatches(CharSequence source, String encodedSource) {
        return encoder.matches(source, encodedSource);
    }

}
