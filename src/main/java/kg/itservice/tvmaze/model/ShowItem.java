package kg.itservice.tvmaze.model;

public class ShowItem
{
    private Float score;

    private Show show;

    public ShowItem()
    {}

    public ShowItem(Float score, Show show)
    {
        this.score = score;
        this.show = show;
    }

    public Float getScore()
    {
        return score;
    }

    public void setScore(Float score)
    {
        this.score = score;
    }

    public Show getShow()
    {
        return show;
    }

    public void setShow(Show show)
    {
        this.show = show;
    }
}
