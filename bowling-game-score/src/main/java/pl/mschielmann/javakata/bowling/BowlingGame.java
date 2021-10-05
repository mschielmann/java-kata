package pl.mschielmann.javakata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame
{
    List<Frame> frames = new ArrayList<>();
    LastFrame lastFrame;
    int currentFrame = 0;

    public BowlingGame()
    {
        frames.add(new Frame());
    }

    public int currentScore()
    {
        int sum = 0;
        for (Frame frame : frames)
        {
            sum += frame.getScore();
        }
        if (lastFrame != null)
        {
            sum += lastFrame.getScore();
        }
        return sum;
    }

    public void registerScoreForBall(int score)
    {
        int previousFrameIndex = currentFrame - 1;
        int secondPreviousFrameIndex = currentFrame - 2;
        if (frameAwaitsScore(previousFrameIndex))
        {
            frames.get(previousFrameIndex).addBonusBallScore(score);
        }
        if (frameAwaitsScore(secondPreviousFrameIndex))
        {
            frames.get(secondPreviousFrameIndex).addBonusBallScore(score);
        }
        if (currentFrameIsRegular())
        {
            frames.get(currentFrame).addFrameBallScore(score);
            createNewFrame();
        }
        else
        {
            lastFrame.addFrameBallScore(score);
        }
    }

    private void createNewFrame()
    {
        if (frames.get(currentFrame).isFinished())
        {
            if (currentFrame < 8)
            {
                frames.add(new Frame());
            }
            else
            {
                lastFrame = new LastFrame();
            }
            currentFrame++;
        }
    }

    private boolean currentFrameIsRegular()
    {
        return currentFrame <= 8;
    }

    private boolean frameAwaitsScore(int frameIndex)
    {
        return frameIndex >= 0 && frames.get(frameIndex).scoringNotFinished();
    }

    private static class Frame
    {
        private Integer firstBallScore = null;
        private Integer secondBallScore = null;
        private Integer firstBonusBall = null;
        private Integer secondBonusBall = null;

        private void addFrameBallScore(int frameBallScore)
        {
            if (firstBallScore == null)
            {
                firstBallScore = frameBallScore;
            }
            else
            {
                secondBallScore = frameBallScore;
            }
        }

        private int getScore()
        {
            if (scoringNotFinished())
            {
                return 0;
            }
            if (isStrike())
            {
                return 10 + firstBonusBall + secondBonusBall;
            }
            if (isSpare())
            {
                return 10 + firstBonusBall;
            }

            return firstBallScore + secondBallScore;
        }

        private boolean isStrike()
        {
            return firstBallScore != null && firstBallScore == 10;
        }

        private boolean isSpare()
        {
            return secondBallScore != null && firstBallScore != null && firstBallScore + secondBallScore == 10;
        }

        private boolean isFinished()
        {
            return isStrike() || secondBallScore != null;
        }

        public boolean scoringNotFinished()
        {
            return !isFinished() ||
                    (isStrike() && secondBonusBall == null) ||
                    (isSpare() && firstBonusBall == null);
        }

        public void addBonusBallScore(int i)
        {
            if (isStrike())
            {
                if (firstBonusBall == null)
                {
                    firstBonusBall = i;
                }
                else
                {
                    secondBonusBall = i;
                }
            }
            else if (isSpare())
            {
                if (firstBonusBall == null)
                {
                    firstBonusBall = i;
                }
            }
        }
    }

    private static class LastFrame
    {
        private Integer firstBallScore = null;
        private Integer secondBallScore = null;
        private Integer thirdBallScore = null;

        private void addFrameBallScore(int frameBallScore)
        {
            if (firstBallScore == null)
            {
                firstBallScore = frameBallScore;
            }
            else if (secondBallScore == null)
            {
                secondBallScore = frameBallScore;
            }
            else
            {
                thirdBallScore = frameBallScore;
            }
        }

        private int getScore()
        {
            if (firstBallScore != null && secondBallScore != null)
            {
                if (firstBallScore + secondBallScore >= 10)
                {
                    if (thirdBallScore != null)
                    {
                        return firstBallScore + secondBallScore + thirdBallScore;
                    }
                    else
                    {
                        return 0;
                    }
                }
                else
                {
                    return firstBallScore + secondBallScore;
                }
            }
            else
            {
                return 0;
            }
        }
    }
}
