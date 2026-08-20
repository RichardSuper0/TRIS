#include <jni.h>
#include <android/native_window.h>
#include <android/native_window_jni.h>

#include "../CMAKE/vulkan_engine.h"

extern "C" void tris_init();
extern "C" void tris_update(float dt);

extern "C" JNIEXPORT void JNICALL
Java_tris_bootloader_nativeInit(JNIEnv* env, jobject thiz, jobject surface) {
    (void)thiz;

    if (surface == nullptr) {
        return;
    }

    ANativeWindow* window = ANativeWindow_fromSurface(env, surface);
    if (window != nullptr) {
        vulkan_init(window);
        ANativeWindow_release(window);
    }

    tris_init();
}

extern "C" JNIEXPORT void JNICALL
Java_tris_bootloader_nativeFrame(JNIEnv* env, jobject thiz, jfloat dt) {
    (void)env;
    (void)thiz;

    tris_update(dt);
    vulkan_draw_frame();
}