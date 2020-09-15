package com.halodoc;

public class DataTypeUtil {
    public static boolean isNumeric(Object o) {
        return isDouble(o);
    }

    public static boolean isInteger(Object o) {
        try {
            Integer.parseInt(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(Object o) {
        try {
            Long.parseLong(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFloat(Object o) {
        try {
            Float.parseFloat(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(Object o) {
        try {
            Double.parseDouble(String.valueOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBoolean(Object o) {
        try {
            String v = String.valueOf(o);
            return "true".equalsIgnoreCase(v) || "false".equalsIgnoreCase(v);
        } catch (Exception e) {
            return false;
        }
    }

    public static Class<?> getDataType(Object o) {
        if(DataTypeUtil.isNumeric(o)) {
            if (DataTypeUtil.isInteger(o)) {
                return Integer.class;
            }
            if (DataTypeUtil.isFloat(o)) {
                return Float.class;
            }
            if (DataTypeUtil.isLong(o)) {
                return Long.class;
            }
            if (DataTypeUtil.isDouble(o)) {
                return Double.class;
            }
        }
        if(DataTypeUtil.isBoolean(o)) {
            return Boolean.class;
        }
        return String.class;
    }
}
