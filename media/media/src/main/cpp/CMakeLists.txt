cmake_minimum_required(VERSION 3.4.1)

include_directories(${CMAKE_SOURCE_DIR}/include)
file(GLOB source ./*.c ./*.cpp  )

add_library(ffmpeg_jni SHARED ${source})

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}")

target_link_libraries(ffmpeg_jni ffmpeg log z)