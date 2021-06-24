LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := native-lib

LOCAL_C_INCLUDES := \
 $(TOP_DIR)/ \
 $(TOP_DIR)/GLFW/

LOCAL_SRC_FILES = \
	native-lib.cpp

include $(BUILD_SHARED_LIBRARY)
