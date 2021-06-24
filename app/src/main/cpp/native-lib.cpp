#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/prctl.h>					// for prctl( PR_SET_NAME )
#include <android/log.h>
#include <android/native_window_jni.h>	// for native window JNI
#include <android/input.h>

#include <EGL/egl.h>
#include <EGL/eglext.h>
#include <GLES3/gl3.h>
#include <GLES3/gl3ext.h>
#include "gl_load.h"

static JavaVM *jVM;

int JNI_OnLoad(JavaVM* vm, void* reserved)
{
    JNIEnv *env;
    jVM = vm;
    if(vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK)
    {
        //ALOGE("Failed JNI_OnLoad");
        return -1;
    }

    return JNI_VERSION_1_4;
}


extern "C"
JNIEXPORT jlong JNICALL
Java_com_example_sample_GLES3JNILib_onCreate(JNIEnv *env, jclass clazz, jobject obj) {

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onDestroy(JNIEnv *env, jclass clazz, jlong handle) {
    // TODO: implement onDestroy()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onPause(JNIEnv *env, jclass clazz, jlong handle) {
    // TODO: implement onPause()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onResume(JNIEnv *env, jclass clazz, jlong handle) {
    // TODO: implement onResume()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onStart(JNIEnv *env, jclass clazz, jlong handle, jobject obj) {
    // TODO: implement onStart()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onStop(JNIEnv *env, jclass clazz, jlong handle) {
    // TODO: implement onStop()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onSurfaceChanged(JNIEnv *env, jclass clazz, jlong handle,
                                                     jobject s) {
    // TODO: implement onSurfaceChanged()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onSurfaceCreated(JNIEnv *env, jclass clazz, jlong handle,
                                                     jobject s) {
    // TODO: implement onSurfaceCreated()
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sample_GLES3JNILib_onSurfaceDestroyed(JNIEnv *env, jclass clazz, jlong handle) {
    // TODO: implement onSurfaceDestroyed()
}
