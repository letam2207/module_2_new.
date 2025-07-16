package ss8_clean_code_refactoring.bai_tap.refactoring;

public class TennisGame {
        private static final int ADVANTAGE_THRESHOLD = 4;
        private static final int WIN_DIFFERENCE = 2;

        public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
            if (player1Score == player2Score) {
                return getEqualScore(player1Score);
            }

            if (player1Score >= ADVANTAGE_THRESHOLD || player2Score >= ADVANTAGE_THRESHOLD) {
                return getAdvantageOrWinScore(player1Score, player2Score);
            }

            return getNormalScore(player1Score, player2Score);
        }

        private static String getEqualScore(int score) {
            switch (score) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                case 3:
                    return "Forty-All";
                default:
                    return "Deuce";
            }
        }

        private static String getAdvantageOrWinScore(int player1Score, int player2Score) {
            int scoreDifference = player1Score - player2Score;

            if (scoreDifference == 1) {
                return "Advantage player1";
            } else if (scoreDifference == -1) {
                return "Advantage player2";
            } else if (scoreDifference >= WIN_DIFFERENCE) {
                return "Win for player1";
            } else {
                return "Win for player2";
            }
        }

        private static String getNormalScore(int player1Score, int player2Score) {
            return getScoreString(player1Score) + "-" + getScoreString(player2Score);
        }

        private static String getScoreString(int score) {
            switch (score) {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    throw new IllegalArgumentException("Invalid score: " + score);
            }
        }

    }

