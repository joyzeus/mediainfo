//
// Created by jay on 2019/6/24.
//
#include "ffmpeg_jni.h"

extern "C"
JNIEXPORT void JNICALL
Java_com_jay_ffmpeg_FfmpegJni_init(JNIEnv *env, jclass type) {

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avCodecConfiguration(JNIEnv *env, jclass type) {
    return env->NewStringUTF(avcodec_configuration());
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avFormatInfo(JNIEnv *env, jclass type) {
    char info[40000] = {0};
    AVInputFormat *if_temp = av_iformat_next(NULL);
    AVOutputFormat *of_temp = av_oformat_next(NULL);

    while (if_temp != NULL) {
        sprintf(info, "%s[In ][%10s]\n", info, if_temp->name);
        if_temp = if_temp->next;
    }

    while (of_temp != NULL) {
        sprintf(info, "%s[Out][%10s]\n", info, of_temp->name);
        of_temp = of_temp->next;
    }
    return env->NewStringUTF(info);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avCodecInfo(JNIEnv *env, jclass type) {

    char info[40000] = {0};
    AVCodec *c_temp = av_codec_next(NULL);
    while (c_temp != NULL) {
        if (c_temp->decode != NULL) {
            sprintf(info, "%s[Dec]", info);
        } else {
            sprintf(info, "%s[Enc]", info);
        }
        switch (c_temp->type) {
            case AVMEDIA_TYPE_VIDEO:
                sprintf(info, "%s[Video]", info);
                break;
            case AVMEDIA_TYPE_AUDIO:
                sprintf(info, "%s[Audio]", info);
                break;
            default:
                sprintf(info, "%s[Other]", info);
                break;
        }
        sprintf(info, "%s[%10s]\n", info, c_temp->name);
        c_temp = c_temp->next;
    }
    //LOGE("%s", info);

    return env->NewStringUTF(info);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avFilterInfo(JNIEnv *env, jclass type) {
    char info[400000] = {0};
    AVFilter *f_temp = (AVFilter *) avfilter_next(NULL);
    while (f_temp != NULL) {
        sprintf(info, "%s[%10s]\n", info, f_temp->name);
        f_temp = f_temp->next;
    }
    //LOGE("%s", info);

    return env->NewStringUTF(info);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avProtocolInfo(JNIEnv *env, jclass type) {

    char info[40000] = {0};
    struct URLProtocol *pup = NULL;
    //Input
    struct URLProtocol **p_temp = &pup;
    avio_enum_protocols((void **) p_temp, 0);
    while ((*p_temp) != NULL) {
        sprintf(info, "%s[In ][%10s]\n", info, avio_enum_protocols((void **) p_temp, 0));
    }
    pup = NULL;
    //Output
    avio_enum_protocols((void **) p_temp, 1);
    while ((*p_temp) != NULL) {
        sprintf(info, "%s[Out][%10s]\n", info, avio_enum_protocols((void **) p_temp, 1));
    }

    //LOGE("%s", info);
    return env->NewStringUTF(info);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_avConfigurationInfo(JNIEnv *env, jclass type) {
    char info[10000] = {0};
    sprintf(info, "%s\n", avcodec_configuration());
    return env->NewStringUTF(info);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegJni_ffmpegVersion(JNIEnv *env, jclass type) {

    return env->NewStringUTF("");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_jay_ffmpeg_FfmpegFormat_getFileFormat(JNIEnv *env, jclass type, jstring filePath_) {
    const char *filePath = env->GetStringUTFChars(filePath_, 0);

// TODO

    env->ReleaseStringUTFChars(filePath_, filePath);

    return env->NewStringUTF("");
}