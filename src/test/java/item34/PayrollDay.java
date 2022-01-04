package item34;


import static item34.PayrollDay.PayType.WEEKDAY;
import static item34.PayrollDay.PayType.WEEKEND;

public enum PayrollDay {
    MONDAY(WEEKDAY), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {this.payType = payType;}

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    //enum 안에 enum ?! 전략 열거 타입
    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minWorked, int payRate) {
            int basePay = minWorked * payRate;
            return basePay + overtimePay(minWorked, payRate);
        }
    }
}
