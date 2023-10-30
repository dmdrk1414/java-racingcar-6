package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameHostTest {
    private final int MOVE = 4;
    private final int STOP = 1;
    private GameHost gameHost;
    private RaceCar raceCar_1;
    private RaceCar raceCar_2;
    private RaceCar raceCar_3;

    private List<RaceCar> progressRaceCarList;

    @BeforeEach
    void setUp() {
        gameHost = new GameHost();
        raceCar_1 = new RaceCar("fir");
        raceCar_2 = new RaceCar("sec");
        raceCar_3 = new RaceCar("third");
        progressRaceCarList = List.of(raceCar_1, raceCar_2, raceCar_3);
    }

    private void moveRaceCar(RaceCar raceCar) {
        raceCar.movementControlCar(MOVE);
    }

    private void stopRaceCar(RaceCar raceCar) {
        raceCar.movementControlCar(STOP);
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._1 ")
    @Test
    void knowWinRaceCarsTest_1() {
        // given
        moveRaceCar(raceCar_1);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._2 ")
    @Test
    void knowWinRaceCarsTest_2() {
        // given
        moveRaceCar(raceCar_2);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_2));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._3 ")
    @Test
    void knowWinRaceCarsTest_3() {
        // given
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_3));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._4 ")
    @Test
    void knowWinRaceCarsTest_4() {
        // given
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1, raceCar_2));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._5 ")
    @Test
    void knowWinRaceCarsTest_5() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_3));
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다._6 ")
    @Test
    void knowWinRaceCarsTest_6() {
        // given
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);
        moveRaceCar(raceCar_1);

        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);
        moveRaceCar(raceCar_2);

        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);
        moveRaceCar(raceCar_3);

        // when
        List<RaceCar> result = gameHost.knowWinRaceCars(progressRaceCarList);

        // than
        assertThat(result).isEqualTo(List.of(raceCar_1, raceCar_2, raceCar_3));
    }

    @Test
    void getCntMaxMoveTest() {
    }
}