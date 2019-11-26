package build;

public class Model
{
    public int p1Location; //  place p1 in middle of the screen
    public int p2Location; //  place p2 in middle of the screen
    public int p1Wins = 0;
    public int p2Wins = 0;
    public int p1Losses = 0;
    public int p2Losses = 0;

    public Model()
    {
        p1Location = 50;
        p2Location = 50;
    }

    //  move each model forward 5 pixels
    public void moveP1()
    {
        p1Location += 5;
        p2Location += 5;
    }

    //  move each model back 5 pixels
    public void moveP2()
    {
        p1Location -= 5;
        p2Location -= 5;
    }

    //  return 1 if p1 is at the right edge of the screen, 2 if p2 is at the left edge of the screen, 0 otherwise
    public int isWinner()
    {
        if (p1Location >= 100) { return 1; }

        if (p2Location <= 0) { return 2; }

        else { return 0; }
    }
}
