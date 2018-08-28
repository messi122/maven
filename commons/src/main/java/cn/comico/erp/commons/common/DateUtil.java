package cn.comico.erp.commons.common;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName DateUtil
 * @Description TODO
 * @date 2018/7/23 17:44
 **/
public class DateUtil {

    private final static Logger log = LoggerFactory.getLogger(DateUtil.class);

    /**
    * 
    * @author      changhuanhu
    * @Description 格式化时间
    * @Param [date, pattern]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 17:45
    **/
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 解析时间
    * @Param [dateStr, pattern]
    * @exception   
    * @return      java.util.Date
    * @Date 2018/7/23 17:48
    **/
    public static Date parse(String dateStr, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            log.error(e.getMessage());
        }
        return date;
    }

    /**
    *
    * @author      changhuanhu
    * @Description 指定时间的某个域加减运算
    * @Param [date, field, amount]
    * @exception
    * @return      java.util.Date
    * @Date 2018/7/23 17:51
    **/
    public static Date add(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取当前时间
    * @Param []
    * @exception   
    * @return      java.util.Date
    * @Date 2018/7/23 17:52
    **/
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取当前年月日
    * @Param []
    * @exception
    * @return      java.lang.String
    * @Date 2018/7/23 18:12
    **/
    public static String getDay() {
        return format(getCurrentDate(), "yyMMdd");
    }

    public static Date getDate(String dateStr, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return date;
    }

    public static int getMonth(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String dateStr = sdf.format(date);
        return Integer.parseInt(dateStr);
    }

    /**
     * 获得当前天的开始时间
     * getDay:().
     * TODO().
     *
     * @author changhuanhu
     * @return
     * @since JDK 1.8
     */
    public static int getDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(date);
        return Integer.parseInt(dateStr);
    }

    /**
     * 获得某年初始日期
     * getDateByYear:().
     * TODO().
     *
     * @author changhuanhu
     * @param year
     * @return
     * @since JDK 1.8
     */
    public static Date getDateByYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 0, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得当前时间月开始时间
     * getMonthOfStartDate:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static Date getMonthOfStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取两个日期相差的自然周数
     * getWeek:().
     * TODO().
     *
     * @author changhuanhu
     * @param startDate
     * @param endDate
     * @return
     * @since JDK 1.8
     */
    public static int getWeek(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        int week1 = startCal.get(Calendar.DAY_OF_WEEK);
        int day1 = getDiffDay(week1);
        startCal.add(Calendar.DATE, day1);
        startCal.set(startCal.get(Calendar.YEAR), startCal.get(Calendar.MONTH), startCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int week2 = endCal.get(Calendar.DAY_OF_WEEK);
        int day2 = getDiffDay(week2);
        endCal.add(Calendar.DATE, day2);
        endCal.set(endCal.get(Calendar.YEAR), endCal.get(Calendar.MONTH), endCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

        int diffWeek = (int) ((endCal.getTimeInMillis() - startCal.getTimeInMillis()) * 1.0 / (7 * 24 * 3600000));

        return diffWeek + 1;
    }

    /**
     * 获取指定时间，指定前几周的时间
     * getBeforeWeek:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @param lastWeek
     * @return
     * @since JDK 1.8
     */
    public static Date getBeforeWeek(Date date, int lastWeek) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int day = getDiffDay(week);
        cal.add(Calendar.DATE, day);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, -(lastWeek-1) * 7);
        return cal.getTime();
    }

    private static int getDiffDay(int week) {
        int day = 0;
        switch (week) {
            case 1:
                day = -6;
                break;
            case 2:
                day = 0;
                break;
            case 3:
                day = -1;
                break;
            case 4:
                day = -2;
                break;
            case 5:
                day = -3;
                break;
            case 6:
                day = -4;
                break;
            case 7:
                day = -5;
                break;
            default:
                break;
        }
        return day;
    }

    /**
     * 获取年份
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获得当前季度开始时间
     * @param date
     * @return
     */
    public static Date getSeasonOfSatrtDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if (month < 3) {
            month = 0;
        } else if (month <6) {
            month = 3;
        } else if (month < 9) {
            month = 6;
        } else if (month < 12) {
            month = 9;
        }
        calendar.set(calendar.get(Calendar.YEAR), month, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得当前季度表示
     * @param date
     * @return
     */
    public static int getSeason(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int season = (int) Math.floor(((month + 3) * 1.0 / 3));
        return Integer.valueOf(year + "" + season);
    }

    /**
     * 获得当前时间在年度属于多少周
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        return Integer.valueOf(year + "" + week);
    }

    /**
     * 获得当前时间开始年度时间
     * getYearOfStartDate:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static Date getYearOfStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得一周的开始时间
     * getWeekOfSatrtDate:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static Date getWeekOfSatrtDate(Date date) {
        return getBeforeWeek(date, 1);
    }

    /**
     * 获得field时间
     * getField:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @param field
     * @return
     * @since JDK 1.8
     */
    public static int getField(Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    /**
     * 获得期数前开始日期
     * getStartDateOfPeriod:().
     * TODO().
     *
     * @author changhuanhu
     * @param date, periodDay
     * @return
     * @since JDK 1.8
     */
    public static Date getStartDateOfPeriod(Date date, int periodDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth >= periodDay) {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), periodDay, 0, 0, 0);
        } else {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, periodDay, 0, 0, 0);
        }
        calendar.set(Calendar.MILLISECOND, 0);
        return  calendar.getTime();
    }

    /**
     * 获得财务周期期数
     * getPeriod:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static int getPeriod(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(DateUtil.add(date, Calendar.MONTH, 1));
        return Integer.valueOf(format);
    }

    /**
     * 获得财务周期期数
     * getFinancePeriod:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static int getFinancePeriod(Date date, int periodDay) {
        return getPeriod(DateUtil.getStartDateOfPeriod(date, periodDay));

    }

    /**
     * 查询上期整数表示形式
     * getLastPeriod:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static int getLastPeriod(Date date) {
        return getMonth(DateUtil.add(date, Calendar.MONTH, -1));
    }

    public static int getMonthDiff(Date d1, Date d2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(d1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(d2);

        int year1 = calendar1.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);

        int year2 = calendar2.get(Calendar.YEAR);
        int month2 = calendar2.get(Calendar.MONTH);

        return (year2 - year1) * 12 + (month2 - month1);
    }

    public static Date getStartDateOfPeriod(int period, int periodDay) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            date = sdf.parse(String.valueOf(period));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), periodDay, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.add(Calendar.MONTH, -1);
            date = calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获得一天的开始时间
     * @param date
     * @return
     */
    public static Date getStartDateOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 转换为timestamp
     * getTimestamp:().
     * TODO().
     *
     * @author changhuanhu
     * @param date
     * @return
     * @since JDK 1.8
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(((Date) date).getTime());
    }

    /**
     * 获取两个日期相差的天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static BigDecimal getDiffDay(Date startDate, Date endDate, int scale, int mode) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        long endMillis = calendar.getTimeInMillis();
        calendar.setTime(startDate);
        long startMillis = calendar.getTimeInMillis();
        return new BigDecimal(String.valueOf(endMillis - startMillis))
                .divide(new BigDecimal(String.valueOf(24 * 60 * 60 * 1000l)), scale, mode);
    }

    /**
     * 获取两个日期相差的周数（7天为一周）
     * @param startDate
     * @param endDate
     * @return
     */
    public static BigDecimal getDiffWeek(Date startDate, Date endDate, int scale, int mode) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        long endMillis = calendar.getTimeInMillis();
        calendar.setTime(startDate);
        long startMillis = calendar.getTimeInMillis();
        return new BigDecimal(String.valueOf(endMillis - startMillis))
                .divide(new BigDecimal(String.valueOf(7 * 24 * 60 * 60 * 1000l)), scale, mode);
    }

    /**
     * 获取两个日期相差的月数（30天为一月）
     * @param startDate
     * @param endDate
     * @return
     */
    public static BigDecimal getDiffMonth(Date startDate, Date endDate, int scale, int mode) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        long endMillis = calendar.getTimeInMillis();
        calendar.setTime(startDate);
        long startMillis = calendar.getTimeInMillis();
        return new BigDecimal(String.valueOf(endMillis - startMillis))
                .divide(new BigDecimal(String.valueOf(30 * 24 * 60 * 60 * 1000l)), scale, mode);
    }

    /**
    * 
    * @author      changhuanhu
    * @Description date 转 calendar
    * @Param [date]
    * @exception   
    * @return      java.util.Calendar
    * @Date 2018/8/2 18:45
    **/
    public static Calendar dateToCalednar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取时间段内的周表示
    * @Param [startDate, endDate]
    * @exception   
    * @return      java.lang.String[]
    * @Date 2018/8/2 18:46
    **/
    public static String[] getWeekArray(Date startDate, Date endDate) {
        List<String> nameList = new ArrayList<String>();
        Calendar startCalendar = dateToCalednar(startDate);
        Calendar endCalendar = dateToCalednar(endDate);
        while (startCalendar.before(endCalendar)) {
            nameList.add(String.valueOf(startCalendar.get(Calendar.YEAR) + "-" + startCalendar.get(Calendar.WEEK_OF_YEAR)));
            startCalendar.add(Calendar.WEEK_OF_YEAR, 1);
        }
        return nameList.toArray(new String[] {});

    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取时间段内的季节表示
    * @Param [startDate, endDate]
    * @exception   
    * @return      java.lang.String[]
    * @Date 2018/8/2 18:46
    **/
    public static String[] getSeasonArray(Date startDate, Date endDate) {
        List<String> nameList = new ArrayList<String>();
        Calendar startCalendar = dateToCalednar(startDate);
        Calendar endCalendar = dateToCalednar(endDate);
        int year = startCalendar.get(Calendar.YEAR);
        int season = (int) Math.floor((startCalendar.get(Calendar.MONTH) + 3) / 3);
        int endYear = endCalendar.get(Calendar.YEAR);
        int endSeason = (int) Math.floor((endCalendar.get(Calendar.MONTH) + 3) / 3);
        while (year < endYear || (year == endYear && season <= endSeason)) {
            nameList.add(String.valueOf(year) + "-" + season);
            if (season == 4) {
                season = 1;
                year++;
            } else {
                season++;
            }
        }
        return nameList.toArray(new String[] {});
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取时间段内的月份表示
    * @Param [startDate, endDate]
    * @exception   
    * @return      java.lang.String[]
    * @Date 2018/8/2 18:46
    **/
    public static String[] getMonthArray(Date startDate, Date endDate) {
        List<String> nameList = new ArrayList<String>();
        while (startDate.before(endDate)) {
            nameList.add(format(startDate, "yyyy-MM"));
            startDate = add(startDate, Calendar.MONTH, 1);
        }
        return nameList.toArray(new String[] {});
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取时间段内的年份表示
    * @Param [startDate, endDate]
    * @exception   
    * @return      java.lang.String[]
    * @Date 2018/8/2 18:47
    **/
    public static String[] getYearArray(Date startDate, Date endDate) {
        List<String> nameList = new ArrayList<String>();
        while (startDate.before(endDate)) {
            nameList.add(format(startDate, "yyyy"));
            startDate = add(startDate, Calendar.YEAR, 1);
        }
        return nameList.toArray(new String[] {});
    }

    /**
    * @author yuyong
    * @Description 获取前N周的周一时间
    * @param [date]
    * @return java.util.Date
    * @date 2018/8/7 16:41
    */
    public static Date getManyWeekMonday(Date date,int weeks) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.add(Calendar.WEEK_OF_YEAR, -1*weeks);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return cal.getTime();
    }

    /**
    * @author yuyong
    * @Description  获取上周末日期
    * @param [date]
    * @return java.util.Date
    * @date 2018/8/7 16:42
    */
    public static Date  getLastWeekSunday(Date date) {
        Date a = DateUtils.addDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(a);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        return cal.getTime();
    }


    public static void main(String[] args) {
        String[] weekArray = getWeekArray(getDate("2018-01-01", "yyyy-MM-dd"), getDate("2018-08-02", "yyyy-MM-dd"));
        Arrays.asList(weekArray).forEach(System.out::println);

    }
}
