cmake_minimum_required(VERSION 3.22)
project(tris LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

find_library(log-lib log)
find_library(android-lib android)
find_library(vulkan-lib vulkan)

add_library(tris SHARED
    ../BOOTLOADER/loader.cpp
)

target_include_directories(tris PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}/..
)

target_link_libraries(tris PRIVATE
    ${log-lib}
    ${android-lib}
    ${vulkan-lib}
)
