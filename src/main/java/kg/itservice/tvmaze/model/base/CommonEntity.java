package kg.itservice.tvmaze.model.base;

import java.io.Serializable;
import java.util.Objects;

public abstract class CommonEntity implements Serializable
{
    private static final long serialVersionUID = -8380084296520534689L;

    private Long id;

    private String name;

    private String url;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonEntity entity = (CommonEntity) o;
        return id.equals(entity.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
