package kg.itservice.tvmaze.model;

import kg.itservice.tvmaze.model.base.CommonEntity;

public class Show extends CommonEntity
{
    private String language;

    public Show()
    {}

    public Show(String language)
    {
        this.language = language;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
