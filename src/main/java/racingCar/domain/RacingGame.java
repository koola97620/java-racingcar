package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import racingCar.view.OutputView;

public class RacingGame {

  private final String[] carNames;
  private final int tryCount;

  public RacingGame(String[] carNames, int tryCount) {
    this.carNames = carNames;
    this.tryCount = tryCount;
  }

  public List<Car> start(OutputView outputView) {
    Cars cars = makeCars(carNames);

    outputView.printResult();
    for (int i = 0; i < tryCount; i++) {
      cars.move(outputView);
      outputView.printEmptyLine();
    }

    return cars.determineWinners();
  }

  private Cars makeCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carNames.length; i++) {
      cars.add(new Car(carNames[i], 0));
    }
    return new Cars(cars);
  }


}
