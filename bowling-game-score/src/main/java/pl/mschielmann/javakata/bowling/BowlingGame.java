package pl.mschielmann.javakata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame
{
    List<Integer> balls = new ArrayList<>();
    List<Frame> frames = new ArrayList<>();
    int currentFrame = 0;

    public BowlingGame()
    {
        frames.add(new Frame());
    }

    public int currentScore()
    {
        return frames.get(currentFrame).getScore();
    }

    public void registerScoreForBall(int i)
    {
        balls.add(i);
        frames.get(currentFrame).addFrameBallScore(i);
    }

    private class Frame
    {
        private int score = 0;
        private int numberOfBalls = 0;

        private void addFrameBallScore(int frameBallScore)
        {
            numberOfBalls++;
            score += frameBallScore;
        }

        private int getScore()
        {
            if (isStrike()) {
                return 0;
            }
            if (isSpare()) {
                return 0;
            }
            if (frameNotFinished()) {
                return 0;
            }
            return score;
        }

        private boolean isStrike()
        {
            return score == 10 && numberOfBalls == 1;
        }

        private boolean isSpare()
        {
            return score == 10 && numberOfBalls == 2;
        }

        private boolean frameNotFinished() {
            return score < 10 && numberOfBalls < 2;
        }
    }
}
