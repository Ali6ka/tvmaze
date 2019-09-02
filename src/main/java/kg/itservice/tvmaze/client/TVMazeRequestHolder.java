package kg.itservice.tvmaze.client;

public class TVMazeRequestHolder {

    public static TVMazeRequestHolder of(String name){
        return new TVMazeRequestHolder()
                .setName(name);
    }

    public static TVMazeRequestHolder of(Long id){
        return new TVMazeRequestHolder()
                .setId(id);
    }

    private String name;

    private Long id;

    public String getName() {
        return name;
    }

    public TVMazeRequestHolder setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public TVMazeRequestHolder setId(Long id) {
        this.id = id;
        return this;
    }
}
