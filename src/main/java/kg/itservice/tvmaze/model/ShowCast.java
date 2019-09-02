package kg.itservice.tvmaze.model;

public class ShowCast implements Comparable<ShowCast>
{
    private Person person;

    private Character character;

    public ShowCast()
    {}

    public ShowCast(Person person, Character character)
    {
        this.person = person;
        this.character = character;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Character getCharacter()
    {
        return character;
    }

    public void setCharacter(Character character)
    {
        this.character = character;
    }


    @Override
    public int compareTo(ShowCast cast) {
        if (getPerson().getBirthday() == null
                || cast.getPerson().getBirthday() == null) {
            return 0;
        }
        return getPerson().getBirthday()
                .compareTo(cast.getPerson().getBirthday());
    }
}
