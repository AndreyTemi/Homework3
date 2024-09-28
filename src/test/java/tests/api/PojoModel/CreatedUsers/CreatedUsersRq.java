package tests.api.PojoModel.CreatedUsers;

public class CreatedUsersRq {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    String name, job;
}
