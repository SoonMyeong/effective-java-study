package item34;

enum PayrollDay2 {

    //전략 열거 타입 패턴을 안쓸 시 아래 방식 혹은 책 코드 34-8 내용 처럼 CASE 문을 사용하여 해결 해야 함
    MONDAY{
        int pay(int minWorked, int payRate) {
            int basePay = minWorked * payRate;
            return basePay + (minWorked <= MINS_PER_SHIFT ? 0 : (minWorked - MINS_PER_SHIFT) * payRate / 2);
        }
    },
    TUESDAY{
        int pay(int minWorked, int payRate) {
            int basePay = minWorked * payRate;
            return basePay + (minWorked <= MINS_PER_SHIFT ? 0 : (minWorked - MINS_PER_SHIFT) * payRate / 2);
        }
    },
    SUNDAY{
        int pay(int minWorked, int payRate) {
            int basePay = minWorked * payRate;
            return basePay + (minWorked * payRate / 2);
        }
    };

    abstract int pay(int minWorked, int payRate);
    private static final int MINS_PER_SHIFT = 8 * 60;

}
