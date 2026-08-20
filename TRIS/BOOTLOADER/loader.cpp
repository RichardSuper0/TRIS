#include <jni.h>
#include <android/native_window_jni.h>
#include "../CMAKE/vulkan_engine.h"   // se lo metti in CMAKE/
                                      // oppure cambia path

                                      extern "C" void tris_init();
                                      extern "C" void tris_update(float dt);

                                      extern "C" JNIEXPORT void JNICALL
                                      Java_tris_bootloader_nativeInit(JNIEnv* env, jobject thiz, jobject surface) {
                                          ANativeWindow* win = ANativeWindow_fromSurface(env, surface);

                                              // Inizializza Vulkan
                                                  vulkan_init(win);

                                                      // Inizializza ASM
                                                          tris_init();
                                                          }

                                                          extern "C" JNIEXPORT void JNICALL
                                                          Java_tris_bootloader_nativeFrame(JNIEnv* env, jobject thiz, jfloat dt) {
                                                              // Logica ASM
                                                                  tris_update(dt);

                                                                      // Render Vulkan
                                                                          vulkan_draw_frame();
                                                                          }