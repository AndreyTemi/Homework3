package tests.api.LombokModel.ListUsers;

import lombok.Data;

@Data
public class LombokResourseModel {

    Integer id;
    String email, first_name, last_name, avatar;
}
