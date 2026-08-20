cmake_minimum_required(VERSION 3.22) project(trisvulkan) 
add_library(tris SHARED
    ../BOOTLOADER/loader.cpp ../ENGINE/main.asm ../ENGINE/gui.asm 
    ../ENGINE/logic.asm
) find_library(log-lib log) find_library(android-lib android) 
find_library(vulkan-lib vulkan) target_link_libraries(tris
    ${log-lib} ${android-lib} ${vulkan-lib} ) EOF cat > 
TRIS/CMAKE/build.xml <<EOF <!-- build.xml — opzionale --> <!-- 
TODO: gradle wrapper --> EOF
# === ENGINE (ASM) ===
cat > TRIS/ENGINE/main.asm <<EOF
// main.asm — entry ASM
.global tris_init .global tris_update tris_init: ret tris_update: 
    ret
EOF cat > TRIS/ENGINE/gui.asm <<EOF
// gui.asm — rendering logic ASM
EOF cat > TRIS/ENGINE/logic.asm <<EOF
// logic.asm — logica tris + bot ASM
