package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHost {
    JudgeStandard judgeStandard;

    public GameHost() {
        this.judgeStandard = new JudgeStandard();
    }

    /**
     * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
     *
     * @param progressCarList   현제 진행중인 RaceCarList
     * @param numOfWinCondition 승리를 위한 조건 (입력 진행숫자)
     * @return
     */
    public List<RaceCar> winRaceCar(List<RaceCar> progressCarList, Integer numOfWinCondition) {
        List<RaceCar> winRaceCarList = new ArrayList<>();
        int cntOfMaxMove = getCntMaxMove(progressCarList);

        for (RaceCar raceCar : progressCarList) {
            // 전진 카운터가 입력한만큼있으면
            if (judgeStandard.isVictoryCondition(raceCar, cntOfMaxMove)) {
                winRaceCarList.add(raceCar);
            }
        }
        return winRaceCarList;
    }

    /**
     * 현제 RaceCarList의 RaceCar의 움직인 횟수중에
     * 최고로 많은 횟수를 알려준다.
     *
     * @param progressCarList
     * @return
     */
    private Integer getCntMaxMove(List<RaceCar> progressCarList) {
        int max = progressCarList.stream()
                .mapToInt(RaceCar::getCntMovementOfCar)
                .max()
                .orElse(0);
        return max;
    }
}
