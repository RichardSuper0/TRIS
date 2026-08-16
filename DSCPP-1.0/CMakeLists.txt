cmake_minimum_required(VERSION 3.10)
project(DSCPP)

set(CMAKE_CXX_STANDARD 20)

set(DSCPP_ROOT_DIR ${CMAKE_CURRENT_SOURCE_DIR})

set(DSCPP_INCLUDE_DIR ${DSCPP_ROOT_DIR}/include)
set(DSCPP_LIBHPP_DIR ${DSCPP_ROOT_DIR}/lib-hpp)
set(DSCPP_LIBRARY_DIR ${DSCPP_ROOT_DIR}/library)

include_directories(${DSCPP_INCLUDE_DIR})
include_directories(${DSCPP_LIBHPP_DIR})

file(GLOB DSCPP_SOURCES "${DSCPP_LIBRARY_DIR}/*.cpp")

add_library(dscpp STATIC ${DSCPP_SOURCES})