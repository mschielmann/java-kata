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
    public void after_one_non_strike_ball_score_is_0()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(5);
        assertEquals(0, game.currentScore());
    }

    @Test
    public void after_strike_in_first_frame_score_is_0()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(10);
        assertEquals(0, game.currentScore());
    }

    @Test
    public void after_spare_in_first_frame_score_is_0()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(5);
        game.registerScoreForBall(5);
        assertEquals(game.currentScore(), 0);
    }

    @Test
    public void if_first_frame_is_open_then_score_is_sum_of_two_balls()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(2);
        game.registerScoreForBall(3);
        assertEquals(5, game.currentScore());
    }

    @Test
    public void if_first_nine_frames_are_open_then_score_is_sum_of_all_balls()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(2);
        game.registerScoreForBall(3);

        game.registerScoreForBall(1);
        game.registerScoreForBall(8);

        game.registerScoreForBall(8);
        game.registerScoreForBall(0);

        game.registerScoreForBall(5);
        game.registerScoreForBall(3);

        game.registerScoreForBall(3);
        game.registerScoreForBall(3);

        game.registerScoreForBall(7);
        game.registerScoreForBall(2);

        game.registerScoreForBall(5);
        game.registerScoreForBall(3);

        game.registerScoreForBall(6);
        game.registerScoreForBall(2);

        game.registerScoreForBall(8);
        game.registerScoreForBall(1);
        assertEquals(70, game.currentScore());
    }

    @Test
    public void after_spare_and_open_frame_and_third_ball_is_scored_twice()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(2);
        game.registerScoreForBall(8);
        game.registerScoreForBall(5);
        game.registerScoreForBall(1);

        assertEquals(21, game.currentScore());
    }

    @Test
    public void perfect_game_sums_up_to_300_points()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        assertEquals(300, game.currentScore());
    }

    @Test
    public void game_with_all_balls_with_one_pin_sums_up_to_20()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        assertEquals(20, game.currentScore());
    }

    @Test
    public void game_with_all_balls_with_one_pin_and_tenth_max_frame_sums_up_to_48()
    {
        BowlingGame game = new BowlingGame();
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(1);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        game.registerScoreForBall(10);
        assertEquals(48, game.currentScore());
    }

    @Test
    public void all_gutter_balls_result_in_0()
    {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++)
        {
            game.registerScoreForBall(0);
        }
        assertEquals(0, game.currentScore());
    }
}
