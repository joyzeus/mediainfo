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
}