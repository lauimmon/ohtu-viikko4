package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private static final int WINNING_SCORE = 4;
    private static final int WINNING_DIFFERENCE = 2;
    private static final int ADVANTAGE = 1;
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        if (m_score1==m_score2)
        {
            score = getNormalScore(m_score1);
            if (!score.equals("Deuce")) {
                score += "-All";
            }
        }
        else if (m_score1>=WINNING_SCORE || m_score2>=WINNING_SCORE)
        {
            int scoreDifference = m_score1-m_score2;
            if (scoreDifference==ADVANTAGE) score ="Advantage player1";
            else if (scoreDifference ==-ADVANTAGE) score ="Advantage player2";
            else if (scoreDifference>=WINNING_DIFFERENCE) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            score = getNormalScore(m_score1) + "-" + getNormalScore(m_score2);
        }
        return score;
    }
    
    private String getNormalScore(int playerScore) {
        switch(playerScore)
        {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
        }
        return "Deuce"; 
    }
}