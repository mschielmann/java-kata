package pl.mschielmann.javakata.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameScoreTest
{
    @Test
    public void score_for_new_game_is_0()
    {
        BowlingGame game = new BowlingGame();
        assertEquals(game.currentScore(), 0);
    }

    @Test
    public void after_one_non_strike_ball_score_is_0() {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(5);
        assertEquals(game.currentScore(), 0);
    }
}
