package racingcar.domain;

public class RaceCar {
    private static final Character CAR_MOVE_FORWARD_CHAR = '-';
    private String nameOfCar;
    private Integer cntMovementOfCar;
    private StringBuilder moveStateStr;


    public RaceCar() {
        this("");
    }

    public RaceCar(String nameOfRaceCar) {
        nameOfCar = nameOfRaceCar;
        cntMovementOfCar = 0;
        moveStateStr = new StringBuilder();
    }

    /**
     * ranNumOfSingleDigit 이 4이상 9이하면 자동차는 이동을 한다.
     *
     * @param ranNumOfSingleDigit 0 ~ 9의 랜덤 한자릿 숫자
     * @return
     */
    public void movementControlCar(Integer ranNumOfSingleDigit) {
        if (isMovementCondition(ranNumOfSingleDigit)) {
            moveForward();
        }
    }

    /**
     * 자동차의 움직여도 되는 조건 (4이상, 9이하)
     *
     * @param ranNumOfSingleDigit "4이상, 9이하"의 값
     * @return
     */
    private boolean isMovementCondition(Integer ranNumOfSingleDigit) {
        return ranNumOfSingleDigit >= 4 && ranNumOfSingleDigit <= 9;
    }

    /**
     * 차동차의 이동을 할때 "차의 이동량과 이동을 위한 출력문자"를 수정
     */
    public void moveForward() {
        // 이동시 전진 카운터 증가.
        cntMovementOfCar = cntMovementOfCar + 1;
        moveStateStr.append(CAR_MOVE_FORWARD_CHAR);
    }

    /**
     * 현재 자동차의 "이름"을 반환한다.
     *
     * @return
     */
    @Override
    public String toString() {
        return nameOfCar;
    }

    public String toStringMoveState() {
        return moveStateStr.toString();
    }

    public Integer getCntMovementOfCar() {
        return cntMovementOfCar;
    }
}
