/*
 * Copyright (c) 2016 Onelight Studio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onelightstudio.olsutilsandroid;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by Sebastien BALARD on 19/04/2016.
 */
public class OLSLog {

    public enum OLSLogLevel {

        // default = info
        NONE(0, "none"), WTF(1, "wtf"), ERROR(2, "error"), WARN(3, "warn"), INFO(4, "info"), DEFAULT(4, "default"),
        DEBUG(5, "debug"), VERBOSE(6, "verbose"), ALL(7, "all");

        public static OLSLogLevel fromName(String pName) {
            OLSLogLevel result = null;
            for (OLSLogLevel vLogLevel : values()) {
                if (vLogLevel.mLevel.equals(pName.toLowerCase())) {
                    result = vLogLevel;
                    break;
                }
            }
            return result;
        }

        protected final int mValue;

        protected final String mLevel;

        OLSLogLevel(int pValue, String pLevel) {
            mValue = pValue;
            mLevel = pLevel;
        }
    }

    private static String TAG;

    private static OLSLogLevel mLevel;

    public static void initWith(@NonNull String pTag, @NonNull OLSLogLevel pLevel) {
        TAG = pTag;
        mLevel = pLevel;
        i("set OLSLog level to: " + mLevel);
    }

    public static void v(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.VERBOSE.mValue) {
            Log.v(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void v(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.VERBOSE.mValue) {
            Log.v(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    public static void d(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.DEBUG.mValue) {
            Log.d(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void d(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.DEBUG.mValue) {
            Log.d(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    public static void i(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.INFO.mValue) {
            Log.i(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void i(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.INFO.mValue) {
            Log.i(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    public static void w(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.WARN.mValue) {
            Log.w(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void w(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.WARN.mValue) {
            Log.w(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    public static void e(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.ERROR.mValue) {
            Log.e(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void e(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.ERROR.mValue) {
            Log.e(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    public static void wtf(String pMessage) {
        if (mLevel.mValue >= OLSLogLevel.WTF.mValue) {
            Log.wtf(TAG + getCallerName(), pMessage);
            //OLSCrashReportUtils.logMessage(getCallerName(), pMessage);
        }
    }

    public static void wtf(String pMessage, Throwable pThrowable) {
        if (mLevel.mValue >= OLSLogLevel.WTF.mValue) {
            Log.wtf(TAG + getCallerName(), pMessage + ": " + pThrowable.getMessage(), pThrowable);
            //OLSCrashReportUtils.catchException(pThrowable);
        }
    }

    private static String getCallerName() {
        return new Throwable().getStackTrace()[2].getClassName();
    }
}
