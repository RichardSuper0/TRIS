cmake_minimum_required(VERSION 3.22) project(trisvulkan) 
add_library(tris SHARED
    ../BOOTLOADER/loader.cpp ../ENGINE/main.asm ../ENGINE/gui.asm 
    ../ENGINE/logic.asm
) find_library(log-lib log) find_library(android-lib android) 
find_library(vulkan-lib vulkan) target_link_libraries(tris
    ${log-lib} ${android-lib} ${vulkan-lib} )
