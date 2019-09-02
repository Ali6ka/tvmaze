package kg.itservice.tvmaze.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.itservice.tvmaze.model.base.CommonEntity;
import kg.itservice.tvmaze.utils.TimeHelper;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person extends CommonEntity
{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TimeHelper.DATE_REVERSE_FORMAT)
    private LocalDate birthday;


    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }
}
