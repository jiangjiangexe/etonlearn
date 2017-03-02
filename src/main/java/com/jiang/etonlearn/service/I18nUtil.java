package com.jiang.etonlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class I18nUtil {

    private static final String INSERT_ERROR = "INSERT_ERROR";
    private static final String UPDATE_ERROR = "UPDATE_ERROR";
    private static final String DELETE_ERROR = "DELETE_ERROR";
    private static final String INSERT_SUCCESS = "INSERT_SUCCESS";
    private static final String UPDATE_SUCCESS = "UPDATE_SUCCESS";
    private static final String DELETE_SUCCESS = "DELETE_SUCCESS";
    public static final String INSERT_ = "INSERT_";
    public static final String UPDATE_ = "UPDATE_";
    public static final String DELETE_ = "DELETE_";

    private static MessageSource messageSource;

    /**
     * 依照key, args, locale取字串
     *
     * @param key
     * @param locale
     * @return
     */
    public static String get(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale);
    }

    /**
     * 依照key取字串
     *
     * @param key
     * @return
     */
    public static String getByKey(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return getByKeyAndLocale(key, locale);
    }

    /**
     * 依照key, args取字串
     *
     * @param key
     * @param args
     * @return
     */
    public static String getByKeyAndArgs(String key, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return get(key, args, locale);
    }

    /**
     * 依照key, locale取字串
     *
     * @param key
     * @param locale
     * @return
     */
    public static String getByKeyAndLocale(String key, Locale locale) {
        return get(key, null, locale);
    }


    /**
     * 依照key, locale取清單
     *
     * @param key
     * @param locale
     * @return
     */
    public static List<String> getList(String key, Locale locale) {
        return Arrays.asList(get(key, null, locale).split(","));
    }

    /**
     * 依照key取清單
     *
     * @param key
     * @return
     */
    public static List<String> getListByKey(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return getList(key, locale);
    }

    /**
     * 依照key, numArray取清單
     *
     * @param key
     * @param numbers
     * @return
     */
    public static List<String> getListByKeyAndNum(String key, int[] numbers) {
        Locale locale = LocaleContextHolder.getLocale();
        return getListByKeyAndNumAndLocale(key, numbers, locale);
    }

    /**
     * 依照key, numArray, locale取清單
     *
     * @param key
     * @param numbers
     * @param locale
     * @return
     */
    public static List<String> getListByKeyAndNumAndLocale(String key, int[] numbers, Locale locale) {
        List<String> list = getList(key, locale);
        List<String> returnList = new ArrayList<>();
        for (int num : numbers) {
            returnList.add(list.get(num));
        }
        return returnList;
    }

    /**
     * 依照key, num, locale取清單中的一筆
     *
     * @param key
     * @param number
     * @return
     */
    public static String getByKeyAndNumAndLocale(String key, int number, Locale locale) {
        return getList(key, locale).get(number);
    }

    /**
     * 依照key, num取清單中的一筆
     *
     * @param key
     * @param number
     * @return
     */
    public static String getByKeyAndNum(String key, int number) {
        Locale locale = LocaleContextHolder.getLocale();
        return getByKeyAndNumAndLocale(key, number, locale);
    }

    public static String Insert(Object arg) {
        return get(INSERT_, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showUpdate(Object arg) {
        return get(UPDATE_, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showDelete(Object arg) {
        return get(DELETE_, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showInsertError(Object arg) {
        return get(INSERT_ERROR, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showUpdateError(Object arg) {
        return get(UPDATE_ERROR, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showDeleteError(Object arg) {
        return get(DELETE_ERROR, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showInsertSuccess(Object arg) {
        return get(INSERT_SUCCESS, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showUpdateSuccess(Object arg) {
        return get(UPDATE_SUCCESS, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    public static String showDeleteSuccess(Object arg) {
        return get(DELETE_SUCCESS, new Object[]{arg}, LocaleContextHolder.getLocale());
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        I18nUtil.messageSource = messageSource;
    }
}
