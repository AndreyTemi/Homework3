package tests.api.LombokModel.ListUsers;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LombokListUsersRs {


    Integer page, per_page, total, total_pages;
    LombokSupportModel support;
    ArrayList<LombokResourseModel> data;

}
