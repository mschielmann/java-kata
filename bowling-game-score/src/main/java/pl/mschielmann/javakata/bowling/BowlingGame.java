package pl.mschielmann.javakata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame
{
    List<Integer> balls = new ArrayList<>();
    public int currentScore()
    {
        return 0;
    }

    public void registerScoreForBall(int i)
    {
        balls.add(i);
    }
}
