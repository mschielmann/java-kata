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

    @Test
    public void after_strike_in_first_frame_score_is_0() {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(10);
        assertEquals(game.currentScore(), 0);
    }

    @Test
    public void after_spare_in_first_frame_score_is_0() {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(5);
        game.registerScoreForBall(5);
        assertEquals(game.currentScore(), 0);
    }

    @Test
    public void if_first_frame_is_open_score_is_sum_of_two_balls() {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(2);
        game.registerScoreForBall(3);
        assertEquals(game.currentScore(), 5);
    }
}
