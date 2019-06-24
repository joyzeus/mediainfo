package com.jay.ffmpeg;

/**
 * @ProjectName: TikTok$
 * @Package: com.jay.medialib$
 * @ClassName: FfmpegJni$
 * @Author: zhouxu
 * @CreateDate: 2019/6/24$ 10:38$
 * @Version: 1.0
 */
public class FfmpegJni {

    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeg_jni");
    }

    public static native void init();

    public static native String avCodecConfiguration();

    public static native String avFormatInfo();

    public static native String avCodecInfo();

    public static native String avFilterInfo();

    public static native String avProtocolInfo();

    public static native String avConfigurationInfo();

    public static native String ffmpegVersion();
}
