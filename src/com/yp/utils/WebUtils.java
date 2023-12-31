package com.yp.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            if (strInt != null && !"".equals(strInt)) {
                return Integer.parseInt(strInt);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static BigDecimal parseBigDecimal(String strDecimal, double defaultValue) {
        try {
            if (strDecimal != null && !"".equals(strDecimal)) {
                return BigDecimal.valueOf(Double.parseDouble(strDecimal));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return BigDecimal.valueOf(defaultValue);
    }


}
